package com.staykeep.config;

import java.util.Properties;
import java.util.Scanner;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.sql.DataSource;
import javax.transaction.TransactionManager;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

import bitronix.tm.TransactionManagerServices;
import bitronix.tm.resource.jms.PoolingConnectionFactory;

@Configuration
@ComponentScan("com.staykeep") // searches in that package, and any nested packages for Spring annotations
@EnableJms
@EnableTransactionManagement
@Component("config")
@EnableAspectJAutoProxy
public class JTAConfig {

	// JMS Broker Url
	public static final String BROKER_URL = "tcp://localhost:61616";

	// JMS Destination - Lotus Queue
	public static final String LOTUS_QUEUE = "MESSAGE_LIST";

	// DataSource info - for Postgres db connection.
	public static final String DATASOURCE_URL = "jdbc:postgresql://" + System.getenv("DB_URL") + ":5432/"
			+ System.getenv("DB_NAME") + "?";
	public static final String DATASOURCE_DRIVERNAME = "org.postgresql.Driver";
	public static final String DATASOURCE_USERNAME = System.getenv("DB_NAME");
	public static final String DATASOURCE_PASSWORD = System.getenv("DB_PASSWORD");
	public static final String DATASOURCE_SCHEMA = System.getenv("DB_SCHEMA");

	// DataSource configuration - for Postgres db connection.
	@Bean
	public DataSource dataSource() {
		// I think we are supposed to use pooling data source instead, but too late.
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(DATASOURCE_URL);
		dataSource.setDriverClassName(DATASOURCE_DRIVERNAME);
		dataSource.setUsername(DATASOURCE_USERNAME);
		dataSource.setPassword(DATASOURCE_PASSWORD);
		dataSource.setSchema(DATASOURCE_SCHEMA);
		return dataSource;
	}

	// JDBC template setup.
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		JdbcTemplate template = new JdbcTemplate();
		template.setDataSource(dataSource);
		return template;
	}

	// Scanner bean for efficiency
	@Bean
	@Scope("singleton")
	public Scanner scan() {
		return new Scanner(System.in);
	}

	// Logger bean for efficiency
	@Bean
	public Logger log() {
		return Logger.getRootLogger();
	}

	// Bitronix connections for ActiveMQ
	@Bean
	public ConnectionFactory bitronixConnectionFactory() {
		PoolingConnectionFactory connectionFactory = new PoolingConnectionFactory();
		connectionFactory.setClassName("org.apache.activemq.ActiveMQXAConnectionFactory");
		connectionFactory.setUniqueName("activemq");
		connectionFactory.setMaxPoolSize(10);
		connectionFactory.setAllowLocalTransactions(true);
		Properties props = new Properties();
		props.put("brokerURL", BROKER_URL);
		connectionFactory.setDriverProperties(props);
		return connectionFactory;
	}

	// Set the Queue to the name above.
	@Bean
	public Queue destinationQueue() {
		return new ActiveMQQueue(LOTUS_QUEUE);
	}

	// Configure the jmsTemplate
	@Bean
	public JmsTemplate jmsTemplate(ConnectionFactory bitronixConnectionFactory) {
		JmsTemplate jmsTemplate = new JmsTemplate();
		jmsTemplate.setConnectionFactory(bitronixConnectionFactory);
		jmsTemplate.setReceiveTimeout(10000);
		return jmsTemplate;
	}

	// Give the btm config a transactionManager
	@Bean
	public bitronix.tm.Configuration btmConfig() {
		bitronix.tm.Configuration config = TransactionManagerServices.getConfiguration();
		config.setDisableJmx(true);
		config.setServerId("spring-btm");
		return config;
	}

	// Make the TransactionManager a bean.
	@Bean(destroyMethod = "shutdown")
	@DependsOn("btmConfig")
	public TransactionManager primaryTransactionManager() {
		return TransactionManagerServices.getTransactionManager();
	}

	// Give the JTA transactionManager another TransactionManager
	@Bean
	public JtaTransactionManager jtaTransactionManager(TransactionManager primaryTransactionManager) {
		JtaTransactionManager jtaTransactionManager = new JtaTransactionManager();
		jtaTransactionManager.setTransactionManager(primaryTransactionManager);
		return jtaTransactionManager;
	}
}
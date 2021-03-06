package com.lotus.staykeep.daoimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lotus.staykeep.mapper.GuestRowMapper;
import com.lotus.staykeep.dao.GuestDao;
import com.lotus.staykeep.pojo.Guest;

@Repository //<--Indicates that an annotated class is a Repository.
public class GuestDaoImpl implements GuestDao {
//Implementation for handling Database functions concerning Guest objects.

	//Logger
	private Logger log;
	
	// JDBC Template to use for database connection.
	private JdbcTemplate jdbcTemplate;

	// GuestRowMapper to return Guest objects from database.
	private GuestRowMapper guestRowMapper;
	
//------------------------------------------------------------
	
	// Auto-wired JDBC Template setter --> nothing calls this.
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// Auto-wired GuestRowMapper setter --> nothing calls this.
	@Autowired
	public void setGuestRowMapper(GuestRowMapper guestRowMapper) {
		this.guestRowMapper = guestRowMapper;
	}
	
	// Auto-wired Logger setter --> nothing calls this.
	@Autowired
	public void setLogger(Logger log) {
		this.log = log;
	}

//-----------------------------------------------------------------------------------
	
	// Gets guest id, first name, last name, and credit card for a given guest id. 
	// Returns a Guest object with these values.
	@Override //<--Overrides abstract method.
	public Guest getGuestInfoById(int g_id) {
		String sql = "SELECT g_id, f_name, l_name, cc_num FROM guest WHERE g_id = ?";
		List<Guest> guestList = jdbcTemplate.query(sql, guestRowMapper, g_id);
		return guestList.get(0);
	}

	// Sets first name for a given guest id.
	@Override //<--Overrides abstract method.
	public void setGuestFname(String f_name, int g_id) {
		String sql = "UPDATE guest SET f_name = ? WHERE g_id = ?";
		jdbcTemplate.update(sql, f_name, g_id);
	}

	// Sets last name for a given guest id.
	@Override //<--Overrides abstract method
	public void setGuestLname(String l_name, int g_id) {
		String sql = "UPDATE guest SET l_name = ? WHERE g_id = ?";
		jdbcTemplate.update(sql, l_name, g_id);
	}

	// Sets credit card number for a given guest id. 
	@Override //<--Overrides abstract method
	public void setGuestCcnum(String cc_num, int g_id) {
		String sql = "UPDATE guest SET cc_num = ? WHERE g_id = ?";
		jdbcTemplate.update(sql, cc_num, g_id);
	}

	// Inserts a new guest into the database with the given values.
	@Override //<--Overrides abstract method
	public void createNewGuest(String f_name, String l_name, String cc_num) {
		String sql = "INSERT INTO guest (f_name, l_name, cc_num) VALUES ( ?, ?, ? )";
		jdbcTemplate.update(sql, f_name, l_name, cc_num);	
	}
}

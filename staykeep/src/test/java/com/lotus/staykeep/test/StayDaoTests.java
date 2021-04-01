package com.lotus.staykeep.test;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lotus.staykeep.config.AppConfig;
import com.lotus.staykeep.daoimpl.StayDaoImpl;
import com.lotus.staykeep.pojo.Stay;

public class StayDaoTests {
	ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
	StayDaoImpl stayDaoImpl;

	@Autowired
	public void setStayDaoImpl(StayDaoImpl stayDaoImpl) {
		this.stayDaoImpl = stayDaoImpl;
	}

	public void shouldGetInfoById() {
		Stay stay = stayDaoImpl.getStayInfoById(3);
		System.out.println(stay);
	}

	public void shouldCreateNewStay() {

		Time chitime = Time.valueOf("9:33:00");
		Date chidate = Date.valueOf("2021-02-20");
		Time chotime = Time.valueOf("01:11:00");
		Date chodate = Date.valueOf("2099-03-20");

		stayDaoImpl.createNewStay(chitime, chidate, chotime, chodate, 3, 6, 100.00f);
	}

	public void shouldGetAllStays() {
		List<Stay> stayList = stayDaoImpl.getAllStays();
		System.out.println(stayList);
	}

	public void shouldSetCheckInTime() {
		Time chitime = Time.valueOf("9:33:00");
		stayDaoImpl.setStayInTime(chitime, 7);
	}

	public void shouldSetCheckInDate() {
		Date chidate = Date.valueOf("2021-02-20");
		stayDaoImpl.setStayInDate(chidate, 7);
	}

	public void shouldSetCheckOutTime() {
		Time chotime = Time.valueOf("01:11:00");
		stayDaoImpl.setStayOutTime(chotime, 7);
	}

	public void shouldSetCheckOutDate() {
		Date chodate = Date.valueOf("2099-03-20");
		stayDaoImpl.setStayOutDate(chodate, 7);
	}
}

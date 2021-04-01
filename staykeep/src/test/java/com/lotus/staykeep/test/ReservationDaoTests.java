package com.lotus.staykeep.test;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lotus.staykeep.config.AppConfig;
import com.lotus.staykeep.daoimpl.ReservationDaoImpl;
import com.lotus.staykeep.pojo.Reservation;

public class ReservationDaoTests {
	ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);

	ReservationDaoImpl reservationDaoImpl;

	@Autowired
	public void setReservationDaoImpl(ReservationDaoImpl reservationDaoImpl) {
		this.reservationDaoImpl = reservationDaoImpl;
	}

	public void shouldGetResById() {
		Reservation res = reservationDaoImpl.getResById(1);
		System.out.println(res);
	}

	public void shouldGetAllRes() {
		List<Reservation> resList = reservationDaoImpl.getAllRes();
		System.out.println(resList);
	}
	
	public void shouldGetAllResByStatus() {
		 List<Reservation> resList = reservationDaoImpl.getAllResStatus("upcoming");
		System.out.println(resList);
	}

	public void shouldCreateNewRes() {

		Time chitime = Time.valueOf("5:32:00");
		Time chotime = Time.valueOf("11:00:00");
		Date chidate = Date.valueOf("2019-01-26");
		Date chodate = Date.valueOf("2019-02-27");
		reservationDaoImpl.createNewReservation(chitime, chidate, chotime, chodate, 3, 1, "completed");
	}

	public void shouldSetCheckInTime() {
		Time chitime = Time.valueOf("5:32:00");

		reservationDaoImpl.setResInTime(chitime, 6);
	}

	public void shouldSetCheckInDate() {

		Date chidate = Date.valueOf("2019-01-26");
		reservationDaoImpl.setResInDate(chidate, 6);
	}

	public void shouldSetCheckOutTime() {

		Time chotime = Time.valueOf("11:00:00");

		reservationDaoImpl.setResOutTime(chotime, 6);

	}

	public void shouldSetChoutdate() {

		Date chodate = Date.valueOf("2019-02-27");
		reservationDaoImpl.setResStatus("completed", 6);
	}

	public void shouldSetStatus() {
		reservationDaoImpl.setResStatus("completed", 6);
	}
	
	public void shouldCreateNewReservation() {
		Time chitime = Time.valueOf("5:32:00");
		Date chidate = Date.valueOf("2019-01-26");
		Time chotime = Time.valueOf("11:00:00");
		Date chodate = Date.valueOf("2019-02-27");
	 reservationDaoImpl.createNewReservation(chitime, chidate, chotime, chodate, 3, 1, "completed");
	}
}

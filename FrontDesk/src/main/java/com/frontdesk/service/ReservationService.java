package com.frontdesk.service;

import java.util.List;
import com.frontdesk.pojo.Reservation;

//REST Service interface for all database functionality 
//concerning Reservation objects.
public interface ReservationService {

	// 1
	public List<Reservation> getAllRes();

	// 2
	public Reservation getResById(int res_id);

	// 3
	public void createNewReservation(Reservation reservation);

	// 4
	public void deleteRes(int res_id);

	// 5
	public List<Reservation> getAllResStatus(String status);

	// 6
	public void setResInTime(Reservation reservation);

	// 7.
	public void setResInDate(Reservation reservation);

	// 8
	public void setResOutTime(Reservation reservation);

	// 9
	public void setResOutDate(Reservation reservation);

	// 10
	public void setResStatus(Reservation reservation);
}

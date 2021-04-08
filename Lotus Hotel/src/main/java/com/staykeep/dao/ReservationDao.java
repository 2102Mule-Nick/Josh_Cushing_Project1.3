package com.staykeep.dao;


import java.util.List;


import com.staykeep.pojo.Reservation;

//Interface for handling Database functions concerning Reservation objects.
public interface ReservationDao {

	// Abstract method that returns a list of all reservations.
	public List<Reservation> getAllRes();

	// Abstract method that returns the reservation with the specified id.
	public Reservation getResById(int res_id);

	// Abstract method that returns a boolean that represents whether the
	// new reservation insertion was successful or not.
	public void createNewReservation(Reservation reservation);

	// Abstract method that returns a boolean that represents whether the
	// specified reservation deletion was successful or not.
	public void deleteRes(int res_id);

	// Abstract method that returns a list of all reservations with the specified
	// status.
	public List<Reservation> getAllResStatus(String status);
	

	// Abstract method that returns a boolean that represents whether the
	// check-in time change for the specified reservation was successful or not.
	public void setResInTime(Reservation reservation);

	// Abstract method that returns a boolean that represents whether the
	// check-in date change for the specified reservation was successful or not.
	public void setResInDate(Reservation reservation);

	// Abstract method that returns a boolean that represents whether the
	// check-out time change for the specified reservation was successful or not.
	public void setResOutTime(Reservation reservation);

	// Abstract method that returns a boolean that represents whether the
	// check-out date change for the specified reservation was successful or not.
	public void setResOutDate(Reservation reservation);

	
	// Abstract method that returns a boolean that represents whether the
	// status change for the specified reservation was successful or not.
	public void setResStatus(Reservation reservation);
	
}
package com.staykeep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.staykeep.daoimpl.ReservationDaoImpl;

import com.staykeep.pojo.Reservation;

//REST Controller for all database functionality concerning reservation objects.
@RestController
public class ReservationController {

	// ReservationDaoImpl object holding functionality.
	private ReservationDaoImpl reservationDaoImpl;

	// Auto-Wired setter. Nothing calls this.
	@Autowired
	public void setReservationDaoImpl(ReservationDaoImpl reservationDaoImpl) {
		this.reservationDaoImpl = reservationDaoImpl;
	}

//--------------------------------------------------------------------------------------
//1
	// Controller method that returns a list of all reservations.
	@GetMapping("/reservation")
	public List<Reservation> getAllRes() {
		List<Reservation> reservationList = reservationDaoImpl.getAllRes();
		return reservationList;
	}

//-----------------------------------------------------------------------
//2
	// Controller method that returns a specific reservation by id.
	@GetMapping("/reservation/{res_id}")
	public Reservation getResById(@PathVariable int res_id) {
		Reservation reservation = reservationDaoImpl.getResById(res_id);
		return reservation;
	}

//-----------------------------------------------------------------------
//3
	// Controller method that creates a new reservation.
	@PostMapping("/reservation")
	public void createNewReservation(@RequestBody Reservation reservation) {
		reservationDaoImpl.createNewReservation(reservation);
	}

//-----------------------------------------------------------------------
//4
	// Controller method that deletes a reservation.
	@DeleteMapping("/reservation/{res_id}")
	public void deleteRes(@PathVariable int res_id) {
		reservationDaoImpl.deleteRes(res_id);
	}

//-----------------------------------------------------------------------
//5	
	// Controller method that returns a list of all reservations with a certain
	// status.
	@GetMapping("/reservation/status/{status}")
	public List<Reservation> getAllResStatus(@PathVariable String status) {
		List<Reservation> reservationList = reservationDaoImpl.getAllResStatus(status);
		return reservationList;
	}

//-----------------------------------------------------------------------
//6		
	// Controller method that sets the reserrvation's check-in-time.
	@PutMapping("/reservation/it")
	public void setResInTime(@RequestBody Reservation reservation) {
		reservationDaoImpl.setResInTime(reservation);
	}

//-----------------------------------------------------------------------
//7		
	// Controller method that sets the reserrvation's check-in-date.
	@PutMapping("/reservation/id")
	public void setResInDate(@RequestBody Reservation reservation) {
		reservationDaoImpl.setResInDate(reservation);
	}

//-----------------------------------------------------------------------
//8	
	// Controller method that sets the reserrvation's check-out-time.
	@PutMapping("/reservation/ot")
	public void setResOutTime(@RequestBody Reservation reservation) {
		reservationDaoImpl.setResOutTime(reservation);
	}

//-----------------------------------------------------------------------
//9	
	// Controller method that sets the reserrvation's check-out-date.
	@PutMapping("/reservation/od")
	public void setResOutDate(@RequestBody Reservation reservation) {
		reservationDaoImpl.setResOutDate(reservation);
	}

//-----------------------------------------------------------------------
//10
	// Controller method that sets the reserrvation's status.
	@PutMapping("/reservation/st")
	public void setResStatus(@RequestBody Reservation reservation) {
		reservationDaoImpl.setResStatus(reservation);
	}
}
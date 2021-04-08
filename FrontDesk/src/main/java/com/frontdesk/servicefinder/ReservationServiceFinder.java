package com.frontdesk.servicefinder;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.frontdesk.pojo.Reservation;

import com.frontdesk.service.ReservationService;

//REST Service for all database functionality concerning Reservation objects.
@Service
public class ReservationServiceFinder implements ReservationService {

	// Rest template for easy serialization
	RestTemplate restTemplate;

	// Auto-wired setter. Nothing calls this.
	@Autowired
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

//-----------------------------------------------------------------------
//1
	// Service method that requests staykeep to return a list of all reservations.
	@Override
	public List<Reservation> getAllRes() {
		final String URL = "http://localhost:8081/staykeep/reservation";
		Reservation[] reservation = restTemplate.getForObject(URL, Reservation[].class);
		return Arrays.asList(reservation);
	}

//-----------------------------------------------------------------------
//2
	// Service method that requests staykeep to return a specific reservation by id.
	@Override
	public Reservation getResById(int res_id) {
		final String URL = "http://localhost:8081/staykeep/reservation/" + res_id;
		return restTemplate.getForObject(URL, Reservation.class);
	}

//-----------------------------------------------------------------------
//3	
	// Service method that requests staykeep to create a new reservation.
	@Override
	public void createNewReservation(Reservation reservation) {
		final String URL = "http://localhost:8081/staykeep/reservation";
		restTemplate.postForEntity(URL, reservation, null);
	}

//-----------------------------------------------------------------------
//4	
	// Service method that requests staykeep to delete a specific reservation by id.
	@Override
	public void deleteRes(int res_id) {
		final String URL = "http://localhost:8081/staykeep/reservation/" + res_id;
		restTemplate.delete(URL, Reservation.class);
	}

//-----------------------------------------------------------------------
//5	
	// Service method that requests staykeep to return a list of reservations with a
	// certain status.
	@Override
	public List<Reservation> getAllResStatus(String status) {
		final String URL = "http://localhost:8081/staykeep/reservation/status/" + status;
		Reservation[] reservation = restTemplate.getForObject(URL, Reservation[].class);
		return Arrays.asList(reservation);
	}

//-----------------------------------------------------------------------
//6	
	// Service method that requests staykeep to set a certain reservation's
	// check-in-time to a certain value.
	@Override
	public void setResInTime(Reservation reservation) {
		final String URL = "http://localhost:8081/staykeep/reservation/it";
		restTemplate.put(URL, reservation);
	}

//-----------------------------------------------------------------------
//7	
	// Service method that requests staykeep to set a certain reservation's
	// check-in-date to a certain value.
	@Override
	public void setResInDate(Reservation reservation) {
		final String URL = "http://localhost:8081/staykeep/reservation/id";
		restTemplate.put(URL, reservation);
	}

//-----------------------------------------------------------------------
//8	
	// Service method that requests staykeep to set a certain reservation's
	// check-out-time to a certain value.
	@Override
	public void setResOutTime(Reservation reservation) {
		final String URL = "http://localhost:8081/staykeep/reservation/ot";
		restTemplate.put(URL, reservation);
	}

//-----------------------------------------------------------------------
//9	
	// Service method that requests staykeep to set a certain reservation's
	// check-out-date to a certain value.
	@Override
	public void setResOutDate(Reservation reservation) {
		final String URL = "http://localhost:8081/staykeep/reservation/od";
		restTemplate.put(URL, reservation);
	}

//-----------------------------------------------------------------------
//10
	// Service method that requests staykeep to set the reservation status of a
	// certain
	// reservation.
	@Override
	public void setResStatus(Reservation reservation) {
		final String URL = "http://localhost:8081/staykeep/reservation/st";
		restTemplate.put(URL, reservation);
	}

}
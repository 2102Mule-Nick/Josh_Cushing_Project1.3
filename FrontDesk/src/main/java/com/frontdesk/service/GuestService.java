package com.frontdesk.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.frontdesk.pojo.Guest;

// REST Service interface for all database functionality 
// concerning Guest objects.
public interface GuestService {

	// 1
	public List<Guest> getAllGuests();

	// 2
	public Guest getGuestInfoById(int g_id);

	// 3
	public Guest createNewGuest(Guest guest);

	// 4
	public void deleteGuest(int g_id);

	// 5
	public void setGuestFname(Guest guest);

	// 6
	public void setGuestLname(Guest guest);

	// 7
	public void setGuestCcnum(Guest guest);
}

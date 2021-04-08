package com.staykeep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.staykeep.daoimpl.GuestDaoImpl;
import com.staykeep.pojo.Guest;

//REST Controller for all database functionality concerning guest objects.
@RestController
public class GuestController {

	// GuestDaoImpl object holding functionality.
	private GuestDaoImpl guestDaoImpl;

	// Auto-Wired setter. Nothing calls this.
	@Autowired
	public void setGuestDaoImpl(GuestDaoImpl guestDaoImpl) {
		this.guestDaoImpl = guestDaoImpl;
	}

//---------------------------------------------------------------------
//1
	// Controller method that returns a list of all guests.
	@GetMapping("/guest")
	public List<Guest> getAllGuests() {
		List<Guest> guestList = guestDaoImpl.getAllGuests();
		return guestList;
	}

//------------------------------------------------------------------------
//2
	// Controller method that returns a single guest by id.
	@GetMapping("/guest/{g_id}")
	public Guest getGuestInfoById(@PathVariable int g_id) {
		Guest guest = guestDaoImpl.getGuestInfoById(g_id);
		return guest;
	}

//--------------------------------------------------------------------
//3
	// Controller method that creates a new guest.
	@PostMapping("/guest")
	public Guest creatNewGuest(@RequestBody Guest guest) {

		//First a new guest with no g_id is inserted into db
		// It will be returned with a g_id.
		// See #3
		Guest guestWithId = guestDaoImpl.createNewGuest(guest);
	
		//Pass it back
		return guestWithId;
	}

//--------------------------------------------------------------------
//4
	// Controller method that deletes a guest by id.
	@DeleteMapping("/guest/{g_id}")
	public void deleteGuest(@PathVariable int g_id) {
		guestDaoImpl.deleteGuest(g_id);
	}

//--------------------------------------------------------------------	
//5
	// Controller method that sets a guest's first name by id.
	@PutMapping("/guest/f")
	public void setGuestFname(@RequestBody Guest guest) {
		guestDaoImpl.setGuestFname(guest);
	}

//--------------------------------------------------------------------		
//6
	// Controller method that sets a guest's last name by id.
	@PutMapping("/guest/l")
	public void setGuestLname(@RequestBody Guest guest) {
		guestDaoImpl.setGuestLname(guest);
	}

//--------------------------------------------------------------------	
//7
	// Controller method that sets a guest's credit card number by id.
	@PutMapping("/guest/c")
	public void setGuestCcnum(@RequestBody Guest guest) {
		guestDaoImpl.setGuestCcnum(guest);
	}
}
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

import com.staykeep.daoimpl.StayDaoImpl;
import com.staykeep.pojo.Stay;

//REST Controller for all database functionality concerning stay objects.
@RestController
public class StayController {

	// StayDaoImpl object holding functionality.
	private StayDaoImpl stayDaoImpl;

	// roomController to set status when a new stay is added.
	private RoomController roomController;
	
	// Auto-Wired setter. Nothing calls this.
	@Autowired
	public void setStayDaoImpl(StayDaoImpl stayDaoImpl) {
		this.stayDaoImpl = stayDaoImpl;
	}

	// Auto-Wired setter. Nothing calls this.
	@Autowired
	public void setRoomController(RoomController roomController) {
		this.roomController = roomController;
	}

//-----------------------------------------------------------------------------
//1
	// Controller method that returns a list of all stays.
	@GetMapping("/stay")
	public List<Stay> getAllStays() {
		List<Stay> stayList = stayDaoImpl.getAllStays();
		return stayList;
	}

// -----------------------------------------------------------------------
//2
	// Controller method that returns a single stay given the id
	@GetMapping("/stay/{s_id}")
	public Stay getStayInfoById(@PathVariable int s_id) {
		Stay stay = stayDaoImpl.getStayInfoById(s_id);
		return stay;
	}

// -----------------------------------------------------------------------
//3
	// Controller method that creates a new list based off the following.
	@Transactional
	@PostMapping("/stay")
	public void createNewStay(@RequestBody Stay stay) {
		// Set is_current to true automatically
		stay.setIs_current(true);
		
		// Create a new stay
		stayDaoImpl.createNewStay(stay);
		
		//NEW functionality updates room status when a stay is made.
		int r_id = stay.getR_id();
		String status = "occupied";
		roomController.setRoomStatus(r_id, status);
	}

// -----------------------------------------------------------------------
//4
	// Controller method that deletes a stay by id.
	@DeleteMapping("/stay/{s_id}")
	public void deleteStay(@PathVariable int s_id) {
		stayDaoImpl.deleteStay(s_id);
	}

// -----------------------------------------------------------------------
//5	
	// Controller method that sets stay currency
	@PutMapping("/stay/{s_id}/current/{is_current}")
	public void setIsCurrent(@PathVariable boolean is_current, @PathVariable int s_id) {
		stayDaoImpl.setIsCurrent(is_current, s_id);
	}

// -----------------------------------------------------------------------
//6		
	// Controller method that requests staykeep to set bill
	@PutMapping("/stay/b")
	public void setBill(@RequestBody Stay stay) {
		stayDaoImpl.setBill(stay);
	}

// -----------------------------------------------------------------------
//7	
	// Controller method that sets stay check-in-time
	@PutMapping("/stay/it")
	public void setStayInTime(@RequestBody Stay stay) {
		stayDaoImpl.setStayInTime(stay);
	}

// -----------------------------------------------------------------------
//8	
	// Controller method that sets stay check-in-date
	@PutMapping("/stay/id")
	public void setStayInDate(@RequestBody Stay stay) {
		stayDaoImpl.setStayInDate(stay);
	}

// -----------------------------------------------------------------------
//9	
	// Controller method that sets stay check-in-time
	@PutMapping("/stay/ot")
	public void setStayOutTime(@RequestBody Stay stay) {
		stayDaoImpl.setStayOutTime(stay);
	}

// -----------------------------------------------------------------------
//10	
	// Controller method that sets stay check-out-date
	@PutMapping("/stay/od")
	public void setStayOutDate(@RequestBody Stay stay) {
		stayDaoImpl.setStayOutDate(stay);
	}
// EXTRA LOGIC ------------------------------------------------------------
//11
	public void checkoutStay(Stay stay) {
		//Sets stay's is_current to false when the guest checks out.
		boolean is_current = false;
		
		// Get the stay ID from the stay object passed. 
		int s_id = stay.getS_id();
		
		// Calls stayDaoImpl to make the db update.
		stayDaoImpl.setIsCurrent(is_current, s_id);
	}

}
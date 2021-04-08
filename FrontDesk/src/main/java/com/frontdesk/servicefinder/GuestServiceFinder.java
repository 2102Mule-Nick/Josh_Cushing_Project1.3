package com.frontdesk.servicefinder;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.frontdesk.pojo.Guest;

import com.frontdesk.service.GuestService;

//REST Service for all database functionality concerning Guest objects.
@Service
public class GuestServiceFinder implements GuestService {

	// Rest template for easy serialization
	RestTemplate restTemplate;

	// Auto-wired setter. Nothing calls this.
	@Autowired
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

//-----------------------------------------------------------------------
//1
	// Service method that requests staykeep to return a list of all guests.
	@Override
	public List<Guest> getAllGuests() {
		final String URL = "http://localhost:8081/staykeep/guest";
		Guest[] guest = restTemplate.getForObject(URL, Guest[].class);
		return Arrays.asList(guest);
	}

//------------------------------------------------------------------------
//2
	// Service method that requests staykeep to return a specific guest by id.
	@Override
	public Guest getGuestInfoById(int g_id) {
		final String URL = "http://localhost:8081/staykeep/guest/" + g_id;
		return restTemplate.getForObject(URL, Guest.class);
	}

//--------------------------------------------------------------------
//3
	// Service method that requests staykeep to create a new guest.
	@Override
	public Guest createNewGuest(Guest guest) {
		final String URL = "http://localhost:8081/staykeep/guest";
		
		//post for entity with a response type guest
		ResponseEntity<Guest> guestResp = restTemplate.postForEntity(URL, guest, Guest.class);
		
		//Get the body
		Guest guestWithId = guestResp.getBody();
		
		//return the body: a new guest object with a g_id
		return guestWithId;
	}

//--------------------------------------------------------------------	
//4
	// Service method that requests staykeep to delete a certain guest by id.
	@Override
	public void deleteGuest(int g_id) {
		final String URL = "http://localhost:8081/staykeep/guest/" + g_id;
		restTemplate.delete(URL, Guest.class);
	}

//--------------------------------------------------------------------	
//5
	// Service method that requests staykeep to set a certain guest's first name by
	// id.
	@Override
	public void setGuestFname(Guest guest) {
		final String URL = "http://localhost:8081/staykeep/guest/f";
		restTemplate.put(URL, guest);
	}

//--------------------------------------------------------------------	
//6
	// Service method that requests staykeep to set a certain guest's last name by
	// id.
	@Override
	public void setGuestLname(Guest guest) {
		final String URL = "http://localhost:8081/staykeep/guest/l";
		restTemplate.put(URL, guest);
	}

//--------------------------------------------------------------------	
//7
	// Service method that requests staykeep to set a certain guest's credit card
	// number by id.
	@Override
	public void setGuestCcnum(Guest guest) {
		final String URL = "http://localhost:8081/staykeep/guest/c";
		restTemplate.put(URL, guest);
		
	}
}
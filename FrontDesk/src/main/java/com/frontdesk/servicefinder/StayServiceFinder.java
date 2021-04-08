package com.frontdesk.servicefinder;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.frontdesk.pojo.Stay;
import com.frontdesk.service.StayService;

//REST Service for all database functionality concerning Stay objects.
@Service
public class StayServiceFinder implements StayService {

	// Rest template for easy serialization
	RestTemplate restTemplate;

	// Auto-wired setter. Nothing calls this.
	@Autowired
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

// -----------------------------------------------------------------------
//1
	// Service method that requests staykeep to return a list of all stays.
	@Override
	public List<Stay> getAllStays() {
		final String URL = "http://localhost:8081/staykeep/stay";
		Stay[] stays = restTemplate.getForObject(URL, Stay[].class);
		return Arrays.asList(stays);
	}

// -----------------------------------------------------------------------
//2
	// Service method that requests staykeep to return a specific stay by id.
	@Override
	public Stay getStayInfoById(int s_id) {
		final String URL = "http://localhost:8081/staykeep/stay/" + s_id;
		return restTemplate.getForObject(URL, Stay.class);
	}

// -----------------------------------------------------------------------
//3
	// Service method that requests staykeep to create a new stay.
	@Override
	public void createNewStay(Stay stay) {
		final String URL = "http://localhost:8081/staykeep/stay";
		restTemplate.postForEntity(URL, stay, null);
	}

// -----------------------------------------------------------------------
//4
	// Service method that requests staykeep to delete a stay.
	@Override
	public void deleteStay(int s_id) {
		final String URL = "http://localhost:8081/staykeep/stay/" + s_id;
		restTemplate.delete(URL, Stay.class);
	}

// -----------------------------------------------------------------------
//5		
	// Service method that requests staykeep to set stay currency
	@Override
	public void setIsCurrent(boolean is_current, int s_id) {
		final String URL = "http://localhost:8081/staykeep/stay/" + s_id + "/current/" + is_current;
		restTemplate.put(URL, null);
	}

// -----------------------------------------------------------------------
//6			
	// Service method that requests staykeep to set bill
	@Override
	public void setBill(Stay stay) {
		final String URL = "http://localhost:8081/staykeep/stay/b";
		restTemplate.put(URL, stay);
	}

// -----------------------------------------------------------------------
//7	
	// Service method that requests staykeep
	// to set a stay's check-in-time
	@Override
	public void setStayInTime(Stay stay) {
		final String URL = "http://localhost:8081/staykeep/stay/it";
		restTemplate.put(URL, stay);
	}

// -----------------------------------------------------------------------
//8	
	// Service method that requests staykeep
	// to set a stay's check-in-date
	@Override
	public void setStayInDate(Stay stay) {
		final String URL = "http://localhost:8081/staykeep/stay/id";
		restTemplate.put(URL, stay);
	}

// -----------------------------------------------------------------------
//9	
	// Service method that requests staykeep
	// to set a stay's check-out-time
	@Override
	public void setStayOutTime(Stay stay) {
		final String URL = "http://localhost:8081/staykeep/stay/ot";
		restTemplate.put(URL, stay);
	}

// -----------------------------------------------------------------------
//10	
	// Service method that requests staykeep
	// to set a stay's check-out-date
	@Override
	public void setStayOutDate(Stay stay) {
		final String URL = "http://localhost:8081/staykeep/stay/od";
		restTemplate.put(URL, stay);
	}
}
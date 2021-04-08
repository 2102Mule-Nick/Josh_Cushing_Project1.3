package com.frontdesk.servicefinder;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.frontdesk.pojo.Guest;
import com.frontdesk.pojo.OnlineUser;
import com.frontdesk.service.OnlineUserService;

//REST Service for all database functionality concerning OnlineUser objects.
@Service
public class OnlineUserServiceFinder implements OnlineUserService {

	// Rest template for easy serialization
	RestTemplate restTemplate;

	// Auto-wired setter. Nothing calls this.
	@Autowired
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

//-----------------------------------------------------------------------
//1
	// Service method that requests staykeep to return of a list of all OnlineUsers.
	@Override
	public List<OnlineUser> getAllOnlineUsers() {
		final String URL = "http://localhost:8081/staykeep/user";
		OnlineUser[] onlineUsers = restTemplate.getForObject(URL, OnlineUser[].class);
		return Arrays.asList(onlineUsers);
	}

//-----------------------------------------------------------------------------
//2
	// Service method that requests staykeep to return a specific OnlineUser by id.
	@Override
	public OnlineUser getOnlineUserInfoById(int u_id) {
		final String URL = "http://localhost:8081/staykeep/user/" + u_id;
		return restTemplate.getForObject(URL, OnlineUser.class);
	}

//-----------------------------------------------------------------------------
//3
	// Service method that requests staykeep to create a new OnlineUser.
	@Override
	public void createNewOnlineUser(OnlineUser onlineUser) {
		final String URL = "http://localhost:8081/staykeep/user";
		restTemplate.postForEntity(URL, onlineUser, null);
	}

//-----------------------------------------------------------------------------
//4	
	// Service method that requests staykeep to delete an OnlineUser by id.
	@Override
	public void deleteOnlineUser(int u_id) {
		final String URL = "http://localhost:8081/staykeep/user/" + u_id;
		restTemplate.delete(URL, Guest.class);
	}

//-----------------------------------------------------------------------------
//5	
	// Service method that requests staykeep to set an OnlineUser's username by id.
	@Override
	public void setOnlineUserUserName(OnlineUser onlineUser) {
		final String URL = "http://localhost:8081/staykeep/user/u";
		restTemplate.put(URL, onlineUser);
	}

//-----------------------------------------------------------------------------
//6		
	// Method that requests the password change of a OnlineUser by id.
	@Override
	public void setOnlineUserPassword(OnlineUser onlineUser) {
		final String URL = "http://localhost:8081/staykeep/user/p";
		restTemplate.put(URL, onlineUser);
	}

//-----------------------------------------------------------------------------
//7	
	// Method that requests the email change of a OnlineUser by id.
	@Override
	public void setOnlineUserEmail(OnlineUser onlineUser) {
		final String URL = "http://localhost:8081/staykeep/user/e";
		restTemplate.put(URL, onlineUser);
	}
}
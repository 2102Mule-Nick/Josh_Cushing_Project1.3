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

import com.staykeep.daoimpl.OnlineUserDaoImpl;
import com.staykeep.pojo.OnlineUser;

//REST Controller for all database functionality concerning OnlineUser objects.
@RestController
public class OnlineUserController {

	// OnlineUserDaoImpl object holding functionality.
	private OnlineUserDaoImpl onlineUserDaoImpl;

	// Auto-Wired setter. Nothing calls this.
	@Autowired
	public void setOnlineUserDaoImpl(OnlineUserDaoImpl onlineUserDaoImpl) {
		this.onlineUserDaoImpl = onlineUserDaoImpl;
	}

//-----------------------------------------------------------------------------
//1
	// Controller method that returns a list of all OnlineUsers.
	@GetMapping("/user")
	public List<OnlineUser> getAllOnlineUsers() {
		List<OnlineUser> userList = onlineUserDaoImpl.getAllOnlineUsers();
		return userList;
	}

//-----------------------------------------------------------------------------
//2
	// Controller method that returns a single OnlineUser by id.
	@GetMapping("/user/{u_id}")
	public OnlineUser getOnlineUserInfoById(@PathVariable int u_id) {
		OnlineUser onlineUser = onlineUserDaoImpl.getOnlineUserInfoById(u_id);
		return onlineUser;
	}

//-----------------------------------------------------------------------------
//3
	// Controller method that creates a new OnlineUser.
	@PostMapping("/user")
	public void createNewOnlineUser(@RequestBody OnlineUser onlineUser) {
		onlineUserDaoImpl.createNewOnlineUser(onlineUser);
	}

//-----------------------------------------------------------------------------
//4	
	// Controller method that deleted an OnlineUser by id.
	@DeleteMapping("/user/{u_id}")
	public void deleteOnlineUser(@PathVariable int u_id) {
		onlineUserDaoImpl.deleteOnlineUser(u_id);
	}

//-----------------------------------------------------------------------------
//5		
	// Controller method that sets an OnlineUser's username by id.
	@PutMapping("/user/u")
	public void setOnlineUserUserName(@RequestBody OnlineUser onlineUser) {
		onlineUserDaoImpl.setOnlineUserUserName(onlineUser);
	}

//-----------------------------------------------------------------------------
//6
	// Method that returns a boolean that represents whether the
	// password change in the specified online user was successful or not.
	@PutMapping("/user/p")
	public void setOnlineUserPassword(@RequestBody OnlineUser onlineUser) {
		onlineUserDaoImpl.setOnlineUserPassword(onlineUser);

	}

//-----------------------------------------------------------------------------
//7
	// Method that returns a boolean that represents whether the
	// email change in the specified online user was successful or not.
	@PutMapping("/user/e")
	public void setOnlineUserEmail(@RequestBody OnlineUser onlineUser) {
		onlineUserDaoImpl.setOnlineUserEmail(onlineUser);
	}
}

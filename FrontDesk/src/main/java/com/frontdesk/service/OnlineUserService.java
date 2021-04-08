package com.frontdesk.service;

import java.util.List;
import com.frontdesk.pojo.OnlineUser;

// REST Service interface for all database functionality 
// concerning OnlineUser objects.
public interface OnlineUserService {

	// 1
	public List<OnlineUser> getAllOnlineUsers();

	// 2
	public OnlineUser getOnlineUserInfoById(int u_id);

	// 3
	public void createNewOnlineUser(OnlineUser onlineUser);

	// 4
	public void deleteOnlineUser(int u_id);

	// 5
	public void setOnlineUserUserName(OnlineUser onlineUser);

	// 6
	public void setOnlineUserPassword(OnlineUser onlineUser);

	// 7
	public void setOnlineUserEmail(OnlineUser onlineUser);
}

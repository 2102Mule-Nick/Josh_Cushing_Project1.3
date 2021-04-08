package com.staykeep.dao;

import java.util.List;

import com.staykeep.pojo.OnlineUser;

//Interface for handling Database functions concerning OnlineUser objects.
public interface OnlineUserDao {

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

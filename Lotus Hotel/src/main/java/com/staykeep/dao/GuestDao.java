package com.staykeep.dao;

import java.util.List;

import com.staykeep.pojo.Guest;

//Interface for handling Database functions concerning Guest objects.
public interface GuestDao {

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
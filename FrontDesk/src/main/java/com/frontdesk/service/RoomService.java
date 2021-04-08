package com.frontdesk.service;

import java.util.List;
import com.frontdesk.pojo.Reservation;
import com.frontdesk.pojo.Room;
import com.frontdesk.pojo.Stay;

//REST Service interface for all database functionality 
//concerning Room objects.
public interface RoomService {

	// 1
	public List<Room> getAllRooms();

	// 2
	public Room getRoomInfoById(int r_id);

	// 3
	public void createNewRoom(Room room);

	// 4
	public void deleteRoom(int r_id);

	// 5
	public List<Room> getRoomsByStatus(String status);

	// 6
	public List<Reservation> getReservationsByRoom(int r_id);

	// 7
	public List<Stay> getStaysByRoom(int r_id);

	// 8
	public void setRoomStatus(String status, int r_id);
}

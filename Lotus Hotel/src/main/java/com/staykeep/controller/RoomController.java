package com.staykeep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.staykeep.daoimpl.RoomDaoImpl;
import com.staykeep.jms.JMSMessageSender;
import com.staykeep.pojo.Reservation;
import com.staykeep.pojo.Room;
import com.staykeep.pojo.Stay;

//REST Controller for all database functionality concerning room objects.
@Component
@RestController
public class RoomController {

	// RoomDaoImpl object holding functionality.
	private RoomDaoImpl roomDaoImpl;

	// JMS message sender
	//private JMSMessageSender jms;
	
	// Auto-Wired setter. Nothing calls this.
	@Autowired
	public void setRoomDaoImpl(RoomDaoImpl roomDaoImpl) {
		this.roomDaoImpl = roomDaoImpl;
	}
	
	// Auto-Wired setter. Nothing calls this.
	//@Autowired
	//public void setJms(JMSMessageSender jms) {
		//this.jms = jms;
	//}

	//---------------------------------------------------------------------
//1
	// Controller method that returns a list of all rooms.
	@Transactional
	@GetMapping("/room")
	public List<Room> getAllRooms() {
		List<Room> roomList = roomDaoImpl.getAllRooms();
		return roomList;
	}

//---------------------------------------------------------------------
//2
	// Controller method that returns a specific room by id.
	@GetMapping("/room/{r_id}")
	public Room getRoomInfoById(@PathVariable int r_id) {
		Room room = roomDaoImpl.getRoomInfoById(r_id);
		
		return room;
	}

//---------------------------------------------------------------------
//3
	// Controller method that creates a new room.
	@PostMapping("/room")
	public void createNewRoom(@RequestBody Room room) {
		roomDaoImpl.createNewRoom(room);
	}

//----------------------------------------------------------------------------
//4	
	// Controller method that deletes a room by id.
	@DeleteMapping("/room/{r_id}")
	public void deleteRoom(@PathVariable int r_id) {
		roomDaoImpl.deleteRoom(r_id);
	}

//----------------------------------------------------------------------------
//5	
	// Controller method that returns all rooms with a certain status.
	@GetMapping("/room/status/{status}")
	public List<Room> getRoomsByStatus(@PathVariable String status) {
		List<Room> roomList = roomDaoImpl.getRoomsByStatus(status);
		return roomList;
	}

//----------------------------------------------------------------------------
//6	
	// Controller method that returns all reservations for a certain room.
	@GetMapping("/room/{r_id}/reservations")
	public List<Reservation> getReservationsByRoom(@PathVariable int r_id) {
		List<Reservation> reservationList = roomDaoImpl.getReservationsByRoom(r_id);
		return reservationList;
	}

//----------------------------------------------------------------------------
//7	
	// Controller method that returns all stays in a certain room.
	@GetMapping("/room/{r_id}/stays")
	public List<Stay> getStaysByRoom(@PathVariable int r_id) {
		List<Stay> stayList = roomDaoImpl.getStaysByRoom(r_id);
		return stayList;
	}

//----------------------------------------------------------------------------
//8		
	// Controller method that sets the status of a certain room.
	@PutMapping("/room/{r_id}/status/{status}")
	public void setRoomStatus(@PathVariable int r_id, @PathVariable String status) {
		roomDaoImpl.setRoomStatus(status, r_id);
	}
}
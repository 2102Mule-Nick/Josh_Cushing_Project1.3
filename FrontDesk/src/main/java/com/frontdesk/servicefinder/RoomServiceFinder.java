package com.frontdesk.servicefinder;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;

import com.frontdesk.pojo.Reservation;
import com.frontdesk.pojo.Room;
import com.frontdesk.pojo.Stay;
import com.frontdesk.service.RoomService;

//REST Service for all database functionality concerning Room objects.
@Service
public class RoomServiceFinder implements RoomService {

	// Rest template for easy serialization
	RestTemplate restTemplate;

	// Auto-wired setter. Nothing calls this.
	@Autowired
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

// -----------------------------------------------------------------------
//1
	// Service method that requests staykeep to return a list of all rooms.
	@Override
	public List<Room> getAllRooms() {
		final String URL = "http://localhost:8081/staykeep/room";
		Room[] rooms = restTemplate.getForObject(URL, Room[].class);
		return Arrays.asList(rooms);
	}

//---------------------------------------------------------------------
//2
	// Service method that requests staykeep to return a specific room by id.
	@Override
	public Room getRoomInfoById(int r_id) {
		final String URL = "http://localhost:8081/staykeep/room/" + r_id;
		return restTemplate.getForObject(URL, Room.class);
	}

//---------------------------------------------------------------------
//3
	// Service method that requests staykeep to create a new room.
	@Override
	public void createNewRoom(Room room) {
		final String URL = "http://localhost:8081/staykeep/room";
		restTemplate.postForEntity(URL, room, null);
	}

//---------------------------------------------------------------------
//4
	// Service method that requests staykeep to delete a specific room by id
	@Override
	public void deleteRoom(int r_id) {
		final String URL = "http://localhost:8081/staykeep/room/" + r_id;
		restTemplate.delete(URL, Room.class);
	}

//----------------------------------------------------------------------------
//5	
	// Service method that requests staykeep to return a list of rooms with a
	// certain status.
	@Override
	public List<Room> getRoomsByStatus(String status) {
		final String URL = "http://localhost:8081/staykeep/room/status/" + status;
		Room[] rooms = restTemplate.getForObject(URL, Room[].class);
		return Arrays.asList(rooms);
	}

//----------------------------------------------------------------------------
//6	
	// Service method that requests staykeep to return a list of all reservations in
	// a certain room.
	@Override
	public List<Reservation> getReservationsByRoom(int r_id) {
		final String URL = "http://localhost:8081/staykeep/room/" + r_id + "/reservations";
		Reservation[] reservations = restTemplate.getForObject(URL, Reservation[].class);
		return Arrays.asList(reservations);
	}

//----------------------------------------------------------------------------
//7		
	// Service method that requests staykeep to return a list of all stays in a
	// certain room.
	@Override
	public List<Stay> getStaysByRoom(int r_id) {
		final String URL = "http://localhost:8081/staykeep/room/" + r_id + "/stays";
		Stay[] stays = restTemplate.getForObject(URL, Stay[].class);
		return Arrays.asList(stays);
	}

//----------------------------------------------------------------------------
//8
	// Service method that requests staykeep to set the reservation status of a
	// certain room.
	@Override
	public void setRoomStatus(String status, int r_id) {
		final String URL = "http://localhost:8081/staykeep/room/" + r_id + "/status/" + status;
		restTemplate.put(URL, null);
	}

}
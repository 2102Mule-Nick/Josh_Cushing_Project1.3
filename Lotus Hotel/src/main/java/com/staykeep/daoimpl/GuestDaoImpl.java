package com.staykeep.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.staykeep.dao.GuestDao;
import com.staykeep.mapper.GuestRowMapper;
import com.staykeep.pojo.Guest;

//Implementation for handling Database functions concerning Guest objects.
@Repository
public class GuestDaoImpl implements GuestDao {

	// JDBC Template to use for database connection.
	private JdbcTemplate jdbcTemplate;

	// GuestRowMapper to return Guest objects from database.
	private GuestRowMapper guestRowMapper;

	// Auto-wired JDBC Template setter --> nothing calls this.
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// Auto-wired GuestRowMapper setter --> nothing calls this.
	@Autowired
	public void setGuestRowMapper(GuestRowMapper guestRowMapper) {
		this.guestRowMapper = guestRowMapper;
	}	
//-------------------------------------------------------------------------------------------------------
//1
	// Dao method that returns a list of all guests.
	@Override
	public List<Guest> getAllGuests() {
		String sql = "SELECT g_id, f_name, l_name, cc_num FROM guest";
		List<Guest> guestList = jdbcTemplate.query(sql, guestRowMapper);
		return guestList;
	}

//-------------------------------------------------------------------------------------------------------
//2
	// Dao method that returns a single guest by id.
	@Override
	public Guest getGuestInfoById(int g_id) {
		String sql = "SELECT g_id, f_name, l_name, cc_num FROM guest WHERE g_id = ?";
		List<Guest> guestList = jdbcTemplate.query(sql, guestRowMapper, g_id);
		return guestList.get(0);
	}

//--------------------------------------------------------------------
//3
	// Dao method that creates a new guest.
	@Override
	public Guest createNewGuest(Guest guest) {

		// A sql string is created to insert the new object into the db
		String sql = "INSERT INTO guest (f_name, l_name, cc_num) VALUES ( ?, ?, ? )";
		
		// The values needed are extracted from the object.
		String f_name = guest.getF_name();
		String l_name = guest.getL_name();
		String cc_num = guest.getCc_num();
		
		// A keyholder is instantiated
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		// This pure Iyad right here
		jdbcTemplate.update(connection -> {
			//The prepared statement inserts a new Guest and then  returns their generated key
			PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, f_name);
			ps.setString(2, l_name);
			ps.setString(3, cc_num);
			//Then it is returned to the "connection" function?
			return ps;
		}, keyHolder); 
		//Both the fancy prepped statement and the keyholder are plugged into the jdbcTemplate.update() method
		
		// Then the g_id is extracted kinda like from a result set
		int guestId = (int) keyHolder.getKeys().get("g_id");
		
		//it is set to the guest.
		guest.setG_id(guestId);
		
		//the guest is returned
		return guest;
	}

//--------------------------------------------------------------------
//4	
	// Dao method that deletes a guest by id.
	@Override
	public void deleteGuest(int g_id) {
		String sql = "DELETE FROM guest WHERE g_id = ?";
		Object[] args = new Object[] { g_id };
		jdbcTemplate.update(sql, args);
	}

//--------------------------------------------------------------------	
//5
	// Dao method that sets a guest's first name by id.
	@Override
	public void setGuestFname(Guest guest) {

		String f_name = guest.getF_name();
		int g_id = guest.getG_id();
		String sql = "UPDATE guest SET f_name = ? WHERE g_id = ?";
		Object[] args = new Object[] { f_name, g_id };
		jdbcTemplate.update(sql, args);
	}

//--------------------------------------------------------------------		
//6
	// Dao method that sets a guest's last name by id.
	@Override
	public void setGuestLname(Guest guest) {
		String l_name = guest.getL_name();
		int g_id = guest.getG_id();
		String sql = "UPDATE guest SET l_name = ? WHERE g_id = ?";
		Object[] args = new Object[] { l_name, g_id };
		jdbcTemplate.update(sql, args);
	}

//--------------------------------------------------------------------	
//7
	// Controller method that sets a guest's credit card number by id.
	@Override
	public void setGuestCcnum(Guest guest) {

		String cc_num = guest.getCc_num();
		int g_id = guest.getG_id();
		String sql = "UPDATE guest SET cc_num = ? WHERE g_id = ?";
		Object[] args = new Object[] { cc_num, g_id };
		jdbcTemplate.update(sql, args);
	}
}

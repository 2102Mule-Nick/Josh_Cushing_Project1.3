package com.staykeep.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.staykeep.extractor.GuestExtractor;
import com.staykeep.pojo.Guest;

// RowMapper class to return results form the database.
@Component
public class GuestRowMapper implements RowMapper<Guest> {
	
	// Guest extractor object
	private GuestExtractor guestExtractor;

	// Auto-wired setter. Nothing calls this.
	@Autowired
	public void setGuestExtractor(GuestExtractor guestExtractor) {
		this.guestExtractor = guestExtractor;
	}

	// Calls the extractData method which extracts the data from the database into an object.
	@Override
	public Guest mapRow(ResultSet rs, int rowNum) throws SQLException {
		return guestExtractor.extractData(rs);
	}
}

package com.staykeep.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.staykeep.extractor.OnlineUserExtractor;
import com.staykeep.pojo.OnlineUser;

//RowMapper class to return results form the database.
@Component
public class OnlineUserRowMapper implements RowMapper<OnlineUser>{
	
	// OnlineUser extractor object
	private OnlineUserExtractor onlineUserExtractor;

	// Auto-wired setter. Nothing calls this.
	@Autowired
	public void setOnlineUserExtractor(OnlineUserExtractor onlineUserExtractor) {
		this.onlineUserExtractor = onlineUserExtractor;
	}
	
	// Calls the extractData method which extracts the data from the database into an object.
	@Override
	public OnlineUser mapRow(ResultSet rs, int rowNum) throws SQLException {
		return onlineUserExtractor.extractData(rs);
	}
}

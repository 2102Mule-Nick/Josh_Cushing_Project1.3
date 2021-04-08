package com.staykeep.extractor;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.staykeep.pojo.OnlineUser;

//Extracts the data from the database into an object.
@Component
public class OnlineUserExtractor implements ResultSetExtractor<OnlineUser> {
	@Override
	public OnlineUser extractData(ResultSet rs) throws SQLException, DataAccessException {
		OnlineUser onlineUser = new OnlineUser();
		onlineUser.setU_id(rs.getInt("u_id"));
		onlineUser.setUser_name(rs.getString("user_name"));
		onlineUser.setPass_word(rs.getString("pass_word"));
		onlineUser.setEmail(rs.getString("email"));
		return onlineUser;
	}
}	

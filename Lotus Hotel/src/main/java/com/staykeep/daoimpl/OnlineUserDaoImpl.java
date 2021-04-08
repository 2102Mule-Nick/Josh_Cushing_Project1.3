package com.staykeep.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.staykeep.dao.OnlineUserDao;
import com.staykeep.mapper.OnlineUserRowMapper;

import com.staykeep.pojo.OnlineUser;

//Implementation for handling Database functions concerning OnlineUser objects.
@Repository
public class OnlineUserDaoImpl implements OnlineUserDao {

	// JDBC Template to use for database connection.
	private JdbcTemplate jdbcTemplate;

	// OnlineUserRowMapper to return Room objects from database.
	private OnlineUserRowMapper onlineUserRowMapper;

	// Auto-wired setter --> nothing calls this.
	@Autowired
	public void setJdbcdTemplate(JdbcTemplate jdbcdTemplate) {
		this.jdbcTemplate = jdbcdTemplate;
	}

	// Auto-wired setter --> nothing calls this.
	@Autowired
	public void setOnlineUserRowMapper(OnlineUserRowMapper onlineUserRowMapper) {
		this.onlineUserRowMapper = onlineUserRowMapper;
	}
	
//-------------------------------------------------------------------------
//1
	// Dao method that returns a list of all online users.
	@Override
	public List<OnlineUser> getAllOnlineUsers() {
		String sql = "SELECT u_id, user_name, pass_word, email FROM online_user";
		List<OnlineUser> ouList = jdbcTemplate.query(sql, onlineUserRowMapper);
		return ouList;
	}

//-------------------------------------------------------------------------
//2
	// Dao method that returns the online user with the specified id.
	@Override
	public OnlineUser getOnlineUserInfoById(int u_id) {
		String sql = "SELECT u_id, user_name, pass_word, email FROM online_user WHERE u_id = ?";
		List<OnlineUser> ouList = jdbcTemplate.query(sql, onlineUserRowMapper, u_id);
		return ouList.get(0);
	}
	
//-------------------------------------------------------------------------
//3
	// Dao method that creates a new OnlineUser.
	@Override
	public void createNewOnlineUser(OnlineUser onlineUser) {
		String user_name = onlineUser.getUser_name();
		String pass_word = onlineUser.getPass_word();
		String email = onlineUser.getEmail();
		String sql = "INSERT INTO online_user (user_name, pass_word, email) VALUES (?, ?, ? )";
		Object[] args = new Object[] {user_name, pass_word, email};
		jdbcTemplate.update(sql, args);
	}

//-------------------------------------------------------------------------
//4
	// Dao method that deletes an OnlineUser by id.
	@Override
	public void deleteOnlineUser(int u_id) {
		String sql = "DELETE FROM online_user WHERE u_id = ?";
		Object[] args = new Object[] {u_id};
		jdbcTemplate.update(sql, args);
	}

//--------------------------------------------------------------------	
//5
	// Dao method that sets an OnlineUser's username.
	@Override
	public void setOnlineUserUserName(OnlineUser onlineUser) {
		String user_name = onlineUser.getUser_name();
		int u_id = onlineUser.getU_id();
		String sql = "UPDATE online_user SET user_name = ? WHERE u_id = ?";
		Object[] args = new Object[] { user_name, u_id };
		jdbcTemplate.update(sql, args);
	}

//--------------------------------------------------------------------		
//6	
	// Dao method that sets an OnlineUser's password.
	@Override
	public void setOnlineUserPassword(OnlineUser onlineUser) {
		String pass_word = onlineUser.getPass_word();
		int u_id = onlineUser.getU_id();
		String sql = "UPDATE online_user SET pass_word = ? WHERE u_id = ?";
		Object[] args = new Object[] { pass_word, u_id };
		jdbcTemplate.update(sql, args);
	}

//--------------------------------------------------------------------		
//7	
	// Dao method that sets an OnlineUser's email.
	@Override
	public void setOnlineUserEmail(OnlineUser onlineUser) {
		String email = onlineUser.getEmail();
		int u_id = onlineUser.getU_id();
		String sql = "UPDATE online_user SET email = ? WHERE u_id = ?";
		Object[] args = new Object[] { email, u_id };
		jdbcTemplate.update(sql, args);
	}
}

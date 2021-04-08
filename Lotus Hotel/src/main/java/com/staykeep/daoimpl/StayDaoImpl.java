package com.staykeep.daoimpl;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.staykeep.dao.StayDao;
import com.staykeep.mapper.StayRowMapper;
import com.staykeep.pojo.Stay;

@Repository
public class StayDaoImpl implements StayDao {

	// JDBC Template to use for database connection.
	private JdbcTemplate jdbcTemplate;

	// GuestRowMapper to return Guest objects from database.
	private StayRowMapper stayRowMapper;

	// Auto-wired JDBC Template setter --> nothing calls this.
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// Auto-wired JDBC Template setter --> nothing calls this.
	@Autowired
	public void setStayRowMapper(StayRowMapper stayRowMapper) {
		this.stayRowMapper = stayRowMapper;
	}

// ------------------------------------------------------------------------------------
//1
	// Dao method that returns a list of all stays.
	@Override
	public List<Stay> getAllStays() {
		String sql = "SELECT s_id, ch_i_time, ch_i_date, ch_o_time, ch_o_date, g_id, r_id, bill, is_current FROM stay";
		List<Stay> stayList = jdbcTemplate.query(sql, stayRowMapper);
		return stayList;
	}

// -----------------------------------------------------------------------
//2
	// Dao method that returns a single stay given the id
	@Override
	public Stay getStayInfoById(int s_id) {
		String sql = "SELECT s_id, ch_i_time, ch_i_date, ch_o_time, ch_o_date, g_id, r_id, bill, is_current FROM stay WHERE s_id = ?";
		List<Stay> stayList = jdbcTemplate.query(sql, stayRowMapper, s_id);
		return stayList.get(0);
	}

// -----------------------------------------------------------------------
//3
	// Dao method that creates a new list based off the following.
	@Override
	public void createNewStay(Stay stay) {
		Time ch_i_time = stay.getCh_i_time();
		Date ch_i_date = stay.getCh_i_date();
		Time ch_o_time = stay.getCh_o_time();
		Date ch_o_date = stay.getCh_o_date();
		int g_id = stay.getG_id();
		int r_id = stay.getR_id();
		float bill = stay.getBill();
		boolean is_current = stay.getIs_current();
		String sql = "INSERT INTO stay (ch_i_time, ch_i_date, ch_o_time, ch_o_date, g_id, r_id, bill, is_current) VALUES ( ?, ?, ?, ?, ?, ?, ?, ? )";
		Object[] args = new Object[] { ch_i_time, ch_i_date, ch_o_time, ch_o_date, g_id, r_id, bill, is_current };
		jdbcTemplate.update(sql, args);
	}

// -----------------------------------------------------------------------
//4
	// Dao method that deletes a stay by id.
	@Override
	public void deleteStay(int s_id) {
		String sql = "DELETE FROM stay WHERE s_id = ?";
		Object[] args = new Object[] { s_id };
		jdbcTemplate.update(sql, args);
	}

// -----------------------------------------------------------------------
//5
	// Dao method that sets stay currency
	@Override
	public void setIsCurrent(boolean is_current, int s_id) {
		String sql = "UPDATE stay SET is_current = ? WHERE s_id = ?";
		Object[] args = new Object[] { is_current, s_id };
		jdbcTemplate.update(sql, args);
	}

// -----------------------------------------------------------------------
//6
	// Dao method that requests staykeep to set bill
	@Override
	public void setBill(Stay stay) {
		String sql = "UPDATE stay SET bill = ? WHERE s_id = ?";
		int s_id = stay.getS_id();
		float bill = stay.getBill();
		Object[] args = new Object[] { bill, s_id };
		jdbcTemplate.update(sql, args);
	}

// -----------------------------------------------------------------------
//7
	// Dao method that sets stay check-in-time
	@Override
	public void setStayInTime(Stay stay) {
		Time ch_i_time = stay.getCh_i_time();
		int s_id = stay.getS_id();
		String sql = "UPDATE stay SET ch_i_time = ? WHERE s_id = ?";
		Object[] args = new Object[] { ch_i_time, s_id };
		jdbcTemplate.update(sql, args);
	}

// -----------------------------------------------------------------------
//8
	// Dao method that sets stay check-in-date
	@Override
	public void setStayInDate(Stay stay) {
		Date ch_i_date = stay.getCh_i_date();
		int s_id = stay.getS_id();
		String sql = "UPDATE stay SET ch_i_date = ? WHERE s_id = ?";
		Object[] args = new Object[] { ch_i_date, s_id };
		jdbcTemplate.update(sql, args);
	}

// -----------------------------------------------------------------------
//9
	// Dao method that sets stay check-in-time
	@Override
	public void setStayOutTime(Stay stay) {
		Time ch_o_time = stay.getCh_o_time();
		int s_id = stay.getS_id();
		String sql = "UPDATE stay SET ch_o_time = ? WHERE s_id = ?";
		Object[] args = new Object[] { ch_o_time, s_id };
		jdbcTemplate.update(sql, args);
	}

// -----------------------------------------------------------------------
//10
	// Dao method that sets stay check-out-date
	@Override
	public void setStayOutDate(Stay stay) {
		Date ch_o_date = stay.getCh_o_date();
		int s_id = stay.getS_id();
		String sql = "UPDATE stay SET ch_o_date = ? WHERE s_id = ?";
		Object[] args = new Object[] { ch_o_date, s_id };
		jdbcTemplate.update(sql, args);
	}

}
package com.lotus.staykeep.daoimpl;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lotus.staykeep.dao.StayDao;
import com.lotus.staykeep.mapper.StayRowMapper;
import com.lotus.staykeep.pojo.Reservation;
import com.lotus.staykeep.pojo.Stay;

//Indicates that an annotated class is a Repository.
@Repository
public class StayDaoImpl implements StayDao {

	//Logger
	private Logger log;
	
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
	
	// Auto-wired Logger setter --> nothing calls this.
		@Autowired
		public void setLogger(Logger log) {
			this.log = log;
		}
//------------------------------------------------------------------------------------
	@Override
	public Stay getStayInfoById(int s_id) {
		String sql = "SELECT s_id, ch_i_time, ch_i_date, ch_o_time, ch_o_date, g_id, r_id, bill FROM stay WHERE s_id = ?";
		List<Stay> stayList = jdbcTemplate.query(sql, stayRowMapper, s_id);
		return stayList.get(0);
	}

	@Override
	public List<Stay> getAllStays() {
		String sql = "SELECT s_id, ch_i_time, ch_i_date, ch_o_time, ch_o_date, g_id, r_id, bill FROM stay";
		List<Stay> stayList = jdbcTemplate.query(sql, stayRowMapper);
		return stayList;
	}

	@Override
	public void createNewStay(Time ch_i_time, Date ch_i_date, Time ch_o_time, Date ch_o_date, int g_id, int r_id, float bill) {
		String sql = "INSERT INTO stay (ch_i_time, ch_i_date, ch_o_time, ch_o_date, g_id, r_id, bill) VALUES ( ?, ?, ?, ?, ?, ?, ? )";
		jdbcTemplate.update(sql, ch_i_time, ch_i_date, ch_o_time, ch_o_date, g_id, r_id, bill);
		
	}

	@Override
	public void setStayInTime(Time ch_i_time, int s_id) {
		String sql = "UPDATE stay SET ch_i_time = ? WHERE s_id = ?";
		jdbcTemplate.update(sql, ch_i_time, s_id);
		
	}

	@Override
	public void setStayInDate(Date ch_i_date, int s_id) {
		String sql = "UPDATE stay SET ch_i_date = ? WHERE s_id = ?";
		jdbcTemplate.update(sql, ch_i_date, s_id);
		
	}

	@Override
	public void setStayOutTime(Time ch_o_time, int s_id) {
		String sql = "UPDATE stay SET ch_o_time = ? WHERE s_id = ?";
		jdbcTemplate.update(sql, ch_o_time, s_id);
	}

	@Override
	public void setStayOutDate(Date ch_o_date, int s_id) {
		String sql = "UPDATE stay SET ch_o_date = ? WHERE s_id = ?";
		jdbcTemplate.update(sql, ch_o_date, s_id);
		
	}

	@Override
	public void changeResToStay(Reservation res) {
		System.out.println("LOL ADD SOME FUNCTIONALITY, SCRUB");
		
	}

}

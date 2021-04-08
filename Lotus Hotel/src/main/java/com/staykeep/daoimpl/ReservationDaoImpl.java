package com.staykeep.daoimpl;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.staykeep.dao.ReservationDao;
import com.staykeep.mapper.ReservationRowMapper;
import com.staykeep.pojo.Reservation;

@Repository
public class ReservationDaoImpl implements ReservationDao {

	// JDBC Template to use for database connection.
	private JdbcTemplate jdbcTemplate;

	// GuestRowMapper to return Guest objects from database.
	private ReservationRowMapper reservationRowMapper;

	// Auto-wired JDBC Template setter --> nothing calls this.
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// Auto-wired ReservationRowMapper setter --> nothing calls this.
	@Autowired
	public void setReservationRowMapper(ReservationRowMapper reservationRowMapper) {
		this.reservationRowMapper = reservationRowMapper;
	}

// -----------------------------------------------------------------------------------------
//1
	// Dao method that returns a list of all reservations.
	@Override
	public List<Reservation> getAllRes() {
		String sql = "SELECT res_id, ch_i_time, ch_i_date, ch_o_time, ch_o_date, r_id, u_id, status FROM reservation";
		List<Reservation> reservationList = jdbcTemplate.query(sql, reservationRowMapper);
		return reservationList;
	}

// -----------------------------------------------------------------------------------------
//2	
	// Dao method that returns the reservation with the specified id.
	@Override
	public Reservation getResById(int res_id) {
		String sql = "SELECT res_id, ch_i_time, ch_i_date, ch_o_time, ch_o_date, r_id, u_id, status FROM reservation WHERE res_id = ?";
		List<Reservation> reservationList = jdbcTemplate.query(sql, reservationRowMapper, res_id);
		return reservationList.get(0);
	}

// -----------------------------------------------------------------------------------------
//3	
	// Dao method that creates a new reservation.
	@Override
	public void createNewReservation(Reservation reservation) {
		Time ch_i_time = reservation.getCh_i_time();
		Date ch_i_date = reservation.getCh_i_date();
		Time ch_o_time = reservation.getCh_o_time();
		Date ch_o_date = reservation.getCh_o_date();
		int r_id = reservation.getR_id();
		int u_id = reservation.getU_id();
		String status = reservation.getStatus();
		String sql = "INSERT INTO reservation (ch_i_time, ch_i_date, ch_o_time, ch_o_date, r_id, u_id, status) VALUES ( ?, ?, ?, ?, ?, ?, ? )";
		Object[] args = new Object[] { ch_i_time, ch_i_date, ch_o_time, ch_o_date, r_id, u_id, status };
		jdbcTemplate.update(sql, args);
	}

// -----------------------------------------------------------------------------------------
//4		
	// Dao method to delete a specific reservation by id.
	@Override
	public void deleteRes(int res_id) {
		String sql = "DELETE FROM reservation WHERE res_id = ?";
		Object[] args = new Object[] { res_id };
		jdbcTemplate.update(sql, args);
	}

// -----------------------------------------------------------------------------------------
//5		
	// Dao method that returns a list of reservations with a certain status.
	@Override
	public List<Reservation> getAllResStatus(String status) {
		String sql = "SELECT res_id, ch_i_time, ch_i_date, ch_o_time, ch_o_date, r_id, u_id, status FROM reservation WHERE status = ?";
		List<Reservation> reservationList = jdbcTemplate.query(sql, reservationRowMapper, status);
		return reservationList;
	}

// -----------------------------------------------------------------------------------------
//6		
	// Dao method that sets a reservation's check-in-time to a certain value.
	@Override
	public void setResInTime(Reservation reservation) {
		Time ch_i_time = reservation.getCh_i_time();
		int res_id = reservation.getRes_id();
		String sql = "UPDATE reservation SET ch_i_time = ? WHERE res_id = ?";
		Object[] args = new Object[] { ch_i_time, res_id };
		jdbcTemplate.update(sql, args);
	}

// -----------------------------------------------------------------------------------------
//7
	// Dao method that sets a reservation's check-in-date to a certain value.
	@Override
	public void setResInDate(Reservation reservation) {
		Date ch_i_date = reservation.getCh_i_date();
		int res_id = reservation.getRes_id();
		String sql = "UPDATE reservation SET ch_i_date = ? WHERE res_id = ?";
		Object[] args = new Object[] { ch_i_date, res_id };
		jdbcTemplate.update(sql, args);
	}

// -----------------------------------------------------------------------------------------
//8
	// Dao method that sets a reservation's check-out-time to a certain value.
	@Override
	public void setResOutTime(Reservation reservation) {
		Time ch_o_time = reservation.getCh_o_time();
		int res_id = reservation.getRes_id();
		String sql = "UPDATE reservation SET ch_o_time = ? WHERE res_id = ?";
		Object[] args = new Object[] { ch_o_time, res_id };
		jdbcTemplate.update(sql, args);
	}

// -----------------------------------------------------------------------------------------
//9
	// Dao method that sets a reservation's check-out-date to a certain value.
	@Override
	public void setResOutDate(Reservation reservation) {
		Date ch_o_date = reservation.getCh_o_date();
		int res_id = reservation.getRes_id();
		String sql = "UPDATE reservation SET ch_o_date = ? WHERE res_id = ?";
		Object[] args = new Object[] { ch_o_date, res_id };
		jdbcTemplate.update(sql, args);
	}

// -----------------------------------------------------------------------------------------
//10
	/// Dao method that sets a reservation's status to a certain value.
	@Override
	public void setResStatus(Reservation reservation) {
		String status = reservation.getStatus();
		int res_id = reservation.getRes_id();
		String sql = "UPDATE reservation SET status = ? WHERE res_id = ?";
		Object[] args = new Object[] { status, res_id };
		jdbcTemplate.update(sql, args);
	}
}

package com.lotus.staykeep.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.lotus.staykeep.extractor.ReservationExtractor;
import com.lotus.staykeep.pojo.Reservation;

@Component
public class ReservationRowMapper implements RowMapper<Reservation>{
	
	private ReservationExtractor reservationExtractor;
	
	@Autowired
	public void setReservationExtractor(ReservationExtractor reservationExtractor) {
		this.reservationExtractor = reservationExtractor;
	}
	
	@Override
	public Reservation mapRow(ResultSet rs, int rowNum) throws SQLException {
		return reservationExtractor.extractData(rs);
	}
}

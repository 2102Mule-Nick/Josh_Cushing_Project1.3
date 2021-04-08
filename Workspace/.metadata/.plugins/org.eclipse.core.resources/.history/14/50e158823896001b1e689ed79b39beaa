package com.staykeep.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.staykeep.extractor.StayExtractor;
import com.staykeep.pojo.Stay;

@Component
public class StayRowMapper implements RowMapper<Stay> {
	private StayExtractor stayExtractor;

	@Autowired
	public void setRoomExtractor(StayExtractor stayExtractor) {
		this.stayExtractor = stayExtractor;
	}

	@Override
	public Stay mapRow(ResultSet rs, int rowNum) throws SQLException {

		return stayExtractor.extractData(rs);
	}

}

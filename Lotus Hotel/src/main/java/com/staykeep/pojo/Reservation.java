package com.staykeep.pojo;

import java.sql.Date;
import java.sql.Time;

// Pojo representing an online reservation that will become a stay when the user checks in.
public class Reservation {
	
	// Unique serial user id
	private int res_id;
	
	// Check in time
	private Time ch_i_time;

	// Check in date
	private Date ch_i_date;
	
	// Check out time
	private Time ch_o_time;
	
	// Check out date
	private Date ch_o_date;
	
	// id of the room the reservation is made for
	private int r_id;
	
	// id of the user who made the reservation
	private int u_id;
	
	// state of the reservation: completed, canceled, or upcoming
	private String status;

//-------------------------------------
	
	// Default getter
	public int getRes_id() {
		return res_id;
	}

	// Default setter
	public void setRes_id(int res_id) {
		this.res_id = res_id;
	}

	// Default getter
	public Time getCh_i_time() {
		return ch_i_time;
	}

	// Default setter
	public void setCh_i_time(Time ch_i_time) {
		this.ch_i_time = ch_i_time;
	}

	// Default getter
	public Date getCh_i_date() {
		return ch_i_date;
	}

	// Default setter
	public void setCh_i_date(Date ch_i_date) {
		this.ch_i_date = ch_i_date;
	}

	// Default getter
	public Time getCh_o_time() {
		return ch_o_time;
	}

	// Default setter
	public void setCh_o_time(Time ch_o_time) {
		this.ch_o_time = ch_o_time;
	}

	// Default getter
	public Date getCh_o_date() {
		return ch_o_date;
	}

	// Default setter
	public void setCh_o_date(Date ch_o_date) {
		this.ch_o_date = ch_o_date;
	}

	// Default getter
	public int getR_id() {
		return r_id;
	}

	// Default setter
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}

	// Default getter
	public int getU_id() {
		return u_id;
	}

	// Default setter
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	// Default getter
	public String getStatus() {
		return status;
	}
	
	// Default setter
	public void setStatus(String status) {
		this.status = status;
	}

	// args constructor
	public Reservation(int res_id, Time ch_i_time, Date ch_i_date, Time ch_o_time, Date ch_o_date, int r_id, int u_id,
			String status) {
		super();
		this.res_id = res_id;
		this.ch_i_time = ch_i_time;
		this.ch_i_date = ch_i_date;
		this.ch_o_time = ch_o_time;
		this.ch_o_date = ch_o_date;
		this.r_id = r_id;
		this.u_id = u_id;
		this.status = status;
	}

	// no-args constructor
	public Reservation() {
		super();
	}

	// to-string method
	@Override
	public String toString() {
		return "Reservation [res_id=" + res_id + ", ch_i_time=" + ch_i_time + ", ch_i_date=" + ch_i_date
				+ ", ch_o_time=" + ch_o_time + ", ch_o_date=" + ch_o_date + ", r_id=" + r_id + ", u_id=" + u_id
				+ ", status=" + status + "]";
	}

	// hashcode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ch_i_date == null) ? 0 : ch_i_date.hashCode());
		result = prime * result + ((ch_i_time == null) ? 0 : ch_i_time.hashCode());
		result = prime * result + ((ch_o_date == null) ? 0 : ch_o_date.hashCode());
		result = prime * result + ((ch_o_time == null) ? 0 : ch_o_time.hashCode());
		result = prime * result + r_id;
		result = prime * result + res_id;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + u_id;
		return result;
	}

	// equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		if (ch_i_date == null) {
			if (other.ch_i_date != null)
				return false;
		} else if (!ch_i_date.equals(other.ch_i_date))
			return false;
		if (ch_i_time == null) {
			if (other.ch_i_time != null)
				return false;
		} else if (!ch_i_time.equals(other.ch_i_time))
			return false;
		if (ch_o_date == null) {
			if (other.ch_o_date != null)
				return false;
		} else if (!ch_o_date.equals(other.ch_o_date))
			return false;
		if (ch_o_time == null) {
			if (other.ch_o_time != null)
				return false;
		} else if (!ch_o_time.equals(other.ch_o_time))
			return false;
		if (r_id != other.r_id)
			return false;
		if (res_id != other.res_id)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (u_id != other.u_id)
			return false;
		return true;
	}

	
	
}

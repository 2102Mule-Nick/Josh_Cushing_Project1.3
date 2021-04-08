package com.frontdesk.pojo;

import java.sql.Date;

import java.sql.Time;

//Pojo representing the present and past stays at the hotel.
public class Stay {
	
	// Unique serial user id
	private int s_id;
	
	// Check in time
	private Time ch_i_time;
	
	// Check in date
	private Date ch_i_date;
	
	// Check out time
	private Time ch_o_time;
	
	// Check out date
	private Date ch_o_date;
	
	// id of the guest paying for the room
	private int g_id;
	
	// id of the room the stay happened in
	private int r_id;
	
	// total bill for the stay
	private float bill;
	
	// denotes whether the stay is the current one or not
	private boolean is_current;

//-------------------------------------	

	// Default getter
	public int getS_id() {
		return s_id;
	}

	// Default setter
	public void setS_id(int s_id) {
		this.s_id = s_id;
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
	public int getG_id() {
		return g_id;
	}

	// Default setter
	public void setG_id(int g_id) {
		this.g_id = g_id;
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
	public float getBill() {
		return bill;
	}

	// Default setter
	public void setBill(float bill) {
		this.bill = bill;
	}
	
	// Default getter
	public boolean getIs_current() {
		return is_current;
	}

	// Default setter
	public void setIs_current(boolean is_current) {
		this.is_current = is_current;
	}

	// args constructor
	public Stay(int s_id, Time ch_i_time, Date ch_i_date, Time ch_o_time, Date ch_o_date, int g_id, int r_id,
			float bill, boolean is_current) {
		super();
		this.s_id = s_id;
		this.ch_i_time = ch_i_time;
		this.ch_i_date = ch_i_date;
		this.ch_o_time = ch_o_time;
		this.ch_o_date = ch_o_date;
		this.g_id = g_id;
		this.r_id = r_id;
		this.bill = bill;
		this.is_current = is_current;
	}
	
	// no-args constructor
	public Stay() {
		super();
	}

	// to-string method
	@Override
	public String toString() {
		return "Stay [s_id=" + s_id + ", ch_i_time=" + ch_i_time + ", ch_i_date=" + ch_i_date + ", ch_o_time="
				+ ch_o_time + ", ch_o_date=" + ch_o_date + ", g_id=" + g_id + ", r_id=" + r_id + ", bill=" + bill
				+ ", is_current=" + is_current + "]";
	}

	// hashcode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(bill);
		result = prime * result + ((ch_i_date == null) ? 0 : ch_i_date.hashCode());
		result = prime * result + ((ch_i_time == null) ? 0 : ch_i_time.hashCode());
		result = prime * result + ((ch_o_date == null) ? 0 : ch_o_date.hashCode());
		result = prime * result + ((ch_o_time == null) ? 0 : ch_o_time.hashCode());
		result = prime * result + g_id;
		result = prime * result + (is_current ? 1231 : 1237);
		result = prime * result + r_id;
		result = prime * result + s_id;
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
		Stay other = (Stay) obj;
		if (Float.floatToIntBits(bill) != Float.floatToIntBits(other.bill))
			return false;
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
		if (g_id != other.g_id)
			return false;
		if (is_current != other.is_current)
			return false;
		if (r_id != other.r_id)
			return false;
		if (s_id != other.s_id)
			return false;
		return true;
	}
}

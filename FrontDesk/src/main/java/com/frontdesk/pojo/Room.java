package com.frontdesk.pojo;

// Pojo representing the physical rooms at the hotel.
public class Room {
	
	// Unique serial user id. Also used as physical room number.
	private int r_id;
	
	// Room status. Resetting, Open, Occupied, or Maintenance
	private String status;
	
	// bed number: always 1 or 2
	private int bed_num;
	
	// bed size: Single or double
	private String bed_size;
	
	// luxury level: 
	private String lux_lev;
	
	// cost per night
	private float cpn;

//-------------------------------------
	
	// Default getter
	public int getR_id() {
		return r_id;
	}

	// Default setter
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}

	// Default getter
	public String getStatus() {
		return status;
	}

	// Default setter
	public void setStatus(String status) {
		this.status = status;
	}

	// Default getter
	public int getBed_num() {
		return bed_num;
	}

	// Default setter
	public void setBed_num(int bed_num) {
		this.bed_num = bed_num;
	}

	// Default getter
	public String getBed_size() {
		return bed_size;
	}

	// Default setter
	public void setBed_size(String bed_size) {
		this.bed_size = bed_size;
	}

	// Default getter
	public String getLux_lev() {
		return lux_lev;
	}

	// Default setter
	public void setLux_lev(String lux_lev) {
		this.lux_lev = lux_lev;
	}

	// Default getter
	public float getCpn() {
		return cpn;
	}

	// Default setter
	public void setCpn(float cpn) {
		this.cpn = cpn;
	}

	// args constructor
	public Room(int r_id, String status, int bed_num, String bed_size, String lux_lev, float cpn) {
		super();
		this.r_id = r_id;
		this.status = status;
		this.bed_num = bed_num;
		this.bed_size = bed_size;
		this.lux_lev = lux_lev;
		this.cpn = cpn;
	}

	// no-args constructor
	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// to-string method
	@Override
	public String toString() {
		return "Room [r_id=" + r_id + ", status=" + status + ", bed_num=" + bed_num + ", bed_size=" + bed_size
				+ ", lux_lev=" + lux_lev + ", cpn=" + cpn + "]";
	}

	// hashcode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bed_num;
		result = prime * result + ((bed_size == null) ? 0 : bed_size.hashCode());
		result = prime * result + Float.floatToIntBits(cpn);
		result = prime * result + ((lux_lev == null) ? 0 : lux_lev.hashCode());
		result = prime * result + r_id;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Room other = (Room) obj;
		if (bed_num != other.bed_num)
			return false;
		if (bed_size == null) {
			if (other.bed_size != null)
				return false;
		} else if (!bed_size.equals(other.bed_size))
			return false;
		if (Float.floatToIntBits(cpn) != Float.floatToIntBits(other.cpn))
			return false;
		if (lux_lev == null) {
			if (other.lux_lev != null)
				return false;
		} else if (!lux_lev.equals(other.lux_lev))
			return false;
		if (r_id != other.r_id)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
}
package com.frontdesk.pojo;

// Pojo representing a guest that is staying or has stayed at the hotel.
public class Guest {
	
	// Unique serial guest id
	private int g_id;

	// Guest first name
	private String f_name;

	// Guest last name
	private String l_name;

	// Guest credit card number
	private String cc_num;

//---------------------------------

	// Default getter
	public int getG_id() {
		return g_id;
	}

	// Default setter
	public void setG_id(int g_id) {
		this.g_id = g_id;
	}

	// Default getter
	public String getF_name() {
		return f_name;
	}

	// Default setter
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	// Default getter
	public String getL_name() {
		return l_name;
	}

	// Default setter
	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	// Default getter
	public String getCc_num() {
		return cc_num;
	}

	// Default setter
	public void setCc_num(String cc_num) {
		this.cc_num = cc_num;
	}

	// args constructor
	public Guest(int g_id, String f_name, String l_name, String cc_num) {
		super();
		this.g_id = g_id;
		this.f_name = f_name;
		this.l_name = l_name;
		this.cc_num = cc_num;
	}

	// no-args constructor
	public Guest() {
		super();
	}

	// to-string method
	@Override
	public String toString() {
		return "Guest [g_id=" + g_id + ", f_name=" + f_name + ", l_name=" + l_name + ", cc_num=" + cc_num + "]";
	}

	// hashcode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cc_num == null) ? 0 : cc_num.hashCode());
		result = prime * result + ((f_name == null) ? 0 : f_name.hashCode());
		result = prime * result + g_id;
		result = prime * result + ((l_name == null) ? 0 : l_name.hashCode());
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
		Guest other = (Guest) obj;
		if (cc_num == null) {
			if (other.cc_num != null)
				return false;
		} else if (!cc_num.equals(other.cc_num))
			return false;
		if (f_name == null) {
			if (other.f_name != null)
				return false;
		} else if (!f_name.equals(other.f_name))
			return false;
		if (g_id != other.g_id)
			return false;
		if (l_name == null) {
			if (other.l_name != null)
				return false;
		} else if (!l_name.equals(other.l_name))
			return false;
		return true;
	}
}

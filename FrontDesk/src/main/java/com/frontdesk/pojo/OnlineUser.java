package com.frontdesk.pojo;

//Pojo representing an online user that can make reservations online.
public class OnlineUser {
	
	// Unique serial user id
	private int u_id;
	
	// login username
	private String user_name;
	
	// login password
	private String pass_word;
	
	// account email
	private String email;

//-------------------------------------
	
	// Default getter
	public int getU_id() {
		return u_id;
	}

	// Default setter
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	// Default getter
	public String getUser_name() {
		return user_name;
	}

	// Default setter
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	// Default getter
	public String getPass_word() {
		return pass_word;
	}

	// Default setter
	public void setPass_word(String pass_word) {
		this.pass_word = pass_word;
	}

	// Default getter
	public String getEmail() {
		return email;
	}

	// Default setter
	public void setEmail(String email) {
		this.email = email;
	}

	// args constructor
	public OnlineUser(int u_id, String user_name, String pass_word, String email) {
		super();
		this.u_id = u_id;
		this.user_name = user_name;
		this.pass_word = pass_word;
		this.email = email;
	}

	// no-args constructor
	public OnlineUser() {
		super();
	}

	// to-string method
	@Override
	public String toString() {
		return "OnlineUser [u_id=" + u_id + ", user_name=" + user_name + ", pass_word=" + pass_word + ", email=" + email
				+ "]";
	}

	// hashcode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((pass_word == null) ? 0 : pass_word.hashCode());
		result = prime * result + u_id;
		result = prime * result + ((user_name == null) ? 0 : user_name.hashCode());
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
		OnlineUser other = (OnlineUser) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (pass_word == null) {
			if (other.pass_word != null)
				return false;
		} else if (!pass_word.equals(other.pass_word))
			return false;
		if (u_id != other.u_id)
			return false;
		if (user_name == null) {
			if (other.user_name != null)
				return false;
		} else if (!user_name.equals(other.user_name))
			return false;
		return true;
	}

	
	
}

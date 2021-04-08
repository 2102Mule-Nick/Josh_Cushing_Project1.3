package com.staykeep.dao;

import java.util.List;
import com.staykeep.pojo.Stay;

//Interface for handling Database functions concerning Stay objects.
public interface StayDao {

	// 1
	public List<Stay> getAllStays();

	// 2
	public Stay getStayInfoById(int s_id);

	// 3
	public void createNewStay(Stay stay);

	// 4
	public void deleteStay(int s_id);

	// 5
	public void setIsCurrent(boolean is_current, int s_id);

	// 6
	public void setBill(Stay stay);

	// 7
	public void setStayInTime(Stay stay);

	// 8
	public void setStayInDate(Stay stay);

	// 9
	public void setStayOutTime(Stay stay);

	// 10
	public void setStayOutDate(Stay stay);

}

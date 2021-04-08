package staykeep.test;
/*

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lotus.staykeep.config.AppConfig;
import com.lotus.staykeep.daoimpl.RoomDaoImpl;
import com.lotus.staykeep.pojo.Room;

public class RoomDaoTests {
	
	@Test
	public void setUp() {
		// Set application context.
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		RoomDaoImpl roomDaoImpl = appContext.getBean("roomDaoImpl", RoomDaoImpl.class);
				
		Room room = roomDaoImpl.getRoomInfoById(5);
		System.out.println(room);
	}
	
	ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);

	RoomDaoImpl roomDaoImpl;

	@Autowired
	public void setRoomDaoImpl(RoomDaoImpl roomDaoImpl) {
		this.roomDaoImpl = roomDaoImpl;
	}

	@Test
	public void shouldGetInfoById() {
		Room room = roomDaoImpl.getRoomInfoById(5);
		System.out.println(room);
	}
	
	// Test 1 - passed - Room [r_id=5, status=resetting, bed_num=1, bed_size=single,
	// lux_level=standard, cpn=100.0]
	//

	public void shouldGetInfoById() {
		Room room = roomDaoImpl.getRoomInfoById(5);
		System.out.println(room);
	}

	public void shouldSetRoomStatus() {

		roomDaoImpl.setRoomStatus("resetting", 5);
	}

	public void shouldGetStaysByRoom() {

		List<Stay> stayList = roomDaoImpl.getStaysByRoom(2);
		System.out.println(stayList);
	}

	public void shouldGetResByRoom() {
		List<Reservation> resList = roomDaoImpl.getReservationsByRoom(3);
		System.out.println(resList);
	}

}
*/
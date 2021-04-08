package com.frontdesk;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;
import com.frontdesk.config.AppConfig;
import com.frontdesk.pojo.Guest;
import com.frontdesk.pojo.OnlineUser;
import com.frontdesk.pojo.Reservation;
import com.frontdesk.pojo.Room;
import com.frontdesk.pojo.Stay;
import com.frontdesk.servicefinder.GuestServiceFinder;
import com.frontdesk.servicefinder.OnlineUserServiceFinder;
import com.frontdesk.servicefinder.ReservationServiceFinder;
import com.frontdesk.servicefinder.RoomServiceFinder;
import com.frontdesk.servicefinder.StayServiceFinder;

public class Driver {

	public static void main(String[] args) {

		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		//Manually get the bean.
		GuestServiceFinder guestServiceFinder = appContext.getBean("guestServiceFinder",GuestServiceFinder.class);
		RoomServiceFinder roomServiceFinder = appContext.getBean("roomServiceFinder",RoomServiceFinder.class);
		StayServiceFinder stayServiceFinder = appContext.getBean("stayServiceFinder",StayServiceFinder.class);
		
		Scanner scanner = new Scanner(System.in);
		String input = "";
		String f_name = "";
		String l_name = "";
		String cc_num = "";
		int num_nights = 0;
		int r_id = 0;
		int g_id = 0;
		String checkintime = "01:00:00";
		String checkindate = "2000-11-11";
		String checkouttime = "01:00:00";
		String checkoutdate = "2000-11-11";
		Time chit = Time.valueOf(checkintime);
		Date chid = Date.valueOf(checkindate);
		Time chot = Time.valueOf(checkouttime);
		Date chod = Date.valueOf(checkoutdate);

		do {
			System.out.println("LOTUS HOTEL FRONTDESK");
			System.out.println("1) Check in Guest");
			System.out.println("0) Quit");

			input = scanner.next();

			switch (input) {
			case "1":
				
				System.out.println("Enter guest first name");
				f_name = scanner.next();
				
				System.out.println("Enter guest last name");
				l_name = scanner.next();
				
				System.out.println("How many nights are they staying?");
				num_nights = scanner.nextInt();
				
				System.out.println("Enter guest credit card number");
				cc_num = scanner.next();
				
				System.out.println("Enter desired room number");
				r_id = scanner.nextInt();
				
				System.out.println("Check-In time?");
				checkintime = scanner.next();
				
				System.out.println("Check-In date?");
				checkindate = scanner.next();
				
				System.out.println("Check-Out time?");
				checkouttime = scanner.next();
				
				System.out.println("Check-Out date?");
				checkoutdate = scanner.next();
				
				System.out.println("-------------------------------------");
				System.out.println("Guest name: " + f_name + " " + l_name);
				System.out.println("Number of nights: " + num_nights);
				System.out.println("Credit Card Number: " + cc_num);
				System.out.println("Desired room number: "+ r_id);
				System.out.println("Check in time / date: " + chit + " ||| " + chid);
				System.out.println("Check out time / date: " + chot + " ||| " + chod);
				System.out.println("--------------------------------------");
				System.out.println("Is this information correct? y/n");
				input = scanner.next();
				if("y".equals(input)) {
					
					Guest checkInGuest = new Guest();
					checkInGuest.setF_name(f_name);
					checkInGuest.setL_name(l_name);
					checkInGuest.setCc_num(cc_num);
					
					Guest guestWithId = guestServiceFinder.createNewGuest(checkInGuest);
					
					g_id = guestWithId.getG_id();
					
					Room room = roomServiceFinder.getRoomInfoById(r_id);
					float multiplyer = room.getCpn();
					
					float bill = num_nights * multiplyer;
					boolean is_current = false;
					
					chit = Time.valueOf(checkintime);
					chid = Date.valueOf(checkindate);
					chot = Time.valueOf(checkouttime);
					chod = Date.valueOf(checkoutdate);
					
					Stay stay = new Stay();
					stay.setCh_i_time(chit);
					stay.setCh_i_date(chid);
					stay.setCh_o_time(chot);
					stay.setCh_o_date(chod);
					stay.setG_id(g_id);
					stay.setR_id(r_id);
					stay.setBill(bill);
					stay.setIs_current(is_current);
						
					stayServiceFinder.createNewStay(stay);
				}
				else {
					System.out.println("Try again or quit");
				}
				break;
			case "0":
				System.exit(0);
				break;
			default:
				System.out.println("Not an option. Try again.");
				break;
			}
		} while (true);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Test to try and get back a guest object with an auto-generated g_id
		//Courtesy of Iyad for teaching me how to use keyholder.
		

			
		//Create a new guest that represents a guest that JUST checked in.
		//In other words, they don't have a g_id yet.
		
		
		
		
		
		/*
		 * Features Documentation (all methods have basic documentation) 
		 * Unit testing (100% coverage) 
		 * Logging 
		 * 1 Java application that will handle a publicly facing REST API 
		 * 
		 * 3 additional Java applications that will handle parts of the logic
		 * at least 2 of the applications communicate to one another using REST 
		 * at least 2 of the applications communicate to one another using SOAP 
		 * at least 1 JMS Topic for applications to communicate 
		 * at least 1 JMS Queue for applications to communicate
		 * 
		 * Tech Stack 
		 * Java JUnit 
		 * Log4J Git SCM (on GitHub) 
		 * Spring Framework 
		 * Spring JDBC Template 
		 * Spring JMS Template 
		 * ActiveMQ 
		 * REST 
		 * SOAP 
		 * Spring Transactions (JTA)
		 */
	}
}
/*






















		// TEST to see if a room status is changed when a new stay is added.
		StayServiceFinder stayServiceFinder = appContext.getBean("stayServiceFinder", StayServiceFinder.class);

		Stay stay = new Stay();
		Time chit = Time.valueOf("5:30:00");
		Date chid = Date.valueOf("2021-04-07");
		Time chot = Time.valueOf("10:00:00");
		Date chod = Date.valueOf("2021-04-09");
		int g_id = 6;
		int r_id = 7;
		float bill = 100.00f;
		boolean is_current = true;
		//------------------------
		stay.setCh_i_time(chit);
		stay.setCh_i_date(chid);
		stay.setCh_o_time(chot);
		stay.setCh_o_date(chod);
		stay.setG_id(g_id);
		stay.setR_id(r_id);
		stay.setBill(bill);
		stay.setIs_current(is_current);
		//-----------------------------------
		stayServiceFinder.createNewStay(stay);
		
		System.out.println("FrontDesk is just happy to be involved....");

		String exit = "";

		Scanner scan = new Scanner(System.in);

		do {

			exit = scan.nextLine();

		} while (!"exit".equals(exit));
















*/
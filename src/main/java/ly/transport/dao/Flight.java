package ly.transport.dao;

import java.util.ArrayList;
import java.util.List;

public class Flight {
	private int day;
	private int fligthtNum;
	private String departure;
	private String arrival;
	private int customerCnt;
	
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getFligthtNum() {
		return fligthtNum;
	}
	public void setFligthtNum(int fligthtNum) {
		this.fligthtNum = fligthtNum;
	}
	public int getCustomerCnt() {
		return customerCnt;
	}
	public void setCustomerCnt(int customerCnt) {
		this.customerCnt = customerCnt;
	}
	
	public static List<Flight> getAllFlight(){
		List<Flight> flightList = new ArrayList<Flight>();
		Flight flight1 = new Flight();
		Flight flight2 = new Flight();
		Flight flight3 = new Flight();
		
		flight1.setDeparture("YUL");
		flight1.setArrival("YYZ");
		flightList.add(flight1);
			
		
		flight2.setDeparture("YUL");
		flight2.setArrival("YYC");
		flightList.add(flight2);
	
		
		flight3.setDeparture("YUL");
		flight3.setArrival("YVR");
		flightList.add(flight3);	
		
	
		int flightNum = 1;
		for(int day=1;day<=2;day++) {
			for(Flight flight:flightList) {
				flight.setDay(day);
				flight.setFligthtNum(flightNum);
				flight.setCustomerCnt(0);
				flightNum++;
				System.out.println(flight);
			}
		}
		return flightList;
	}
	
	@Override
	public String toString() {
		return String.format("Flight: %d, departure: %s, arrival: %s, day: %d", fligthtNum,departure,arrival,day);
	}	
	
	
}

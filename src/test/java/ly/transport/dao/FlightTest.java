package ly.transport.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ly.transport.dao.Flight;

class FlightTest {

	@Test
	void testFlightDisplay() {
		Flight flight1 = new Flight();
		Flight flight2 = new Flight();
		Flight flight3 = new Flight();
		List<Flight> flightList = new ArrayList<Flight>();
		
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
				flightNum++;
				System.out.println(flight);
			}
		}

	}

}

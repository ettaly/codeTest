package ly.transport.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class OrderTest {
	
	public static final List<String> ALL_DEST = Arrays.asList(new String[] {"YYZ","YYC","YVR"});

	@Test
	public void test() throws FileNotFoundException, IOException, ParseException   {
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("C:\\Users\\Peter\\Downloads\\coding-assigment-orders.json"));
		
		ObjectMapper objectMapper = new ObjectMapper();
		@SuppressWarnings("unchecked")
		List<Object> resultList = (List<Object>) jsonObject.keySet().stream().sorted().collect(Collectors.toList());
		Map<String,Flight> orderMap = new TreeMap<String,Flight>();
		List<Inventory> inventoryList = new ArrayList<Inventory>();
		List<Inventory> invalidInventoryList = new ArrayList<Inventory>();
		for(Object flightObject:resultList) {
			Destination destination = objectMapper.readValue(jsonObject.get(flightObject).toString(), Destination.class);
			
			if(ALL_DEST.contains(destination.getDestination())) {
				Flight flight = new Flight();
				flight.setDeparture("YUL");
				flight.setArrival(destination.getDestination());
				flight.setFligthtNum(1);
				flight.setDay(1);
				if(flight.getCustomerCnt()==20) {
					flight.setDay(2);
				}
				flight.setCustomerCnt(flight.getCustomerCnt()+1);
				orderMap.put(flightObject.toString(), flight);
				
				Inventory inventory = new Inventory();
				inventory.setFlight(flight);
				inventory.setOrder(flightObject.toString());
				inventoryList.add(inventory);
				System.out.println(String.format("order: %s, flightNumber: %d, departure: %s, arrival: %s, day: %d", 
						flightObject,flight.getFligthtNum(),flight.getDeparture(),flight.getArrival(),flight.getDay()));
			}
			else {
				Inventory inventory = new Inventory();
				inventory.setOrder(flightObject.toString());
				invalidInventoryList.add(inventory);
				System.out.println(String.format("order: %s, flightNumber: not scheduled", flightObject));
			}
		}
		
		
	}

	
}

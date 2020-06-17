package ly.transport.dao;

public class Inventory {
	
	private String order;
	private Flight flight;
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	
	@Override
	public String toString() {
		return "Inventory [order=" + order + ", flight=" + flight + "]";
	}
	
}

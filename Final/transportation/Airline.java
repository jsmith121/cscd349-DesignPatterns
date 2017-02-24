package transportation;

import java.util.Random;

public class Airline extends TransportLine{

	public Airline(String n) {
		super(n);
		Random rand = new Random();
	}
	public void addTransport(String orig, String dest, int year, int month, int day, String id) {
		transports.add(new Flight(orig, dest, year, month, day, id));
	}
	public String toString() {
		String ret = "Airline: " + name + ":\n";
		for (Transport tr : transports) {
			ret += tr.toString();
		}
		return ret;
	}

}

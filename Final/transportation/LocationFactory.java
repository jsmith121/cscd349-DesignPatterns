package transportation;

import java.util.ArrayList;

public class LocationFactory {

	public Airport createAirport(String n, ArrayList<Airport> airports)
	{
		Airport air;
		if (airportNameValid(n, airports)) {
			air = new Airport(n);
			return air;
		} else
			System.out.println("Airport " + n + " invalid");
		return null;
	}
	public Port createPort(String n, ArrayList<Port> ports)
	{
		Port port;
		if(portNameValid(n, ports))
		{
			port = new Port(n);
			return port;
		}
		else
		{
			System.out.println("Port " + n + " invalid");
		}
		return null;
	}
	private boolean airportNameValid(String n, ArrayList<Airport> airports) {
		if (n.length() == 3) {
			for (char c : n.toCharArray()) {
				if (Character.isLetter(c) && Character.isLowerCase(c)) {
					return false;
				}
			}
			for (Airport a : airports) {
				if (a.getName() == n) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
	private boolean portNameValid(String n, ArrayList<Port> ports) {
		if (n.length() == 3) {
			for (char c : n.toCharArray()) {
				if (Character.isLetter(c) && Character.isLowerCase(c)) {
					return false;
				}
			}
			for (Port p : ports) {
				if (p.getName() == n) {
					return false;
				}
			}
			return true;
		}
		return false;
	}	
}

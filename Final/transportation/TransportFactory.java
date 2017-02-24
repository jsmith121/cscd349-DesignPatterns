package transportation;

import java.util.ArrayList;
import java.util.Calendar;

public class TransportFactory {

	public void createFlight(String aname, String orig, String dest, int year, int month, int day, String id,
			ArrayList<Airport> airports, ArrayList<Airline> airlines) {
		Airline al = searchAirlines(aname, airlines);
		if (al != null) {
			boolean validFlightPath = checkFlightPath(orig, dest, airports);
			boolean validDate = checkDate(year, month, day);
			boolean validID = !al.transportExists(id);
			if (validFlightPath && validDate && validID) {
				al.addTransport(orig, dest, year, month, day, id);
			}
			if (al.transportExists(id))
				System.out.println("Flight already exists");
		} else
			System.out.println("Airline " + aname + " does not exist");
	}
	public void createTrip(String aname, String orig, String dest, int year, int month, int day, String id, String ship,
			ArrayList<Port> ports, ArrayList<Cruise> cruises) {
		Cruise cr = searchCruises(aname, cruises);
		if (cr != null) {
			boolean validPath = checkCruisePath(orig, dest, ports);
			boolean validDate = checkDate(year, month, day);
			boolean validID = !cr.transportExists(id);
			if (validPath && validDate && validID) {
				cr.addTransport(orig, dest, year, month, day, id, ship);
			}
			if (cr.transportExists(id))
				System.out.println("Trip already exists");
		} else
			System.out.println("Cruise " + aname + " does not exist");
	}
	

	private Airline searchAirlines(String name, ArrayList<Airline> airlines) {
		for (Airline a : airlines) {
			if (a.getName() == name) {
				return a;
			}
		}
		return null;

	}
	private Cruise searchCruises(String name, ArrayList<Cruise> cruises) {
		for (Cruise cr : cruises) {
			if (cr.getName() == name) {
				return cr;
			}
		}
		return null;

	}

	private boolean airportExists(String n, ArrayList<Airport> airports) {
		for (Airport a : airports) {
			if (a.getName() == n) {
				return true;
			}
		}
		System.out.println("Invalid airport " + n);
		return false;
	}
	private boolean portExists(String n, ArrayList<Port> ports) {
		for (Port p : ports) {
			if (p.getName() == n) {
				return true;
			}
		}
		System.out.println("Invalid port " + n);
		return false;
	}

	
	private boolean checkFlightPath(String orig, String dest, ArrayList<Airport> airports) {
		if (airportExists(orig, airports) && airportExists(dest, airports) && !dest.equals(orig)) {
			return true;
		}
		System.out.println("Invalid flight path: " + orig + "->" + dest);
		return false;
	}

	private boolean checkCruisePath(String orig, String dest, ArrayList<Port> ports) {
		if (portExists(orig, ports) && portExists(dest, ports) && !dest.equals(orig)) {
			return true;
		}
		System.out.println("Invalid cruise path: " + orig + "->" + dest);
		return false;
	}
	private boolean checkDate(int year, int month, int day) {
		Calendar c = Calendar.getInstance();
		c.setLenient(false);
		c.set(year, month, day);
		try {
			c.getTime();
		} catch (Exception e) {
			System.out.println("Invalid date");
			return false;
		}
		return true;
	}
}

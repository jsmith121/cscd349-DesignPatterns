package transportation;

import java.util.ArrayList;

public class TransportLineFactory {

	public Airline createAirline(String n, ArrayList<Airline> airlines)
	{
		Airline al;

		if (airlineNameValid(n, airlines)) {
			al = new Airline(n);
			return al;
		} else
			System.out.println(n + " invalid");
		return null;
	}
	public Cruise createCruise(String n, ArrayList<Cruise> cruises)
	{
		Cruise cr;

		if (cruiseNameValid(n, cruises)) {
			cr = new Cruise(n);
			return cr;
		} else
			System.out.println(n + " invalid");
		return null;
	}
	private boolean airlineNameValid(String n, ArrayList<Airline> airlines) {
		if (n.length() > 0 && n.length() < 6) {
			for (char c : n.toCharArray()) {
				if (Character.isLetter(c) && Character.isLowerCase(c)) {
					return false;
				}
			}
			for (Airline a : airlines) {
				if (a.getName() == n) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
	private boolean cruiseNameValid(String n, ArrayList<Cruise> cruises) {
		if (n.length() > 0 && n.length() < 6) {
			for (char c : n.toCharArray()) {
				if (Character.isLetter(c) && Character.isLowerCase(c)) {
					return false;
				}
			}
			for (Cruise cr : cruises) {
				if (cr.getName() == n) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
}

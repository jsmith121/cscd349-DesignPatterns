package transportation;

import java.util.ArrayList;
import java.util.Scanner;

public class SystemManager {

	private ArrayList<Airport> airports = new ArrayList<Airport>();
	private ArrayList<Airline> airlines = new ArrayList<Airline>();
	private ArrayList<Port> ports = new ArrayList<Port>();
	private ArrayList<Cruise> cruises = new ArrayList<Cruise>();

	//Locations////////////////////
	public void createAirport(String n) {
		LocationFactory lf = new LocationFactory();
		Airport air = lf.createAirport(n, airports);
		if (air != null)
			airports.add(air);
	}
	public void createPort(String n) {
		LocationFactory lf = new LocationFactory();
		Port port = lf.createPort(n, ports);
		if (port != null)
			ports.add(port);
	}
	///////////////////////////////
	
	//TransportLines//////////////
	public void createAirline(String n) {
		TransportLineFactory tf = new TransportLineFactory();
		Airline al = tf.createAirline(n, airlines);
		if (al != null)
			airlines.add(al);
	}
	public void createCruise(String n) {
		TransportLineFactory tf = new TransportLineFactory();
		Cruise al = tf.createCruise(n, cruises);
		if (al != null)
			cruises.add(al);
	}
	///////////////////////////////
	
	//Transports///////////////////
	public void createFlight(String aname, String orig, String dest, int year, int month, int day, String id) {
		TransportFactory tf = new TransportFactory();
		tf.createFlight(aname, orig, dest, year, month, day, id, airports, airlines);

	}
	public void createTrip(String aname, String orig, String dest, int year, int month, int day, String id, String ship) {
		TransportFactory tf = new TransportFactory();
		tf.createTrip(aname, orig, dest, year, month, day, id, ship, ports, cruises);

	}
	///////////////////////////////
	//Sections//////////////////////////
	public void createFlightSection(String air, String flID, int rows, char l, SeatClass s) {

		Airline al = searchAirlines(air);
		if (al != null) {
			Flight fl = (Flight)al.findTransport(flID);
			if (fl != null) {
				fl.addSection(rows, l, s.toString());
			} else
				System.out.println("Flight " + flID + " on " + air + " does not exist");
		} else
			System.out.println("Airline " + air + " does not exist");

	}
	public void createCabinSection(String cruise, String trID, int rows, int cols, CabinClass s) {

		Cruise cr = searchCruises(cruise);
		if (cr != null) {
			Trip tr = (Trip)cr.findTransport(trID);
			if (tr != null) {
				tr.addSection(rows, cols, s.toString());
			} else
				System.out.println("Flight " + trID + " on " + cruise + " does not exist");
		} else
			System.out.println("Airline " + cruise + " does not exist");

	}
	/////////////////////////////////////////
	
	//Find Available////////////////////////
	public void findAvailableFlights(String orig, String dest) {
		if (airportExists(orig) && airportExists(dest)) {
			for (Airline a : airlines) {
				ArrayList<Transport> temp = a.getTransports();
				for (Transport fl : temp) {
					if (fl.getOrig().equals(orig) && fl.getDest().equals(dest)) {
						System.out.println("\nAvailable flights for " + orig + "->" + dest + ":");
						System.out.println(fl.toString());
					}
				}
			}
		}
	}
	public void findAvailableFlightsPref(String air, String fl, SeatClass sc, char pref) {
		
	}
	public void findAvailableTrips(String orig, String dest) {
		if (portExists(orig) && portExists(dest)) {
			for (Cruise c : cruises) {
				ArrayList<Transport> temp = c.getTransports();
				for (Transport tr : temp) {
					if (tr.getOrig().equals(orig) && tr.getDest().equals(dest)) {
						System.out.println("\nAvailable flights for " + orig + "->" + dest + ":");
						System.out.println(tr.toString());
					}
				}
			}
		}
	}
	/////////////////////////////////////////
	//Booking////////////////////////////////
	public void bookSeat(String air, String fl, SeatClass s, int row, char col) {

		Airline al = searchAirlines(air);
		Flight f;
		if (al != null) {
			f = (Flight)al.findTransport(fl);
			if (f != null)
				f.bookSeat(s.toString(), row, col);
			else
				System.out.println("Flight " + fl + " on " + air + " does not exist");
		} else
			System.out.println("Invalid airline " + air);
	}
	public void bookSeatPreference(String air, String fl, SeatClass s, char pref)
	{
		Airline al = searchAirlines(air);
		Flight f;
		if (al != null) {
			f = (Flight)al.findTransport(fl);
			if (f != null)
				f.bookPreference(s.toString(), pref);
			else
				System.out.println("Flight " + fl + " on " + air + " does not exist");
			
		}
		else
			System.out.println("Invalid airline " + air);

	}
	public void bookCabin(String cru, String tr, CabinClass s, int room, char deck) {

		Cruise cr = searchCruises(cru);
		Trip t;
		if (cr != null) {
			t = (Trip)cr.findTransport(tr);
			if (t != null)
				t.bookSeat(s.toString(), room, deck);
			else
				System.out.println("Flight " + tr + " on " + cru + " does not exist");
		} else
			System.out.println("Invalid airline " + cru);
	}
	///////////////////////////////////////////
	//Display errathang///////////////////////
	public void displaySystemDetails() {
		System.out.println();
		printAirports();
		System.out.println();
		printAirlines();
		System.out.println();
		printPorts();
		System.out.println();
		printCruises();
	}
	public void displayAirportSystemDetails()
	{
		System.out.println();
		printAirports();
		System.out.println();
		printAirlines();
	}
	public void displayCruiseSystemDetails()
	{
		System.out.println();
		printPorts();
		System.out.println();
		printCruises();
	}
	////////////////////////////////////////////
	//Menus/////////////////////////////////////
	public void menu()
	{
		System.out.println("a.	Create an airport system by using information provided in an input file. (NOT IMPLEMENTED) \n"+
							"b.	Change the price associated with seats in a flight section (all seats in a flight section have the same price).\n" +
							"c.	Query the system for flights with available seats in a given class (e.g., economy, business).\n" +
							"d.	Change the seat class (e.g., economy) pricing for an origin and destination for a given airline.\n" +
							"e.	Book a seat given a specific seat on a flight.\n" +
							"f.	Book a seat on a flight given only a seating preference.\n" +
							"g.	Display details of the airport system.\n" +
							"h.	Store information about the airport system in a specified file. (NOT IMPLEMENTED)\n");
	}
	public void adminMenu()
	{
		System.out.println("a.	Create airports, airlines, and flights with flight sections and seats. (NOT IMLPLEMENTED) \n" +
							"b.	Create cruises, ports, trips, and ships with cabin sections and cabins. (NOT IMPLEMENTED) \n" +
							"c.	Print the current state of the airline subsystem including information on seats that are available and booked on each flight.\n" +
							"d.	Print the current state of the cruise subsystem including information on cabins that are available and booked on each cruise trip.\n");
	}
	public void generalMenu()
	{
		System.out.println("a. Admin");
		System.out.println("b. User");
		System.out.println("Select a menu: ");
	}
	////////////////////////////////////////////	
	public void init()
	{
		Scanner kb = new Scanner(System.in);
		menuSelect(kb);
	}
	public void userMenuSelect(Scanner kb)
	{
		menu();
		System.out.println("Choose an option: ");
		char op = kb.next().charAt(0);
		do
		{
			switch(op)
			{
			case 'a': createAirportSystem(kb);
				break;
			case 'b': changeFlightPrice(kb);
				break;
			case 'c': queryFlight(kb);
				break;
			case 'd': changeFlightPrice(kb);
				break;
			case 'e': bookSeatQuery(kb);
				break;
			case 'f': bookSeatPreferenceQuery(kb);
				break;
			case 'g': displayAirportSystemDetails();
				break;
			case 'h':
				break;
			}
			menu();
			System.out.println("Choose an option: ");
			op = kb.next().charAt(0);
		}while(op != 'q');
	}
	public void adminMenuSelect(Scanner kb)
	{
		adminMenu();
		System.out.println("Choose an option: ");
		char choice = kb.next().charAt(0);
		do
		{
			switch(choice)
			{
			case 'a': //manageAirports();
				break;
			case 'b': //manageCruises();
				break;
			case 'c': displayAirportSystemDetails();
				break;
			case 'd': displayCruiseSystemDetails();
				break;
			}
			adminMenu();
			System.out.println("Choose an option: ");
			kb.nextLine();
			choice = kb.next().charAt(0);
		}while(choice != 'q');
	}
	public void menuSelect(Scanner kb)
	{
		//Scanner kb = new Scanner(System.in);
		generalMenu();
		
		char choice = kb.next().charAt(0);
		do
		{
			switch(choice)
			{
			case 'a': adminMenuSelect(kb);
				break;
			case 'b': userMenuSelect(kb);
				break;
			}
			generalMenu();
			kb.nextLine();
			choice = kb.next().charAt(0);
		}while(choice != 'q');
	}
	public void bookSeatPreferenceQuery(Scanner kb)
	{
		System.out.println("Choose an Airline: ");
		String air = kb.next();
		System.out.println("Choose a flight: ");
		String fl = kb.next();
		System.out.println("Choose a seating class (Business, Economy, First): ");
		String sc = kb.next();
		System.out.println("Enter your seating preference (Window or Aisle): ");
		String pref = kb.next();
		boolean validPref = false;
		for(SeatClass s: SeatClass.values())
		{
			if(s.name().equals(sc))
			{
				validPref = true;
			}
		}
		if(validPref)
			bookSeatPreference(air, fl, SeatClass.valueOf(sc), pref.charAt(0));
		else
			System.out.println("Invalid seating preference");
	}
	public void bookSeatQuery(Scanner kb)
	{
		System.out.println("Choose an Airline: ");
		String air = kb.next();
		System.out.println("Choose a flight: ");
		String fl = kb.next();
		System.out.println("Choose a seating class (Business, Economy, First): ");
		String sc = kb.next();
		System.out.println("Enter the row number: ");
		kb.nextLine();
		int r = kb.nextInt();
	
		System.out.println("Enter the column: ");
		kb.nextLine();
		char c = kb.nextLine().charAt(0);
		boolean validPref = false;
		for(SeatClass s: SeatClass.values())
		{
			if(s.name().equals(sc))
			{
				validPref = true;
			}
		}
		if(validPref)
			bookSeat(air, fl, SeatClass.valueOf(sc), r, c);
	}
	public void createAirportSystem(Scanner kb)
	{
		
	}
	public void changeFlightPrice(Scanner kb)
	{
		
		System.out.println("Enter the Airline name: ");
		kb.nextLine();
		String al = kb.nextLine();
		System.out.println("Enter the Flight id");
		String flid = kb.nextLine();
		System.out.println("Enter the seat class you wish to change the price of: ");
		String s = kb.nextLine();
		System.out.println("Enter new price");
		int p = kb.nextInt();
		Airline air = searchAirlines(al);
		if(air != null)
		{
			Flight fl = (Flight)air.findTransport(flid);
			if(sectionValid(s))
			{
					if(fl.sectionExists(s))
					{
						FlightSection fs = (FlightSection)(fl.findSection(s.toString()));
						fs.setPrice(p);
					}
			}
		}
	}
	private boolean sectionValid(String s)
	{
		for(SeatClass sc: SeatClass.values())
		{
			if(sc.name().equals(s))
				return true;
		}
		
		return false;
	}
	private void queryFlight(Scanner kb)
	{
		System.out.println("Choose an Airline: ");
		String air = kb.next();
		System.out.println("Choose a flight: ");
		String fl = kb.next();
		System.out.println("Choose a seating class (Business, Economy, First): ");
		String sc = kb.next();
		System.out.println("Enter your seating preference (Window or Aisle): ");
		String pref = kb.next();
		boolean validPref = false;
		for(SeatClass s: SeatClass.values())
		{
			if(s.name().equals(pref))
			{
				validPref = true;
			}
		}
		if(validPref)
			findAvailableFlightsPref(air, fl, SeatClass.valueOf(sc), pref.charAt(0));
		else
			System.out.println("Invalid seating preference");
	}
	private void printAirports() {
		for (Airport a : airports) {
			System.out.println(a.toString());
		}
	}
	private void printPorts() {
		for (Port p : ports) {
			System.out.println(p.toString());
		}
	}

	private void printAirlines() {
		for (Airline al : airlines) {
			System.out.println(al.toString());
		}
	}
	
	private void printCruises() {
		for (Cruise c : cruises) {
			System.out.println(c.toString());
		}
	}

	private boolean airportExists(String n) {
		for (Airport a : airports) {
			if (a.getName() == n) {
				return true;
			}
		}
		System.out.println("Invalid airport " + n);
		return false;
	}
	private boolean portExists(String n) {
		for (Port p : ports) {
			if (p.getName() == n) {
				return true;
			}
		}
		System.out.println("Invalid airport " + n);
		return false;
	}

	private Airline searchAirlines(String name) {
		for (Airline a : airlines) {
			if (a.getName() == name) {
				return a;
			}
		}
		return null;

	}
	private Cruise searchCruises(String name) {
		for (Cruise a : cruises) {
			if (a.getName() == name) {
				return a;
			}
		}
		return null;

	}

}

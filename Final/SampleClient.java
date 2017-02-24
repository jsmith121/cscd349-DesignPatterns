import transportation.*;

public class SampleClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SystemManager res = new SystemManager();
		/*FileManager fileManager = new FileManager(res);
		fileManager.readFile("ams.txt");
		res.displaySystemDetails();*/
		
		res.init();
		
		
		/*		
		res.createAirport("DEN");
		res.createAirport("DFW");
		res.createAirport("LON");
		res.createAirport("DEN");// invalid
		res.createAirport("DENW");// invalid

		res.createAirline("DELTA");
		res.createAirline("AMER");
		res.createAirline("FRONT");
		res.createAirline("FRONTIER"); // invalid
		res.createAirline("FRONT"); // invalid

		res.createFlight("DELTA", "DEN", "LON", 2013, 10, 10, "123");
		res.createFlight("DELTA", "DEN", "DEH", 2013, 8, 8, "567abc");
		res.createFlight("DEL", "DEN", "LON", 2013, 9, 8, "567"); // invalid airline
		res.createFlight("DELTA", "LON33", "DEN33", 2013, 5, 7, "123");// invalid airports
		res.createFlight("AMER", "DEN", "LON", 2010, 40, 100, "123abc");// invalid date

		res.createFlightSection("DELTA", "123", 2, 'S', SeatClass.economy);
		res.createFlightSection("DELTA", "123", 2, 'M', SeatClass.first);
		res.createFlightSection("DELTA", "123", 2, 'W', SeatClass.first);// Invalid
		res.createFlightSection("SWSERTT", "123", 5, 'S', SeatClass.economy);// Invalid airline

		res.bookSeat("DELTA", "123", SeatClass.first, 1, 'A');
		res.bookSeat("DELTA", "123", SeatClass.economy, 1, 'A');
		res.bookSeat("DELTA", "123", SeatClass.economy, 1, 'B');
		res.bookSeat("DELTA888", "123", SeatClass.business, 1, 'A'); // Invalid airline
		res.bookSeat("DELTA", "123haha7", SeatClass.business, 1, 'A'); // Invalid flightId
		res.bookSeat("DELTA", "123", SeatClass.economy, 1, 'A'); // already booked

		res.displaySystemDetails();

		res.findAvailableFlights("DEN", "LON");
	*/	
		
		
		
		
		/*res.createPort("DEN");
		res.createPort("DFW");
		res.createPort("LON");
		res.createPort("DEN");// invalid
		res.createPort("DENW");// invalid
		
		res.createCruise("DELTA");
		res.createCruise("AMER");
		res.createCruise("FRONT");
		res.createCruise("FRONTIER"); // invalid
		res.createCruise("FRONT"); // invalid

		res.createTrip("DELTA", "DEN", "LON", 2013, 10, 10, "123", "HMS Thing");
		res.createTrip("DELTA", "DEN", "DEH", 2013, 8, 8, "567abc", "USS Shipington");
		res.createTrip("DEL", "DEN", "LON", 2013, 9, 8, "567", "USS Enterprise"); // invalid airline
		res.createTrip("DELTA", "LON33", "DEN33", 2013, 5, 7, "123", "HMS aghdfhd");// invalid airports
		res.createTrip("AMER", "DEN", "LON", 2010, 40, 100, "123abc", "sdgsdhsdg");// invalid date

		res.createCabinSection("DELTA", "123", 2, 2, CabinClass.Couples);
		res.createCabinSection("DELTA", "123", 2, 3, CabinClass.Couples);
		res.createCabinSection("DELTA", "123", 2, 3, CabinClass.DeluxeFamily);
		res.createCabinSection("SWSERTT", "123", 5, 5, CabinClass.Family);

		res.bookCabin("DELTA", "123", CabinClass.Couples, 1, 'A');
		res.bookCabin("DELTA", "123", CabinClass.DeluxeCouples, 1, 'A');
		res.bookCabin("DELTA", "123", CabinClass.Family, 1, 'B');
		res.bookCabin("DELTA888", "123", CabinClass.DeluxeFamily, 1, 'A'); // Invalid airline
		res.bookCabin("DELTA", "123haha7", CabinClass.Couples, 1, 'A'); // Invalid flightId
		res.bookCabin("DELTA", "123", CabinClass.Family, 1, 'A'); // already booked

*/
		

	}

}

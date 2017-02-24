package transportation;


public class Flight extends Transport{

	public Flight(String orig, String dest, int year, int month, int day, String id) {
		super(orig, dest, year, month, day, id);
	}

	public void bookSeat(String s, int row, char col) {
		FlightSection sec = (FlightSection) findSection(s);
		if (sec != null) {
			sec.book(row, col);
		} else
			System.out.println("Section does not exist");
	}
	public void bookPreference(String s, char pref)
	{
		FlightSection sec = (FlightSection) findSection(s);
		if (sec != null) {
			sec.bookPref(pref);
		} else
			System.out.println("Section does not exist");
	}
	
	public void addSection(int r, char c, String s) {
		SeatClass sc = SeatClass.valueOf(s);;
		if (!sectionExists(s)) {

			if (sectionSizeValid(r)) {
				
				this.sections.add(new FlightSection(r, sc, c));
			} else {
				System.out.println("Invalid section size " + r + "x" + c);
			}
		} else
			System.out.println("Section already exists");
	}
	protected boolean sectionExists(String s) {
		for (Section sec : sections) {
			SeatClass sc = SeatClass.valueOf(s);
			FlightSection fs = (FlightSection)sec;
			if (fs.getSeatClass() == sc) {
				return true;
			}
		}
		return false;
	}
	protected boolean sectionSizeValid(int r) {
		int rowMax = 100;
		int colMax = 10;
		if (r <= rowMax && r > 0)
			return true;
		return false;
	}
	public Section findSection(String s) {
		for (Section sec : sections) {
			SeatClass sc = SeatClass.valueOf(s);
			FlightSection fs = (FlightSection)sec;
			if (fs.getSeatClass() == sc) {
				return fs;
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		String ret = "================================================\n" + "Flight: " + id + "\n" + "Date: " + month
				+ "/" + day + "/" + year + "\n" + "Departing from: " + orig + "\n" + "Destination: " + dest + "\n";
		for (Section sec : sections) {
			ret += "\n" + sec.toString();
		}
		ret += "================================================";
		return ret;
	}

	

	
}

package transportation;

public class Trip extends Transport{
	
	private Ship ship;

	public Trip(String orig, String dest, int year, int month, int day, String id, String ship) {
		super(orig, dest, year, month, day, id);
		this.ship = new Ship(ship);
	}
	public void bookSeat(String s, int row, char col) {
		CabinSection sec = (CabinSection) findSection(s);
		if (sec != null) {
			sec.book();
		} else
			System.out.println("Section does not exist");
	}
	public void addSection(int r, int c, String s) {
		CabinClass cc = CabinClass.valueOf(s);;
		if (!sectionExists(s)) {

			if (sectionSizeValid(r, c)) {
				
				this.sections.add(new CabinSection(r, c, cc));
			} else {
				System.out.println("Invalid section size " + r + "x" + c);
			}
		} else
			System.out.println("Section already exists");
	}
	protected boolean sectionSizeValid(int r, int d) {
		int rowMax = 100;
		int deckMax = 10;
		if (r <= rowMax && r > 0 && d <= deckMax && d > 0)
			return true;
		return false;
	}
	protected boolean sectionExists(String s) {
		for (Section sec : sections) {
			CabinClass c = CabinClass.valueOf(s);
			CabinSection cs = (CabinSection)sec;
			if (cs.getCabinClass() == c) {
				return true;
			}
		}
		return false;
	}
	public Section findSection(String s) {
		for (Section sec : sections) {
			CabinClass c = CabinClass.valueOf(s);
			CabinSection cs = (CabinSection)sec;
			if (cs.getCabinClass() == c) {
				return cs;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		String ret = "================================================\n" + "Trip: " + id + "\n" + "Date: " + month
				+ "/" + day + "/" + year + "\n" + "Departing from: " + orig + "\n" + "Destination: " + dest + "\n";
		for (Section sec : sections) {
			ret += "\n" + sec.toString();
		}
		ret += "================================================";
		return ret;
	}

}

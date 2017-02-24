package transportation;

public class Cruise extends TransportLine{

	public Cruise(String n) {
		super(n);

	}
	public void addTransport(String orig, String dest, int year, int month, int day, String id, String ship) {
		transports.add(new Trip(orig, dest, year, month, day, id, ship));
	}
	public String toString() {
		String ret = "Cruise: " + name + ":\n";
		for (Transport tr : transports) {
			ret += tr.toString();
		}
		return ret;
	}
}

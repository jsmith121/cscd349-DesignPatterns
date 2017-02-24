package transportation;

import java.util.ArrayList;

public abstract class Transport {

	protected ArrayList<Section> sections;
	protected int year, month, day;
	protected String orig, dest, id;

	public Transport(String orig, String dest, int year, int month, int day, String id) {
		sections = new ArrayList<Section>();
		this.orig = orig;
		this.dest = dest;
		this.year = year;
		this.month = month;
		this.day = day;
		this.id = id;
	}

	@Override
	public abstract String toString();
	protected abstract boolean sectionExists(String s);

	public abstract Section findSection(String s);

	public String getOrig() {
		return orig;
	}

	public String getDest() {
		return dest;
	}

	public String getId() {
		return this.id;
	}
}

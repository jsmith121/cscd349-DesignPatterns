package transportation;

import java.util.ArrayList;

public abstract class TransportLine {
	protected String name;
	protected ArrayList<Transport> transports;
	
	public TransportLine(String n)
	{
		this.name = n;
		this.transports = new ArrayList<Transport>();
	}
	public String getName() {
		return this.name;
	}
	public ArrayList<Transport> getTransports() {
		return transports;
	}
	public Transport findTransport(String id) {
		for (Transport tr : transports) {
			if (tr.getId() == id) {
				return tr;
			}
		}
		return null;
	}
	public boolean transportExists(String id) {
		for (Transport tr : transports) {
			if (tr.getId() == id) {
				return true;
			}
		}
		return false;
	}
	@Override
	public abstract String toString();
}

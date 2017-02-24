package transportation;

public abstract class Arrangement {
	protected boolean booked = false;

	
	public void book() {
		this.booked = true;
	}

	public void cancel() {
		this.booked = false;
	}

	public boolean isBooked() {
		return this.booked;
	}


}

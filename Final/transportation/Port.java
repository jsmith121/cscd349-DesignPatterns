package transportation;

public class Port extends Location {

	public Port(String n)
	{
		super(n);
	}
	public String toString()
	{
		return "Port: " + this.name;
	}
}

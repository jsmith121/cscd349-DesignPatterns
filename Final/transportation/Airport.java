package transportation;

public class Airport extends Location{

	public Airport(String n) 
	{
		super(n);
	}
	public String toString()
	{
		return "Airport: " + this.name;
	}
	
}

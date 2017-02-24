package transportation;
public abstract class Location {
	protected String name;
	
	public Location(String n)
	{
		this.name = n;
	}
	public String getName() {
		return name;
	}
	
	@Override
	public abstract String toString();

}

package shapes;

public abstract class Shape implements Comparable<Shape>{

	
	public abstract double area();
	
	@Override
	public int compareTo(Shape s)
	{
		if(this.getName().equals(s.getName()))
		{
			return (int)(this.area()-s.area());
		}
		return this.getName().compareTo(s.getName());
	}
	public abstract String getName();

}
package shapes;

public class Circle extends Shape{

	int radius;
	
	public Circle(int r)
	{
		this.radius = r;
	}
	
	public double area()
	{
		return Math.PI*Math.pow(radius, 2);
	}
	@Override
	public String getName(){return "Circle";}

}

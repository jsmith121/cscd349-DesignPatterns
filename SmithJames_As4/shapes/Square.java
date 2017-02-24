package shapes;

public class Square extends Shape{

	private int sideLength;
	public Square(int s)
	{
		this.sideLength = s;
	}
	
	public double area()
	{
		return this.sideLength*sideLength;
	}

	@Override
	public String getName(){return "Square";}

}

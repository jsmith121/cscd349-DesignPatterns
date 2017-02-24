package shapes;

public class Triangle extends Shape{

	private int width;
	private int height;
	
	public Triangle(int w, int h)
	{
		this.width = w;
		this.height = h;
	}
	
	public double area()
	{
		return (this.width*this.height)/2;
	}

	@Override
	public String getName(){return "Triangle";}

}

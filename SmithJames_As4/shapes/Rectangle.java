package shapes;

public class Rectangle extends Shape{

	private int width;
	private int height;
	
	public Rectangle(int w, int h)
	{
		this.width = w;
		this.height = h;
	}
	
	public double area()
	{
		return this.width*this.height;
	}
	public String getName(){return "Rectangle";}


}

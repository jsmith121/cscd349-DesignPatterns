package shapes;

public interface ShapeFactory {
	public Circle createCircle(int r);
	public Triangle createTriangle(int w, int h);
	public Square createSquare(int s);
	public Rectangle createRectangle(int w, int h);
}

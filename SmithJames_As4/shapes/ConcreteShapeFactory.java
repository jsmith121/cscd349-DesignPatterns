package shapes;

public class ConcreteShapeFactory implements ShapeFactory {

	@Override
	public Circle createCircle(int r) {
		return new Circle(r);
	}

	@Override
	public Triangle createTriangle(int w, int h) {
		return new Triangle(w, h);
	}

	@Override
	public Square createSquare(int s) {
		return new Square(s);
	}

	@Override
	public Rectangle createRectangle(int w, int h) {
		return new Rectangle(w, h);
	}

}

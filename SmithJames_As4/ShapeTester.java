import java.util.ArrayList;
import java.util.Collections;

import shapes.*;

public class ShapeTester {

	public static void main(String[] args) {
		ArrayList<Shape> shapes = new ArrayList();
		
		ConcreteShapeFactory sf = new ConcreteShapeFactory();
		
		shapes.add(sf.createCircle(5));
		shapes.add(sf.createSquare(4));
		shapes.add(sf.createRectangle(5, 10));
		shapes.add(sf.createCircle(2));
		shapes.add(sf.createSquare(10));
		
		System.out.println("Before Sorting:");
		for(int i = 0; i<shapes.size();i++)
		{
			System.out.println("Area of the " + shapes.get(i).getName() + " is " + shapes.get(i).area());
		}
		Collections.sort(shapes);
		System.out.println();
		System.out.println("After Sorting:");
		for(int i = 0; i<shapes.size();i++)
		{
			System.out.println("Area of the " + shapes.get(i).getName() + " is " + shapes.get(i).area());
		}
	}

}

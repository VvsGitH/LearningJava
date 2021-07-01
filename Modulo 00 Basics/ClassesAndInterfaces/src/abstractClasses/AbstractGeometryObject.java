package abstractClasses;

import java.util.Arrays;

/* You should use abstract classes to implement the core of a set of similar classes: 
 * some sort of common concept, or idea. For example, every object in a graphic software
 * is a GeometryObject and because of that has a position, a type, it can be moved and rotated */

public abstract class AbstractGeometryObject {

	// Fields
	public double[] cohordinates;
	public String type;

	// Constructor
	public AbstractGeometryObject(String type, double[] pos) {
		this.type = type;
		cohordinates = new double[3];
		cohordinates = pos;
	}

	// Not abstract method
	public void getPosition() {
		System.out.println(Arrays.toString(cohordinates));
	}

	// Abstract methods -> must be implemented in child classes
	abstract public void move();

	abstract public void rotate();

}

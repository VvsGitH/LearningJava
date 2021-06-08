package abstractClasses;

public class Rectangle extends AbstractGeometryObject {

	public double longSize;
	public double shortSize;

	// Redefining constructor
	public Rectangle(double[] pos, double length1, double length2) {
		super("Rectangle", pos);
		longSize = length1;
		shortSize = length2;
	}

	@Override
	public void move() {
		System.out.println("Moving the rectangle");

	}

	@Override
	public void rotate() {
		System.out.println("Rotating the rectangle");

	}

}

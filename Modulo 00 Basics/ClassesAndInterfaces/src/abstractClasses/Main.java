package abstractClasses;

public class Main {

	public static void main(String[] args) {
		// INHERITANCE AND ABSTRACT CLASS EXAMPLE
		double[] position = { 0.2, 0.1, 1.3 };
		Rectangle r = new Rectangle(position, 12, 6);
		r.getPosition(); // This method is implemented in the abstract class
		r.move(); // This method is implemented in the Rectangle class
	}

}

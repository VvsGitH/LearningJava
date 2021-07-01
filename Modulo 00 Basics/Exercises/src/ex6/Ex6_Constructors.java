package ex6;

class Point {
	protected float x;
	protected float y;
	protected float z;

	public Point() {
		x = y = z = 0;
	}

	public Point(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public String toString() {
		return String.format("(%.2f, %.2f, %.2f)", x, y, z);
	}

	public void print() {
		System.out.println("P: " + this);
	}
}

class ColoredPoint extends Point {
	private String color;

	public ColoredPoint() {
		color = "Black";
	}

	public ColoredPoint(float x, float y, float z, String color) {
		super(x, y, z);
		this.color = color;
	}

	@Override
	public void print() {
		super.print();
		System.out.println("Color: " + color);
	}
}

class PointWithMass extends Point {
	protected float mass;

	public PointWithMass(float mass) {
		this.mass = mass;
	}

	@Override
	public void print() {
		super.print();
		System.out.println("Mass: " + mass);
	}
}

class PointWithMassAndVelocity extends PointWithMass {
	private float velocity;

	public PointWithMassAndVelocity(float mass, float velocity) {
		super(mass);
		this.velocity = velocity;
	}

	@Override
	public void print() {
		super.print();
		System.out.println("Velocity: " + velocity);
	}
}

public class Ex6_Constructors {

	public static void main(String[] args) {
		Point p1 = new Point();
		p1.print();
		System.out.println();

		Point p2 = new Point(1, 2, 3);
		p2.print();
		System.out.println();

		ColoredPoint pc1 = new ColoredPoint();
		pc1.print();
		System.out.println();

		ColoredPoint pc2 = new ColoredPoint(5, 2.2F, 1.1F, "Red");
		pc2.print();
		System.out.println();

		PointWithMass pm = new PointWithMass(3.5F);
		pm.print();
		System.out.println();

		PointWithMassAndVelocity pmv = new PointWithMassAndVelocity(4.1F, 10.0F);
		pmv.print();

		// Risultato
		// Il costruttore super() viene chiamato automaticamente nel costruttore
		// della sottoclasse se non richiede argomenti.
		// Serve chiamarlo esplicitamente solo se necessita degli argomenti.
	}

}

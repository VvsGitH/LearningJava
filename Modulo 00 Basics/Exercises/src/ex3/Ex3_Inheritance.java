package ex3;

class Segment {
	public float x1;
	public float y1;
	public float x2;
	public float y2;

	public Segment(float x1, float y1, float x2, float y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	@Override
	public String toString() {
		return String.format("[(%.2f, %.2f), (%.2f, %.2f)]", x1, y1, x2, y2);
	}

	public void print() {
		System.out.println("The segment is " + this);
	}
}

class OrientedSegment extends Segment {
	public boolean direction;

	public OrientedSegment(float x1, float y1, float x2, float y2, boolean direction) {
		super(x1, y1, x2, y2);
		this.direction = direction;
	}
}

public class Ex3_Inheritance {
	public static double length(Segment s) {
		return Math.sqrt(Math.pow((s.x2 - s.x1), 2) + Math.pow((s.y2 - s.y1), 2));
	}

	public static void main(String[] args) {
		OrientedSegment os = new OrientedSegment(0, 0, 5, 8, true);

		// Verifica di poter usare print() con gli oggetti OrientedSegment
		os.print();

		// Verifica di poter usare un oggetto OrientedSegment al posto di un
		// oggetto Segment
		System.out.printf("The segment length is: %.2f\n", length(os));
	}

}

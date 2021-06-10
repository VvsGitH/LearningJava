package ex10;

class Building implements Comparable {
	public int heigth;

	public Building(int heigth) {
		this.heigth = heigth;
	}

	public boolean greater(Comparable b) {
		if (b != null && getClass().equals(b.getClass())) {
			return heigth > ((Building) b).heigth;
		} else
			return false;
	}

	public boolean equal(Comparable b) {
		// Check if b is of the same class as this (Building)
		if (b != null && getClass().equals(b.getClass())) {
			return heigth == ((Building) b).heigth;
		} else
			return false;
	}

	public boolean graterOrEqual(Comparable b) {
		return greater(b) || equal(b);
	}
}

public class Ex10_Interfaces {

	public static void main(String[] args) {
		Building b1 = new Building(10);
		Building b2 = new Building(30);
		Building b3 = new Building(15);
		Building b4 = new Building(30);

		Building highest = (Building) Utilities.maxOfThree(b1, b2, b3);

		System.out.println("The highest building among the first three is: " + highest.heigth);

		Building highest2 = (Building) Utilities.max(new Comparable[] { b1, b2, b3, b4 });
		int highestNum = Utilities.maxNum(new Comparable[] { b1, b2, b3, b4 });

		System.out.println("The highest heigth is: " + highest2.heigth);
		System.out.printf("The are %d buildings of this heigth\n", highestNum);
	}

}

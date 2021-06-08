
public class Square {
	private int side = 4;

	public int getSide() {
		return side;
	}

	public void setSide(int side) {
		this.side = side;
	}
	
	public void printArea(String user) {
		if (side < 0) {
			System.out.println("The side can't be negative!");
		} else {
			int area = side * side;
			System.out.println("Hey " + user + ", the area is: " + area);

			switch (area) {
			case 0:
				System.out.println("Your square doesn't exist!");
				break;
			case 4:
				System.out.println("Your square has a side of 2");
				break;
			case 9:
			case 25:
				System.out.println("Your square has an odd side");
				break;
			default:
				System.out.println("Your square is pretty normal");
			}
		}
	}
}

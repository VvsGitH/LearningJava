
public class SpecialToDo extends ToDo {
	private int hour;
	private int minutes;

	public void setTime(int h, int m) {
		if (h < 0 || h > 23) {
			System.out.println("Invalid hour!");
			return;
		}

		if (m < 0 || m > 59) {
			System.out.println("Invalid minutes!");
			return;
		}

		this.hour = h;
		this.minutes = m;
	}

	public String getTime() {
		return String.format("%02d", hour) + ":" + String.format("%02d", minutes);
	}

	@Override
	public void printToDo() {
		System.out.println();
		System.out.println("Name: " + getName());
		System.out.println("Day: " + getDay());
		System.out.println("Month: " + getMonthStr());
		System.out.println("Year: " + getYear());

		System.out.println("Time: " + getTime());
	}

}

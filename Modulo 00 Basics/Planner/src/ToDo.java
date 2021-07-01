import java.time.Year;

public class ToDo {
	private int day = 0;
	private int month = 0;
	private int year = 0;
	private String name = null;

	public void setDay(int d) {
		if (d < 0 || d > 31) {
			System.out.println("Invalid day");
			return;
		}

		if (month == 0) {
			System.out.println("Insert the month first!");
			return;
		}

		switch (month) {
		case 4:
		case 6:
		case 9:
		case 11:
			if (d > 30) {
				System.out.println("The selected month has 30 days!");
			} else {
				this.day = d;
			}
			break;
		case 2:
			if (d > 28) {
				System.out.println("February has only 28 days!");
			} else {
				this.day = d;
			}
			break;
		default:
			this.day = d;
		}
	}

	public int getDay() {
		return day;
	}

	public void setMonth(int m) {
		if (m < 1 || m > 12) {
			System.out.println("Invalid month");
		} else {
			this.month = m;
		}
	}

	public int getMonth() {
		return month;
	}

	public String getMonthStr() {
		switch (month) {
		case 1:
			return "Gen";
		case 2:
			return "Feb";
		case 3:
			return "Mar";
		case 4:
			return "Apr";
		case 5:
			return "May";
		case 6:
			return "Jun";
		case 7:
			return "Jul";
		case 8:
			return "Aug";
		case 9:
			return "Sep";
		case 10:
			return "Oct";
		case 11:
			return "Nov";
		case 12:
			return "Dec";
		default:
			return null;
		}
	}

	public void setYear(int y) {
		int currentYear = Year.now().getValue();
		if (y < currentYear) {
			System.out.println("Invalid year!");
		} else {
			this.year = y;
		}
	}

	public int getYear() {
		return year;
	}

	public void setName(String n) {
		if (n == null || n.length() < 0) {
			System.out.println("Insert a name");
		} else {
			this.name = n;
		}
	}

	public String getName() {
		return name;
	}

	public void printToDo() {
		System.out.println();
		System.out.println("Name: " + getName());
		System.out.println("Day: " + getDay());
		System.out.println("Month: " + getMonthStr());
		System.out.println("Year: " + getYear());
	}
}

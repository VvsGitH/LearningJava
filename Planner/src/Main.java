
public class Main {

	public static void main(String[] args) {
		ToDo first = new ToDo();
		first.setMonth(11);
		first.setDay(22);
		first.setYear(2021);
		first.setName("Vai al barbiere");

		first.printToDo();

		SpecialToDo second = new SpecialToDo();
		second.setMonth(4);
		second.setDay(1);
		second.setYear(2022);
		second.setName("Happy Birthday");
		second.setTime(21, 0);

		second.printToDo();

		//
		// ToDos' array
		//

		ToDo[] planner = new ToDo[3];
		planner[0] = first;

		// OSS: the assignment pass the reference to the object
		// Therefore the planner[0] and first are the same!
		// A change in one will modify both.
		first.setName("Test");
		planner[0].printToDo();

		// OSS: I can insert a child class too!
		planner[1] = second;
		// However I can't use the child specific methods directly
		// planner[1].setTime(13,30) is an error

		// But I can use the second obj. directly to call its methods
		// and the changes will be reflected in the planner[1] obj.
		second.setTime(13, 30);

		// Strangely, I can use the overridden methods correctly
		planner[1].printToDo();

		// I can create a new ToDo object directly inside the array
		planner[2] = new ToDo();
		planner[2].setMonth(5);
		planner[2].setDay(15);
		planner[2].setYear(2021);
		planner[2].setName("New Todo");
		planner[2].printToDo();

	}

}

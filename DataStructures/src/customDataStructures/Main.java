package customDataStructures;

public class Main {

	public static void arrayListDemo() {
		ArrayList<Integer> arr = new ArrayList<Integer>(3);
		arr.append(1);
		arr.append(2);
		arr.append(3);
		arr.append(4); // Extending the array

		arr.print(); // [ 1 2 3 4 ]

		arr.insert(11, 0); // Inserting at the start
		arr.insert(12, 3); // Inserting in the middle
		arr.insert(13, arr.length); // Inserting at the end

		arr.set(20, 2);

		arr.print(); // [ 11 1 20 12 3 4 13 ]

		arr.remove(1); // [ 11 20 12 3 4 13 ]
		arr.remove(3); // [ 11 20 12 4 13 ]
		arr.remove(3); // [ 11 20 12 13 ]

		arr.print();
	}

	public static void queueDemo() {
		Queue<String> queue = new Queue<String>(4);

		queue.push("Hi");
		queue.push("Hello");
		queue.push("Ciao");
		queue.push("Salve");
		queue.push("Buongiorno");

		queue.print();

		queue.pop();
		queue.pop();

		queue.print();

		queue.push("We");
		queue.push("Weila");
		queue.push("Saluti");

		queue.print();

		queue.pop();
		queue.pop();
		queue.pop();

		queue.print();

		queue.pop();
		queue.pop();

		queue.print();
	}

	public static void main(String[] args) {
		//arrayListDemo();
		queueDemo();
	}

}

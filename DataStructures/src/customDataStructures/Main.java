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
		Queue queue = new Queue(4);

		queue.push(0);
		queue.push(1);
		queue.push(2);
		queue.push(3);
		queue.push(4);

		queue.print();

		queue.pop();
		queue.pop();

		queue.print();

		queue.push(4);
		queue.push(5);
		queue.push(6);

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
		// arrayListDemo();
		queueDemo();
	}

}

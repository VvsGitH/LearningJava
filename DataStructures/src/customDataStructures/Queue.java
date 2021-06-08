package customDataStructures;

public class Queue {
	private int[] queue;
	private int size;

	private int head; // Indx of the oldest element
	private int tail; // Indx of the newest element

	private final String EMPTY_MSG = "The queue is empty!";
	private final String FULL_MSG = "The queue is full!";

	public Queue(int size) {
		queue = new int[size];
		this.size = size;

		head = tail = -1;
	}

	public void push(int elm) {
		// Move the tail
		if (head == -1) {
			// The queue is empty
			head++;
			tail++;

		} else if (tail == size - 1) {
			// The tail is at the end of the queue array
			if (head != 0)
				// If the tail is not at 0 we can loop back to the start
				// [_ _ head elm elm tail] -> [tail _ head elm elm elm]
				tail = 0;
			else {
				// [head elm elm elm tail]
				System.out.println(FULL_MSG);
				return;
			}

		} else if (tail == head - 1) {
			// [elm tail head elm elm]
			System.out.println(FULL_MSG);
			return;
		} else
			tail++;

		// Add the element
		queue[tail] = elm;
	}

	public int pop() {
		if (head == -1) {
			// The queue is empty
			System.out.println(EMPTY_MSG);
			return -1;
		}

		int popped = queue[head];

		// Move the head
		if (head == tail)
			head = tail = -1;

		else if (head == size - 1)
			// [elm elm tail _ head] -> [head elm tail _ _]
			head = 0;

		else
			head++;

		return popped;
	}

	public int[] getOrderedQueue() {
		int[] orderedQueue = new int[size];

		// Queue example
		// [elm tail _ head elm elm elm ]

		boolean tailReached = false;
		int j = 0; // Index of the new array

		// Copy the elments of the queue starting from the head
		// -> [head elm elm elm ]
		for (int i = head; i < size; i++) {
			orderedQueue[j] = queue[i];
			j++;

			// This is the simple case in which the tail is after
			// the head -> [head elm elm tail _ _]
			if (i == tail) {
				tailReached = true;
				break;
			}
		}

		// Adding the remaining elments starting from 0
		// -> [head elm elm elm ] + [elm tail]
		if (!tailReached) {
			for (int i = 0; i <= tail; i++) {
				orderedQueue[j] = queue[i];
				j++;
			}
		}

		// There were empty elments in the queue
		// Create a new vector with the correct dimension
		// [head elm elm elm elm tail _] -> [head elm elm elm elm tail]
		if (j < size) {
			int[] reduced = new int[j];
			for (int i = 0; i < j; i++) {
				reduced[i] = orderedQueue[i];
			}
			orderedQueue = reduced;
		}

		return orderedQueue;
	}

	public void print() {
		if (head == -1)
			System.out.println("[]");
		
		else {
			int[] orderedQueue = getOrderedQueue();
			System.out.print("[ ");
			for (int elm : orderedQueue) {
				System.out.print(elm + " ");
			}
			System.out.println("]");
		}
	}
}

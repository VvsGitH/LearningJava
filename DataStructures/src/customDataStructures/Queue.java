package customDataStructures;

import java.util.Arrays;

@SuppressWarnings("unchecked")
public class Queue<T> {
	private T[] queue;
	private int size;

	private int head; // Indx of the oldest element
	private int tail; // Indx of the newest element

	private final String EMPTY_MSG = "The queue is empty!";
	private final String FULL_MSG = "The queue is full!";

	public Queue(int size) {
		queue = (T[]) new Object[size];
		this.size = size;

		head = tail = -1;
	}

	public void push(T elm) {
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

	public T pop() {
		if (head == -1) {
			// The queue is empty
			System.out.println(EMPTY_MSG);
			return null;
		}

		T popped = queue[head];

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

	public T[] getOrderedQueue() {
		T[] orderedQueue = (T[]) new Object[size];

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
			T[] reduced = (T[]) new Object[j];
			for (int i = 0; i < j; i++) {
				reduced[i] = orderedQueue[i];
			}
			orderedQueue = reduced;
		}

		return orderedQueue;
	}
	
	public void print() {
		System.out.println(this);
	}

	@Override
	public String toString() {
		if (head == -1)
			return "[]";
		
		else {
			T[] orderedQueue = getOrderedQueue();
			String str = "[ ";
			for (T elm : orderedQueue) {
				str += (elm + " ");
			}
			str += "]";
			return str;
		}
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
	
		if (o == null || !getClass().equals(o.getClass()))
			return false;
		
		Queue<T> q = (Queue<T>) o;
		
		if (size != q.size || head != q.head || tail != q.tail)
			return false;
		
		for (int i = 0; i < size; i++) {
			if (queue[i] != q.queue[i])
				return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		int hash = 3;
		hash = 5*hash + size;
		hash = 5*hash + head;
		hash = 5*hash + tail;
		hash = 5*hash + Arrays.deepHashCode(queue);
		return hash;
	}
	
	@Override
	public Object clone() {
		try {
			Queue<T> q = (Queue<T>) super.clone();
			
			q.queue = queue.clone();
			
			return q;
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}

}

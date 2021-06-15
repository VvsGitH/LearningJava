package customDataStructures;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Queue<T> implements Collection<T> {
	private Object[] queue;
	private int capacity;

	private int head; // Indx of the oldest element
	private int tail; // Indx of the newest element

	private final String EMPTY_MSG = "The queue is empty!";
	private final String FULL_MSG = "The queue is full!";

	// CONSTRUCTOR

	public Queue(int capacity) {
		queue = new Object[capacity];
		this.capacity = capacity;

		head = tail = -1;
	}

	// STANDARD OPERATIONS

	@Override
	public boolean add(T elm) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		queue = new Object[capacity];
		head = tail = -1;
	}

	// OPERATIONS ON THE QUEUE

	public boolean push(T elm) {
		// Move the tail
		if (head == -1) {
			// The queue is empty
			head++;
			tail++;

		} else if (tail == capacity - 1) {
			// The tail is at the end of the queue array
			if (head != 0)
				// If the tail is not at 0 we can loop back to the start
				// [_ _ head elm elm tail] -> [tail _ head elm elm elm]
				tail = 0;
			else {
				// [head elm elm elm tail]
				System.out.println(FULL_MSG);
				return false;
			}

		} else if (tail == head - 1) {
			// [elm tail head elm elm]
			System.out.println(FULL_MSG);
			return false;
		} else
			tail++;

		// Add the element
		queue[tail] = elm;
		return true;
	}

	public T peek() {
		if (head == -1) {
			// The queue is empty
			System.out.println(EMPTY_MSG);
			return null;
		}

		@SuppressWarnings("unchecked")
		T peeked = (T) queue[head];

		return peeked;
	}

	public T pop() {
		T popped = peek();

		// Move the head
		if (head == tail)
			// The queue is being emptied
			head = tail = -1;

		else if (head == capacity - 1)
			// [elm elm tail _ head] -> [head elm tail _ _]
			head = 0;

		else
			head++;

		return popped;
	}

	// INFOS

	public boolean isEmpty() {
		return head == -1;
	}

	public int size() {
		return capacity;
	}

	public int remainingCapacity() {
		int elmNum = 0;

		if (head == -1)
			// Empty!
			elmNum = 0;

		else if (head < tail)
			// [_ head elm elm elm tail _]
			elmNum = tail - head + 1;

		else if (head > tail)
			// [elm elm tail _ _ head elm]
			elmNum = capacity - head + tail + 1;

		else
			// [_ head/tail _ _ _ _ _ ]
			elmNum = 1;

		return capacity - elmNum;
	}

	public boolean contains(Object obj) {
		if (obj == null)
			return false;

		for (int i = head; i < capacity; i++) {
			if (queue[i].equals(obj))
				return true;
			else if (i == tail)
				// End of queue reached
				return false;
		}

		// The previous for-loop ended without finding either
		// the obj or the tail. We are in this case:
		// [ elm obj? elm tail _ _ _ head elm elm ]
		for (int i = 0; i <= tail; i++) {
			if (queue[i].equals(obj))
				return true;
		}

		return false;
	}

	// CONVERSIONS

	public Object[] toArray() {
		Object[] orderedQueue = new Object[capacity - remainingCapacity()];

		// Queue example
		// [elm tail _ head elm elm elm ]

		boolean tailReached = false;
		int j = 0; // Index of the new array

		// Copy the elments of the queue starting from the head
		// -> [head elm elm elm ]
		for (int i = head; i < capacity; i++) {
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

		return orderedQueue;
	}

	@SuppressWarnings("unchecked")
	public T[] toArray(T[] orderedQueue) {
		orderedQueue = (T[]) Array.newInstance(orderedQueue.getClass().getComponentType(),
				capacity - remainingCapacity());

		// Queue example
		// [elm tail _ head elm elm elm ]

		boolean tailReached = false;
		int j = 0; // Index of the new array

		// Copy the elments of the queue starting from the head
		// -> [head elm elm elm ]
		for (int i = head; i < capacity; i++) {
			orderedQueue[j] = (T) queue[i];
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
				orderedQueue[j] = (T) queue[i];
				j++;
			}
		}

		return orderedQueue;
	}

	@Override
	public String toString() {
		if (head == -1)
			return "[]";
		
		else {
			Object[] orderedQueue = toArray();
			String str = "[ ";
			for (Object elm : orderedQueue) {
				str += (elm + " ");
			}
			str += "]";
			return str;
		}
	}
	
	// EQUALS AND CLONE

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
	
		if (o == null || !getClass().equals(o.getClass()))
			return false;
		
		@SuppressWarnings("unchecked")
		Queue<T> q = (Queue<T>) o;
		
		if (capacity != q.capacity || head != q.head || tail != q.tail)
			return false;
		
		for (int i = 0; i < capacity; i++) {
			if (queue[i] != q.queue[i])
				return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		int hash = 3;
		hash = 5 * hash + capacity;
		hash = 5*hash + head;
		hash = 5*hash + tail;
		hash = 5*hash + Arrays.deepHashCode(queue);
		return hash;
	}
	
	@Override
	public Object clone() {
		try {
			@SuppressWarnings("unchecked")
			Queue<T> q = (Queue<T>) super.clone();
			
			q.queue = queue.clone();
			
			return q;
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}


}

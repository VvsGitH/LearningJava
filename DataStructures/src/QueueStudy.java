import java.util.PriorityQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

// QUEUE INTERFACE

/* 
 * A collection designed for holding elements prior to processing. 
 * Besides basic Collection operations, queues provide additional insertion, 
 * extraction, and inspection operations. Each of these methods exists in two forms: 
 * one throws an exception if the operation fails, the other returns a special value 
 * (either null or false, depending on the operation). 
 * 
 * offer: add to the queue
 * poll: remove head
 * peak: retrieve head, without removing it
 * 
 * Queues typically, but do not necessarily, order elements in a FIFO manner. 
 * 
 * */

//BLOCKING QUEUE INTERFACE

/*
 * A Queue that additionally supports operations that wait for the queue to
 * become non-empty when retrieving an element, and wait for space to become
 * available in the queue when storing an element.
 * 
 * BlockingQueue methods come in four forms, with different ways of handling
 * operations that cannot be satisfied immediately, but may be satisfied at some
 * point in the future: one throws an exception; the second returns a special
 * value; the third blocks for only a given maximum time limit before giving
 * up; the fourth blocks the current thread indefinitely until the operation
 * is done.
 * 
 * Adding element: add(e) - offer(e) - offer(e, time) - put(e)
 * Removing head: remove() - poll() - poll(time) - take()
 * Examening head: element() - peek()
 * 
 */

public class QueueStudy {
	public static void priorityQueue() {

		// An unbounded priority queue based on a priority heap.
		// The elements of the priority queue are ordered according to their
		// natural ordering, or by a Comparator provided at queue construction time.
		// A priority queue does not permit null elements.

		PriorityQueue<Integer> myQueue = new PriorityQueue<Integer>();

		// Offer -> Insert element and do not retur an exception in fail
		myQueue.offer(3);
		myQueue.offer(4);
		myQueue.offer(1);
		myQueue.offer(0);
		myQueue.offer(2);

		// Peak the head
		System.out.println("The head of the queue is: " + myQueue.peek());

		// Retrieves and remove the head (no exception)
		myQueue.poll();
		System.out.println(myQueue);
	}

	public static void blockingQueue() {

		// ARRAY BLOCKING QUEUE
		// FIFO -> The head is the oldest element in the queue; the tail is the newest.
		// Is a bounded buffer.

		ArrayBlockingQueue<Integer> myQueue = new ArrayBlockingQueue<Integer>(5);

		// ADDING NEW ELEMENTS

		myQueue.add(3);
		myQueue.add(4);
		myQueue.add(1);
		myQueue.add(0);
		myQueue.add(2);
		System.out.println(myQueue);

		// ADDING AN ELMENT IN FULL QUEUE

		// This will throw a Queue full eception
		try {
			System.out.println(myQueue.add(10));
		} catch (Exception e) {
			System.out.println(e);
		}

		// This will return false
		System.out.println(myQueue.offer(10));

		// This will return false after 2 seconds
		// Throws an exception if is interrupted while waiting
		try {
			System.out.println(myQueue.offer(10, 2, TimeUnit.SECONDS));
		} catch (Exception e) {
			System.out.println(e);
		}

		// I can't use put because it would block the app indefinitely

		// REMOVING OLDEST ELEMENT

		myQueue.remove();
		myQueue.poll();

		// This can block the app indefinitely
		try {
			myQueue.take();
		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println(myQueue);

	}
}

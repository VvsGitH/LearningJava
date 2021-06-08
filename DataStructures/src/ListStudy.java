import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

// LIST INTERFACE
// An ordered collection (also known as a sequence).
// The user of this interface has precise control over where in the list each 
// element is inserted. The user can access elements by their integer index 
// (position in the list), and search for elements in the list.

public class ListStudy {

	public static void arrayListTutorial() {

		// ArrayList -> Resizable array

		// The ArrayList class has a regular array inside it. When an element is added,
		// it is placed into the array. If the array is not big enough, a new, larger
		// array is created to replace the old one and the old one is removed.

		// Use an ArrayList when:
		// You want to access random items frequently
		// You only need to add or remove elements at the end of the list

		ArrayList<Integer> myArrList = new ArrayList<Integer>();

		// Append to the list
		myArrList.add(13);
		myArrList.add(15);
		myArrList.add(17);
		myArrList.add(29);
		myArrList.add(31);

		// Insert at specific indx
		myArrList.add(3, 20);

		// Remove element
		myArrList.remove(4);

		// Set and get a specific item
		// Throw IndexOutOfBoundsException
		myArrList.set(2, 18);
		int element = myArrList.get(2);
		System.out.println("At index 2 there is: " + element);

		// Other usefull methods
		// indexOf(elm) -> elm or -1
		// isEmpty() -> bool
		// size() -> int
		// subList(from, to) -> List
		// toArray() -> array

		// Iterator
		Iterator<Integer> iterator = myArrList.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();

		// I can obtain the same result with a for-each loop
		for (Integer elm : myArrList) {
			System.out.print(elm + " ");
		}
		System.out.println();

		// NOTE: VECTOR
		// Vector is almost identical to ArrayList. The main list is the fact that
		// Vector is synchronized and thread-safe, while ArrayList isn't.

	}

	public static void linkedListTutorial() {
		// LinkedList -> chain of objects

		// The LinkedList stores its items in "containers." The list has a link to the
		// first container and each container has a link to the next container in the
		// list. To add an element to the list, the element is placed into a new
		// container and that container is linked to one of the other containers in the
		// list.

		// Use a LinkedList when:
		// You only use the list by looping through it instead of accessing random items
		// You frequently need to add and remove items from the beginning, middle or end
		// of the list

		LinkedList<String> myLinkList = new LinkedList<String>();

		// A LinkedList has the same methods of an ArrayList, but it can do certain
		// operation more efficiently

		myLinkList.add("First,");
		myLinkList.add("Second,");
		myLinkList.add("Third,");
		myLinkList.add("Fourth,");

		myLinkList.addFirst("Now I'm the first,");
		myLinkList.addLast("I'm the last");

		// removeFirst, removeLast
		// getFirst, getLast

		for (String elm : myLinkList) {
			System.out.print(elm + " ");
		}
		System.out.println();
	}

}

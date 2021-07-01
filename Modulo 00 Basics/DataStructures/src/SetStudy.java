import java.util.HashSet;
import java.util.TreeSet;

// SET INTERFACE
// A collection that contains no duplicate elements.
// More formally, sets contain no pair of elements e1 and e2 such that e1.equals(e2), 
// and at most one null element. As implied by its name, this interface models the 
// mathematical set abstraction.
// Elements in a set have no index.

public class SetStudy {
	public static void hashSetTutorial() {

		// HashSet is an implementation of Set. It uses an hash function to store the
		// items without duplicates

		HashSet<String> myHashSet = new HashSet<String>();

		myHashSet.add("Hello");
		myHashSet.add("Hello");
		myHashSet.add("World");
		myHashSet.add("World");
		myHashSet.add("!");

		// The HashSet doesn't have a predictable iteration order!
		// If order is important, use the LinkedHashSet

		for (String elm : myHashSet) {
			System.out.print(elm + " ");
		}
		System.out.println();

		// Since the Set interface does not support indexes, we can't directly
		// access or insert elements in the middle of the set

		// Check if an element is present in the set
		System.out.println("Is the word 'World' present? " + myHashSet.contains("World"));

		// I can also remove an element
		myHashSet.remove("!");
		// Or clear the entire set
		// myHashSet.clear();
	}

	public static void treeSetTutorial() {

		// A TreeSet is an implementation of the Set <- SortedSet <- NavigableSet
		// interfaces. It's a particular set that automatically sort its elements
		// based on their natural ordering or on a custom comparator.

		TreeSet<String> myTreeSet = new TreeSet<String>();

		myTreeSet.add("Bob");
		myTreeSet.add("Luke");
		myTreeSet.add("Angel");
		myTreeSet.add("Ross");
		myTreeSet.add("Phoebe");
		myTreeSet.add("Joe");

		System.out.println(myTreeSet);
	}
}

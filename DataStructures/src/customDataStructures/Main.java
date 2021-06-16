package customDataStructures;

class A {
	public int a;

	public A(int a) {
		this.a = a;
	}

	public void hello() {
		System.out.println("Hello from an A object");
	}
}

public class Main {
	public static void arrayListDemo() {

		// Testing appending elements and memory extension

		ArrayList<Integer> arr = new ArrayList<>(3);
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(4); // Extending the array

		System.out.println(arr); // [ 1 2 3 4 ]

		// Testing insertion and elment update

		arr.add(11, 0); // Inserting at the start
		arr.add(12, 3); // Inserting in the middle
		arr.add(13, arr.size()); // Inserting at the end

		arr.set(20, 2);

		System.out.println(arr); // [ 11 1 20 12 3 4 13 ]

		// Testing removing elements

		arr.remove(1); // [ 11 20 12 3 4 13 ]
		arr.remove(3); // [ 11 20 12 4 13 ]
		arr.remove(3); // [ 11 20 12 13 ]

		System.out.println(arr);

		// Testing datatype of remove and get returns

		int getted = arr.get(0); // int/Integer type correct!
		int removed = arr.remove(0); // int/Integer type correct!
		System.out.println(getted + " " + removed);

		// Testing constructor with array and addAll

		ArrayList<Integer> arr2 = new ArrayList<>(new Integer[] { 23, 43, 675, 776 });
		arr2.add(100);
		arr2.addAll(new Integer[] { 13, 151, 45 });
		System.out.println(arr2); // [ 23 43 675 776 100 13 151 45 ]

		// Testing toArray()

		Object[] resArray1 = arr2.toArray();
		// Integer[] test1 = (Integer[]) arr2.toArray(); // ClassCastException
		System.out.println(resArray1.getClass().getComponentType());
		// The elements inside the array are still integers!
		System.out.println("The int inside the array is " + ((int) resArray1[0]));

		// Testing toArray(T[] a)
		// Avoids the type confusion of toArray()

		Integer[] test = arr2.toArray(new Integer[0]);
		System.out.println(test.getClass().getComponentType());

		// Testing HighOrderMethods

		arr2.forEach(elm -> elm * 2);
		System.out.println(arr2); // [ 46 86 1350 1552 200 26 302 90 ]

		ArrayList<Integer> mapped = arr2.map(elm -> elm + 1);
		System.out.println(mapped); // [ 47 87 1351 1553 201 27 303 91 ]
		System.out.println(mapped.get(0).getClass()); // Integer -> The casting works!

		ArrayList<Integer> filtered = arr2.filter(elm -> elm > 200);
		System.out.println(filtered); // [ 1350 1552 302 ]
		System.out.println(filtered.get(0).getClass()); // Integer -> The casting works!

		int sum = arr2.reduce((acc, elm) -> elm + acc, 0);
		System.out.println(sum); // 3652

		// Testing with custom objects

		ArrayList<A> arrA = new ArrayList<>(new A[] { new A(1), new A(2), new A(3) });
		arrA.addAll(new A[] { new A(4), new A(5), new A(6) });
		A[] result = arrA.toArray(new A[3]);
		System.out.println(result.getClass().getComponentType()); // A - correct!
		result[0].hello(); // Hello from an A object

		// Testing the constructor with another ArrayList

		ArrayList<Float> arrF = new ArrayList<>(new Float[] { 1.2F, 3.2F, 6.23F });
		ArrayList<Number> arrN = new ArrayList<>(arrF);
		System.out.println(arrN.toArray(new Float[0]).getClass().getComponentType());

		// Testing equal

		ArrayList<Integer> arrE1 = new ArrayList<>(new Integer[] { 1, 2, 3, 4 });
		ArrayList<Integer> arrE2 = new ArrayList<>(new Integer[] { 1, 2, 4, 4 });
		System.out.println(arrE1.equals(arrE2));

	}

	public static void queueDemo() {
		Queue<String> queue = new Queue<>(4);

		queue.push("Hi");
		queue.push("Hello");
		System.out.println(queue + ", " + queue.remainingCapacity());
		queue.push("Ciao");
		queue.push("Salve");
		queue.push("Buongiorno");

		System.out.println(queue + ", " + queue.remainingCapacity());

		queue.pop();
		queue.pop();

		System.out.println(queue + ", " + queue.remainingCapacity());

		queue.push("We");
		queue.push("Weila");
		queue.push("Saluti");

		System.out.println(queue + ", " + queue.remainingCapacity());

		queue.pop();
		queue.pop();
		queue.pop();

		System.out.println(queue + ", " + queue.remainingCapacity());

		queue.pop();
		queue.pop();

		System.out.println(queue + ", " + queue.remainingCapacity());
	}
	
	public static void queueDemo2() {
		Queue<String> queue = new Queue<>(6);
		queue.push("elm1");
		queue.push("elm2");
		queue.push("elm3");
		queue.push("elm4");
		queue.push("elm5");
		queue.push("elm6");
		System.out.println(queue.toString(false));
		
		Queue<String> queue2 = new Queue<>(4);
		queue.drainTo(queue2);
		System.out.println(queue2);
		
		ArrayList<String> arr = new ArrayList<>(6);
		queue.drainTo(arr);
		System.out.println(arr);
	}

	public static void main(String[] args) {
		// arrayListDemo();
		// queueDemo();
		queueDemo2();
	}
}

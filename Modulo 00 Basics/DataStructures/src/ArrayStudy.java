import java.util.Arrays;

public class ArrayStudy {

	public static void tutorial() {

		// Declaration and instantiation
		short[] numbers1 = new short[10];

		// Initializing the array using a common for-loop
		for (int i = 0; i < numbers1.length; i++) {
			numbers1[i] = (short) i;
		}

		// Navigating the array using a for-each-loop
		for (short elm : numbers1) {
			System.out.print(elm + " ");
		}

		System.out.println();

		// Declaration, instantiation, initialization
		int[] numbers2 = { 1, 2, 3, 4, 5 };

		for (int elm : numbers2) {
			System.out.print(elm + " ");
		}

		System.out.println();

		// FILTER, MAP, REDUCE
		// First I must convert my array in a data stream, using the stream(arr) method
		// of the java.util.Arrays class.
		// Only a stream object can access the filter, map and reduce methods.
		// After the operations, I must convert the stream back to an array.

		int[] filteredNumbers = Arrays.stream(numbers2).filter(elm -> elm > 2).toArray();
		for (int elm : filteredNumbers) {
			System.out.print(elm + " "); // 3,4,5
		}

		System.out.println();

		int[] mappedNumbers = Arrays.stream(numbers2).map(elm -> elm * 2).toArray();
		for (int elm : mappedNumbers) {
			System.out.print(elm + " "); // 2, 4, 6, 8, 10
		}

		System.out.println();

		int sum = Arrays.stream(numbers2).reduce(0, (acc, elm) -> acc + elm);
		System.out.println(sum); // 15
	}

}

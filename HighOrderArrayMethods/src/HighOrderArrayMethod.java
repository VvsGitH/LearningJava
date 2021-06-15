import java.util.Arrays;

@FunctionalInterface
interface Consumer<T> {
	void run(T elm);
}

@FunctionalInterface
interface Operator<T> {
	T run(T elm);
}

@FunctionalInterface
interface BinaryOperator<T> {
	T run(T accumulator, T elm);
}

@FunctionalInterface
interface Predicate<T> {
	boolean run(T elm);
}

class MyArray {
	public int[] arr;
	public MyArray(int[] arr) {
		this.arr = arr.clone();
	}
	
	public void forEach(Consumer<Integer> lambda) {
		for(int i = 0; i < arr.length; i++) {
			lambda.run(arr[i]);
		}
	}
	
	public void forEach(Operator<Integer> lambda) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = lambda.run(arr[i]);
		}
	}

	public int[] map(Operator<Integer> lambda) {
		int[] newArr = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++) 
			newArr[i] = lambda.run(arr[i]);
		
		return newArr;
	}
	
	public int[] filter(Predicate<Integer> lambda) {
		int[] newArr = new int[arr.length];
		
		int j = 0;
		for(int i = 0; i < arr.length; i++) {
			if (lambda.run(arr[i])) {
				newArr[j] = arr[i];
				j++;
			}
		}
		
		return Arrays.copyOf(newArr, j);
	}

	public int reduce(BinaryOperator<Integer> lambda, int initial) {
		for (int i = 0; i < arr.length; i++) {
			initial = lambda.run(initial, arr[i]);
		}

		return initial;
	}
}

public class HighOrderArrayMethod {
	
	public static void print(int[] arr) {
		System.out.print("[ ");
		for (int elm : arr)
			System.out.print(elm + " ");
		System.out.println("]");
	}

	public static void main(String[] args) {
		MyArray arr = new MyArray(new int[] {1,2,3,4,5});
		
		System.out.print("[ ");
		arr.forEach(elm -> {
			System.out.print(elm + " ");
		});
		System.out.println("]");
		
		arr.forEach(elm -> elm + 1);
		print(arr.arr);

		int[] mappedArray = arr.map(elm -> 2*elm);
		print(mappedArray);
		
		int[] filteredArray = arr.filter(elm -> elm > 3);
		print(filteredArray);

		int sum = arr.reduce((acc, elm) -> acc + elm, 0);
		System.out.println(sum);
	}

}

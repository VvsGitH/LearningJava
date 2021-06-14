import java.util.Arrays;

interface forEachOperator<T> {
	void run(T elm);
}

interface mapOperator<T> {
	T run(T elm);
}

interface filterOperator<T> {
	boolean run(T elm);
}

class MyArray {
	public int[] arr;
	public MyArray(int[] arr) {
		this.arr = arr.clone();
	}
	
	public void forEach(forEachOperator<Integer> lambda) {
		for(int i = 0; i < arr.length; i++) {
			lambda.run(arr[i]);
		}
	}
	
	public int[] map(mapOperator<Integer> lambda) {
		int[] newArr = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++) 
			newArr[i] = lambda.run(arr[i]);
		
		return newArr;
	}
	
	public int[] filter(filterOperator<Integer> lambda) {
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
}

public class HighOrderArrayMethod {
	
	public static void print(int[] arr) {
		System.out.print("[ ");
		for (int elm : arr)
			System.out.print(elm + " ");
		System.out.println("]");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyArray arr = new MyArray(new int[] {1,2,3,4,5});
		
		System.out.print("[ ");
		arr.forEach(elm -> System.out.print(elm + " "));
		System.out.println("]");
		
		int[] mappedArray = arr.map(elm -> 2*elm);
		print(mappedArray);
		
		int[] filteredArray = arr.filter(elm -> elm > 2);
		print(filteredArray);
	}

}

package customDataStructures;

import java.lang.reflect.Array;
import java.util.Arrays;

import customDataStructures.funcInterfaces.BinaryOperator;
import customDataStructures.funcInterfaces.Consumer;
import customDataStructures.funcInterfaces.Operator;
import customDataStructures.funcInterfaces.Predicate;

public class ArrayList<T> implements Collection<T> {
	private Object[] arr;
	private int capacity; // Maximum number of elements before re-allocation
	private int length; // Number of elements present in the array

	//
	// CONSTRUCTORS
	//

	public ArrayList() {
		arr = new Object[1];
		capacity = 1;
		length = 0;
	}

	public ArrayList(int capacity) {
		arr = new Object[capacity];
		this.capacity = capacity;
		length = 0;
	}

	public ArrayList(T[] elms) {
		if (elms == null)
			throw new NullPointerException();

		capacity = length = elms.length;
		arr = elms.clone();
	}

	public ArrayList(ArrayList<? extends T> elms) {
		if (elms == null)
			throw new NullPointerException();

		capacity = length = elms.size();

		arr = elms.toArray();
	}

	//
	// ADDING ELEMENTS
	//

	@Override
	public boolean add(T elm) {
		if (elm == null)
			throw new NullPointerException();

		if (length < capacity) {
			// There is at least one free space in the array
			// Add the element to the end
			arr[length] = elm;

		} else {
			// There is no space left: create a new array
			Object[] newArr = new Object[capacity + 1];

			// Coping the elements of the old one
			if (length != 0) {
				for (int i = 0; i < length; i++) {
					newArr[i] = arr[i];
				}
			}

			// Appending the new element
			newArr[newArr.length - 1] = elm;

			// Overwriting the reference
			arr = newArr;

			// Updating capacity
			capacity++;
		}

		// Updating length
		length++;
		return true;
	}

	public boolean add(T elm, int indx) {
		if (elm == null)
			throw new NullPointerException();

		if (indx < 0 || indx > length)
			throw new IndexOutOfBoundsException();

		if (indx == length) {
			// Special case
			add(elm);

		} else if (length < capacity) {
			// There is at least one free space in the array
			// Shift rigth the elements after indx
			for (int i = length; i > indx; i--) {
				arr[i] = arr[i - 1];
			}
			arr[indx] = elm;

			// Updating length
			length++;

		} else {
			// There is no space left: create a new array
			Object[] newArr = new Object[capacity + 1];

			// Copying old array's elments and inserting the new one
			for (int i = 0; i <= length; i++) {
				if (i < indx)
					newArr[i] = arr[i];
				else if (i == indx)
					newArr[i] = elm;
				else
					newArr[i] = arr[i - 1];
			}

			// Overwriting the reference
			arr = newArr;

			// Updating capacity and length
			capacity++;
			length++;
		}

		return true;
	}

	public boolean addAll(T[] elms) {
		if (elms == null)
			throw new NullPointerException();
		
		ensureCapacity(length + elms.length);
		
		for (int i = 0; i < elms.length; i++) {
			arr[length] = elms[i];
			length++;
		}

		return true;
	}

	//
	// REMOVING ELEMENTS
	//

	@SuppressWarnings("unchecked")
	public T remove(int indx) {
		if (indx < 0 || indx >= length)
			throw new IndexOutOfBoundsException();

		// Che cast is correct. arr is of type Object[], therefore every element added
		// to it is downcasted to Object. However, since every method that add or modify
		// elements assures that the new elements are of type T, the cast to T will
		// always be correct.

		T removed = (T) arr[indx];

		// Shift left the elements after indx
		if (indx < length - 1) {
			for (int i = indx + 1; i < length; i++) {
				arr[i - 1] = arr[i];
			}
		}

		// Updating length
		length--;

		return removed;
	}

	@Override
	public boolean remove(Object obj) {
		int rmIndx = indexOf(obj);

		if (rmIndx == -1)
			return false;

		else {
			remove(rmIndx);
			return true;
		}
	}

	@Override
	public void clear() {
		arr = new Object[1];
		capacity = 1;
		length = 0;
	}

	//
	// SEARCHING
	//

	@Override
	public boolean contains(Object obj) {
		if (obj == null)
			return false;

		for (int i = 0; i < length; i++)
			if (obj.equals(arr[i]))
				return true;

		return false;
	}

	public int indexOf(Object obj) {
		if (obj == null)
			return -1;

		for (int i = 0; i < length; i++)
			if (obj.equals(arr[i]))
				return i;

		return -1;
	}

	//
	// UPDATING AND RETRIEVING
	//

	public boolean set(T elm, int indx) {
		if (indx < 0 || indx >= length)
			return false;

		arr[indx] = elm;

		return true;
	}

	@SuppressWarnings("unchecked")
	public T get(int indx) {
		if (indx < 0 || indx >= length)
			throw new IndexOutOfBoundsException();

		// Che cast is correct. arr is of type Object[], therefore every element added
		// to it is downcasted to Object. However, since every method that add or modify
		// elements assures that the new elements are of type T, the cast to T will
		// always be correct.

		return (T) arr[indx];
	}

	//
	// UTILITIES
	//

	public void ensureCapacity(int minCapacity) {
		if (capacity < minCapacity) {
			Object[] newArr = new Object[minCapacity];

			// Coping the elements of the old one
			if (length != 0) {
				for (int i = 0; i < length; i++) {
					newArr[i] = arr[i];
				}
			}

			arr = newArr;
			capacity = minCapacity;
		}
	}

	public void trimToSize() {
		if (length < capacity) {
			Object[] newArr = new Object[length];

			// Coping the elements of the old one
			if (length != 0) {
				for (int i = 0; i < length; i++) {
					newArr[i] = arr[i];
				}
			}

			arr = newArr;
			capacity = length;
		}
	}

	@Override
	public boolean isEmpty() {
		return length == 0;
	}

	@Override
	public int size() {
		return length;
	}

	//
	// HIGH ORDER METHODS
	//

	@SuppressWarnings("unchecked")
	public void forEach(Consumer<T> lambda) {
		for (int i = 0; i < arr.length; i++) {
			lambda.run((T) arr[i]);
		}
	}

	@SuppressWarnings("unchecked")
	public void forEach(Operator<T> lambda) {
		for (int i = 0; i < length; i++) {
			arr[i] = lambda.run((T) arr[i]);
		}
	}

	@SuppressWarnings("unchecked")
	public ArrayList<T> map(Operator<T> lambda) {
		ArrayList<T> mapped = new ArrayList<>(length);

		for (int i = 0; i < length; i++)
			mapped.add(lambda.run((T) arr[i]));

		return mapped;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<T> filter(Predicate<T> lambda) {
		ArrayList<T> filtered = new ArrayList<>(length);

		for (int i = 0; i < length; i++)
			if (lambda.run((T) arr[i]))
				filtered.add((T) arr[i]);

		return filtered;
	}

	@SuppressWarnings("unchecked")
	public T reduce(BinaryOperator<T> lambda, T initial) {
		for (int i = 0; i < length; i++) {
			initial = lambda.run(initial, (T) arr[i]);
		}

		return initial;
	}

	//
	// CONVERSION
	//

	@Override
	public Object[] toArray() {
		return Arrays.copyOf(arr, length);
	}

	@Override
	@SuppressWarnings("unchecked")
	public T[] toArray(T[] a) {
		if (a == null)
			throw new NullPointerException();

		// Using reflection on the class in input the runtime system gets the correct
		// class reference.
		// The cast to T[] is useless at run-time but is necessary for the compiler
		// since generic types are evaluated at compile-time.

		a = (T[]) Array.newInstance(a.getClass().getComponentType(), length);

		for (int i = 0; i < length; i++) {
			a[i] = (T) arr[i];
		}

		return a;
	}

	@Override
	public String toString() {
		String str = "[ ";
		for (int i = 0; i < length; i++) {
			str += (arr[i] + " ");
		}
		str += "]";
		return str;
	}

	//
	// COMPARISON
	//

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null || !getClass().equals(obj.getClass()))
			return false;

		@SuppressWarnings("unchecked")
		ArrayList<T> arrList = (ArrayList<T>) obj;

		if (length != arrList.length)
			return false;

		for (int i = 0; i < length; i++)
			if (arr[i] != arrList.arr[i])
				return false;

		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		for (int i = 0; i < length; i++)
			result = prime * result + arr[i].hashCode();
		return result;
	}

}

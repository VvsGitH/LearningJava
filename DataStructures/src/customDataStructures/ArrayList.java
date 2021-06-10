package customDataStructures;

@SuppressWarnings("unchecked")
public class ArrayList<T> {
	private T[] arr;
	private int capacity; // Current maximum number of elements
	public int length; // Number of elements present in the array

	public ArrayList() {
		capacity = 0;
		length = 0;
	}

	public ArrayList(int capacity) {
		arr = (T[]) new Object[capacity];
		this.capacity = capacity;
		length = 0;
	}

	public void append(T newElm) {
		if (length < capacity) {
			// There is at least one free space in the array
			// Add the element to the end
			arr[length] = newElm;

		} else {
			// There is no space left: create a new array
			T[] newArr = (T[]) new Object[capacity + 1];

			// Coping the elements of the old one
			if (length != 0) {
				for (int i = 0; i < length; i++) {
					newArr[i] = arr[i];
				}
			}

			// Appending the new element
			newArr[newArr.length - 1] = newElm;

			// Overwriting the reference
			arr = newArr;

			// Updating capacity
			capacity++;
		}

		// Updating lenght
		length++;
	}

	public void insert(T elm, int indx) throws IndexOutOfBoundsException {
		if (indx < 0 || indx > length)
			throw new IndexOutOfBoundsException();

		if (indx == length) {
			// Special case
			this.append(elm);

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
			T[] newArr = (T[]) new Object[capacity + 1];

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
	}

	public T remove(int indx) throws IndexOutOfBoundsException {
		if (indx < 0 || indx >= length)
			throw new IndexOutOfBoundsException();

		T removed = arr[indx];

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

	public boolean set(T elm, int indx) {
		if (indx < 0 || indx >= length)
			return false;

		arr[indx] = elm;

		return true;
	}

	public T get(int indx) throws IndexOutOfBoundsException {
		if (indx < 0 || indx >= length)
			throw new IndexOutOfBoundsException();

		return arr[indx];
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

	public void print() {
		System.out.println(this);
	}
}

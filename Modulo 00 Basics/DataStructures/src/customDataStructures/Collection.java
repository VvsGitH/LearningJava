package customDataStructures;

public interface Collection<T> {

	// ADD ELEMENT

	public boolean add(T elm);

	// REMOVE ELEMENT

	public boolean remove(Object obj);

	// RESET THE COLLECTION

	public void clear();

	// INFORMATIONS

	public boolean contains(Object obj);

	public boolean isEmpty();

	public int size();

	// CONVERSION

	public Object[] toArray();

	public T[] toArray(T[] a);

	public String toString();

	// EQUALS AND HASHCODE

	public boolean equals(Object obj);

	public int hashCode();
}

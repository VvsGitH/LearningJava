package customDataStructures.funcInterfaces;

@FunctionalInterface
public interface Operator<T> {
	T run(T elm);
}

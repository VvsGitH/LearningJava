package customDataStructures.funcInterfaces;

@FunctionalInterface
public interface BinaryOperator<T> {
	T run(T accumulator, T elm);
}

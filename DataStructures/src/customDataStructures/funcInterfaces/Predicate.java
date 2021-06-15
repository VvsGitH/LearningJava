package customDataStructures.funcInterfaces;

@FunctionalInterface
public interface Predicate<T> {
	boolean run(T elm);
}

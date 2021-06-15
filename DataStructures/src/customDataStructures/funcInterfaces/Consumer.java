package customDataStructures.funcInterfaces;

@FunctionalInterface
public interface Consumer<T> {
	void run(T elm);
}

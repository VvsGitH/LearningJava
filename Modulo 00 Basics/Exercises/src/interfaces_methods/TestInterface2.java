package interfaces_methods;

public interface TestInterface2 {
	static void printStuffStatic() {
		System.out.println("Hello I'm a static method in TestInterface2");
	}
	
	default void printStuffDefault() {
		System.out.println("Hello I'm a default method in TestInterface2");
	}
}

package interfaces_methods;

public interface TestInterface {
	static void printStuffStatic() {
		System.out.println("Hello! I'm a static method in TestInterface");
	}
	
	default void printStuffDefault() {
		System.out.println("Hello! I'm a default method in TestInterface");
	}
	
	default void otherDefaultMethod() {
		System.out.println("Hi! I'm another default method in TestInterface");
	}
	
}

package ex2.testPackage;

public class A {
	public static void publicHello() {
		System.out.println("Hello everyone from A!");
	}

	protected static void protectedHello() {
		System.out.println("Hello package friends and distant children!");
	}

	static void defautlHello() {
		System.out.println("Hello package friends!");
	}

	@SuppressWarnings("unused")
	private static void privateHello() {
		System.out.println("Hello myself!");
	}
}

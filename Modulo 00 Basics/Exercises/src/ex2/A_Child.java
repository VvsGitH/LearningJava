package ex2;

import ex2.testPackage.A;

public class A_Child extends A {
	public static void test() {
		A.publicHello();
		A.protectedHello();
		// A.defautlHello(); // error
	}
}

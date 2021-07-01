package ex2;

import ex2.testPackage.A;
import ex2.testPackage.B;

public class Ex2_Visibility {

	public static void main(String[] args) {
		System.out.println("-------- CLASS IN THE SAME PACKAGE -------- ");
		B.test();

		System.out.println("-------- SUBCLASS IN A DIFFERENT PACKAGE -------- ");
		A_Child.test();

		System.out.println("-------- CLASS IN A DIFFERENT PACKAGE -------- ");
		A.publicHello();
		// A.protectedHello(); // error
		// A.defautlHello(); // error
		// A.privateHello(); // error
	}

}

package ex7;

class B {
	protected int c;

	void stampa() {
		System.out.println("c: " + c);
	}
}

class D extends B {
	protected int e;

	void stampa() {
		super.stampa();
		System.out.println("e: " + e);
	}
}

public class Ex7_Overriding {
	public static void main(String[] args) {
		B b = new B();
		b.stampa(); // c: 0

		D d = new D();
		d.stampa(); // c: 0, e: 0

		// Late-binding: anche se inserisco l'oggetto D in
		// un oggetto B, a run-time verrà eseguito comunque
		// il metodo sovrascritto.
		B b2 = new D();
		b2.stampa(); // c: 0, e: 0
	}
}
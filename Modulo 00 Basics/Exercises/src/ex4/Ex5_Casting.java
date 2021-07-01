package ex4;

class B {
}

class D extends B {
	int x_d;
}

public class Ex5_Casting {
	static void f(B b) {
		((D) b).x_d = 2000;
		System.out.println(((D) b).x_d);
	}

	public static void main(String[] args) {
		B b = new B();
		D d = new D();

		// Uso semanticamente corretto del casting nella funzione f
		f(d);

		// Uso semanticamente scorretto
		// La funzione f richiede l'attrivuto x_d che non è presente negli
		// oggetti di classe B.
		f(b); // error
	}

}

package ex8;

class B {
	protected int id;

	public B(int i) {
		id = i;
	}

	public boolean get() {
		return id < 0;
	}
}

class D extends B {
	protected char ch;

	public D(int i, char c) {
		super(i);
		ch = c;
	}

	public boolean get() {
		return ch != 'a';
	}
}
public class Ex8_LateBinding {
	public static void main(String[] args) {
		D d = new D(1, 'b');
		B b = d; // polimorfismo d'inclusione
		System.out.println(b.get()); // late-binding: true
		System.out.println(d.get()); // true
	}
}

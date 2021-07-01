package ex13_15_16;

public class Ex15_Clone {

	public static void main(String[] args) {
		Amount a1 = new Amount(10, 20, "€");
		Amount a2 = (Amount) a1.clone();
		
		a1.setAmount(13,22);
		System.out.println(a1);
		System.out.println(a2);
		
		String[] receivers = {"Mike", "Bob", "Jack"};
		Transaction t1 = new Transaction("Vito", receivers, 100, 0, "€");
		
		Transaction t2 = (Transaction) t1.clone();
		t2.setAmount(200, 0);
		t2.changeReceiver("Bob", "Luke");
		
		System.out.println(t1);
		System.out.println(t2);
	}

}

package ex13_15_16;

public class Ex13_Equals {

	public static void main(String[] args) {
		Amount m1 = new Amount(10,20,"€");
		
		Amount m2 = new Amount(10,20,"€");
		System.out.println("M1 == M2 ? " + m1.equals(m2));
		
		Amount m3 = new Amount(10,20,"$");
		System.out.println("M1 == M3 ? " + m1.equals(m3));
		
		Amount m4 = new Amount(15,20,"€");
		System.out.println("M1 == M4 ? " + m1.equals(m4));
		
		Amount m5 = new Amount(15,20,"€");
		System.out.println("M1 == M5 ? " + m1.equals(m5));
		
		Transaction t1 = new Transaction("Vito", new String[] {"Luke", "Bob", "Carl"}, 100, 00, "€");
		Transaction t2 = new Transaction("Vito", new String[] {"Luke", "Bob", "Carl"}, 100, 00, "€");
		System.out.println("T1 == T2 ? " + t1.equals(t2));
	}

}

package interfaces_methods;

public class Main implements TestInterface, TestInterface2 {

	public static void main(String[] args) {
		// Posso usare i metodi statici chiamando direttamente le interfacce
		TestInterface.printStuffStatic();
		TestInterface2.printStuffStatic();
		System.out.println();
		
		Main m = new Main();
		// m.printStuffStatic() // Error: non posso usare metodi statici negli oggetti
		
		// Posso usare i metodi di default delle interfacce
		m.otherDefaultMethod();
		System.out.println();
		
		// Ma, se due interfacce implementano lo stesso metodo di default, devo fare l'override
		m.printStuffDefault();
		System.out.println();
	}
	
	// Le due interfacce implementano lo stesso metodo printStuffDefault.
	// Devo per forza fare override!
	// Posso chiamare il metodo di default usando 'super'.
	// Così facendo posso addirittura combinare le due implementazioni!
	
	@Override
	public void printStuffDefault() {
		System.out.print("TestInterface implementation:  ");
		TestInterface.super.printStuffDefault();
		System.out.print("TestInterface2 implementation:  ");
		TestInterface2.super.printStuffDefault();
	}
}

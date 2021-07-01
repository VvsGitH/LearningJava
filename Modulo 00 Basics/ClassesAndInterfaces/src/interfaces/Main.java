package interfaces;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Person p = new Person("Vito", "Developer");
		Scanner sc = new Scanner(System.in);

		p.sayHello();
		p.saySomethingAboutYou();

		p.askName(sc);
		p.askInformation(sc);
		sc.close();

		p.walkFw();
		p.turn(true);

		p.stop();

	}

}

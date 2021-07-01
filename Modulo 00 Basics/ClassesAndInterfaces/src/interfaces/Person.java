package interfaces;

import java.util.Scanner;

/* This class implements PresentationInterface and WalkingInterface
 * In general, a class can extend only one parent, but can implement a number of interfaces.
 * As a matter of fact, interfaces do not cause the diamond problem: if two interfaces share a 
 * method of the same name, that method will be only implemented once. */

public class Person
    implements PresentationInterface, WalkingInterface {
    
    // Class Attributes
    public String fullName;
    public String job;

    // Class Methods
    public Person(String fullName, String job) {
        this.fullName = fullName;
        this.job = job;
    }

    // Presentation Interface Implementations
    @Override
    public void sayHello() {
        System.out.println(STANDARD_GREATING + fullName + "!");
    } 

    @Override
	public void askName(Scanner sc) {
        System.out.println("What's your name?");

		String name = null;
		if (sc.hasNextLine())
			name = sc.nextLine();
		System.out.println("Hi " + name);
    }

    @Override
    public void saySomethingAboutYou() {
        System.out.println("I'm an " + job);
    }

    @Override
	public void askInformation(Scanner sc) {
        System.out.println("What's your job?");

		String job = null;
		if (sc.hasNextLine())
			job = sc.nextLine();
		System.out.println("So you are a " + job);
    }

    // Walking Interface Implementations
    @Override
    public void walkFw() {
        System.out.println("I'm walking");
    }

    @Override
    public void turn(boolean leftRight) {
        if (leftRight == true)
            System.out.println("Turn right");
        else
            System.out.println("Turn left");
    }

	// Common method between the two interfaces
    @Override
    public void stop() {
        System.out.println("I stopped walking");
    }

}
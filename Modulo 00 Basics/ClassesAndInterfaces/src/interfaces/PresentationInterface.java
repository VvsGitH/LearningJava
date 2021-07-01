package interfaces;

import java.util.Scanner;

public interface PresentationInterface {

	// Interface attributes, must be all final and static
	// They are only used to define general constants
	public final static String STANDARD_GREATING = "Hello cool people, I'm ";
	public final static String STANDARD_GOODBYE = "Bye!";

	// Interface methods, must be all implemented in the classes
	public void sayHello();

	public void askName(Scanner sc);

	public void saySomethingAboutYou();

	public void askInformation(Scanner sc);

	public void stop(); // This method is also present in WalkingInterface

}

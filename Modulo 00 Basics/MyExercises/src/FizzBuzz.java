import java.util.InputMismatchException;
import java.util.Scanner;

public class FizzBuzz {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        while(true) {

            System.out.print("Enter a number (0 to exit): ");

			try {
				int n = in.nextInt();

				if (n == 0)
					break;

				if (n % 3 == 0)
					System.out.print("Fizz");

				if (n % 5 == 0)
					System.out.print("Buzz");

				if (n % 3 != 0 && n % 5 != 0)
					System.out.print(n);

				System.out.println();

			} catch (InputMismatchException e) {
				System.out.println("Enter a number!");

				// Empty the scanner before the next iteration
				in.next();
			}
        }

        in.close();
    }
}
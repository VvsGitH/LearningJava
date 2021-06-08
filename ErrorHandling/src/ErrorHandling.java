
public class ErrorHandling {

	/*
	 * The error handling is done with the try..catch keywords. Catch receives the
	 * error object or one of its children.
	 * 
	 * When you define a function that could throw an exception you have two
	 * options:
	 * 
	 * 1. Manage the try..catch logic inside the function.
	 * 
	 * 2. Manage the error logic outside the function. In this case, even if it's
	 * not required, it's a common practice to add the THROWS keyword in the
	 * function signature, to make it clear to others developers that they must
	 * implement the error logic.
	 * 
	 * Finally, you could explicitly throw an error inside a function with the THROW
	 * keyword. This is used in those cases where the code is syntactically correct,
	 * but the logic of your application required that specific situation to be an
	 * error.
	 */

	public static float divide(int num, int den) throws ArithmeticException {
		return num / den;
	}

	public static float divide(float num, float den) throws ArithmeticException {
		// A float division by 0 will return 'Infinite'
		// I want that to be an error instead.
		if (den == 0)
			throw new ArithmeticException("You can't divide by 0!");
		return num / den;
	}

	public static void main(String[] args) {
		int a = 3;
		int b = 0;

		try {
			System.out.println(a / b);
		} catch (Exception e) {
			if (e instanceof ArithmeticException)
				System.out.println("You can't divide by 0!");
			else
				System.out.println(e);
		}

		try {
			float res = divide(3.5F, 0);
			System.out.println(res);
		} catch (ArithmeticException e) {
			System.out.println(e);
		}

	}

}

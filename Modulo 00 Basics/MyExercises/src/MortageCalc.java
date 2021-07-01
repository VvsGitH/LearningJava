import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

public class MortageCalc {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        NumberFormat nf = NumberFormat.getNumberInstance(Locale.FRANCE); // Accept number with both dot and comma

        float principal = 0;
        float annualRate = 0;
        byte years = 0;

        System.out.println("This app will calculate the monthly mortage of a loan!\n");

        while(true) {
            try {
				System.out.print("Enter the Principal: € ");
                /* The scanner reads a String
                 * The nf parse the String into a Number, accepting both dot and comma
                 * Finally the number is converted to a float */
                principal = nf.parse(sc.next()).floatValue();

                System.out.print("Enter the Annual Interest Rate %: ");
                annualRate = nf.parse(sc.next()).floatValue();

                System.out.print("Enter the Period (Years): ");
                years = nf.parse(sc.next()).byteValue();

                sc.close(); // closing input scanner
                break; // exit the loop

            } catch (ParseException e) {
                System.out.println("Please enter a number!\n");
            }
        }

        // Calculating monthly interest rate from percentual annual rate
        float monthlyRate = annualRate / 100 / 12;

        // Calculating monthly mortage
        float num = principal * monthlyRate;
		float den = 1 - (float) Math.pow(1 + monthlyRate, -years);
        float mortage = num/den;

        // Returning the mortage value
		System.out.println("------------------------\nThe monthly mortage is: "
				+ NumberFormat.getCurrencyInstance().format(mortage) + "\n");
    }

}
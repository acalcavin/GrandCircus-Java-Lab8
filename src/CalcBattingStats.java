
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Scanner;

/*
 * @author Andrew Calabro-Cavin
 * Program to calculate batting ave and slugging percentage
 * using arrays
 */

public class CalcBattingStats {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String cont = "y";

		System.out.println("Welcome to Batting Average Calculator!");

		while (cont.equalsIgnoreCase("y")) { // as long as cont is y or Y, will exec. at least once
			// your code should start here. For example:

			System.out.println("Enter number of times at bat: ");
			int atBat = scan.nextInt();
			int[] batter = new int[atBat]; // declare an array within while loop, to reset for each batter

			System.out.println("0=out, 1=single, 2=double, 3=triple, 4=home run");

			int i = 0;
			for (i = 0; i < batter.length; i++) { // populate array with user input
				System.out.println("Result for at-bat " + i + ":");

				batter[i] = scan.nextInt();
			}
			// System.out.println(Arrays.toString(batter)); // test

			// calculate hits, where index of batter > 0
			int hits = 0;
			for (int j = 0; j < batter.length; j++) {
				if (batter[j] > 0) {
					hits++;
				}
			}
			// System.out.println(hits);

			// calculate batting average, total num of at-bats where player got on base, div
			// by at-bats
			float battingAve = (float) hits / atBat;
			// System.out.println(battingAve);
			BigDecimal bigDbatAve = new BigDecimal(battingAve).setScale(3, RoundingMode.HALF_UP);
			System.out.println("\nBatting average: " + bigDbatAve);

			// calculate total number of bases earned
			int sum = 0;
			for (int k = 0; k < batter.length; k++) {
				sum += batter[k]; 

			}
			float slugPercentage = (float)sum / atBat;
			BigDecimal bigDslugPerc = new BigDecimal(slugPercentage).setScale(3, RoundingMode.HALF_UP);
			System.out.println("Slugging percentage: " + bigDslugPerc);

			scan.nextLine();
			// This is where your code should end.
			System.out.println("\nAnother batter? (y/n)");
			cont = scan.nextLine();

		} // end of while

		// let the user know the program has closed
		System.out.println("Goodbye!");

		scan.close();
	}

}

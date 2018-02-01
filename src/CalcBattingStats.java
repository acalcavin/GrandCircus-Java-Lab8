
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

		while (cont.equalsIgnoreCase("y")) { // as long as cont is y or Y, will continue

			int atBat = ValidatorForStats.getInt(scan, "Enter number of times at bat: "); // use method to validate
																							// input
			// System.out.println("You entered " + atBat); // TEST CODE

			// int atBat = scan.nextInt();
			int[] batter = new int[atBat]; // declare an array within while loop, to reset for each batter

			System.out.println("0=out, 1=single, 2=double, 3=triple, 4=home run");

			int i = 0;
			for (i = 0; i < batter.length; i++) { // populate array with user input
				System.out.println("Result for at-bat " + i + ":");
				int temp = scan.nextInt();
				while ((temp < 0) || (temp > 4)) {
					System.out.println("Please enter an number 0-4.");
					temp = scan.nextInt();
				}
				batter[i] = temp;
			}
			// FIXME: add a method using ValidatorForStats that will validate input between 0-4
			// and populate the array.
			// pass in scan, array, range, return an array? 
			// ValidatorForStats.getIntInRange(scan, batter, 0, 4);

			// calculate hits, where index of batter > 0; calculate sum of bases earned
			int hits = 0;
			int sum = 0;

			for (int j = 0; j < batter.length; j++) {
				if (batter[j] > 0) {
					hits++;
				}
				sum += batter[j];
			}

			// calculate batting average: total num of at-bats where player got on base
			// divide by at-bats
			float battingAve = (float) hits / atBat;
			BigDecimal bigDbatAve = new BigDecimal(battingAve).setScale(3, RoundingMode.HALF_UP);
			System.out.println("\nBatting average: " + bigDbatAve);

			// calculate slugging percentage: total number of bases earned
			// divided by number of at-bats

			float slugPercentage = (float) sum / atBat;
			BigDecimal bigDslugPerc = new BigDecimal(slugPercentage).setScale(3, RoundingMode.HALF_UP);
			System.out.println("Slugging percentage: " + bigDslugPerc);

			scan.nextLine();
			System.out.println("\nAnother batter? (y/n)");
			cont = scan.nextLine();

		} // end of while

		System.out.println("Goodbye!");

		scan.close();
	}

}

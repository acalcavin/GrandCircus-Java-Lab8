import java.util.Scanner;

public class ValidatorForStats {

	public static int getInt(Scanner sc, String prompt) {
		int i = 0;
		boolean isValid = false;
		while (isValid == false) {
			System.out.print(prompt);

			if (sc.hasNextInt()) {
				i = sc.nextInt();
				if (i >= 0) {
					isValid = true;
				} else {
					System.out.println("Please enter a positive integer.");
				}
			} else {
				System.out.println("Not a valid integer. Try again.");
			}

			sc.nextLine(); // discard any other data entered on the line
		}
		return i;
	}

	public static void getIntInRange(Scanner sc, int[] array, int min, int max) {
		int i = 0;
		boolean isValid = false;
		while (isValid == false) {

			for (i = 0; i < array.length; i++) { // populate array with user input
				System.out.println("Result for at-bat " + i + ":");
				if (sc.hasNextInt()) {
					array[i] = sc.nextInt();
					isValid = true;
					if ((i < min) || (i > max)) {
						System.out.println("Please enter a num from 0 to 4.");
					}
				} else {
					System.out.println("Not a valid integer. Try again.");
				}
			}
				sc.nextLine(); // discard any other data entered on the line
			}
		return;
	}



	
}
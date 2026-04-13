package user_input;

import java.util.Scanner;

public class InputExample {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		try {
			// byte input
			System.out.print("Enter a byte value (-128 to 127): ");
			byte byteVal = sc.nextByte();

			// short input
			System.out.print("Enter a short value (-32768 to 32767): ");
			short shortVal = sc.nextShort();

			// int input
			System.out.print("Enter an int value: ");
			int intVal = sc.nextInt();

			// long input
			System.out.print("Enter a long value: ");
			long longVal = sc.nextLong();

			// float input
			System.out.print("Enter a float value: ");
			float floatVal = sc.nextFloat();

			// double input
			System.out.print("Enter a double value: ");
			double doubleVal = sc.nextDouble();

			// char input
			System.out.print("Enter a single character: ");
			char charVal = sc.next().charAt(0);

			// boolean input
			System.out.print("Enter a boolean value (true/false): ");
			boolean boolVal = sc.nextBoolean();

			// String input (single word)
			System.out.print("Enter a single word string: ");
			String singleWord = sc.next();

			// String input (full line)
			sc.nextLine(); // consume leftover newline
			System.out.print("Enter a full sentence: ");
			String fullLine = sc.nextLine();

			// Display all values
			System.out.println("\n--- You Entered ---");
			System.out.println("byte: " + byteVal);
			System.out.println("short: " + shortVal);
			System.out.println("int: " + intVal);
			System.out.println("long: " + longVal);
			System.out.println("float: " + floatVal);
			System.out.println("double: " + doubleVal);
			System.out.println("char: " + charVal);
			System.out.println("boolean: " + boolVal);
			System.out.println("String (word): " + singleWord);
			System.out.println("String (line): " + fullLine);

		} catch (Exception e) {
			System.out.println("Invalid input type! Please enter values in the correct format.");
		} finally {
			sc.close();
		}

	}
}

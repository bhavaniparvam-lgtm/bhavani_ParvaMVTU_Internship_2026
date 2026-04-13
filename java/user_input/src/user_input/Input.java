package user_input;

import java.util.Scanner;

public class Input{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter byte: ");
		byte b = sc.nextByte();
		System.out.print("Enter short: ");
		short s = sc.nextShort();
		System.out.print("Enter int: ");
		int i = sc.nextInt();
		System.out.print("Enter long: ");
		long l = sc.nextLong();
		System.out.print("Enter float: ");
		float f = sc.nextFloat();
		System.out.print("Enter double: ");
		double d = sc.nextDouble();
		System.out.print("Enter boolean: ");
		boolean bool = sc.nextBoolean();
		System.out.print("Enter char: ");
		char c = sc.next().charAt(0);
		sc.nextLine(); // Consume newline
		System.out.print("Enter String: ");
		String str = sc.nextLine();

		System.out.println("Byte: " + b + ", Short: " + s + ", Int: " + i);
		System.out.println("Long: " + l + ", Float: " + f + ", Double: " + d);
		System.out.println("Boolean: " + bool + ", Char: " + c + ", String: " + str);

		sc.close();
	}
}

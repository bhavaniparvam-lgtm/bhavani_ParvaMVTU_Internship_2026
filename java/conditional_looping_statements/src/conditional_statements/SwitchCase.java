package conditional_statements;

import java.util.*;

public class SwitchCase {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter day no:");
		int value = sc.nextInt();
		String typeOfDay = switch (value) {
		case 1, 2, 3, 4, 5, 6 -> "Weekday";
		case 7 -> "Weekend";
		default -> "Invalid";

		};
		System.out.println("Res:" + typeOfDay);
		sc.close();
	}

}

package non_primitive;

import java.util.*;
import java.util.Arrays;

public class UserInput2 {
	public static void main(String[] args) {
		// array
		// scanner
		Scanner sc = new Scanner(System.in);
		int marks[] = new int[3];// [1,2,3,4,5]

		System.out.println("Enter values: ");
		marks[0] = sc.nextInt();
		marks[1] = sc.nextInt();
		marks[2] = sc.nextInt();
		System.out.println("Array:" + Arrays.toString(marks));
		sc.close();
	}
}

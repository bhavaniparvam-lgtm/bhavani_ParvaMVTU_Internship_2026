package looping_statements;

import java.util.Scanner;

public class DoWhile {
	public static void main(String[] args) {
		/**/
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number:");
		int count = sc.nextInt();
		int i=1;
		do {
			System.out.println("Value:"+i);
			i++;
		}
		while(i<=count);
	}
}

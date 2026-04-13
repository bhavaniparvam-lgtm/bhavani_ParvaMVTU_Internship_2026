package looping_statements;

import java.util.Scanner;

public class WhileLoop {
	public static void main(String[] args) {
		/*
		 * whilw loop:
		 * ===========
		 * ini;
		 * while(con){
		 *  //code
		 *  inc/dec
		 *  }
		 *  if you don't know the no. of iteration and condition check happens before*/
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number:");
		int count = sc.nextInt();
		int i = 1;
		while(i<=count) {
			System.out.println("Value:"+i);
			i++;
			sc.close();
		}
	}
}

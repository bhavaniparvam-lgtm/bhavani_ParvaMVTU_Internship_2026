package com.exception_handling;

import java.util.Scanner;

public class ExceptionHandling6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		try {
			String str = null;
			System.out.println("result1: "+str.toString());
			int res = num1/num2;
			System.out.println("result: "+res);
		
		}
//			catch (ArithmeticException e) {
//			// TODO: handle exception
//			System.out.println("Exception: "+e.getMessage());
//			
//		}
			catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception: "+e.getMessage());
		}finally {
			sc.close();
		}
	}
}

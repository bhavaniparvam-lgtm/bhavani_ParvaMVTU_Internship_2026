package com.exception_handling;

public class ExceptionHandling4 {
	public static void main(String[] args) {
		System.out.println("statrt of program");
		try {
			System.out.println("res: "+(10/3));
		} finally {
			System.out.println("This is a finally block");
			
		}
		System.out.println("End of program");
		
		System.out.println("statrt of program");
		try {
			System.out.println("res: "+(10/0));
		}catch (ArithmeticException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		finally {
			System.out.println("This is a finally block");
			
		}
		System.out.println("End of program");
	}
}

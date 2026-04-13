package com.exception_handling;

public class ExceptionHandling1 {
	public static void main(String[] args) {
//		while(true) {
//			System.out.println("Hello");
//		}
		fun();
	}
	//recursion
	private static void fun() {
		System.out.println("Hello");
		fun();
	}
}

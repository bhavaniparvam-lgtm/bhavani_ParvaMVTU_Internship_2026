package com.exception_handling;

import java.io.PrintWriter;

public class ExceptionHandling5 {
	public static void main(String[] args) {
		PrintWriter pw = null;
		try {
			System.out.println("opening file");
			pw = new PrintWriter("world.txt");
			pw.write("Hello World");
			System.out.println("Completed1");
			
		} finally {
			System.out.println("closing file");
			if(pw != null) {
				pw.close();
			}
		}
		System.out.println("After finally");
		 
	}
}

package com.exception_handling;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ExceptionHandling2 {
	public static void main(String[] args) throws FileNotFoundException {
		//1st way
		try {
			PrintWriter pw = new PrintWriter("hello.txt");
			pw.write("Hello World");
			System.out.println("Completed");
			pw.close();
		}catch(FileNotFoundException e) {
			//3ways
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println(e);
		}
		//2nd way
		PrintWriter pw = new PrintWriter("world.txt");
		pw.write("Hello World");
		System.out.println("Completed1");
		pw.close();
	}
}

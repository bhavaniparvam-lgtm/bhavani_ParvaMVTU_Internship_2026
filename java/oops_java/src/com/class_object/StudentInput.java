package com.class_object;
import java.util.*;
public class StudentInput {
	String st_n,st_sec;
	int st_cl,st_rn;
	public String isStudent() {
		return "is a student";
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Student std = new Student();{
			System.out.println("Enter the student name: ");
			std.st_n=sc.nextLine();
			System.out.println("Enter the student roll number: ");
			std.st_rn=sc.nextInt();
			System.out.println("Enter the student class from 1 to 10: ");
			std.st_cl=sc.nextInt();
			System.out.println("Enter the student section from 'A' to 'C' ");
			sc.nextLine();
			std.st_sec=sc.nextLine();
			
			String res = std.isStudent();
			
			
			System.out.println("Name: "+std.st_n);
			System.out.println("Roll no. : "+std.st_rn);
			System.out.println("Class: "+std.st_cl);
			System.out.println("Section : "+std.st_sec);
			System.out.println(res);
		}
		
	}
}

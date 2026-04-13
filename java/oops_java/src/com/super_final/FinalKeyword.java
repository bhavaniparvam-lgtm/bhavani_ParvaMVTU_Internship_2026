package com.super_final;


class Person{
	public final void display() {
		System.out.println("Parent class display");
	}
}

class Student extends Person{

//	@Override
//	public void display() {
//		// TODO Auto-generated method stub
//		System.out.println("Child class display");
//	}
	
}
public class FinalKeyword {
	public static void main(String[] args) {
		/*
		 * final keyword:
		 * ===============
		 * 1.variables
		 * 2.methods
		 * 3.classes*/
		final int age;
		age=30;
		System.out.println("Age: "+age);
//		age = 40;
//		System.out.println("Age: "+age);
		
		Student s = new Student();
		s.display();
	}
}

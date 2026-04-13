package com.abstraction;

abstract class Person{
	public abstract void isWalking();
	public void isSleeping() {
		System.out.println("Person is sleeping");
	}
}

class Student extends Person{

	@Override
	public void isWalking() {
		// TODO Auto-generated method stub
		System.out.println("Student is sleeping");
		
	}
	//right-click --> source --> override
	
}
public class Abstraction1 {
	public static void main(String[] args) {
		Student s1 = new Student();
		s1.isSleeping();
		s1.isWalking();
	}
}

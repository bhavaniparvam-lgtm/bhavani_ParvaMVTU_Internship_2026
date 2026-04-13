package com.inheritance;

class Grandparent{
	int age = 27;
	public void grandParent() {
		System.out.println("Grandparent class method");
	}
}

class Parent1 extends Grandparent{
	
}

class Child1 extends Parent1{
	
}

public class Inheritance2 {
	public static void main(String[] args) {
		Child1 c1 = new Child1();
		System.out.println(c1.age);
		c1.grandParent();
		
	}
}

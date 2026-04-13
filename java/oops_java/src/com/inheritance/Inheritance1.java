package com.inheritance;

class Parent{
	int age=40;
	public void parent(){
		System.out.println("This is parent class method");
	}
}

class Child extends Parent{
	public void child() {
		System.out.println("This is child class method");
	}
}
public class Inheritance1 {
	public static void main(String[] args) {
		/*
		 * Inheritance(extends):
		 * ======================
		 * extending the properties of parent class to the child class
		 * parent class is also known as the base/super class
		 * properties:
		 * ===========
		 * state and actions
		 * 
		 * types of inheritance:
		 * =====================
		 * 1.single 
		 * 2.multi-level - child -- parent --- grandparent
		 * 3.hybrid
		 * 4.multiple - using interface we can achieve 
		 * 5.Hierarchical*/
		
		
		Child c1 = new Child();
		System.out.println("age: "+c1.age);
		c1.parent();
		c1.child();
	}
}

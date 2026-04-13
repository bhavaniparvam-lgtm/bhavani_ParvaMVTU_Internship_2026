package com.constructor;

class Person1{
	String name;
	int age;
	String email;
	
	Person1(){
		System.out.println("Person1 Constructor");
	}
	
	Person1 (String name, int age){
		System.out.println("Person1 only 2 args Constructor");
		this.name = name;
		this.age = age;
	}
	
	Person1(String name, int age, String email){
		System.out.println("Person1 args Constructor");
		this.name = name;
		this.age = age;
		this.email = email;
	}
	
	public void display() {
		System.out.println("Name: "+this.name);
		System.out.println("Age: "+this.age);
		System.out.println("Email: "+this.email);
	}
}
public class ArgsConstructor {
	public static void main(String[] args) {
		Person1 p1 = new Person1();
		p1.display();
		Person1 p2 = new Person1("Callahan Kane",26,"cal@gmail.com");
		p2.display();
		Person1 p3 = new Person1("Declan",29);
		p3.display();
		
	}
}

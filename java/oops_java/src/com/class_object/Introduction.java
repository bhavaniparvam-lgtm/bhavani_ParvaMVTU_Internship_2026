package com.class_object;


class Car{
	//properties
	String name = "Defender";
	long price= 1000000000;
	
	//behaviour
	public void canDrive() {
		System.out.println("yes");
	}
}
public class Introduction {
	public static void main(String[] args) {
	/*
	 * OOPS : object oriented programming system
	 * not 100% object 
	 * topics:
	 * =========
	 * 1. Class and Object
	 * 2. Inheritance
	 * 3. Polymorphism
	 * 4. Encapsulation
	 * 5. Abstraction
	 * 6. Interface
	 * 
	 * 1. Class:
	 * =========
	 * it will represent the state and behaviour of an object.
	 * state : properties of an object(instance variables)
	 * behaviour : actions of an object (functionds or methods)
	 * syntax:
	 * =======
	 * 
	 * access_modifier class_name{
	 * 		//properties
	 * 
	 * 		//behaviour
	 * }
	 * 
	 * public Car {
	 * 	String carName;
	 * 	long price;
	 * 
	 * 	public void canDrive(){
	 * 	syso("yes");
	 * 	}
	 * }
	 * 
	 * 
	 * Object:
	 * ==========
	 * object is the implementation of the class
	 * class will not take a memory, whereas object will take a memory
	 * to create an object in java we use "new"
	 * syntax : to create an object
	 * new class_name();
	 * class_name obj_name = new class_name();
	 * we can create n no. of objects
	 * 
	 * ex:
	 * ===
	 * Student ---> Callahan, Declan, Rowan.
	 * Employee ---> Alana, Iris, Zahra*/
		Car c = new Car();
		System.out.println("Name: "+c.name);
		System.out.println("Price: "+c.price);
		c.canDrive();
	}
}

package com.constructor_reference;

import java.util.function.Supplier;

class Person{
	String name;
	
	public Person() {
		super();
	}
	public Person(String name) {
		super();
		this.name=name;
	}
}
public class ConstructorReference {
	public static void main(String[] args) {
		//without
		Supplier<Person> sup = ()->new Person();
		Person person=sup.get();
		person.name="Murthy";
		System.out.println(person.name);
		//with
		Supplier<Person> sup1 = Person::new;
		Person person1=sup1.get();
		person1.name="Callahan";
		System.out.println(person1.name);
	}
}

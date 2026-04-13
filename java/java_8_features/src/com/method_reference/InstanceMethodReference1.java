package com.method_reference;

import java.util.function.Supplier;

public class InstanceMethodReference1 {
	public String getMessage() {
		return "Instance Methodd";
	}
	public static void main(String[] args) {
		InstanceMethodReference1 obj1 = new InstanceMethodReference1();
		//without
		Supplier<String> sup = ()->obj1.getMessage();
		System.out.println("Rres: "+sup.get());
		//with
		Supplier<String> sup1 = obj1::getMessage;
		System.out.println("Rres1: "+sup1.get());
		
	}
}

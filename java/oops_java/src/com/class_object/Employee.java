package com.class_object;

public class Employee {
	String emp_name;
	int emp_id;
	String emp_email;
	
	public String isWorking() {
		return "Yes he is working";
	}
	public static void main(String[] args) {
		Employee emp = new Employee();
		emp.emp_name = "Callahan";
		emp.emp_id = 121;
		emp.emp_email = "cal@gmail.com";
		String res= emp.isWorking();
		System.out.println(emp.emp_name);
		System.out.println(emp.emp_id);
		System.out.println(emp.emp_email);
		System.out.println(res);
		
		System.out.println();
		Employee emp1 = new Employee();
		emp1.emp_name = "Declan";
		emp1.emp_id = 122;
		emp1.emp_email = "declan@gmail.com";
		String res1= emp.isWorking();
		System.out.println(emp1.emp_name);
		System.out.println(emp1.emp_id);
		System.out.println(emp1.emp_email);
		System.out.println(res1);
	}
}

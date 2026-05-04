package com.paginationsorting.model;

import jakarta.persistence.*;



@Entity
@Table(name = "employees")
public class Employee {
/** Primary key — auto-incremented by the DB. */
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
/** Employee full name. */
@Column(nullable = false)
private String name;
/** Unique corporate e-mail address. */
@Column(nullable = false, unique = true)
private String email;
/** Annual salary in USD. */
@Column(nullable = false)
private Double salary;
/** Department the employee belongs to. */
@Column(nullable = false)
private String department;
public Employee(Long id, String name, String email, Double salary, String department) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.salary = salary;
	this.department = department;
}
public Employee() {
	super();
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Double getSalary() {
	return salary;
}
public void setSalary(Double salary) {
	this.salary = salary;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}

}
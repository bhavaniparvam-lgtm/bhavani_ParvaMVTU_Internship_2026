package com.thymleafcrud1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "students")
@Data                    // Lombok: generates getters, setters, toString
@NoArgsConstructor       // Lombok: generates no-arg constructor
@AllArgsConstructor //to avoid all arg constructor
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long  id;
	
	@NotBlank(message = "Name is required")
    @Column(nullable = false)
	private String name;
	
	@NotBlank(message = "Email is required")
    @Email(message = "Enter a valid email")
    @Column(nullable = false, unique = true)
	private String email;
	
	 @Min(value = 1, message = "Age must be positive")
	 @Max(value = 150, message = "Age not realistic")
	 private Integer age;
	 @NotBlank(message = "Course is required")
	 private String course;
	 public Object getName() {
		// TODO Auto-generated method stub
		return null;
	 }
	 public void setName(Object name2) {
		// TODO Auto-generated method stub
		
	 }
	 public Object getEmail() {
		// TODO Auto-generated method stub
		return null;
	 }
	 public void setEmail(Object email2) {
		// TODO Auto-generated method stub
		
	 }
	 public Object getAge() {
		// TODO Auto-generated method stub
		return null;
	 }
	 public void setAge(Object age2) {
		// TODO Auto-generated method stub
		
	 }
	 public Object getCourse() {
		// TODO Auto-generated method stub
		return null;
	 }
	 public void setCourse(Object course2) {
		// TODO Auto-generated method stub
		
	 }

}
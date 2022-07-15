package com.greatlearning.gradedproject6.erp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employeeId")
	private int employeeId;

	@Column(name = "firstName", columnDefinition = "varchar(50)")
	private String firstName;

	@Column(name = "lastName", columnDefinition = "varchar(50)")
	private String lastName;

	@Column(name = "email", columnDefinition = "varchar(100)")
	private String email;

	public Employee(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
}

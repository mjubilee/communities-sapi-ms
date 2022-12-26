package com.mjubilee.communitiessapims.model;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Person {
	@Id
	@GeneratedValue
	private Long id;
	private String firstName;
	private String lastName;
	private LocalDate dob;
	private String email;
	
	public Person() {
	}

	public Person(Long id, String firstName, String lastName, LocalDate dob, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", email="
				+ email + "]";
	}
			
}

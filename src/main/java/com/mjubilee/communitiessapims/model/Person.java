package com.mjubilee.communitiessapims.model;

import java.time.LocalDate;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
public class Person {
	
	@Id
	@GeneratedValue
	@Column(nullable=false, updatable=false)
	private Long id;
	
	@Size(min=3, message="First name must be minimum 3 characters.")
	private String firstName;

	@Size(min=3, message="Last name must be minimum 3 characters.")
	private String lastName;
	
	@Past(message="Date of birth can not be today or in the future")
	private LocalDate dob;
	private String email;
	
	@ManyToMany(mappedBy = "personList")
	List<Category> categoryList;
	
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

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}
		
}

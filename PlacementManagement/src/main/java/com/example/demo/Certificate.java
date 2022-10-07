package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Certificate 
{
	@Id
	private long id;
	private Integer year;
	
	//Super class method
	public Certificate() {
		super();
		// TODO Auto-generated constructor stub
	}

	//parameterized constructor
	public Certificate(long id, Integer year) {
		super();
		this.id = id;
		this.year = year;
	}

	
	//Getters and Setters Method
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	//to String Method
	@Override
	public String toString() {
		return "Certificate [id=" + id + ", year=" + year + "]";
	}
	
	
	

}
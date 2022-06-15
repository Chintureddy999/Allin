package com.zensar.bean;

import java.time.LocalDate;
public class Employee {
	private int empId;
	private String name;
	private LocalDate dateOfJoin;
	private double basics;
	private char grade;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDateOfJoin() {
		return dateOfJoin;
	}
	public void setDateOfJoin(LocalDate dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}
	public double getBasics() {
		return basics;
	}
	public void setBasics(double basics) {
		this.basics = basics;
	}
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", dateOfJoin=" + dateOfJoin + ", basics=" + basics
				+ ", grade=" + grade + "]";
	}
	
	
	
	

}

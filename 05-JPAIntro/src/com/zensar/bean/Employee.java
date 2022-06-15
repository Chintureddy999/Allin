package com.zensar.bean;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employees")
public class Employee {
	@Id
	@Column(name="e_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;
	@Column(name="e_name")
	private String name;
	@Column(name="e_dOJ")
	private LocalDate dateOfJoin;
	@Column(name="e_basics")
	private double basics;
	@Column(name="e_grade")
	private char grade;
	
	
	
	public Employee(int empId, String name, LocalDate dateOfJoin, double basics, char grade) {
		super();
		this.empId = empId;
		this.name = name;
		this.dateOfJoin = dateOfJoin;
		this.basics = basics;
		this.grade = grade;
	}
	public Employee() {
		// TODO Auto-generated constructor stub
	}
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
	public void setSalary(int i) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}


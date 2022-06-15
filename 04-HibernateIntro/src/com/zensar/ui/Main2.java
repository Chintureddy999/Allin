package com.zensar.ui;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.zensar.bean.Employee;

import com.zensar.util.HibernateUtil;

public class Main2 {
	static void insert() {
		Employee employee=new Employee();
		employee.setName("vignesh");
		employee.setBasics(55000.0);
		employee.setDateOfJoin(LocalDate.of(2013,12,10));
		employee.setGrade('C');
		
		HibernateUtil.init();
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		session.save(employee);
		tx.commit();
		HibernateUtil.cleanUp();
		
	}
	static void load() {
		Employee employee=null;
		Session session=null;
		HibernateUtil.init();
		session=HibernateUtil.getSession();
		
		employee=session.load(Employee.class,2);
		
		System.out.println(employee);
		
		HibernateUtil.cleanUp();
	}
	static void loadAll() {
		HibernateUtil.init();
		Session session=HibernateUtil.getSession();
		
		String qry="from Employee";
		Query query=session.createQuery(qry);
		List<Employee>allEmployees=query.list();
		System.out.println(allEmployees);
		
		HibernateUtil.cleanUp();
		
	}
	
	static void editing() {
		HibernateUtil.init();
		Session session=HibernateUtil.getSession();
		Employee employee=session.load(Employee.class,1);
		employee.setBasics(80000);
		
		Transaction tx=session.beginTransaction();
		session.update(employee);
		tx.commit();
		HibernateUtil.cleanUp();
	}
	static void deleting() {
		HibernateUtil.init();
		Session session=HibernateUtil.getSession();
		Employee employee=session.load(Employee.class,2);
		Transaction tx=session.beginTransaction();
		session.delete(employee);
		tx.commit();
		HibernateUtil.cleanUp();
		
	}
	

	public static void main(String[] args) {
		deleting();
		

	}

}

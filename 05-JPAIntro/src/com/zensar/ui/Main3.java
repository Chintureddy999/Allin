package com.zensar.ui;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.zensar.bean.Address;
import com.zensar.bean.Student;
import com.zensar.util.JPAUtil;

public class Main3 {
	static void insert() {
		Student student=new Student();
		Address address =new Address("A-1","Peenya","Bangalore");
		student.setName("chintu");
		student.setRollNumber(1099);
		student.setAddress(address);
		EntityManager em=JPAUtil.createEntityManager("JPAIntro");
		
		em.getTransaction().begin();
		em.merge(student);
		em.getTransaction().commit();
		
		JPAUtil.shutDown();
		
	}
	static void load() {
		EntityManager em=JPAUtil.createEntityManager("JPAIntro");
		Student student=em.find(Student.class,1099);
		System.out.println(student);
		JPAUtil.shutDown();
	}
	static void loadAll() {
		EntityManager em=JPAUtil.createEntityManager("JPAIntro");
		String qry="from Student";
		Query query=em.createQuery(qry);
		List<Student> allStudents=query.getResultList();
		System.out.println(allStudents);
		JPAUtil.shutDown();
	}
	static void editing() {
		EntityManager em=JPAUtil.createEntityManager("JPAIntro");
		Student student=em.find(Student.class,1099);
		student.setName(student.getName().toUpperCase());
		student.getAddress().setCityName("Hyderabad");
		
		em.getTransaction().begin();
		em.merge(student);
		em.getTransaction().commit();
		
		JPAUtil.shutDown();
		
	}
	static void deleting() {
		EntityManager em=JPAUtil.createEntityManager("JPAIntro");
		Student student=em.find(Student.class,1099);
		
		em.getTransaction().begin();
		em.remove(student);
		em.getTransaction().commit();
		
		JPAUtil.shutDown();
	}
		
		
	
	public static void main(String[] args) {
		deleting();
	}

}

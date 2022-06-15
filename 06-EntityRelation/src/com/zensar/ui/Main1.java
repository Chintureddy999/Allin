package com.zensar.ui;

import java.time.LocalDate;

import javax.persistence.EntityManager;


import com.zensar.bean.pack1.ContactInfo;
import com.zensar.bean.pack1.Person;
import com.zensar.util.JPAUtil;

public class Main1 {
	
	static void test1() {
		Person person = new Person("chintu",LocalDate.of(1990,1,1),'M');
		person.setPersonId(1099);
		ContactInfo contactInfo = new ContactInfo("chintu@gmail.com","1234567890");
		person.setContactInfo(contactInfo);
		contactInfo.setPerson(person);
		
		EntityManager em=JPAUtil.createEntityManager("JPAIntro");
		
		em.getTransaction().begin();
		em.persist(person);
		em.getTransaction().commit();
		
		JPAUtil.shutDown();
		
	}
	static void test2() {
		EntityManager em=JPAUtil.createEntityManager("JPAIntro");
		
		
		Person person =em.find(Person.class,1099);
		System.out.println(person);
		
		JPAUtil.shutDown();
	}
	static void test3() {
		EntityManager em=JPAUtil.createEntityManager("JPAIntro");
		ContactInfo contactInfo=em.find(ContactInfo.class,1099);
		System.out.println( contactInfo);
		System.out.println( contactInfo.getPerson());
		JPAUtil.shutDown();
		
		

}
		
	
			
			
	

	

	public static void main(String[] args) {
		test3();

	}

}

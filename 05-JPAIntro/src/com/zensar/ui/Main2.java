package com.zensar.ui;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.time.LocalDate;

import com.zensar.bean.Employee;
import com.zensar.util.JPAUtil;

public class Main2 {
	static void insert() {
	EntityManager em=JPAUtil.createEntityManager("JPAIntro");
		
		Employee employee=new Employee();
		employee.setName("Reddy");
		employee.setBasics(45000.0);
		employee.setDateOfJoin(LocalDate.of(2013,12,10));
		employee.setGrade('A');
		
		em.getTransaction().begin();
		em.persist(employee);
		em.getTransaction().commit();
		
		JPAUtil.shutDown();
	}
		static void load() {
			EntityManager em=JPAUtil.createEntityManager("JPAIntro");
			
			
			Employee employee =em.find(Employee.class,1);
			System.out.println(employee);
			
			JPAUtil.shutDown();
		}
			
			static void editing() {
				EntityManager em=JPAUtil.createEntityManager("JPAIntro");
				
				Employee employee =em.find(Employee.class,2);
				employee.setBasics(123000);
				
				em.getTransaction().begin();
				em.merge(employee);
				em.getTransaction().commit();
				
				JPAUtil.shutDown();
				
				
		
	}
			static void deleting() {
				EntityManager em=JPAUtil.createEntityManager("JPAIntro");
				
				Employee employee =em.find(Employee.class,1);
				
				em.getTransaction().begin();
				em.remove(employee);
				em.getTransaction().commit();
				JPAUtil.shutDown();
			
				
			}
			
	public static void main(String[] args) {
		editing();

	}
}
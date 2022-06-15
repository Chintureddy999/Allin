package com.zensar;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.zensar.bean.SimpleCalculator;

public class SimpleCalculatorTester {
	SimpleCalculator calc;
	@BeforeAll
	public static void x() {
		System.out.println("x executes");
	}
	@AfterAll
	public static void y() {
		System.out.println("y executes");
	}
	@BeforeEach
	public void f1() {
		calc=new SimpleCalculator();
	}
	@AfterEach
	public void f2() {
		calc = null;
	}
	@Test
	public void testingAdd() {
		
		int expected=8;
		int actual=calc.add(3, 5);
		 assertEquals (expected,actual);
		
	}
	@Test
	public void testingAddWithNegativeValue() {
			int actual=calc.add(-9, -19);
		int expected=-28;
		 assertEquals (expected,actual);
		 
	}
	@Test
	public void testingSubstract() {
		
		int expected=8;
		int actual=calc.substract(13, 5);
		 assertEquals (expected,actual);
		
	}
	@Test
	public void testingMultiply() {
		
		int actual=calc.multiply(9, 2);
		int expected=18;
		 assertEquals (expected,actual);
	
	}
	@Test
	public void testingMultiplyWithNegativeValues() {
		
		int actual=calc.multiply(-9, 2);
		int expected=-18;
		 assertEquals (expected,actual);
		
	}
	@Test
	public void testingDivide() {
		int actual=calc.divide(9, 2);
		int expected=4;
		 assertEquals (expected,actual);
	}
	
	

}

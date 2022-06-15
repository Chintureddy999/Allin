package com.zensar;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.zensar.bean.PrimeNumberDecider;

public class PrimeNumberTester {
	PrimeNumberDecider decider;
	@BeforeEach
	public void f1() {
		decider =new PrimeNumberDecider();
	}
	@AfterEach
	public void f2() {
		decider=null;
	}
	@Test
	public void test1() {
		decider.setNumber(15);
		boolean actual=decider.isPrimeNumber(15);
		boolean expected=false;
		assertEquals(actual,expected);
		
	}
	@Test
	public void test2() {
		decider.setNumber(17);
		boolean actual=decider.isPrimeNumber(17);
		boolean expected=true;
		assertEquals(actual,expected);
		
	}
	@Test
	public void test3() {
		decider.setNumber(7);
		boolean actual=decider.isPrimeNumber(7);
		boolean expected=true;
		assertEquals(actual,expected);
	
	
	

}

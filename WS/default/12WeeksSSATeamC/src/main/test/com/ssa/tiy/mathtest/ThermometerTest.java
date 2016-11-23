package com.ssa.tiy.mathtest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import com.ssa.tiy.math.Thermometer;

public class ThermometerTest {
	Thermometer t1 = new Thermometer(0, false);
	Thermometer t2;
	
	@Before
	public void init() {
		//Thermometer t1 = new Thermometer(0, false);
	}
	
	@Test
	public void test() {
		//Thermometer t1 = new Thermometer(32, true);
		t1.setTemp(32);
		t1.setFahrenheit(true);
		assertEquals(0, t1.convert(), 0);
	}
	
	@Test
	public void test1() {
		//Thermometer t1 = new Thermometer(212, true);
		t1.setTemp(212);
		t1.setFahrenheit(true);
		assertEquals(100, t1.convert(), 0);
	}
	
	@Test
	public void failedTest() {
		t1.setTemp(-100);
		assertEquals(9, t1.convert(), 0);
	}
	
	@Test
	public void nullTest() {
		assertNotNull(t1);
	}
	
	@Test
	public void notTheSame() {
		assertNotSame(t1, t2);
	}

}

package com.ssa.tiy.mathtest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.ssa.tiy.math.Math;

public class MathTest {

	@Before
	public void setup() {
		// Initializations go in here
		System.out.println("Hello Junit");
	}
	
	@Test
	public void test() {
		Math math = new Math(3,0);
		int x = math.getA();
		int y = math.getB();
		
		assertEquals(12, math.add(x,y));
		assertEquals(-1.0, math.division(x,y), 0);
	}

}

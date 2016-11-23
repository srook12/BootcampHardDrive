package com.ssa.tiy.math;

public class Math {
	int a, b;
	
	public Math(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public int add(int x, int y) {
		return x+y;
	}
	
	public int substract(int x, int y) {
		return x-y;
	}
	
	public int multiply(int x, int y) {
		return x*y;
	}
	
	public float division(int x, int y) {
		if(y!= 0)
			return x/y;
		else
			return (float)-1.0;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}
}

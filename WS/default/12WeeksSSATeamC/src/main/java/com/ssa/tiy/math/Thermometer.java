package com.ssa.tiy.math;

public class Thermometer {
	double temp;
	boolean isFahrenheit;
		
	public Thermometer(double temp, boolean isFahrenheit) {
		this.temp = temp;
		this.isFahrenheit = isFahrenheit;
	}
	
	public double convert() {
		if(isFahrenheit) {
			return (temp - 32) * (5.0/9);
		} else {
			return ((9.0/5)*temp + 32);
		}
	}

	public double getTemp() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}

	public boolean isFahrenheit() {
		return isFahrenheit;
	}

	public void setFahrenheit(boolean isFahrenheit) {
		this.isFahrenheit = isFahrenheit;
	}
	
	public static void main(String[] args) {
		Thermometer t1 = new Thermometer(3, false);
		System.out.printf("%.1f", t1.convert());
	}
}

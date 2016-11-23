package ssa.employee;

public class Manager extends Employee {
	private boolean hasParkingPriv = true;

	public boolean getHasParkingPriv() {
		return hasParkingPriv;
	}

	public void setHasParkingPriv(boolean hasParkingPriv) {
		this.hasParkingPriv = hasParkingPriv;
	}	
	
	public String print() {
		return print() + " infinite loop...";
	}
}

package gov.ssa.instructor;

import ssa.gov.major.Major;
import ssa.gov.major.MajorFactory;

public class Instructor {
	private int id;
	private String firstName;
	private String lastName;
	private int yearsExp;
	private int tenured;
	private Major majorId;
	
	public Instructor() { }
	
	public Instructor(String firstName, String lastName, int yearsExp, int tenured) {
		this(-1, firstName, lastName, yearsExp, tenured);
	}
	
	public Instructor(int id, String firstName, String lastName, int yearsExp, int tenured) {
		setId(id);
		setFirstName(firstName);
		setLastName(lastName);
		setYearsExp(yearsExp);
		setTenured(tenured);
	}
	
	public Instructor(String firstName, String lastName, int yearsExp, int tenured, String majorDescription) {
		this(firstName, lastName, yearsExp, tenured);
		
		setMajorId(new MajorFactory().getByField("description", majorDescription));
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getYearsExp() {
		return yearsExp;
	}
	public void setYearsExp(int yearsExp) {
		this.yearsExp = yearsExp;
	}
	public int getTenured() {
		return tenured;
	}
	public void setTenured(int tenured) {
		this.tenured = tenured;
	}
	public Major getMajorId() {
		return majorId;
	}
	public void setMajorId(Major majorId) {
		this.majorId = majorId;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append(String.format("%-4d   %-15s   %-15s   %2d   ", getId(), getFirstName(), getLastName(),
				getYearsExp()));
		
		String tenured = getTenured() == 0 ? "N" : "Y";
		String majorDescription = getMajorId() == null ? "N/A" : getMajorId().getDescription();
		
		sb.append(String.format("%s   %-15s", tenured, majorDescription));
		
		return sb.toString();
	}
}

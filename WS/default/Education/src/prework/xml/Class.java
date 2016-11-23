package prework.xml;

import org.apache.commons.lang.StringEscapeUtils;

import com.mysql.jdbc.StringUtils;

public class Class {
	private String code;
	private String number;
	
	private String name;
	
	private int numCredits;
	
	private String description;

	private int departmentId; // fk
	
	private String departmentName;
	
	private static int class_id_ctr = 1;
	
	private int class_id;
	
	public Class() {class_id = class_id_ctr; class_id_ctr++; }
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number.replaceAll("'","''");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name.replaceAll("'","''");
	}

	public int getNumCredits() {
		return numCredits;
	}

	public void setNumCredits(int numCredits) {
		this.numCredits = numCredits;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description.replaceAll("'","''");
	}	
	
	public int getDepartmentId() {
		return departmentId;
	}
	
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	
	public String getDepartmentName() {
		return this.departmentName;
	}
	
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("insert into class (num, name, credits, description, department_id) ");
		sb.append("values('" + getNumber() + "', '" + getName() + "', ");
		sb.append(getNumCredits() + ", '" + getDescription() + "', " + getDepartmentId() + ");");
		/*
		sb.append("values (\"" + getNumber() + "\", \"" + getName() + "\", "); 
		sb.append(getNumCredits() + ", \"" + getDescription() + "\", " + getDepartmentId() + ");");
		*/
		return sb.toString();
	}
	
	public String printClass() {
		StringBuffer sb = new StringBuffer();
		
		sb.append(getDepartmentName() + " " + getNumber() + "=" + class_id);
		
		return sb.toString();
	}
}

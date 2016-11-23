package gov.ssa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String first_name;
	
	@Column(name="last_name")
	private String last_name;
	
	@Column(name="gpa")
	private double gpa;
	
	@Column(name="sat")
	private Integer sat;
	
	// Foreign key major_id
	@ManyToOne
    @JoinColumn(name = "major_id")
	Major major_id;
	
	public Student() {}
	
	public Student(String first_name, String last_name, double gpa, int sat) {
		this(first_name, last_name, gpa, sat, null);
	}
	
	public Student(String first_name, String last_name, double gpa, int sat, Major major_id) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.gpa = gpa;
		this.sat = sat;
		this.major_id = major_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public Integer getSat() {
		return sat;
	}

	public void setSat(Integer sat) {
		this.sat = sat;
	}
	
	
	public Major getMajor_id() {
		return major_id;
	}

	public void setMajor_id(Major major_id) {
		this.major_id = major_id;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append(String.format("%-4d   %-20s   %-20s   %4.2f   %4d   ", getId(), getFirst_name(), getLast_name(), getGpa(), getSat()));
		
		String description = null;
		
		if(major_id != null) {
			description = major_id.getDescription();
		} else {
			description = "N/A";
		}
		
		sb.append(String.format("%-20s", description));
		
		return sb.toString();
	}
}

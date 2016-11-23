package gov.ssa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor")
public class Instructor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String first_name;
	
	@Column(name="last_name")
	private String last_name;
	
	@Column(name="years_experience")
	private int years_experience;
	
	@Column(name="is_tenured")
	private int is_tenured;
	
	// Foreign key major_id
	@ManyToOne
	@JoinColumn(name = "major_id")
	Major major_id;

	public Instructor(String first_name, String last_name, int years_experience, int is_tenured, Major major_id) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.years_experience = years_experience;
		this.is_tenured = is_tenured;
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

	public int getYears_experience() {
		return years_experience;
	}

	public void setYears_experience(int years_experience) {
		this.years_experience = years_experience;
	}

	public int getIs_tenured() {
		return is_tenured;
	}

	public void setIs_tenured(int is_tenured) {
		this.is_tenured = is_tenured;
	}

	public Major getMajor_id() {
		return major_id;
	}

	public void setMajor_id(Major major_id) {
		this.major_id = major_id;
	}
}

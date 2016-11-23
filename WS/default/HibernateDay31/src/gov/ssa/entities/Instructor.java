package gov.ssa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.persistence.CascadeType;

@Entity
@Table(name="Instructor")
public class Instructor extends BaseObject {
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
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="major_id")
	private Major major_id;
	
	public Instructor() {}

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
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(String.format("%-2d   %-20s   %-20s   %2d   ", getId(), getFirst_name(), getLast_name(), getYears_experience()));

		String has_tenure = getIs_tenured() == 1 ? "Y" : "N";
		
		String description;
		if(major_id != null) {
			description = major_id.getDescription();
		} else {
			description = "N/A";
		}
		
		sb.append(String.format("%s   %-20s", has_tenure, description));
		
		return sb.toString();
	}
}

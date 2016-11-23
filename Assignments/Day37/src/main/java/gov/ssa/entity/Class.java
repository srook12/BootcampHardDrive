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
@Table(name="class")
public class Class {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="subject")
	private String subject;
	
	@Column(name="section")
	private int section;
	
	// Foreign key major_id
	@ManyToOne
	@JoinColumn(name = "instructor_id")
	private Instructor instructor_id;

	public Class(String subject, int section, Instructor instructor_id) {
		super();
		this.subject = subject;
		this.section = section;
		this.instructor_id = instructor_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getSection() {
		return section;
	}

	public void setSection(int section) {
		this.section = section;
	}

	public Instructor getInstructor_id() {
		return instructor_id;
	}

	public void setInstructor_id(Instructor instructor_id) {
		this.instructor_id = instructor_id;
	}
}

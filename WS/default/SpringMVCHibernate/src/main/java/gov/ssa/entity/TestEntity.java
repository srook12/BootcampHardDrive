package gov.ssa.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="test_entity")
public class TestEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="days")
	private Set<String> days = new HashSet<String>();
	
	public TestEntity() {}

	public TestEntity(Set<String> days) {
		super();
		this.days = days;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<String> getDays() {
		return days;
	}

	public void setDays(Set<String> days) {
		this.days = days;
	}
}

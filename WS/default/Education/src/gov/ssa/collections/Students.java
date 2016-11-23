package gov.ssa.collections;

import gov.ssa.entities.Major;
import gov.ssa.entities.Student;

public class Students extends BaseObjects {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String ID_FIELD = "ID";
	
	public Students selectStudents(String hql) {
		Students students = new Students();
		students.addAll(select(hql));		
		return students;
	}
	
	public Student getById(int id) {
		Students students = selectStudents("from Student where " + ID_FIELD + " = " + id);
		
		if(students.size() > 0) {
			return (Student) students.get(0);
		} else {
			return null;
		}
	}
		
	public void insertMajor(Major major) {
		insert(major);
	}
	
	public void updateMajor(Major major) {
		update(major);
	}
	
	public void deleteMajor(Major major) {
		delete(major);
	}
	
	public String displayAllMajors() {
		StringBuffer sb = new StringBuffer();
		
		Majors majors = selectMajors("from Major");
			
		System.out.println("Print all majors\n-------------------\n");
		sb.append(display(majors));
		
		return sb.toString();
	}
}

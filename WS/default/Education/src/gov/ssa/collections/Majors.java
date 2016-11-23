package gov.ssa.collections;

import gov.ssa.entities.Major;
import gov.ssa.entities.Student;

public class Majors extends BaseObjects {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String ID_FIELD = "ID";
	public static final String DESCRIPTION_FIELD = "DESCRIPTION";
	
	public Majors selectMajors(String hql) {
		Majors majors = new Majors();
		majors.addAll(select(hql));		
		return majors;
	}
	
	public Major getById(int id) {
		Majors majors = selectMajors("from Major where " + ID_FIELD + " = " + id);
		
		if(majors.size() > 0) {
			return (Major) majors.get(0);
		} else {
			return null;
		}
	}
		
	public Major getByDescription(String description) {
		Majors majors = selectMajors("from Major where " + DESCRIPTION_FIELD + " = '" + description + "'");
		
		if(majors.size() > 0) {
			return (Major) majors.get(0);
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

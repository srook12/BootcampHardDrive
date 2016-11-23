package gov.ssa.mainline;

import gov.ssa.collections.BaseObjects;
import gov.ssa.collections.Majors;
import gov.ssa.entities.Major;

public class Mainline2 {

	static Majors majors = new Majors();
	
	public static void main(String[] args) {
		insert();
		update();
		delete();
		
		BaseObjects.getSessionFactory().close();
	}
	
	public static void insert() {
		majors.insertMajor(new Major("Computer Science", 1390));
		majors.insertMajor(new Major("History", 720));
		majors.insertMajor(new Major("Music", 810));
		
		System.out.println(majors.displayAllMajors());
	}
	
	public static void update() {
		Major major = majors.getByDescription("Accounting");
		major.setDescription("Business Education");
		majors.update(major);
		
		major = majors.getByDescription("Engineering");
		major.setDescription("Statics");
		major.setReq_sat(1430);
		majors.update(major);
		
		System.out.println(majors.displayAllMajors());
	}

	public static void delete() {
		Major major = majors.getByDescription("History");
		majors.deleteMajor(major);
		
		major = majors.getByDescription("Music");
		majors.deleteMajor(major);
		
		System.out.println(majors.displayAllMajors());
	}
}

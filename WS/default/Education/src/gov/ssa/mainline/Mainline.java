package gov.ssa.mainline;

import java.util.List;
import java.util.ArrayList;

import gov.ssa.collections.BaseObjects;
import gov.ssa.collections.Majors;
import gov.ssa.entities.Major;

public class Mainline {

	static Majors majors;
	static List<Major> majorList = new ArrayList<Major>();
	
	public static void main(String[] args) {
		majors = new Majors();
		
		majorList.add(new Major("Computer Science", 1350));
		majorList.add(new Major("English", 1050));
		majorList.add(new Major("Journalism", 920));
		majorList.add(new Major("History", 1000));

		insert();
		update();
		delete();
		
		BaseObjects.getSessionFactory().close();
	}
	
	public static void insert() {
		for(Major major : majorList) {
			majors.insertMajor(major);
		}
		
		System.out.println(majors.displayAllMajors());
	}
	
	public static void update() {
		Major major = majors.getByDescription("Education");
		major.setReq_sat(920);
		majors.updateMajor(major);
		
		major = majors.getById(4);
		major.setDescription("Mathematics");
		major.setReq_sat(1400);
		majors.updateMajor(major);
		
		major = majors.getById(12);
		
		System.out.println(majors.displayAllMajors());
	}
	
	public static void delete() {
		Major major = majors.getById(9);
		majors.deleteMajor(major);
		
		major = majors.getById(10);
		majors.deleteMajor(major);
		
		major = majors.getById(12);
		majors.delete(major);
		
		System.out.println(majors.displayAllMajors());
		
	}

}

package ssa;

import java.util.ArrayList;
import java.util.List;

import ssa.gov.major.Major;
import ssa.gov.major.MajorFactory;

public class Mainline2 {

	public static void main(String[] args) {
		List<Major> majorCollection = new ArrayList<Major>();
		MajorFactory majorFactory = new MajorFactory();
		
		
		majorCollection = majorFactory.getAllMajors();
		printMajors("Print all majors\n-------------------", majorCollection);
		
		majorCollection.clear();
		
		majorCollection.add(majorFactory.getByField("id", 4));
		majorCollection.add(majorFactory.getByField("id", -1));
		
		printMajors("Find a major that exists and search for one that doesn't\n------------------", majorCollection);
		
		majorFactory.insertMajor(new Major("Computer Science", 1200));
		majorCollection = majorFactory.getAllMajors();
		printMajors("Insert a new major\n-------------------", majorCollection);
		
		Major major = majorFactory.getByField("id", 7);
		major.setReqSat(610);
		major.setDescription("Undeclared");
		majorFactory.updateMajor(major);
		majorCollection = majorFactory.getAllMajors();
		printMajors("Update the General Studies major\n------------------", majorCollection);
		
		major = majorFactory.getByField("id", 8);
		majorFactory.deleteById(major.getId());
		majorCollection = majorFactory.getAllMajors();
		printMajors("Delete the computer science major\n------------", majorCollection);
	}

	public static void printMajors(String preface, List<Major> majors) {
		System.out.println(preface);
		for(Major major : majors) {
			System.out.println(major);
		}
		System.out.println();
	}
}

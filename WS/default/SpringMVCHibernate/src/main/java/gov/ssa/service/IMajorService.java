package gov.ssa.service;

import java.util.List;

import gov.ssa.entity.Major;
import gov.ssa.entity.Student;

public interface IMajorService {
	List<Major> getAllMajors();
	
	List<Major> listEligibleMajors(int sat);
	
	Major getMajorById(int majorId);
	
	boolean addMajor(Major major);
	
	void updateMajor(Major major);
	
	void deleteMajor(Major major);
}

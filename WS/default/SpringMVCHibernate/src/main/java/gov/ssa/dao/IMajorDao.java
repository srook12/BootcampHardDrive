package gov.ssa.dao;

import java.util.List;

import gov.ssa.entity.Major;

public interface IMajorDao {
	List<Major> getAllMajors();
	
	List<Major> listEligibleMajors(int sat);
	
	Major getMajorById(int majorId);
	
	boolean addMajor(Major major);
	
	void updateMajor(Major major);
	
	void deleteMajor(Major major);
}

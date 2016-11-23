package gov.ssa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ssa.dao.IMajorDao;
import gov.ssa.entity.Major;

@Service
public class MajorService implements IMajorService {

	@Autowired
	private IMajorDao majorDao;
	
	@Override
	public List<Major> getAllMajors() {
		return majorDao.getAllMajors();
	}
	
	@Override
	public List<Major> listEligibleMajors(int sat) {
		return majorDao.listEligibleMajors(sat);
	}

	@Override
	public Major getMajorById(int majorId) {
		return majorDao.getMajorById(majorId);
	}

	@Override
	public boolean addMajor(Major major) {
		return majorDao.addMajor(major);
	}

	@Override
	public void updateMajor(Major major) {
		majorDao.updateMajor(major);	
	}

	@Override
	public void deleteMajor(Major major) {
		majorDao.deleteMajor(major);	
	}	
}

package gov.ssa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ssa.dao.ITEDao;
import gov.ssa.entity.TestEntity;

@Service
public class TEService implements ITEService {

	@Autowired
	private ITEDao teDao;
	
	@Override
	public List<TestEntity> getAllTEs() {
		return teDao.getAllTEs();
	}
	
	@Override
	public TestEntity getTEById(int id) {
		return teDao.getTEById(id);
	}
}

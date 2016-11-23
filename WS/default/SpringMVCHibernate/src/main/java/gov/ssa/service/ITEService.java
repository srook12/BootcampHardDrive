package gov.ssa.service;

import java.util.List;

import gov.ssa.entity.TestEntity;

public interface ITEService {
	List<TestEntity> getAllTEs();
	
	TestEntity getTEById(int id);
}

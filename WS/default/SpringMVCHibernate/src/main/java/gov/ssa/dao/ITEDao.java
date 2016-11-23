package gov.ssa.dao;

import java.util.List;

import gov.ssa.entity.TestEntity;

public interface ITEDao {
	List<TestEntity> getAllTEs();
	
	TestEntity getTEById(int id);
}

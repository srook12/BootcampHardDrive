package gov.ssa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ssa.entity.TestEntity;

@Transactional
@Repository
public class TEDao implements ITEDao {

	@Autowired
    private HibernateTemplate hibernateTemplate;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TestEntity> getAllTEs() {
		String hql = "from TestEntity as te order by te.id";
		return (List<TestEntity>) hibernateTemplate.find(hql);
	}

	@Override
	public TestEntity getTEById(int id) {
		String hql = "from TestEntity as te where te.id = " + id;
		return (TestEntity) hibernateTemplate.find(hql).get(0);
	}

	
}

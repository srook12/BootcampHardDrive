package gov.ssa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ssa.entity.Major;

@Transactional
@Repository
public class MajorDao implements IMajorDao {

	@Autowired
    private HibernateTemplate hibernateTemplate;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Major> getAllMajors() {
		String hql = "from Major as m order by m.id";
		return (List<Major>) hibernateTemplate.find(hql);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Major> listEligibleMajors(int sat) {
		String hql = "from Major as m where m.req_sat <= " + sat + " order by m.req_sat desc";
		return (List<Major>) hibernateTemplate.find(hql);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Major getMajorById(int majorId) {
		String hql = "from Major as m where m.id = " + majorId;
		List<Major> majors = (List<Major>) hibernateTemplate.find(hql);
		
		if(majors.size() > 0) {
			return majors.get(0);
		} else {
			return null;
		}
	}

	@Override
	public boolean addMajor(Major major) {
		
		try {
			hibernateTemplate.persist(major);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public void updateMajor(Major major) {
		hibernateTemplate.update(major);
	}

	@Override
	public void deleteMajor(Major major) {
		hibernateTemplate.delete(major);	
	}
}

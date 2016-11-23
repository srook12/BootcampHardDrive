package gov.ssa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ssa.entity.Student;

@Transactional
@Repository
public class StudentDao implements IStudentDao {

	@Autowired
    private HibernateTemplate hibernateTemplate;

    @SuppressWarnings("unchecked")
    @Override
    public List<Student> getAllStudents() {
        String hql = "FROM Student as s ORDER BY s.id";
        return (List<Student>) hibernateTemplate.find(hql);
    }
    
    @SuppressWarnings("unchecked")
    @Override
	public Student getStudentById(int studentId) {
		String hql = "from Student as s where id = " + studentId;
		List<Student> students = (List<Student>) hibernateTemplate.find(hql);
		
		if(students.size() > 0) {		
			return students.get(0);
		} else {
			return null;
		}
		
	}

	@Override
	public boolean addStudent(Student student) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateStudent(Student student) {
		hibernateTemplate.update(student);
	}

	@Override
	public void deleteStudent(Student student) {
		//String hql = "delete from Student where id = " + student.getId();
		hibernateTemplate.delete(student);
	}
}

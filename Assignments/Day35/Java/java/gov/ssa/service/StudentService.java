package gov.ssa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ssa.dao.IStudentDao;
import gov.ssa.entity.Student;

@Service
public class StudentService implements IStudentService {
	@Autowired
	private IStudentDao studentDao;
	
	@Override
	public List<Student> getAllStudents() {
		return studentDao.getAllStudents();
	}

	@Override
	public Student getStudentById(int studentId) {
		return studentDao.getStudentById(studentId);
	}

	@Override
	public boolean addStudent(Student student) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateStudent(Student student) {
		studentDao.updateStudent(student);		
	}

	@Override
	public void deleteStudent(Student student) {
		studentDao.deleteStudent(student);		
	}
}

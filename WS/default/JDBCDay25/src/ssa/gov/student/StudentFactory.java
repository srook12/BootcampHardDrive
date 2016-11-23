package ssa.gov.student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import ssa.gov.major.Major;
import ssa.gov.major.MajorFactory;
import ssa.gov.utils.DBUtils;

public class StudentFactory extends HashMap<Integer, Student> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Properties sqlProperties = null;
	
	static {		
		sqlProperties = DBUtils.getSqlProperties();
	}
	
	public List<Student> getAllStudents() {
		ResultSet rs = DBUtils.executeSelect(sqlProperties.getProperty("select.students.sql"));			
		return getStudents(rs);
	}
	
	public Student getById(int id) {
		List<Student> students = new ArrayList<Student>();
		
		ResultSet rs = DBUtils.executeSelectWhere(sqlProperties.getProperty("select.students.sql"), "where id = ?", 
				null, id);
		students = getStudents(rs);
				
		// Check to see whether a result exists
		if(!students.isEmpty()) {
			return students.get(0);
		}
		
		return null;
	}
	
	public List<Student> getStudents(ResultSet rs) {
		List<Student> students = new ArrayList<Student>();
		MajorFactory majorFactory = new MajorFactory();
		
		try {
			while(rs.next()) {
				Student student = new Student(
						rs.getInt("id"), 
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getInt("sat"), 
						rs.getDouble("gpa")
						);
				
				int major_id = rs.getInt("major_id");
				Major major = majorFactory.getByField("id", major_id);
				if(major != null) {
					student.setMajorId(majorFactory.getByField("id", major_id));
				}
				
				students.add(student);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return students;
	}
	
	public void insertStudent(Student student) {
		if(student.getMajorId() != null) {
			DBUtils.executeUpdate(sqlProperties.getProperty("insert.students.sql.1"), 
					student.getFirstName(), student.getLastName(), student.getSat(), student.getGpa(), 
					student.getMajorId().getId());
		} else {
			DBUtils.executeUpdate(sqlProperties.getProperty("insert.students.sql.2"), 
				student.getFirstName(), student.getLastName(), student.getSat(), student.getGpa());
		}
		student.setId(DBUtils.getLastInsertId());
	}
	
	public void updateStudent(Student student) {
		if(student.getMajorId() != null) {
			DBUtils.executeUpdate(sqlProperties.getProperty("update.students.sql.1"), 
					student.getFirstName(), student.getLastName(), student.getSat(), student.getGpa(), 
					student.getMajorId().getId(), student.getId());
		} else {
			DBUtils.executeUpdate(sqlProperties.getProperty("update.students.sql.2"), 
					student.getFirstName(), student.getLastName(), student.getSat(), student.getGpa(), 
					student.getId());
		}		
	}
	
	public void deleteById(int id) {
		DBUtils.executeUpdate(sqlProperties.getProperty("delete.students.sql"), id);
	}
}

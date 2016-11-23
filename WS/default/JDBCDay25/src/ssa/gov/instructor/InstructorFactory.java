package ssa.gov.instructor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import ssa.gov.major.Major;
import ssa.gov.major.MajorFactory;
import ssa.gov.student.Student;
import ssa.gov.utils.DBUtils;

public class InstructorFactory extends HashMap<Integer, Instructor> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Properties sqlProperties = null;
	
	static {		
		sqlProperties = DBUtils.getSqlProperties();
	}
	
	public List<Instructor> getAllInstructors() {
		ResultSet rs = DBUtils.executeSelect(sqlProperties.getProperty("select.instructors.sql"));			
		return getInstructors(rs);
	}
	
	public Instructor getById(int id) {
		List<Instructor> instructors = new ArrayList<Instructor>();
		
		ResultSet rs = DBUtils.executeSelectWhere(sqlProperties.getProperty("select.instructors.sql"), " id = ?", 
				null, id);
		instructors = getInstructors(rs);
				
		// Check to see whether a result exists
		if(!instructors.isEmpty()) {
			return instructors.get(0);
		}
		
		return null;
	}
	
	public List<Instructor> getInstructors(ResultSet rs) {
		List<Instructor> instructors = new ArrayList<Instructor>();
		MajorFactory majorFactory = new MajorFactory();
		
		try {
			while(rs.next()) {				
				Instructor instructor = new Instructor(
						rs.getInt("id"), 
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getInt("years_experience"), 
						rs.getInt("is_tenured")
						);
				
				int major_id = rs.getInt("major_id");
				Major major = majorFactory.getByField("id", major_id);
				
				if(major != null) {
					instructor.setMajorId(majorFactory.getByField("id", major_id));
				}
				
				instructors.add(instructor);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return instructors;
	}
	
	public void insertInstructor(Instructor instructor) {
		if(instructor.getMajorId() != null) {
			DBUtils.executeUpdate(sqlProperties.getProperty("insert.instructors.sql.1"), 
					instructor.getFirstName(), instructor.getLastName(), instructor.getYearsExp(), 
					instructor.getTenured(), instructor.getMajorId().getId());
		} else {
			DBUtils.executeUpdate(sqlProperties.getProperty("insert.instructors.sql.2"), 
				instructor.getFirstName(), instructor.getLastName(), instructor.getYearsExp(), 
				instructor.getTenured());
		}
		
		instructor.setId(DBUtils.getLastInsertId());
	}
	
	public void updateInstructor(Instructor instructor) {
		if(instructor.getMajorId() != null) {
			DBUtils.executeUpdate(sqlProperties.getProperty("update.instructors.sql.1"), 
					instructor.getFirstName(), instructor.getLastName(), instructor.getYearsExp(), 
					instructor.getTenured(), instructor.getMajorId().getId(), instructor.getId());
		} else {
			DBUtils.executeUpdate(sqlProperties.getProperty("update.instructors.sql.2"), 
					instructor.getFirstName(), instructor.getLastName(), instructor.getYearsExp(), 
					instructor.getTenured(), instructor.getId());
		}		
	}
	
	public void deleteById(int id) {
		DBUtils.executeUpdate(sqlProperties.getProperty("delete.instructors.sql"), id);
	}
}

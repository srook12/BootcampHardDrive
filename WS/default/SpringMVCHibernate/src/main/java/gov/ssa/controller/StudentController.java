package gov.ssa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gov.ssa.entity.Major;
import gov.ssa.entity.Student;
import gov.ssa.service.IMajorService;
import gov.ssa.service.IStudentService;

@CrossOrigin
@Controller
public class StudentController {
	@Autowired
	private IStudentService studentService;
	
	@Autowired
	private IMajorService majorService;
	
	@RequestMapping(value= "/students/list_students", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
    }
	
	@RequestMapping(value="/students/student_info/{id}", method = RequestMethod.GET)
	public ResponseEntity<Student> getStudentById(@PathVariable("id") Integer id) {
		Student student = studentService.getStudentById(id);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	
	@RequestMapping(value="/students/add_student/{first_name}/{last_name}/{sat}/{gpa}/{major_id}", method = RequestMethod.GET)
	public ResponseEntity<Void> addStudent(@PathVariable("first_name") String first_name,
										   @PathVariable("last_name") String last_name,
										   @PathVariable("sat") Integer sat,
										   @PathVariable("gpa") Double gpa,
										   @PathVariable("major_id") Integer major_id) {
		try {
			/*
			Major major = null;
			if(major_id != 0) {
				major = majorService.getMajorById(major_id);
				//student.setMajor_id(major);
				//student.setMajor_id(majorService.getMajorById(major_id));				
			}*/
			
			Student student = new Student(first_name, last_name, gpa, sat);
			
			if(sat == 0) {
				student.setSat(null);
			}
			
			if(major_id != 0) {
				student.setMajor_id(majorService.getMajorById(major_id));
			}
						
			studentService.addStudent(student);
			
			return ResponseEntity.accepted().build();
		} catch(Exception ex) {
			return ResponseEntity.unprocessableEntity().build();
		}
	}
	
	@RequestMapping(value="/students/update_student/{id}/{first_name}/{last_name}/{sat}/{gpa}/{major_id}", method = RequestMethod.GET)
	public ResponseEntity<Void> updateStudent(@PathVariable("id") Integer id,
			                                  @PathVariable("first_name") String first_name,
			                                  @PathVariable("last_name") String last_name,
			                                  @PathVariable("sat") Integer sat, 
			                                  @PathVariable("gpa") Double gpa,
			                                  @PathVariable("major_id") Integer major_id) {
		try {
			Student student = studentService.getStudentById(id);
			student.setFirst_name(first_name);
			student.setLast_name(last_name);
			student.setSat(sat);
			
			if(sat == 0) {
				student.setSat(null);
			}
			
			student.setGpa(gpa);
			
			if(major_id == 0) {
				student.setMajor_id(null);
			} else {
				student.setMajor_id(majorService.getMajorById(major_id));
			}
			
			studentService.updateStudent(student);
			
			return ResponseEntity.noContent().build();
		} catch (Exception ex) {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@RequestMapping(value="/students/delete_student/{id}", method = RequestMethod.GET) 
	public ResponseEntity<Void> deleteStudent(@PathVariable("id") Integer id) {
		try {
			studentService.deleteStudent(studentService.getStudentById(id));
			return ResponseEntity.noContent().build();
		} catch (Exception ex) {
			return ResponseEntity.notFound().build();
		}
	}
}

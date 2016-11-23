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

import gov.ssa.entity.Student;
import gov.ssa.service.IStudentService;

@CrossOrigin
@Controller
//@RequestMapping("/")
public class StudentController {
	@Autowired
	private IStudentService studentService;
	
	@RequestMapping(value= "/students", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
    }
	
	@RequestMapping(value="/student/{id}", method = RequestMethod.GET)
	public ResponseEntity<Student> getStudentById(@PathVariable("id") Integer id) {
		Student student = studentService.getStudentById(id);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	
	@RequestMapping(value="/update_student/{id}/{first_name}/{last_name}/{sat}/{gpa}", method = RequestMethod.GET)
	public ResponseEntity<Void> updateStudent(@PathVariable("id") Integer id,
			                                  @PathVariable("first_name") String first_name,
			                                  @PathVariable("last_name") String last_name,
			                                  @PathVariable("sat") Integer sat, 
			                                  @PathVariable("gpa") Double gpa) {
		try {
			Student student = studentService.getStudentById(id);
			student.setFirst_name(first_name);
			student.setLast_name(last_name);
			student.setSat(sat);
			student.setGpa(gpa);
			
			studentService.updateStudent(student);
			
			return ResponseEntity.noContent().build();
		} catch (Exception ex) {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@RequestMapping(value="/delete_student/{id}", method = RequestMethod.GET) 
	public ResponseEntity<Void> deleteStudent(@PathVariable("id") Integer id) {
		try {
			studentService.deleteStudent(studentService.getStudentById(id));
			return ResponseEntity.noContent().build();
		} catch (Exception ex) {
			return ResponseEntity.notFound().build();
		}
	}
}

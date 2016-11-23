import java.util.List;

import ssa.gov.instructor.Instructor;
import ssa.gov.instructor.InstructorFactory;
import ssa.gov.major.MajorFactory;
import ssa.gov.student.Student;
import ssa.gov.student.StudentFactory;

public class Mainline3 {

	public static void main(String[] args) {
		StudentFactory studentFactory = new StudentFactory();
		MajorFactory majorFactory = new MajorFactory();
		
		studentFactory.insertStudent(new Student("Adam", "Zapel", 1200, 3.0, "Finance"));
		studentFactory.insertStudent(new Student("Graham", "Krakir", 500, 2.5, "General Studies"));
		studentFactory.insertStudent(new Student("Ella", "Vader", 800, 3.0, "Accounting"));
		studentFactory.insertStudent(new Student("Stanley", "Kupp", 1350, 3.3, "Engineering"));
		studentFactory.insertStudent(new Student("Lou", "Zar", 950, 3.0, "Education"));

		InstructorFactory instructorFactory = new InstructorFactory();
		List<Instructor> instructors = instructorFactory.getAllInstructors();
		printInstructor(instructors);
		
		instructorFactory.insertInstructor(new Instructor("Bill", "Cosby", 5, 0));
		instructorFactory.insertInstructor(new Instructor("Papa", "Smurf", 50, 1, "Engineering"));
		
		instructors = instructorFactory.getAllInstructors();
		printInstructor(instructors);
		
		Instructor instructor = instructorFactory.getById(80);
		instructor.setLastName("Brock-Lee");
		instructor.setMajorId(majorFactory.getByField("description", "General Studies"));
		instructorFactory.updateInstructor(instructor);
		
		instructors = instructorFactory.getAllInstructors();
		printInstructor(instructors);
		
		instructor = instructorFactory.getById(101);
		instructorFactory.deleteById(instructor.getId());
		
		instructors = instructorFactory.getAllInstructors();
		printInstructor(instructors);
	}

	public static void printInstructor(List<Instructor> instructors) {
		for(Instructor instructor : instructors) {
			System.out.println(instructor);
		}
		System.out.println();
	}
}

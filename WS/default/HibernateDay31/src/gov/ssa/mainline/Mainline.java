package gov.ssa.mainline;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import gov.ssa.collections.BaseObjects;
import gov.ssa.collections.Instructors;
import gov.ssa.collections.Majors;
import gov.ssa.collections.Students;
import gov.ssa.entities.BaseObject;
import gov.ssa.entities.Instructor;
import gov.ssa.entities.Major;
import gov.ssa.entities.Student;

public class Mainline {

	static SessionFactory factory;
	static Session session;
	
	static {
		factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Major.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
	}
	
	public static void main(String[] args) {
		try {
			insertTest();
						
			updateTest();
		
			deleteTest();
			
			assignMajorTest();
			
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			factory.close();
		}
	}
	
	public static void insertTest() {
		System.out.println("Insert a new major (Computer Science, 1380) into the table\n--------------------\n");
		Major major = new Major("Computer Science", 1380);
		insertMajor(major);
		
		System.out.println("Insert a new major (English, 750) into the table\n--------------------\n");
		major = new Major("English", 750);
		insertMajor(major);
		
		displayAllMajors();
	}
	
	public static void updateTest() {		
		System.out.println("Update Education to require an SAT score of 990\n-----------------\n");
		Major major = (Major) selectMajors("from Major where id = 6").get(0);
		
		major.setReq_sat(990);
		updateMajor(major);
		
		System.out.println("Update General Studies to Undeclared\n-----------------\n");
		major = (Major) selectMajors("from Major where id = 7").get(0);
		
		major.setDescription("Undeclared");
		updateMajor(major);
		
		displayAllMajors();
	}
	
	public static void deleteTest() {
		System.out.println("Delete the Computer Science major\n-------------------------\n");
		Major major = getByDescription("Computer Science");
		
		deleteMajor(major);
		
		System.out.println("Delete the non-existent Statistics major\n--------------------\n");
		major = getByDescription("Statistics");
		
		deleteMajor(major);
		
		displayAllMajors();
	}
	
	public static void assignMajorTest() {
		System.out.println("Assign the Mathematics major to Howard Hess\n");
		
		// Get Howard Hess
		Student student = (Student) selectStudents("from Student where id = 130").get(0);
		
		// Assign the math major to Howard Hess
		assignMajor(student, "Math");
	
		System.out.println("Assign the Accounting major to Doug Dumas\n");
		
		// Get Doug Dumas
		student = (Student) selectStudents("from Student where id = 160").get(0);
		
		// Assign the accounting major to Doug Dumas
		assignMajor(student, "Math");
		
		displayAllStudents();
	}
	
	public static Majors selectMajors(String hql) {
		Majors majors = new Majors();
		majors.addAll(select(hql));		
		return majors;
	}
	
	public static Students selectStudents(String hql) {
		Students students = new Students();
		students.addAll(select(hql));	
		return students;
	}
	
	public static Instructors selectInstructors(String hql) {
		Instructors instructors = new Instructors();
		instructors.addAll(select(hql));
		return instructors;
	}
	
	// Base select statement
	public static BaseObjects select(String hql) {
		BaseObjects baseObjects = new BaseObjects();
		
		session = factory.getCurrentSession();
		session.beginTransaction();
		
		baseObjects.addAll(session.createQuery(hql).list());
		
		session.getTransaction().commit();
		
		return baseObjects;
	}
	
	// Base insert statement
	public static void insert(BaseObject baseObject) {
		session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(baseObject);
		session.getTransaction().commit();
	}
	
	// Base update statement
	public static void update(BaseObject baseObject) {
		session = factory.getCurrentSession();
		session.beginTransaction();
		session.update(baseObject);
		session.getTransaction().commit();
	}
	
	public static void delete(BaseObject baseObject) {
		session = factory.getCurrentSession();
		session.beginTransaction();

		if(baseObject != null) {
			session.delete(baseObject);
		} else {
			System.out.println("Cannot delete a non-existent entity!\n");
		}
		
		session.getTransaction().commit();
	}
	
	public static Major getByDescription(String description) {
		Majors majors = selectMajors("from Major where description = '" + description + "'");
		
		if(majors.size() > 0) {
			return (Major) majors.get(0);
		} else {
			return null;
		}
	}
	
	public static void insertMajor(Major major) {
		insert(major);
	}
	
	public static void insertStudent(Student student) {
		insert(student);
	}
	
	public static void insertInstructor(Instructor instructor) {
		insert(instructor);
	}
	
	public static void updateMajor(Major major) {
		update(major);
	}
	
	public static void updateStudent(Student student) {
		update(student);
	}
	
	public static void updateInstructor(Instructor instructor) {
		update(instructor);
	}
	
	public static void assignMajor(Student student, String description) {
		Major major = getByDescription(description);
		
		if(major != null) {
			student.setMajor_id(major);
			updateStudent(student);
		} else {
			System.out.println("Cannot update the major!\n");
		}
	}
	
	public static void deleteMajor(Major major) {		
		delete(major);
	}
	
	public static void deleteStudent(Student student) {
		delete(student);
	}
	
	public static void deleteInstructor(Instructor instructor) {
		delete(instructor);
	}
	
	public static void displayAllStudents() {
		Students students = selectStudents("from Student");
		
		System.out.println("Print all students\n------------------------------\n");
		display(students);
	}

	public static void displayAllMajors() {
		Majors majors = selectMajors("from Major");
		
		System.out.println("Print all majors\n-------------------\n");
		display(majors);
	}
	
	public static void displayAllInstructors() {
		Instructors instructors = selectInstructors("from Instructor");
		
		System.out.println("Print all instructors\n-----------------\n");
		display(instructors);
	}
	
	// Polymorphism at work!
	public static void display(List<BaseObject> baseObjects) {
		for(BaseObject baseObject : baseObjects) {
			System.out.println(baseObject);
		}
		System.out.println();
	}
}

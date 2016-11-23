package gov.ssa.tiy.createstudent;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import gov.ssa.tiy.entity.Student;

public class CreateStudent {

	static SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Student.class)
			.buildSessionFactory();
	
	static Session session;
		
	public static void main(String[] args) {		
		Student student = new Student("Santa", "Claus", 4.0, 1400);
				
		try {
			session = factory.getCurrentSession();
			
			insert(student);
		
			session = factory.getCurrentSession();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("update Student set sat=1400 where id=190").executeUpdate();
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("delete from Student where id=204").executeUpdate();
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			List<Student> students = session.createQuery("from Student where id in (120, 130, 140)").list();
			
			display(students);
			
			/*
			update(student);
		
			session = factory.getCurrentSession();			
			session.beginTransaction();
			
			student = session.get(Student.class, 191);
	
			delete(student);
			*/			
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			factory.close();
		}
	}

	private static void display(List<Student> students) {
		for(Student student1 : students) {
			System.out.println(student1);
		}
	}
	
	public static void insert(Student student) {
		try {			
			// begin transaction
			session.beginTransaction();
			
			session.save(student);
			
			// commit and end transaction
			session.getTransaction().commit();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void update(Student student) {
		try {			
			// begin transaction
			session.beginTransaction();
			
			session.update(student);
			
			session.save(student);
			
			// commit and end transaction
			session.getTransaction().commit();
		} catch(Exception ex) {
			ex.printStackTrace();
		} 
	}
	
	public static void delete(Student student) {
		try {
			// begin transaction
			session.delete(student);
			
			// commit and end transaction
			session.getTransaction().commit();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}

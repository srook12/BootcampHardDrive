package gov.ssa.collections;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import gov.ssa.entities.BaseObject;
import gov.ssa.entities.Major;
//import gov.ssa.entities.Student;

public class BaseObjects extends ArrayList<BaseObject> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static SessionFactory factory;
	static Session session;
	
	static {
		factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Major.class)
//				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory() {
		return factory;
	}
	
	// Base select statement
	public BaseObjects select(String hql) {
		BaseObjects baseObjects = new BaseObjects();
			
		session = factory.getCurrentSession();
		session.beginTransaction();
			
		baseObjects.addAll(session.createQuery(hql).list());
			
		session.getTransaction().commit();
			
		return baseObjects;
	}
	
	// Base insert statement
	public void insert(BaseObject baseObject) {
		session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(baseObject);
		session.getTransaction().commit();
	}
		
	// Base update statement
	public void update(BaseObject baseObject) {
		session = factory.getCurrentSession();
		session.beginTransaction();
		session.update(baseObject);
		session.getTransaction().commit();
	}
		
	public void delete(BaseObject baseObject) {
		session = factory.getCurrentSession();
		session.beginTransaction();

		if(baseObject != null) {
			session.delete(baseObject);
		} else {
			System.out.println("Cannot delete a non-existent entity!\n");
		}
			
		session.getTransaction().commit();
	}
	
	// Polymorphism at work!
	public static String display(List<BaseObject> baseObjects) {
		StringBuffer sb = new StringBuffer();
	
		
		for(BaseObject baseObject : baseObjects) {
			sb.append(baseObject).append("\n");
		}
		sb.append("\n");
		
		return sb.toString();
	}
}

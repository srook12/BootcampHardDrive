package ssa;

import static org.junit.Assert.*;

import org.junit.Test;

public class StudentTest {

	Student student = new Student();
	
	@Test
	public void test() {
		student.printClassRoster();
		String firstName = (Student.classRosterMap).get("001212").firstName;
		assertEquals("Stephen", firstName);
	}

}

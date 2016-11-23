package gov.ssa.test;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import gov.ssa.collections.Majors;
import gov.ssa.entities.Major;

public class MajorsTest {

	Major major1, major2, major3, major4;
	
	Majors majors;
	
	@Before
	public void setUp() throws Exception {
		major1 = new Major("Computer Science", 1350);
		major2 = new Major("English", 1050);
		major3 = new Major("Journalism", 920);
		major4 = new Major("History", 1000);
		
		majors = new Majors();
	}

	@Test
	public void testSelectMajors() {
		;
	}

	@Test
	public void testGetByDescription() {
	}

	@Test
	public void testInsertMajor() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateMajor() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteMajor() {
		fail("Not yet implemented");
	}

	@Test
	public void testDisplayAllMajors() {
		fail("Not yet implemented");
	}

}

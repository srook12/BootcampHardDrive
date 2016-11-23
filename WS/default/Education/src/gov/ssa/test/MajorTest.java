package gov.ssa.test;

import static org.junit.Assert.fail;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import gov.ssa.entities.Major;

import static org.junit.Assert.assertEquals;

public class MajorTest {

	Major major1;
	Major major2;
	Major major3;
		
	@Before
	public void setUp() throws Exception {				
		major1 = new Major();
		major2 = new Major("Computer Science", 1360);
	}

	@Test
	public void testMajor() {
		assertEquals(0, major1.getId());
		assertEquals(null, major1.getDescription());
		assertEquals(0, major1.getReq_sat());
	}

	@Test
	public void testMajorStringInt() {
		assertEquals("Computer Science", major2.getDescription());
		assertEquals(1360, major2.getReq_sat());
	}

	@Test
	public void testGetId() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetId() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDescription() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetDescription() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetReq_sat() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetReq_sat() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}

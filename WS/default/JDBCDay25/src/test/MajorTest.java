package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ssa.gov.major.Major;

public class MajorTest {

	Major major1, major2, major3;
	
	@Before
	public void setUp() throws Exception {
		major1 = new Major();
		major2 = new Major("Computer Science", 1200);
		major3 = new Major(12, "Statistics", 1150);
	}

	@Test
	public void testMajor() {
		assertEquals(null, major1.getDescription());
		assertEquals(0, major1.getReqSat());
	}

	@Test
	public void testMajorStringInt() {
		assertEquals("Computer Science", major2.getDescription());
		assertEquals(1200, major2.getReqSat());
	}

	@Test
	public void testMajorIntStringInt() {
		assertEquals(12, major3.getId());
		assertEquals("Statistics", major3.getDescription());
		assertEquals(1150, major3.getReqSat());
	}

	@Test
	public void testGetId() {
		assertEquals(0, major1.getId());
		assertEquals(-1, major2.getId());
	}

	@Test
	public void testSetId() {
		major1.setId(40);
		assertEquals(40, major1.getId());
	}

	@Test
	public void testGetDescription() {
		assertEquals(null, major1.getDescription());
		assertEquals("Computer Science", major2.getDescription());
		assertEquals("Statistics", major3.getDescription());
	}

	@Test
	public void testSetDescription() {
		major1.setDescription("Art");
		assertEquals("Art", major1.getDescription());
	}

	@Test
	public void testGetReqSat() {
		assertEquals(0, major1.getReqSat());
		assertEquals(1200, major2.getReqSat());
		assertEquals(1150, major3.getReqSat());
	}

	@Test
	public void testSetReqSat() {
		major1.setReqSat(550);
		assertEquals(550, major1.getReqSat());
	}

	@Test
	public void testToString() {
		String formatString = "%-3d   %-20s   %4d";
		
		String toStringMajor1 = String.format(formatString, 0, null, 0);
		String toStringMajor2 = String.format(formatString, -1, "Computer Science", 1200);
		String toStringMajor3 = String.format(formatString, 12, "Statistics", 1150);
		
		assertEquals(toStringMajor1, major1.toString());
		assertEquals(toStringMajor2, major2.toString());
		assertEquals(toStringMajor3, major3.toString());
	}

}

package model;

import static org.junit.Assert.*;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class LaboratoryTest {
   
	private static Laboratory laborator;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		laborator= new Laboratory(5,"5/2/2017",7,9,"mnop1234");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	
//	@Test
//	public void testLaboratoryIntStringIntFloatString() {
//		fail("Not yet implemented");
//	}
	
	
	
	
	@Test
	public void testSetNumber() {
		laborator.setNumber(8);
		assertNotEquals(5,laborator.getNumber());
		assertEquals(8,laborator.getNumber());
		laborator.setNumber(5);
		assertEquals(5,laborator.getNumber());
		assertNotEquals(8,laborator.getNumber());
	}
	
	@Test
	public void testGetNumber() {
		assertEquals(5,laborator.getNumber());
		assertNotEquals(10,laborator.getNumber());
	}


	

	@Test
	public void testGetDate() {
		assertEquals("5/2/2017",laborator.getDate());
		assertNotEquals("5/5/2017",laborator.getDate());
	}

	@Test
	public void testSetDate() {
     laborator.setDate("6/3/2017");
	 assertNotEquals("5/2/2017",laborator.getDate());
     assertEquals("6/3/2017",laborator.getDate());
     laborator.setDate("5/5/2017");
     assertEquals("5/5/2017",laborator.getDate());
     assertNotEquals("3/3/2012",laborator.getDate());
	}


	
	@Test
	public void testSetProblemNumber() {
		laborator.setProblemNumber(8);
		assertNotEquals(7,laborator.getProblemNumber());
		assertEquals(8,laborator.getProblemNumber());
	}
	

	@Test
	public void testGetProblemNumber() {
		assertEquals(8,laborator.getProblemNumber());
		assertNotEquals(10,laborator.getProblemNumber());
	}

	

	@Test
	public void testGetGrade() {
		assertEquals(9,laborator.getGrade());
		assertNotEquals(10,laborator.getGrade());
	}
	
	@Test
	public void testSetGrade() {
		laborator.setGrade(5);
		assertNotEquals(9,laborator.getGrade());
		assertEquals(5,laborator.getGrade());
		laborator.setGrade(9);
		assertEquals(9,laborator.getGrade());
		
	}
	
	

	@Test
	public void testGetStudentRegNumber() {
		assertEquals("mnop1234",laborator.getStudentRegNumber());
		assertNotEquals("test1234",laborator.getStudentRegNumber());
	}

	@Test
	public void testSetStudentRegNumber() {
		laborator.setStudentRegNumber("mnop1234");
		assertNotEquals("asdf1234",laborator.getStudentRegNumber());
		assertEquals("mnop1234",laborator.getStudentRegNumber());
		laborator.setStudentRegNumber("test1234");
		assertEquals("test1234",laborator.getStudentRegNumber());
	}

}

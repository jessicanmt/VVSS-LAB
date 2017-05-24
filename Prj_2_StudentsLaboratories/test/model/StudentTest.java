package model;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class StudentTest {
	
	private static Student student;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		student=new Student("abcd1234","Andreea Popa",1);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testStudentStringStringInt() {
        Student student2=new Student("abcd1234","Andreea Popa",1);
         assertEquals(student2, student);
	}

	@Test
	public void testGetRegNumber() {
		assertEquals("abcd1234",student.getRegNumber());
	}

	@Test
	public void testSetRegNumber() {
		student.setRegNumber("abcd7895");
		assertEquals("abcd7895",student.getRegNumber());
	}

	@Test
	public void testGetName() {
		assertEquals("Andreea Popa",student.getName());
	}

	@Test
	public void testSetName() {
		student.setName("Andreea Test");
		assertNotEquals("Andreea Popa",student.getName());
		assertEquals("Andreea Test", student.getName());
	}

	@Test
	public void testGetGroup() {
		assertEquals(1, student.getGroup());
	}

	@Test
	public void testSetGroup() {
		student.setGroup(731);
		assertNotEquals(1,student.getGroup());
		assertEquals(731, student.getGroup());
	}

}

package repository;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.LaboratoriesController;
import model.Laboratory;
import model.Student;

public class FileDataPersistenceTest {
	
	FileDataPersistence filerepo=new FileDataPersistence("students.txt");

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testGetFile() {
		assertEquals("students.txt", filerepo.getFile());
		assertNotEquals("labo.txt", FileDataPersistence.getFile());
	}


	@Test
	public void testSaveStudent() throws FileNotFoundException {
		Student stud = new Student("vvss1234","Test Test",6);
		assertTrue(FileDataPersistence.saveStudent(stud));
		stud.setName("Jureschi Magda");
		assertTrue(FileDataPersistence.saveStudent(stud));
	}

	@Test
	public void testSaveLaboratory() throws ParseException {
		filerepo.setFile("laboratories.txt");
		
		Laboratory labor = new Laboratory (1,"4/4/2017",7,8,"vvss1234");
		assertTrue(filerepo.saveLaboratory(labor));
		labor.setNumber(10);
		assertTrue(filerepo.saveLaboratory(labor));
	}
	
//	@Test
//	public void testAddGrade() throws NumberFormatException, IOException, ParseException {
//	String regNr= "vvss1234";
//	String labNr="2";
//	 assertTrue(LaboratoriesController.addGrade(regNr,labNr,8));
//	 assertFalse(LaboratoriesController.addGrade(regNr, labNr, -5));
//	 regNr="mnop1234";
//	 assertTrue(LaboratoriesController.addGrade(regNr, labNr, 5));
//	 assertFalse(LaboratoriesController.addGrade(regNr, labNr, -5));
//	}

	


}

package controller;

import static org.junit.Assert.*;

import java.io.IOException;
import java.text.ParseException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Laboratory;
import model.Student;

public class LaboratoriesControllerTest {

	private static Student student;
	private static Laboratory laborator;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	  laborator= new Laboratory(7,"7/3/2017",5,5,"zzzz1234");
	  student=new Student("zzzz1234","Magda Jureschi",4);
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testSaveStudent() {
		Student stud=new Student("test1234","Sanda Lazarean",2);
		assertTrue(LaboratoriesController.saveStudent(stud));
		stud.setRegNumber("123");
		assertFalse(LaboratoriesController.saveStudent(stud));
		stud.setName("123");
		stud.setRegNumber("test1234");
		assertFalse(LaboratoriesController.saveStudent(stud));
		stud.setGroup(200);
		assertFalse(LaboratoriesController.saveStudent(stud));
	}

	@Test
	public void testSaveLaboratory() throws ParseException {
		Laboratory labor= new Laboratory(6,"6/2/2017",7,9,"mnop3445");
		assertTrue(LaboratoriesController.saveLaboratory(labor));
		labor.setNumber(-2);;
		assertFalse(LaboratoriesController.saveLaboratory(labor));
		labor.setNumber(6);
		labor.setProblemNumber(100);
		assertFalse(LaboratoriesController.saveLaboratory(labor));
		
	}

	@Test
	public void testAddGrade() throws NumberFormatException, IOException, ParseException {
	String regNr= student.getRegNumber();
		int lab = laborator.getNumber();
		String labNr=""+lab;
	 assertTrue(LaboratoriesController.addGrade(regNr,labNr,8));
	 assertFalse(LaboratoriesController.addGrade(regNr, labNr, -5));
	 regNr="mnop1234";
	 assertTrue(LaboratoriesController.addGrade(regNr, labNr, 5));
	 assertFalse(LaboratoriesController.addGrade(regNr, labNr, -5));
	}

}

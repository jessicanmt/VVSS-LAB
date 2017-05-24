package validator;
import model.Student;
import model.Laboratory;
import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ValidatorTest {

	private static Student student;
	private static Laboratory laborator;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		student=new Student("grup1234","Magda Jureschi",2);
		laborator= new Laboratory(3,"7/7/2017",6,8,"grup1234");
	}


	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testValidateStudent() {
		assertTrue(Validator.validateStudent(student));
		student.setRegNumber("123");
		assertFalse(Validator.validateStudent(student));
		student.setName("123");
		assertFalse(Validator.validateStudent(student));
		student.setRegNumber("grup1234");
		student.setName("Beniamin Movileanu");
		assertTrue(Validator.validateStudent(student));
		student.setGroup(2000);
		assertFalse(Validator.validateStudent(student));
		student.setGroup(2);
		student.setName("Jessica Neamtu");
		assertTrue(Validator.validateStudent(student));
	}

	@Test
	public void testValidateLaboratory() {
		assertTrue(Validator.validateLaboratory(laborator));
		laborator.setProblemNumber(100);
		assertFalse(Validator.validateLaboratory(laborator));
	    laborator.setProblemNumber(8);
		assertTrue(Validator.validateLaboratory(laborator));
		laborator.setProblemNumber(-1);
		assertFalse(Validator.validateLaboratory(laborator));
		laborator.setProblemNumber(8);
		laborator.setNumber(-2);
		assertFalse(Validator.validateLaboratory(laborator));

		
	}

	@Test
	public void testValidateGrade() {
		assertTrue(Validator.validateGrade(7));
		assertFalse(Validator.validateGrade(1000));
		assertTrue(Validator.validateGrade(9));
		assertFalse(Validator.validateGrade(-9));
	}

}

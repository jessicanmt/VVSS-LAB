package repository;

import model.Laboratory;
import model.Student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileDataPersistence {
    private static  String file;

    public FileDataPersistence(String file) {
        this.file = file;
    }

    public static  String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
    
 /* public boolean existsStudent(String regNumber) throws FileNotFoundException{
  	 File fileA = new File(file);
  
      BufferedReader reader = new BufferedReader(new FileReader(fileA));
    String line;

    try {
		while ((line = reader.readLine()) != null) {
		    String[] temp = line.split(" ");

		    String fileRegNumber = temp[4];
		    if ( fileRegNumber.equals(regNumber)) 
		    	return true;
		   
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    return false;
 }*/
//
//    public boolean existsLaboratory(String regNumber, int labNumber){
//    	
//    }
//    
    public static  boolean saveStudent(Student student) throws FileNotFoundException {
    	//String regNumber=student.getRegNumber();
    	//if(existsStudent(regNumber)==true)
    	//	return false;
        try {
            BufferedWriter writer;
            writer = new BufferedWriter(new FileWriter(file, true));
            writer.write(student.toString() + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    	return true;
    }

    // No check if laboratory is unique
    public static boolean saveLaboratory(Laboratory laboratory) {
    	/*String regNumber=laboratory.getStudentRegNumber();
    	int labNumber=laboratory.getNumber();
    	if(existsLaboratory(regNumber,labNumber)==false)
    		return false;*/
        BufferedWriter writter;
        try {
            writter = new BufferedWriter(new FileWriter(file, true));
            writter.write(laboratory.toString() + "\n");
            writter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    
    public boolean addGrade(String regNumber, String labNumber, int grade)
            throws IOException, NumberFormatException, ParseException {
        File fileA = new File(file);
        File fileB = new File("temp");

        BufferedReader reader = new BufferedReader(new FileReader(fileA));
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileB));

        String line;

        while ((line = reader.readLine()) != null) {
            String[] temp = line.split(" ");
            String fileLabNumber = temp[0];
            String fileRegNumber = temp[4];
            if (fileLabNumber.equals(labNumber) && fileRegNumber.equals(regNumber)) {
                Laboratory laboratory = new Laboratory(
                        Integer.valueOf(temp[0]), temp[1],
                        Integer.valueOf(temp[2]), temp[4]);
                laboratory.setGrade(grade);
                writer.write(laboratory.toString() + "\n");
            } else {
                writer.write(line + "\n");
                return false;
            }
        }
        writer.close();
        reader.close();

        fileA.delete();
        fileB.renameTo(fileA);
        return true;
    }

    public Map<String, List<Laboratory>> getLaboratoryMap()
            throws NumberFormatException, IOException, ParseException {
        BufferedReader reader = new BufferedReader(new FileReader(file));

        Map<String, List<Laboratory>> laboratoryMap = new HashMap<String, List<Laboratory>>();

        String line;

        while ((line = reader.readLine()) != null) {
            String[] temp = line.split(" ");
            Laboratory laboratory = new Laboratory(Integer.valueOf(temp[0]),
                    temp[1], Integer.valueOf(temp[2]), Integer.valueOf(temp[3]),
                    temp[4]);
            if (laboratoryMap.get(laboratory.getStudentRegNumber()) == null) {
                List<Laboratory> laboratoryList = new ArrayList<Laboratory>();
                laboratoryList.add(laboratory);
                laboratoryMap.put(laboratory.getStudentRegNumber(),
                        laboratoryList);
            } else {
                laboratoryMap.get(laboratory.getStudentRegNumber()).add(
                        laboratory);
            }
        }
        return laboratoryMap;
    }

    public List<Student> getStudentsList() throws NumberFormatException,
            IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));

        List<Student> allStudentsList = new ArrayList<Student>();

        String line = null;

        while ((line = reader.readLine()) != null) {
            String[] temp = line.split(" ");
            Student student = new Student(temp[0], temp[1] + temp[2], Integer.valueOf(temp[3]));
            allStudentsList.add(student);
        }

        return allStudentsList;
    }
} 
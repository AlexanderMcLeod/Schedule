package schoolclass;

import java.util.ArrayList;
import java.io.Serializable;

public class SchoolClass implements Serializable{

    private String ID; // Students unique ID number

    public String getID() throws Exception{

        if (ID == null){ // Checks if the ID is not null
            throw new Exception("ID is null");
        }
        if (ID.length() == 0){ // Checks if the ID's length is 0
            throw new Exception("ID has length 0");
        }
        return ID;
    }

    public void setID(final String ID_TO_SET) throws Exception{ // This sets the student ID

        if (ID_TO_SET == null){
            throw new Exception("Tried to set ID of Student as null, previous ID was " + getID());
        }

        if (ID_TO_SET.length() == 0){
            throw new Exception("Tried to set ID of Student with length 0, previous ID was " + getID());
        }

        if (!usesLegalCharacters(ID_TO_SET)){
            throw new Exception("ID " + ID_TO_SET + " uses illegal characters");
        }

        ID = ID_TO_SET; 
    }

    public boolean usesLegalCharacters(final String ID){

        String lowercaseAlphabet = "abcdefghijklmnopqrstuvwxyz";
        String uppercaseAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numberCase = "1234567890";

        String availableLetters = lowercaseAlphabet + uppercaseAlphabet + numberCase;

        for (int IDChar = 0; IDChar < ID.length() - 1; IDChar++){
            for (int availableLetter = 0; availableLetter < availableLetters.length() - 1; availableLetter++){
                if (ID.charAt(IDChar) == (availableLetters.charAt(availableLetter))){
                    return true;
                }
            }
        }
        return false;
    }

    private ArrayList<String> studentList = new ArrayList<String>(); // This contains the ID of the subject selected by the student

    public String getStudentIDByIndex(final int INDEX) throws Exception{

        if (getStudentList().get(INDEX) == null){ // Checks whether subject selection is valid and whether the subject id is too
            throw new Exception("Subject at index " + INDEX + " in class " + getID() + " is null");
        }

        if (getStudentList().get(INDEX).length() == 0){ // Checks whether the subject string is not length 0
            throw new Exception("Subject at index " + INDEX + " in class " + getID() + " has length 0");
        }
        return studentList.get(INDEX);
    }

    public ArrayList<String> getStudentList() throws Exception{

        if (studentList == null){
            throw new Exception("Student list in class " + getID() + " is null");
        }

        if (studentList.isEmpty()){
            throw new Exception("Student list in class " + getID() + " is empty");
        }
        
        return studentList;

    }

    public void addStudent(final String NEW_STUDENT_ID){

        studentList.add(NEW_STUDENT_ID);

    }

    public void removeStudent(final String REMOVED_STUDENT_ID) throws Exception{

        try {
            studentList.remove(REMOVED_STUDENT_ID);
        } catch(Exception e){
            throw e;
        }

    }


}

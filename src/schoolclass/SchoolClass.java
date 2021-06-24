package schoolclass;

import java.util.ArrayList;

public class SchoolClass{

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

    public void setID(final String NEW_ID){ // This sets the student ID
        ID = NEW_ID; 
    }

    private ArrayList<String> studentList = new ArrayList<String>(); // This contains the ID of the subject selected by the student

    public String getStudentID(final int INDEX) throws Exception{

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

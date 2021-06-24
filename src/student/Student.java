package student;

import java.util.ArrayList;

public class Student{

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

    private ArrayList<String> subjectSelection = new ArrayList<String>(); // This contains the ID of the subject selected by the student

    public String getSubjectID(final int INDEX) throws Exception{

        if (getSubjectSelection().get(INDEX) == null){ // Checks whether subject selection is valid and whether the subject id is too
            throw new Exception("Subject for student " + getID() + " at index " + INDEX + "is null");
        }

        if (getSubjectSelection().get(INDEX).length() == 0){ // Checks whether the subject string is not length 0
            throw new Exception("Subject for student " + getID() + " at index " + INDEX + " has length 0");
        }

        return subjectSelection.get(INDEX);

    }

    public ArrayList<String> getSubjectSelection() throws Exception{

        if (subjectSelection == null){
            throw new Exception("Subject selection list for student " + getID() + "is null");
        }

        if (subjectSelection.isEmpty()){
            throw new Exception("Subject selection list for student " + getID() + "is empty");
        }
        
        return subjectSelection;

    }

    public void addSubject(final String NEW_SUBJECT_ID){

        subjectSelection.add(NEW_SUBJECT_ID);

    }

    public void removeSubject(final String REMOVED_SUBJECT_ID) throws Exception{

        try {
            subjectSelection.remove(REMOVED_SUBJECT_ID);
        } catch(Exception e){
            throw e;
        }

    }

    

}
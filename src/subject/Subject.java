package subject;



public class Subject{

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

}
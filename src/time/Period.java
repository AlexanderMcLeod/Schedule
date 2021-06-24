package time;

import java.util.ArrayList;
import java.io.Serializable;

import schoolclass.SchoolClass;

public class Period implements Serializable{

    private String ID;

    public String getID() throws Exception{

        if (ID == null){
            throw new Exception("ID of Period is null");
        }
        if (ID.length() == 0){
            throw new Exception("ID of Period is of length 0");
        }
        return ID;
    }

    public void setID(final String ID_TO_SET) throws Exception{ // This sets the student ID

        if (ID_TO_SET == null){
            throw new Exception("Tried to set ID of Period as null, previous ID was " + getID());
        }

        if (ID_TO_SET.length() == 0){
            throw new Exception("Tried to set ID of Period with length 0, previous ID was " + getID());
        }

        ID = ID_TO_SET; 
    }

    private ArrayList<SchoolClass> schoolClassList = new ArrayList<SchoolClass>();

    public ArrayList<SchoolClass> getSchoolClassList() throws Exception{

        if (schoolClassList == null){
            throw new Exception("School class list for period " + getID() + "is null");
        }
        if (schoolClassList.isEmpty()){
            throw new Exception("School class list for period " + getID() + "is empty");
        }
        return schoolClassList;
    }

    public SchoolClass getSchoolClassID(final int INDEX) throws Exception{

        if (getSchoolClassList().get(INDEX) == null){ // Checks whether subject selection is valid and whether the subject id is too
            throw new Exception("Class for period " + getID() + " at index " + INDEX + "is null");
        }

        return getSchoolClassList().get(INDEX);

    }

    public void addSchoolClass(final SchoolClass NEW_SCHOOLCLASS){

        schoolClassList.add(NEW_SCHOOLCLASS);

    }

    public void removeSchoolClassWithID(final String ID_TO_REMOVE) throws Exception {

        try {
            for (SchoolClass schoolClass : schoolClassList){
                if (schoolClass.getID().equals(ID_TO_REMOVE)){
                    schoolClassList.remove(schoolClass);
                }
            }
        } catch(Exception e) {
            throw e;
        }
    }

    public void removeSchoolClass(final SchoolClass SCHOOLCLASS_TO_REMOVE) throws Exception {

        try {
            schoolClassList.remove(SCHOOLCLASS_TO_REMOVE);
        } catch (Exception e){
            throw e;
        }

    }


}
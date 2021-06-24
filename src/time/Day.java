package time;

import java.util.ArrayList;

public class Day{

    private String ID;

    public String getID() throws Exception{

        if (ID == null){
            throw new Exception("ID of Day is null");
        }
        if (ID.length() == 0){
            throw new Exception("ID of Day is of length 0");
        }
        return ID;
    }

    public void setID(final String ID_TO_SET) throws Exception{ // This sets the student ID

        if (ID_TO_SET == null){
            throw new Exception("Tried to set ID of Day as null, previous ID was " + getID());
        }

        if (ID_TO_SET.length() == 0){
            throw new Exception("Tried to set ID of Day with length 0, previous ID was " + getID());
        }

        ID = ID_TO_SET; 
    }

    private ArrayList<Period> periodList = new ArrayList<Period>();

    public ArrayList<Period> getPeriodList() throws Exception{

        if (periodList == null){
            throw new Exception("Period list for Day " + getID() + "is null");
        }
        if (periodList.isEmpty()){
            throw new Exception("Period list for Day " + getID() + "is empty");
        }
        return periodList;
    }

    public Period getPeriod(final int INDEX) throws Exception{

        if (getPeriodList().get(INDEX) == null){ // Checks whether subject selection is valid and whether the subject id is too
            throw new Exception("Period for day " + getID() + " at index " + INDEX + "is null");
        }

        return getPeriodList().get(INDEX);

    }

    public void addPeriod(final Period NEW_PERIOD){

        periodList.add(NEW_PERIOD);

    }

    public void removePeriodWithID(final String ID_TO_REMOVE) throws Exception {

        try {
            for (Period period : periodList){
                if (period.getID().equals(ID_TO_REMOVE)){
                    periodList.remove(period);
                }
            }
        } catch(Exception e) {
            throw e;
        }
    }

    public void removePeriod(final Period PERIOD_TO_REMOVE) throws Exception {

        try {
            periodList.remove(PERIOD_TO_REMOVE);
        } catch (Exception e){
            throw e;
        }

    }



}
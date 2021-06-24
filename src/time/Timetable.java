package time;

import java.util.ArrayList;

public class Timetable{

    ArrayList<Day> dayList = new ArrayList<Day>();

    public Day getDay(final int INDEX) throws Exception{

        if (getDayList().get(INDEX) == null){
            throw new Exception("Day " + Integer.valueOf(INDEX) + " has value null");
        }
        return dayList.get(INDEX);
    }

    public ArrayList<Day> getDayList() throws Exception{

        if (dayList == null){
            throw new Exception("Day list is null");
        }
        return dayList;
    }

    public void addDay(final Day DAY_TO_ADD){
        dayList.add(DAY_TO_ADD);
    }

    public void removeDayWithID(final String ID_TO_REMOVE) throws Exception {

        try {
            for (Day day : dayList){
                if (day.getID().equals(ID_TO_REMOVE)){
                    dayList.remove(day);
                }
            }
        } catch(Exception e) {
            throw e;
        }
    }

    public void removeDay(final Day DAY_TO_REMOVE) throws Exception {

        try {
            dayList.remove(DAY_TO_REMOVE);
        } catch (Exception e){
            throw e;
        }

    }


}
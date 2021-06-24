package random;

import java.util.Random;
import java.util.ArrayList;

import schedule.Schedule;
import student.Student;
import subject.Subject;
import time.*;

public class RandomID {

    public static String createUniqueRandomID(final Schedule schedule, final int LENGTH) throws Exception{

        String randomID = createRandomID(LENGTH);

        if (isIDInUse(schedule, randomID)){
            return createUniqueRandomID(schedule, LENGTH);
        } else {
            return randomID;
        }
    }

    public static boolean isIDInUse(final Schedule schedule, final String ID_TO_CHECK) throws Exception{

        if (isIDInUseInTimetable(schedule.timetable, ID_TO_CHECK)){
            return true;
        }

        if (isIDInUseByStudent(schedule.getStudentList(), ID_TO_CHECK)){
            return true;
        }

        if (isIDInUseBySubject(schedule.getSubjectList(), ID_TO_CHECK)){
            return true;
        }

        return false;
    }

    public static boolean isIDInUseInTimetable(final Timetable timetable, final String ID_TO_CHECK) throws Exception{

        return isIDInUseInDay(timetable.getDayList(), ID_TO_CHECK);

    }

    public static boolean isIDInUseInDay(final ArrayList<Day> dayList, final String ID_TO_CHECK) throws Exception {

        for (Day day : dayList){

            if (day.getID().equals(ID_TO_CHECK)){
                return true;
            }

            if (isIDInUseInPeriod(day.getPeriodList(), ID_TO_CHECK)){
                return true;
            }

        }

        return false;

    }

    public static boolean isIDInUseInPeriod(final ArrayList<Period> periodList, final String ID_TO_CHECK) throws Exception {

        for (Period period : periodList){
            if (period.getID().equals(ID_TO_CHECK)){
                return true;
            }
        }

        return false;

    }

    public static boolean isIDInUseBySubject(final ArrayList<Subject> subjectList, final String ID_TO_CHECK) throws Exception{

        for (Subject subject : subjectList){
            if (subject.getID().equals(ID_TO_CHECK)){
                return true;
            }
        }
        return false;
    }

    public static boolean isIDInUseByStudent(final ArrayList<Student> studentList, final String ID_TO_CHECK) throws Exception{

        for (Student student : studentList){
            if (student.getID().equals(ID_TO_CHECK)){
                return true;
            }
        }
        return false;
    }

    public static String createRandomID(final int LENGTH){

        StringBuilder randomID = new StringBuilder();

        for (int i = 0; i < LENGTH; i++){
            randomID.append(generateRandomCharacter());
        }

        return randomID.toString();

    }

    public static char generateRandomCharacter(){

        StringBuilder lowercaseAlphabet = new StringBuilder("abcdefghijklmnopqrstuvwxyz");
        StringBuilder uppercaseAlphabet = new StringBuilder("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        StringBuilder numberCase = new StringBuilder("1234567890");

        StringBuilder availableLetters = lowercaseAlphabet.append(uppercaseAlphabet.append(numberCase));

        return availableLetters.charAt(new Random().nextInt(availableLetters.length()));

    }
    
}



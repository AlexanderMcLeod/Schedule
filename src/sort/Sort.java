package sort;

import schedule.Schedule;
import student.Student;
import subject.Subject;
import schoolclass.SchoolClass;
import time.*;
import random.*;

public class Sort {

    public static Schedule sort(Schedule schedule){
        return null;
    }

    public static void main(String[] args) throws Exception{

        long startTime = System.nanoTime();

        Schedule schedule = RandomSchedule.createRandomSchedule("lib/store/whs", 100, 250);

        System.out.println(schedule.getStudentByIndex(0).getSubjectIDByIndex(1));

        schedule.save();
        schedule.update();

        Day newDay = new Day();
        Period newPeriod = new Period();
        SchoolClass newSchoolClass = new SchoolClass();
        
        newSchoolClass.addStudent(schedule.getStudentByIndex(0).getID());
        newPeriod.addSchoolClass(newSchoolClass);
        newDay.addPeriod(newPeriod);
        schedule.addDay(newDay);

        schedule.save();
        schedule.update();

        System.out.println(schedule.getStudentByID(schedule.getStudentInSchoolClassByIndices(0, 0, 0, 0)).getSubjectIDByIndex(1));

        long endTime = System.nanoTime();

        long convertToMilliseconds = 1000000;
        long duration = (endTime - startTime) / convertToMilliseconds;

        System.out.println("Function took " + Long.valueOf(duration) + "ms");

    }
    
}

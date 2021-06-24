package app;

import random.RandomSchedule;
import schedule.Schedule;

public class app {

    public static void main(String[] args) throws Exception{

        Schedule schedule = RandomSchedule.createRandomSchedule("lib/store/whs.txt", 12, 250);
        System.out.println(schedule.getStudentList().get(0).getSubjectSelection().get(0));
        schedule.save();
        schedule.update();

    }
    
}

package random;

import schedule.Schedule;

public class RandomSchedule {

    public static Schedule createRandomSchedule(final int SUBJECT_COUNT, final int STUDENT_COUNT) throws Exception{

        Schedule randomSchedule = new Schedule();

        for (int i = 0; i < SUBJECT_COUNT; i++){
            randomSchedule.addSubject(RandomSubjects.generateRandomSubject(randomSchedule, randomSchedule.getSubjectList()));
        }

        for (int i = 0; i < STUDENT_COUNT; i++){
            randomSchedule.addStudent(RandomStudents.generateRandomStudent(randomSchedule));
        }

        return randomSchedule;

    }
    
}

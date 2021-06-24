package random;

import java.util.ArrayList;
import java.util.Random;

import student.Student;
import schedule.Schedule;
import subject.Subject;

public class RandomStudents {

    public static Student generateRandomStudent(final Schedule schedule) throws Exception{

        Student randomStudent = new Student();

        final int STUDENT_ID_LENGTH = 6;
        randomStudent.setID(RandomID.createUniqueRandomID(schedule, STUDENT_ID_LENGTH));

        final int SUBJECT_SELECTION_COUNT = 5;

        for (int i = 0; i < SUBJECT_SELECTION_COUNT; i++){
            randomStudent.addSubject(generateRandomSubject(schedule.getSubjectList(), randomStudent.getSubjectSelection()));
        }
        
        return randomStudent;
    }

    public static String generateRandomSubject(ArrayList<Subject> scheduleSubjectList, ArrayList<String> studentSubjectList) throws Exception{

        Subject randomSubjectID = scheduleSubjectList.get(new Random().nextInt(scheduleSubjectList.size()));

        if (studentSubjectList.contains(randomSubjectID.getID())){
            return generateRandomSubject(scheduleSubjectList, studentSubjectList);
        } else {
            return randomSubjectID.getID();
        }
    }
    
}

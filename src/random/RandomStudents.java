package random;

import java.util.ArrayList;
import java.util.Random;

import student.Student;
import schedule.Schedule;

public class RandomStudents {

    public static Student generateRandomStudent(final Schedule schedule) throws Exception{

        Student randomStudent = new Student();

        final int STUDENT_ID_LENGTH = 6;
        randomStudent.setID(RandomID.createUniqueRandomID(schedule, STUDENT_ID_LENGTH));

        final int SUBJECT_SELECTION_COUNT = 5;

        for (int i = 0; i < SUBJECT_SELECTION_COUNT; i++){
            randomStudent.addSubject(generateRandomSubject(randomStudent.getSubjectSelection()));
        }
        
        return randomStudent;
    }

    public static String generateRandomSubject(ArrayList<String> subjectList){

        String randomSubjectID = subjectList.get(new Random().nextInt(subjectList.size()));

        if (subjectList.contains(randomSubjectID)){
            return generateRandomSubject(subjectList);
        } else {
            return randomSubjectID;
        }
    }
    
}

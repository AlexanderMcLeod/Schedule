package random;

import java.util.ArrayList;

import subject.Subject;
import schedule.Schedule;

public class RandomSubjects {

    public static ArrayList<Subject> createRandomSubjects(final Schedule schedule, final int SUBJECT_COUNT) throws Exception{

        ArrayList<Subject> subjectList = new ArrayList<Subject>();

        for (int i = 0; i < SUBJECT_COUNT; i++){
            subjectList.add(generateRandomSubject(schedule, subjectList));
        }
        return subjectList;
    }

    public static Subject generateRandomSubject(final Schedule schedule, final ArrayList<Subject> subjectList) throws Exception{

        Subject randomSubject = new Subject();

        final int SUBJECT_ID_LENGTH = 5;
        
        if (subjectList.size() == 0)
        randomSubject.setID(RandomID.createUniqueRandomID(schedule, SUBJECT_ID_LENGTH));

        return randomSubject;

    }

    


    
}

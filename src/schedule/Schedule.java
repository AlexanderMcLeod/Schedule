package schedule;

import java.util.ArrayList;

import random.RandomID;
import student.Student;
import subject.Subject;
import time.Timetable;

public class Schedule {

    private ArrayList<Student> studentList = new ArrayList<Student>();
    private ArrayList<Subject> subjectList = new ArrayList<Subject>();
    
    public Timetable timetable = new Timetable();

    public ArrayList<Student> getStudentList() throws Exception {

        if (studentList == null){
            throw new Exception("Student list has value null");
        }
        return studentList;
    }   

    public ArrayList<Subject> getSubjectList() throws Exception {

        if (subjectList == null){
            throw new Exception("Subject list has value null");
        }
        return subjectList;
    }   

    public Timetable getTimetable() throws Exception{

        if (timetable == null){
            throw new Exception ("Timetable has value of null");
        }
        return timetable;
    }

    public void addStudent(final Student student) throws Exception{

        try {
            student.getID();
        } catch (Exception e){
            final int ID_LENGTH = 7;
            student.setID(RandomID.createUniqueRandomID(this, ID_LENGTH));
        }

        /* Add subject selection generator here
        if there is an error with the subject selection */
        
        studentList.add(student);
    }

    public void removeStudent(final Student student) throws Exception{

        try{
            studentList.remove(student);
        } catch (Exception e){
            throw e;
        }
    }

    public void removeStudentByID(final String ID_TO_BE_REMOVED) throws Exception{

        for (Student student : studentList){
            if (student.getID().equals(ID_TO_BE_REMOVED)){
                studentList.remove(student);
            }
        }

        throw new Exception("No student had ID: " + ID_TO_BE_REMOVED);

    }

    public void addSubject(final Subject subject) throws Exception{

        try {
            subject.getID();
        } catch (Exception e){
            final int ID_LENGTH = 7;
            subject.setID(RandomID.createUniqueRandomID(this, ID_LENGTH));
        }
        subjectList.add(subject);
    }

    public void removeSubject(final Subject subject) throws Exception{

        try{
            subjectList.remove(subject);
        } catch (Exception e){
            throw e;
        }
    }

    public void removeSubjectByID(final String ID_TO_BE_REMOVED) throws Exception{

        for (Subject subject : subjectList){
            if (subject.getID().equals(ID_TO_BE_REMOVED)){
                subjectList.remove(subject);
            }
        }

        throw new Exception("No subject had ID: " + ID_TO_BE_REMOVED);

    }





    
}

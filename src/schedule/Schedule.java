package schedule;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.Serializable;

import random.RandomID;
import schoolclass.SchoolClass;
import student.Student;
import subject.Subject;
import time.*;
import accesslayer.AccessLayer;

public class Schedule implements Serializable{

    private String path;

    private ArrayList<Student> studentList = new ArrayList<Student>();
    private ArrayList<Subject> subjectList = new ArrayList<Subject>();
    
    public Timetable timetable = new Timetable();

    public Schedule(String path){
        this.path = path;
    }

    public void setPath(final String PATH_TO_SET) throws Exception{

        if (PATH_TO_SET == null){
            throw new Exception("Path to set is null");
        }

        if (PATH_TO_SET.length() == 0){
            throw new Exception("Path the set has length 0");
        }
        path = PATH_TO_SET;
    }

    public String getPath() throws Exception{
        if (path == null){
            throw new Exception("Path is null");
        }
        return path;
    }

    public void save() throws IOException{
        AccessLayer.saveSchedule(this, path);
    }

    public void update() throws FileNotFoundException, ClassNotFoundException, IOException {

        Schedule tempSchedule = AccessLayer.getSchedule(path);

        studentList = tempSchedule.studentList;
        subjectList = tempSchedule.subjectList;
        timetable = tempSchedule.timetable;
    }

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

    public Student getStudentByID(final String STUDENT_ID) throws Exception{

        for (Student student: getStudentList()){
            if (student.getID().equals(STUDENT_ID)){
                return student;
            }
        }
        throw new Exception("Student ID " + STUDENT_ID + " was not found");
    }

    public Student getStudentByIndex(final int INDEX) throws Exception {

        if (INDEX > getStudentList().size() - 1){
            throw new Exception("Index " + Integer.valueOf(INDEX) + " in student list is out of bounds");
        }

        if (getStudentList().get(INDEX) == null){
            throw new Exception("Student at index " + Integer.valueOf(INDEX) + " has value of null");
        }

        return getStudentList().get(INDEX);

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

    public Subject getSubjectByID(final String SUBJECT_ID) throws Exception{

        for (Subject subject : getSubjectList()){
            if (subject.getID().equals(SUBJECT_ID)){
                return subject;
            }
        }
        throw new Exception("Subject ID " + SUBJECT_ID + " was not found");
    }

    public Subject getSubjectByIndex(final int INDEX) throws Exception {

        if (INDEX > getSubjectList().size() - 1){
            throw new Exception("Index " + Integer.valueOf(INDEX) + " of subject list is out of bounds");
        }

        if (getSubjectList().get(INDEX) == null){
            throw new Exception("Subject at index " + Integer.valueOf(INDEX) + " in subject list has value of null");
        }

        return getSubjectList().get(INDEX);

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

    public void addDay(Day DAY_TO_ADD){
        timetable.addDay(DAY_TO_ADD);
    }

    public Day getDayByIndex(final int INDEX) throws Exception{
        return timetable.getDayByIndex(INDEX);
    }

    public Period getPeriodByIndices(final int DAY_INDEX, final int PERIOD_INDEX) throws Exception{
        return getDayByIndex(DAY_INDEX).getPeriodByIndex(PERIOD_INDEX);
    }

    public ArrayList<SchoolClass> getSchoolClassListByIndices(final int DAY_INDEX, final int PERIOD_INDEX) throws Exception {
        return getPeriodByIndices(DAY_INDEX, PERIOD_INDEX).getSchoolClassList();
    }

    public SchoolClass getSchoolClassByIndices(final int DAY_INDEX, final int PERIOD_INDEX, final int SCHOOLCLASS_INDEX) throws Exception {
        return getSchoolClassListByIndices(DAY_INDEX, PERIOD_INDEX).get(SCHOOLCLASS_INDEX);
    }

    public String getStudentInSchoolClassByIndices(final int DAY_INDEX, final int PERIOD_INDEX, final int SCHOOLCLASS_INDEX, final int STUDENT_INDEX) throws Exception {
        return getSchoolClassByIndices(DAY_INDEX, PERIOD_INDEX, SCHOOLCLASS_INDEX).getStudentIDByIndex(STUDENT_INDEX);
    }




    
}

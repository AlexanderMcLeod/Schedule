package test;

import java.util.Scanner;

import student.Student;

public class StudentClassTest {

    public static void testCreateEmptyClass(){

        try{
            Student testStudent = new Student();
            System.out.println("Successfully instantiated a student class");
        } catch (Exception e){
            throw e;
        }

    }

    public static void testSetStudentID() throws Exception{

        Student testStudent = new Student();

        try {

            Scanner scan = new Scanner(System.in);
            String ID = (scan.next());
            scan.close();

            testStudent.setID(ID);

            System.out.println("Successfully set the students ID");

        } catch (Exception e){
            throw e;
        }     

    }

    public static String testGetStudentID() throws Exception {

        Student testStudent = new Student();

        testStudent.setID("!@#$@");

        return testStudent.getID();

    }

    

    public static void main(String[] args) throws Exception{
        testGetStudentID();
    }
    
}

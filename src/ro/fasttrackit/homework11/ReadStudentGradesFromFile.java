package ro.fasttrackit.homework11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ReadStudentGradesFromFile {
    public static void main(String[] args) throws Exception {
        ArrayList<StudentGrade> students = readObjectsFromFile ();
        students.forEach (System.out::println);
    }

    public static ArrayList<StudentGrade> readObjectsFromFile() throws Exception {
        ArrayList<StudentGrade> students = new ArrayList<> ();
        BufferedReader fileReader = new BufferedReader (new FileReader ("files/grades.txt"));
        String line;
        while ((line = fileReader.readLine ()) != null) {
            students.add (readStudent (line));
        }
        return students;
    }

    private static StudentGrade readStudent(String studentInfo) {
        String[] studentData = studentInfo.split ("\\|");
        String name = studentData[0];
        String discipline = studentData[1];
        int grade = Integer.parseInt (studentData[2]);

        return new StudentGrade (name, discipline, grade);
    }
}

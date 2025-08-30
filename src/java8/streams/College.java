package java8.streams;

import java.util.ArrayList;

public class College {
    ArrayList<Student> students;

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void generateStudents() {
        students = new ArrayList<>();
        students.add(new Student("101","Abc","M"));
        students.add(new Student("102","DEF","F"));
        students.add(new Student("103","GHI","M"));
    }

}

package java8.streams;

import java.util.Date;

public class Student {
    private String id;
    private String name;
    private String gender;

    public Student(String id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void printStudent() {
        System.out.println("Id:"+this.getId());
        System.out.println("Name:"+this.getName());
        System.out.println("Gender:"+this.getGender());
    }
}

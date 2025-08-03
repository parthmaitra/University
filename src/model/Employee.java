package model;

import java.io.Serializable;
import java.util.UUID;

public class Employee implements Serializable {
    private String name;
    private String id;
    private String dateOfBirth;
    private int salary;

    public Employee() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setId(boolean shouldAutoGenerate) {
        this.setId(generateId());
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    private static String generateId() {
        return UUID.randomUUID().toString();
    }
}

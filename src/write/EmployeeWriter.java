package write;

import model.Employee;
import java.io.*;
import java.util.HashMap;

public class EmployeeWriter {

    public void writeEmployee(Employee e) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("Employee.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(e);
        fileOutputStream.close();
        objectOutputStream.close();
    }

    public Employee readEmployee() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("Employee.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        fileInputStream.close();
        objectInputStream.close();
        return (Employee)objectInputStream.readObject();
    }

    public void writeEmployees(HashMap<String,Employee> employeeList) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("Employees.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(employeeList);
    }

    public HashMap<String,Employee> readEmployees() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream("Employees.txt");
            objectInputStream = new ObjectInputStream(fileInputStream);
            return (HashMap<String, Employee>) objectInputStream.readObject();
        } catch (EOFException e) {
            return new HashMap<>();
        }
    }
}

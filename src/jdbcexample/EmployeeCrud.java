package jdbcexample;

import jdbcexample.dao.EmployeeDao;
import model.Employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.UUID;

public class EmployeeCrud {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static EmployeeDao employeeDao = new EmployeeDao();

    public static void main(String args[]) throws IOException, SQLException {
        while (true) {
            System.out.println("Enter the option from below");
            System.out.println("1. Insert an employee record");
            System.out.println("2. Display all employees");
            System.out.println("3. Search by name");
            System.out.println("4. Delete employee by ID ");
            System.out.println("5. Update the Employee by Salary ");
            int choice = Integer.parseInt(bufferedReader.readLine());
            switch (choice) {
                case 1:
                    Employee employee = createEmployee();
                    employeeDao.insertEmployeeRecord(employee);
                    break;
                case 2:
                    HashMap<String, Employee> employeeHashMap = employeeDao.retrieveEmployees();
                    for (Employee emp : employeeHashMap.values()) {
                        printEmployeeDetails(emp);
                    }
                    break;
                case 3:
                    System.out.println("Enter the name: ");
                    HashMap<String, Employee> employeeHashMap2 = employeeDao.getPersonDetails(bufferedReader.readLine());
                    for (Employee emp : employeeHashMap2.values()) {
                        printEmployeeDetails(emp);
                    }
                    break;
                case 4:
                    System.out.println("Enter the ID ");
                    String id = bufferedReader.readLine();
                    int res = employeeDao.deleteEmployee(id);
                    System.out.println(res + " records affected");
                    break;
                case 5:
                    System.out.println("Enter the ID ");
                    String id1 = bufferedReader.readLine();
                    System.out.println("Enter the Salary ");
                    int salary = Integer.parseInt(bufferedReader.readLine());
                    int res1 = employeeDao.updateSalary(id1, salary);
                    System.out.println(res1 + " records affected");
                    break;
                default:
                    System.exit(0);
            }
        }
    }

    private static Employee createEmployee() throws IOException {
        Employee employee = new Employee();
        employee.setId(UUID.randomUUID().toString());
        System.out.println("Enter the name of the Employee:");
        String name = bufferedReader.readLine();
        employee.setName(name);
        System.out.println("Enter the date of birth:");
        employee.setDateOfBirth(bufferedReader.readLine());
        System.out.println("Enter the salary:");
        int salary = Integer.parseInt(bufferedReader.readLine());
        employee.setSalary(salary);
        return employee;
    }

    private static void printEmployeeDetails(Employee employee) {
        System.out.println("Id:" + employee.getId());
        System.out.println("Name:" + employee.getName());
        System.out.println("Date of birth:" + employee.getDateOfBirth());
        System.out.println("Salary:" + employee.getSalary());
    }
}

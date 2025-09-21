package jdbc.dao;

import java8.streams.Student;
import jdbc.DataSource;
import model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EmployeeDao {
    Connection con = DataSource.getConnection();
    public boolean insertEmployee(Employee employee) throws SQLException {
        PreparedStatement statement = con.prepareStatement("INSERT INTO employees (id, name, date_of_birth, salary) VALUES (?, ?, ?, ?) ");
        statement.setString(1, employee.getId());
        statement.setString(2, employee.getName());
        statement.setString(3,employee.getDateOfBirth());
        statement.setInt(4,employee.getSalary());
        return statement.execute();
    }

    public HashMap<String,Employee> getEmployees() throws SQLException {
        Statement statement = con.createStatement();
        ResultSet executedQuery = statement.executeQuery("Select * from employees");
        HashMap<String,Employee> employees = new HashMap<>();
        while (executedQuery.next()) {
            Employee employee = new Employee();
            employee.setId(executedQuery.getString("id"));
            employee.setName(executedQuery.getString("name"));
            employee.setDateOfBirth(executedQuery.getString("date_of_birth"));
            employee.setSalary(executedQuery.getInt("salary"));
            employees.put(employee.getId(), employee);
        }
        return employees;
    }
}

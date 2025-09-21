package jdbcexample.dao;

import jdbc.DataSource;
import model.Employee;

import java.sql.*;
import java.util.HashMap;

public class EmployeeDao {
    Connection con;

    public EmployeeDao() {
        con = DataSource.getConnection();
    }

    public boolean insertEmployeeRecord(Employee employee) throws SQLException {
        PreparedStatement pts = con.prepareStatement(
                "INSERT INTO employees (id, name, date_of_birth, salary) VALUES (?, ?, ?, ?) ");
        pts.setString(1, employee.getId());
        pts.setString(2, employee.getName());
        pts.setString(3, employee.getDateOfBirth());
        pts.setInt(4, employee.getSalary());
        return pts.execute();
    }

    public HashMap<String, Employee> getPersonDetails(String name) throws SQLException {
        PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM Employees WHERE name=?");
        ps.setString(1, name);
        ResultSet resultSet = ps.executeQuery();
        HashMap<String, Employee> employeeHashMap = new HashMap<>();
        while (resultSet.next()) {
            Employee employee = new Employee();
            employee.setId(resultSet.getString("id"));
            employee.setName(resultSet.getString("name"));
            employee.setDateOfBirth(resultSet.getString("date_of_birth"));
            employee.setSalary(resultSet.getInt("salary"));
            employeeHashMap.put(employee.getId(), employee);
        }
        return employeeHashMap;
    }

    public int deleteEmployee(String id) throws SQLException {
        PreparedStatement pstmt = con.prepareStatement("delete from employees where id=?");
        pstmt.setString(1, id);

        return pstmt.executeUpdate();

    }

    public HashMap<String, Employee> retrieveEmployees() throws SQLException {
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * from employees");
        HashMap<String, Employee> employeeHashMap = new HashMap<>();
        while (resultSet.next()) {
            Employee employee = new Employee();
            employee.setId(resultSet.getString("id"));
            employee.setName(resultSet.getString("name"));
            employee.setDateOfBirth(resultSet.getString("date_of_birth"));
            employee.setSalary(resultSet.getInt("salary"));
            employeeHashMap.put(employee.getId(), employee);
        }
        return employeeHashMap;
    }

    public int updateSalary(String id, int salary) throws SQLException {
        PreparedStatement ps = con.prepareStatement(
                "Update Employees Set salary = ? WHERE id=?");
        ps.setInt(1, salary);
        ps.setString(2, id);
        return ps.executeUpdate();
    }
}

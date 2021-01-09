package com.company;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    private ConnectToDatabase connectToDatabase;
    private Statement statement;

    public EmployeeDAO() throws SQLException, IOException {
        connectToDatabase = new ConnectToDatabase();
        statement = connectToDatabase.getConnection().createStatement();
    }

    public List<Employee> getAllEmployee() throws SQLException {
        List<Employee> employees = new ArrayList<>();

        // Create Query and put All Employees in ResultSet
        String query = "SELECT * FROM `employee`";
        ResultSet employeesSet = statement.executeQuery(query);

        while (employeesSet.next()){
            Employee employee = convertRowToEmployee(employeesSet);
            employees.add(employee);
        }
        return employees;
    }

    public List<Employee> search(String firstName) throws SQLException {
        List<Employee> employees = new ArrayList<>();

        // Create Query get Employees have firstname matches with parameter
        String query = "SELECT * FROM Employee WHERE `firstName` LIKE ?";
        PreparedStatement preparedStatement = connectToDatabase.getConnection().prepareStatement(query);

        // set parameter in Query
        preparedStatement.setString(1,firstName);

        ResultSet employeesSet = preparedStatement.executeQuery();
        while (employeesSet.next()){
            Employee employee = convertRowToEmployee(employeesSet);
            employees.add(employee);
        }
        return employees;
    }

    private Employee convertRowToEmployee(ResultSet row) throws SQLException {
        int id = row.getInt("id");
        String firstName = row.getString("firstname");
        String lastName = row.getString("lastname");
        float salary = row.getFloat("salary");

        return new Employee(id, firstName, lastName, salary);
    }


}

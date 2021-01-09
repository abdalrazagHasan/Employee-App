package com.company;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {

        EmployeeDAO dao = new EmployeeDAO();
        List<Employee> employeesBunch = dao.getAllEmployee();

        for (Employee employee : employeesBunch){
            System.out.println(employee);
        }

    }
}

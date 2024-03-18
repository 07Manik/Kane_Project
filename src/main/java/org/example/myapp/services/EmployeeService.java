package org.example.myapp.services;

import org.example.myapp.entities.Employee;


import java.util.List;


public interface EmployeeService {
        Employee getEmployeeById(int id);

        void saveEmployee(Employee employee);
        List<Employee> getAllEmployees();
        boolean isEmployeeBirthday(String employeeName);
        void updateEmployee(Employee employee);



}

package org.example.myapp.dao;

import org.example.myapp.entities.Employee;

import java.util.List;

public interface EmployeeDao {
    Employee getEmployeeById(int id);

    void saveEmployee(Employee employee);
    void updateEmployee(Employee employee);

    void save(Employee employee);
    void update(Employee employee);

    List<Employee> getAll();

    Employee getById(int id);
}

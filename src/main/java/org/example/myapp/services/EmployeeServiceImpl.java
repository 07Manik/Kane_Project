package org.example.myapp.services;

import org.example.myapp.dao.EmployeeDao;
import org.example.myapp.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @PersistenceContext
    private EntityManager entityManager;

private final EmployeeDao employeeDao;

@Autowired
public EmployeeServiceImpl(EmployeeDao employeeDao) {
    this.employeeDao = employeeDao;
}

@Override
public Employee getEmployeeById(int id) {
    return employeeDao.getById(id);
}

@Override
public void saveEmployee(Employee employee) {
    employeeDao.save(employee);
}

@Override
@Transactional(readOnly = true)
public List<Employee> getAllEmployees() {
    return employeeDao.getAll();
}

    @Override
    public boolean isEmployeeBirthday(String employeeName) {
        Employee employee = getEmployeeByName(employeeName);

        return isBirthdayToday(employee.getBirthdate());    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeDao.update(employee);
    }

    private Employee getEmployeeByName(String employeeName) {
        Employee employee = new Employee();
        employee.setName(employeeName);

        return employee;
    }


    private boolean isBirthdayToday(Date birthdate) {

        String birthdayMonthAndDay = getMonthAndDay(birthdate);
        String todayMonthAndDay = getMonthAndDay(Calendar.getInstance().getTime());
        return birthdayMonthAndDay.equals(todayMonthAndDay);
    }

    private String getMonthAndDay(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return String.format("%02d-%02d", month, day);
    }
}

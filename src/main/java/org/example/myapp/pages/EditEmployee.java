package org.example.myapp.pages;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.example.myapp.entities.Employee;
import org.example.myapp.services.EmployeeService;

import java.util.Date;

public class EditEmployee {

    @Inject
    private EmployeeService employeeService;
    @Property
    private Employee employee;

    @Property
    private String name;
    @Property
    private Date birthdate;
    @Property
    private int age;

    @Property
    private String address;
    @Property
    private String gender;
    @Property
    private String designation;
@Property
private String image;



    void onActivate(Employee employee) {
        this.employee = employee;
    }

    String onPassivate() {
        if (employee != null) {
            return String.valueOf(employee.getId());
        }
        return null;
    }

    Object onSuccessFromEditForm() {
        employeeService.updateEmployee(employee);
        return EmployeeDetails.class;

    }

}

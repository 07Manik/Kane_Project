package org.example.myapp.pages;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.upload.services.UploadedFile;
import org.example.myapp.entities.Employee;
import org.example.myapp.services.EmployeeService;

import java.io.File;
import java.util.Date;

public class EmployeeAdd {
    @Inject
private EmployeeService employeeService;

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
private  String designation;
@Property
private UploadedFile image;


@Component
private Form employeeForm;




Object onSuccessFromEmployeeForm() {

    File file = new File("C://Users//Manik//Downloads//Project//Kane_TapestryAssignment-main//java-web-project//src//main//webapp//images//"+ image.getFileName());
    image.write(file);

    employeeService.saveEmployee(new Employee(age, name, address, gender, birthdate, designation,image.getFileName()));
    return EmployeeDetails.class;

}



}
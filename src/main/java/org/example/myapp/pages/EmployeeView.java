//package org.example.myapp.pages;
//
//
//import org.apache.tapestry5.annotations.OnEvent;
//import org.apache.tapestry5.annotations.Property;
//import org.apache.tapestry5.ioc.annotations.Inject;
//import org.apache.tapestry5.services.javascript.JavaScriptSupport;
//import org.example.myapp.dao.EmployeeDao;
//import org.example.myapp.dao.UserDao;
//import org.example.myapp.entities.Employee;
//
//
//public class EmployeeDetailPage {
//    @Inject
//    private UserDao userDao;
//
//    @Property
//    private Employee employee;
//
//    void onActivate(Employee employee) {
//        this.employee = employee;
//    }
//
//    String onPassivate() {
//        if (employee != null) {
//            return String.valueOf(employee.getId());
//        }
//        return null;
//    }
//
//    public String getPageTitle() {
//        return (employee != null) ? "Employee Details - " + employee.getName() : "Employee Details";
//    }
//
//    @Property
//    private String employeeImage;
//
//    @Property
//    private String designation;
//
//    @Inject
//    private JavaScriptSupport javaScriptSupport;
//
//    @ActionLink
//    public void showImage() {
//        employeeImage = "/images/employee.jpg";
//        javaScriptSupport.addScript("$('#imagePopup').modal('show');");
//    }
//
//    @OnEvent(value = "promoteLink")
//    public void promoteEmployee() {
//        EmployeeDao employeeService = null;
//        employee = employeeService.getEmployeeById(employee.getId());
//        employee.setDesignation("Manager"); // Assuming the designation is updated to "Manager"
//        designation = employee.getDesignation(); // Update the designation property
//    }
//
//}


package org.example.myapp.pages;


import org.apache.tapestry5.Asset;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Path;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.ajax.AjaxResponseRenderer;
import org.example.myapp.dao.EmployeeDao;
import org.example.myapp.dao.UserDao;
import org.example.myapp.entities.Employee;
import org.got5.tapestry5.jquery.components.Dialog;

import java.util.Date;

public class EmployeeView {
    @Inject
    private UserDao userDao;


    @Inject
    private EmployeeDao employeeDao;


    @Property
    private Employee employee;

    void onActivate(Employee employee) {
        this.employee = employee;
    }

    String onPassivate() {
        if (employee != null) {
            return String.valueOf(employee.getId());
        }
        return null;
    }

    public String getPageTitle() {
        return (employee != null) ? "Employee Details - " + employee.getName() : "Employee Details";
    }

    @Property
    private String employeeImage;

    @Property
    private String designation;

    @Property
    @Path("context:images/edit-text.png")
    private Asset asset;

    public String getImage() {
        return employee.getImage();
    }


}

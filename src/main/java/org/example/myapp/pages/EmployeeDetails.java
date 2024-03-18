package org.example.myapp.pages;

import org.apache.tapestry5.annotations.*;

import org.apache.tapestry5.http.services.Session;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.example.myapp.dao.UserDao;
import org.example.myapp.entities.Employee;
import org.example.myapp.services.EmployeeService;

import java.util.List;

public class EmployeeDetails {
@Inject
private EmployeeService employeeService;

@Inject
private PageRenderLinkSource linkSource;

@Property
private Employee employee;

@Property
@SessionAttribute("username")
private  String username;

    @Inject
    @SessionState
    private Session session;

@Property
private boolean isAdmin;

@Property
private List<Employee> employees;



@InjectPage
private EmployeeAdd employeeAdd;

    @Inject
    private UserDao userDao;

public Object onAddEmployee() {
    return employeeAdd;
}

void setupRender(){
    this.employees=employeeService.getAllEmployees();


    if (username != null && userDao != null) {
        isAdmin = userDao.isAdmin(username);
    } else {

        isAdmin = false;
    }
}
    public boolean isAdmin() {
        String role = userDao.getUserRole(username);
        return "Admin".equalsIgnoreCase(role);
    }

    public void setUserRoles(List<String> userRoles) {
    }
}

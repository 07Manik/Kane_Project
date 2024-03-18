
package org.example.myapp.pages;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.TextField;

import org.apache.tapestry5.http.Link;
import org.apache.tapestry5.http.services.Session;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.example.myapp.services.UserService;


public class Login {
    public String getMessage() {
        return "server time: " + new java.util.Date() + ".";
    }


    @Inject
    private PageRenderLinkSource pageRenderLinkSource;

    @Component
    private Form form;

    @Component(id = "username")
    private TextField usernameField;

    @Component(id = "password")
    private TextField passwordField;

    @Property
    @SessionAttribute
    private String username;

    @Property
    private String password;


    @Property
    private String errorMessage;

    @Inject
    private UserService userService;






    void onValidateFromForm() {
        if (!userService.checkusernameandpassword(username,password)) {
            errorMessage = "Invalid username or password.";
            form.recordError("Invalid login.");
        }
    }

    Object onSuccess() {
        Link link=pageRenderLinkSource.createPageRenderLinkWithContext(EmployeeDetails.class);

        return link;
  }
}



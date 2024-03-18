package org.example.myapp.components;

import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.example.myapp.entities.Employee;

import java.util.Calendar;



public class WishBanner {
    @Parameter(required = true)
    @Property
    private Employee employee;




    public boolean isEmployeeBirthday() {
        Calendar today = Calendar.getInstance();
        Calendar birthdate = Calendar.getInstance();
        birthdate.setTime(employee.getBirthdate());

        return today.get(Calendar.MONTH) == birthdate.get(Calendar.MONTH) &&
                today.get(Calendar.DAY_OF_MONTH) == birthdate.get(Calendar.DAY_OF_MONTH);
    }

    public String getColor(){
        if(employee.getGender().equals("Female")){
            return "background-color:pink";
        }else {
            return "background-color:blue";
        }
    }
}

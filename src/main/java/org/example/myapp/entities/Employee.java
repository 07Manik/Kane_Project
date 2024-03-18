package org.example.myapp.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employees")
public class Employee {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

@Column(name = "age")
private int age;

@Column(name = "name")
private String name;

@Column(name = "address")
private String address;
@Column (name ="gender")
private String gender;

@Column (name ="birthdate")
private Date birthdate;

@Column(name ="designation")
private String designation;
@Column(name="image")
private  String image;

public Employee() {

}


public Employee(int age, String name, String address, String gender, Date birthdate, String designation, String image) {
this.age = age;
this.name = name;
this.address = address;
this.gender = gender;
this.birthdate = birthdate;
this.designation = designation;
this.image = image;
}


public int getId() {
return id;
}

public void setId(int id) {
this.id = id;
}

public int getAge() {
return age;
}

public void setAge(int age) {
this.age = age;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getAddress() {
return address;
}

public void setAddress(String address) {
this.address = address;
}
public  String getGender(){
    return gender;
}
public void setGender(String gender){
    this.gender = gender;
}
    public Date getBirthdate(){
        return birthdate;
    }
    public void setBirthdate(Date birthdate){
        this.birthdate = birthdate;
    }
    public String getDesignation(){
        return designation;
    }
    public void setDesignation(String designation){
        this.designation = designation;
    }
    public String getImage(){
        return image;
    }
    public void setImage(String image){
        this.image = image;
    }
@Override
public String toString() {
return "Employee{" +
        "id=" + id +
        ", age=" + age +
        ", name='" + name + '\'' +
        ", address='" + address + '\'' +
        ", gender='" + gender + '\''+
        ", birthdate='" + birthdate + '\''+
        ", designation='" + designation + '\'' +
        ", image='" + image + '\'' +
        '}';
}
}

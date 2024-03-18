package org.example.myapp.services;

public interface UserService {
    boolean checkusernameandpassword(String username,String password);
    String getUserRole(String current_user);
}

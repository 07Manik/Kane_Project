package org.example.myapp.dao;

public interface UserDao {
    boolean checkusernameandpassword(String username,String password);

    String getUserRole(String current_user);

    boolean isAdmin(String username);
}

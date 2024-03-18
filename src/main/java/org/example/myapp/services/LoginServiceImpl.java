package org.example.myapp.services;

public class LoginServiceImpl implements LoginService {

@Override
public boolean validateLogin(String username, String password) {
    if (username != null && !username.isEmpty() && password != null && !password.isEmpty()) {
        return username.equals("admin") && password.equals("password");
    }
    return false;
}
}






package org.example.myapp.services;

import org.example.myapp.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService{

    private final UserDao userDao;
    @Autowired
    public UserServiceImpl(UserDao userDao){
        this.userDao=userDao;
    }
    @Override
    @Transactional(readOnly = true)
    public boolean checkusernameandpassword(String username, String password) {
        return userDao.checkusernameandpassword(username,password);
    }
    @Transactional(readOnly = true)
    @Override
    public String getUserRole(String current_user) {
        return userDao.getUserRole(current_user);
    }
}

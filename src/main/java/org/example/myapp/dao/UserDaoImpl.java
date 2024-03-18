package org.example.myapp.dao;

import org.example.myapp.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{

    private final SessionFactory sessionFactory;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public boolean checkusernameandpassword(String username, String password) {
        Session session=sessionFactory.getCurrentSession();
        String query="from User where username=:username and password=:password";
        User user=session.createQuery(query, User.class)
                .setParameter("username",username)
                .setParameter("password",password)
                .uniqueResult();
        if (user == null){
            return false;
        }
        else {
            return true;
        }
    }

    public String getUserRole(String username){
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();


            String query="select role from User where username=:username";
            return (String)  session.createQuery(query)
                    .setParameter("username",username)
                    .uniqueResult();
        }
        catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }
    }

    @Override
    public boolean isAdmin(String username) {
        return false;
    }

}

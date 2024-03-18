package org.example.myapp.dao;

import org.example.myapp.entities.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {


private final SessionFactory sessionFactory;

@Autowired
public EmployeeDaoImpl(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
}

@Override
public Employee getEmployeeById(int id) {
    try (Session session = sessionFactory.openSession()) {
        return session.get(Employee.class, id);
    }
}

@Override
public void saveEmployee(Employee employee) {
    save(employee);
}

public void updateEmployee(Employee employee){
    update(employee);
}
@Override
public void save(Employee employee) {

    Session session = sessionFactory.openSession();
    Transaction tx = session.beginTransaction();
    session.save(employee);
    tx.commit();
}

@Override
@Transactional
public void update(Employee employee){
    Session session = sessionFactory.openSession();
    Transaction tx = null;
    try {
        tx = session.beginTransaction();
        String hqlUpdate = "update Employee set name = :name, designation=:designation, address = :address, age = :age, gender= :gender, birthdate =:birthdate where id = :id";
        int updatedEntities = session.createQuery( hqlUpdate )
                .setParameter( "name", employee.getName())
                .setParameter( "id", employee.getId() )
                .setParameter("gender",employee.getGender())
                .setParameter("address",employee.getAddress())
                .setParameter("birthdate",employee.getBirthdate())
                .setParameter("age",employee.getAge())
                .setParameter("designation",employee.getDesignation())

                .executeUpdate();
        tx.commit();
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
public List<Employee> getAll() {
    Session session=sessionFactory.getCurrentSession();
    return session.createQuery("from Employee").list();
}

@Override
public Employee getById(int id) {
    return null;
}
}

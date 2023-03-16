package by.javatest.task3.repository.impl;

import by.javatest.task3.entity.Login;
import by.javatest.task3.repository.LoginDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LoginDaoImpl implements LoginDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Login> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Login", Login.class);
        List<Login> logins = query.getResultList();
        return logins;
    }

    @Override
    public void saveAll(List<Login> logins) {
        Session session = sessionFactory.getCurrentSession();
        for (Login login : logins) {
            session.save(login);
        }
    }
}

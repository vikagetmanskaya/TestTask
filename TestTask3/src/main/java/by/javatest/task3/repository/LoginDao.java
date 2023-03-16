package by.javatest.task3.repository;

import by.javatest.task3.entity.Login;

import java.util.List;

public interface LoginDao {
    List<Login> findAll();

    void saveAll(List<Login> logins);
}

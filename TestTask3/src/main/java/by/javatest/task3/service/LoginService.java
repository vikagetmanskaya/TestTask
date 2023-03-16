package by.javatest.task3.service;

import by.javatest.task3.entity.Login;

import java.io.IOException;
import java.util.List;

public interface LoginService {
    List<Login> readLoginsFromCSV() throws IOException;

    void saveLogins(List<Login> logins);

    List<Login> getLogins();
}

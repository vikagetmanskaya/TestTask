package by.javatest.task3.helper;

import by.javatest.task3.entity.Login;
import by.javatest.task3.entity.Posting;

import java.io.InputStream;
import java.util.List;

public interface CSVHelper {

    List<Login> readCSVLogin(InputStream is);

    List<Posting> readCSVPosting(InputStream is);
}

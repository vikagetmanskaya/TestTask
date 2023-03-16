package by.javatest.task3.service;


import by.javatest.task3.entity.Posting;

import java.io.IOException;
import java.util.List;

public interface PostingService {
    List<Posting> readPostingsFromCSV() throws IOException;

    void savePostings(List<Posting> postings);

    List<Posting> findByParameter(Integer year, Integer month, Integer day, Boolean authorizedPosting);

}

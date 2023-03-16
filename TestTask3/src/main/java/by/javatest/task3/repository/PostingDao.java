package by.javatest.task3.repository;


import by.javatest.task3.entity.Posting;


import java.util.List;

public interface PostingDao {
    void saveAll(List<Posting> postings);

    List<Posting> findByParameter(Integer day, Integer year, Integer month, Boolean authorizedPosting);


}

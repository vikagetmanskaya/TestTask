package by.javatest.task3.repository.impl;

import by.javatest.task3.entity.Posting;
import by.javatest.task3.repository.PostingDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class PostingDaoImpl implements PostingDao {
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void saveAll(List<Posting> postings) {
        Session session = sessionFactory.getCurrentSession();
        for (Posting posting : postings) {
            session.save(posting);
        }

    }


    @Override
    public List<Posting> findByParameter(Integer year, Integer month, Integer day, Boolean authorizedPosting) {

        Session session = sessionFactory.getCurrentSession();
        if (day == null && month == null && year == null && authorizedPosting == null) {
            Query query = session.createQuery("from Posting", Posting.class);
            List<Posting> postings = query.getResultList();
            return postings;
        } else if (day == null && month == null && year == null) {
            Query query = session.createQuery("from Posting " +
                    "where authorizedPosting=:authorizedPosting");
            query.setParameter("authorizedPosting", authorizedPosting);
            List<Posting> postings = query.getResultList();
            return postings;
        } else if (day == null && month == null && authorizedPosting == null) {
            Query query = session.createQuery("from Posting " +
                    "where year(postingDate)=:year");

            query.setParameter("year", year);
            List<Posting> postings = query.getResultList();
            return postings;
        } else if (day == null && month == null) {
            Query query = session.createQuery("from Posting " +
                    "where year(postingDate)=:year and authorizedPosting=:authorizedPosting");
            query.setParameter("year", year);
            query.setParameter("authorizedPosting", authorizedPosting);
            List<Posting> postings = query.getResultList();
            return postings;
        } else if (day == null && authorizedPosting == null) {
            Query query = session.createQuery("from Posting " +
                    "where year(postingDate)=:year and month(postingDate)=:month");

            query.setParameter("year", year);
            query.setParameter("month", month);
            List<Posting> postings = query.getResultList();
            return postings;
        } else if (day == null) {
            Query query = session.createQuery("from Posting " +
                    "where year(postingDate)=:year and month(postingDate)=:month " +
                    "and authorizedPosting=:authorizedPosting");

            query.setParameter("year", year);
            query.setParameter("month", month);
            query.setParameter("authorizedPosting", authorizedPosting);
            List<Posting> postings = query.getResultList();
            return postings;
        } else if (authorizedPosting == null) {
            Query query = session.createQuery("from Posting " +
                    "where year(postingDate)=:year and month(postingDate)=:month " +
                    "and day(postingDate)=:day");

            query.setParameter("year", year);
            query.setParameter("month", month);
            query.setParameter("day", day);
            List<Posting> postings = query.getResultList();
            return postings;
        }
        Query query = session.createQuery("from Posting " +
                "where year(postingDate)=:year and month(postingDate)=:month " +
                "and day(postingDate)=:day and authorizedPosting=:authorizedPosting");

        query.setParameter("year", year);
        query.setParameter("month", month);
        query.setParameter("day", day);
        query.setParameter("authorizedPosting", authorizedPosting);
        List<Posting> postings = query.getResultList();
        return postings;

    }
}

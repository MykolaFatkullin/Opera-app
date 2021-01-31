package com.tickets.dao.impl;

import com.tickets.dao.MovieSessionDao;
import com.tickets.exception.DataProcessingException;
import com.tickets.lib.Dao;
import com.tickets.model.MovieSession;
import com.tickets.util.HibernateUtil;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

@Dao
public class MovieSessionDaoImpl implements MovieSessionDao {
    @Override
    public MovieSession add(MovieSession movieSession) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(movieSession);
            transaction.commit();
            return movieSession;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert Movie Session entity: "
                    + movieSession, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<MovieSession> query = session.createQuery("FROM movie_session "
                    + "WHERE movie.id = :movieId AND showTime "
                    + "BETWEEN :timeStart AND :timeEnd", MovieSession.class);
            query.setParameter("movieId", movieId);
            query.setParameter("timeStart", date.atStartOfDay());
            query.setParameter("timeEnd", date.atTime(LocalTime.MAX));
            return query.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't find sessions by parameters: "
                    + "movieId = " + movieId + " date:" + date, e);
        }
    }
}

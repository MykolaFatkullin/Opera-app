package com.opera.dao.impl;

import com.opera.dao.PerformanceSessionDao;
import com.opera.exception.DataProcessingException;
import com.opera.model.PerformanceSession;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class PerformanceSessionDaoImpl implements PerformanceSessionDao {
    private final SessionFactory sessionFactory;

    public PerformanceSessionDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public PerformanceSession add(PerformanceSession performanceSession) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(performanceSession);
            transaction.commit();
            return performanceSession;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert performance session entity: "
                    + performanceSession, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<PerformanceSession> findAvailableSessions(Long performanceId, LocalDate date) {
        try (Session session = sessionFactory.openSession()) {
            Query<PerformanceSession> query = session.createQuery("FROM PerformanceSession "
                    + "WHERE performance.id = :performanceId AND showTime "
                    + "BETWEEN :timeStart AND :timeEnd", PerformanceSession.class);
            query.setParameter("performanceId", performanceId);
            query.setParameter("timeStart", date.atStartOfDay());
            query.setParameter("timeEnd", date.atTime(LocalTime.MAX));
            return query.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't find sessions by parameters: "
                    + "performanceId = " + performanceId + " date:" + date, e);
        }
    }

    @Override
    public void update(PerformanceSession performanceSession) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(performanceSession);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't update performance session entity: "
                    + performanceSession, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void delete(Long id) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            PerformanceSession performanceSession = session.load(PerformanceSession.class, id);
            session.delete(performanceSession);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't delete performance session entity by id: "
                    + id, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Optional<PerformanceSession> getById(Long movieSessionId) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.get(PerformanceSession.class, movieSessionId));
        } catch (Exception e) {
            throw new DataProcessingException("Can't get performance session by id "
                    + movieSessionId, e);
        }
    }
}

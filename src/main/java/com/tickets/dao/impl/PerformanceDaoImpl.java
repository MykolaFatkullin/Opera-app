package com.tickets.dao.impl;

import com.tickets.dao.PerformanceDao;
import com.tickets.exception.DataProcessingException;
import com.tickets.model.Performance;
import java.util.List;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class PerformanceDaoImpl implements PerformanceDao {
    private final SessionFactory sessionFactory;

    public PerformanceDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Performance add(Performance performance) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(performance);
            transaction.commit();
            return performance;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert performance entity: " + performance, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Performance> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Performance", Performance.class).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get all performances", e);
        }
    }

    @Override
    public Optional<Performance> getById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.get(Performance.class, id));
        } catch (Exception e) {
            throw new DataProcessingException("Can't get performance by id: " + id, e);
        }
    }
}

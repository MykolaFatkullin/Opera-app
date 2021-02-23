package com.tickets.dao.impl;

import com.tickets.dao.StageHallDao;
import com.tickets.exception.DataProcessingException;
import com.tickets.model.Stage;
import java.util.List;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class StageHallDaoImpl implements StageHallDao {
    private final SessionFactory sessionFactory;

    public StageHallDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Stage add(Stage stage) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(stage);
            transaction.commit();
            return stage;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert stage entity: " + stage, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Stage> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Stage> getAllCinemaHalls = session
                    .createQuery("from Stage", Stage.class);
            return getAllCinemaHalls.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get all stages", e);
        }
    }

    @Override
    public Optional<Stage> getById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.get(Stage.class, id));
        } catch (Exception e) {
            throw new DataProcessingException("Can't get stage by id " + id, e);
        }
    }
}

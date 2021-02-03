package com.tickets.dao.impl;

import com.tickets.dao.TicketDao;
import com.tickets.exception.DataProcessingException;
import com.tickets.lib.Dao;
import com.tickets.model.Ticket;
import com.tickets.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Dao
public class TicketDaoImpl implements TicketDao {
    @Override
    public Ticket add(Ticket ticket) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.persist(ticket);
            transaction.commit();
            return ticket;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert Ticket entity: " + ticket, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}

package com.tickets.service.model.impl;

import com.tickets.dao.PerformanceSessionDao;
import com.tickets.model.PerformanceSession;
import com.tickets.service.model.PerformanceSessionService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PerformanceSessionServiceImpl implements PerformanceSessionService {
    private final PerformanceSessionDao performanceSessionDao;

    public PerformanceSessionServiceImpl(PerformanceSessionDao performanceSessionDao) {
        this.performanceSessionDao = performanceSessionDao;
    }

    @Override
    public PerformanceSession add(PerformanceSession performanceSession) {
        return performanceSessionDao.add(performanceSession);
    }

    @Override
    public List<PerformanceSession> findAvailableSessions(Long performanceId, LocalDate date) {
        return performanceSessionDao.findAvailableSessions(performanceId, date);
    }

    @Override
    public void update(PerformanceSession performanceSession) {
        performanceSessionDao.update(performanceSession);
    }

    @Override
    public void delete(Long id) {
        performanceSessionDao.delete(id);
    }

    @Override
    public PerformanceSession getById(Long performanceSessionId) {
        return performanceSessionDao.getById(performanceSessionId)
                .orElseThrow(RuntimeException::new);
    }
}

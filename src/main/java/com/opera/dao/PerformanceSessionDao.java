package com.opera.dao;

import com.opera.model.PerformanceSession;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PerformanceSessionDao {
    PerformanceSession add(PerformanceSession performanceSession);

    List<PerformanceSession> findAvailableSessions(Long performanceId, LocalDate date);

    void update(PerformanceSession performanceSession);

    void delete(Long id);

    Optional<PerformanceSession> getById(Long performanceSessionId);
}

package com.opera.service.model;

import com.opera.model.PerformanceSession;
import java.time.LocalDate;
import java.util.List;

public interface PerformanceSessionService {
    PerformanceSession add(PerformanceSession performanceSession);

    List<PerformanceSession> findAvailableSessions(Long performanceId, LocalDate date);

    void update(PerformanceSession performanceSession);

    void delete(Long id);

    PerformanceSession getById(Long performanceSessionId);
}

package com.tickets.dao;

import com.tickets.model.Performance;
import java.util.List;
import java.util.Optional;

public interface PerformanceDao {
    Performance add(Performance performance);

    List<Performance> getAll();

    Optional<Performance> getById(Long id);
}

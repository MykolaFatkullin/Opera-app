package com.tickets.service.model;

import com.tickets.model.Performance;
import java.util.List;

public interface PerformanceService {
    Performance add(Performance performance);

    List<Performance> getAll();

    Performance getById(Long id);
}

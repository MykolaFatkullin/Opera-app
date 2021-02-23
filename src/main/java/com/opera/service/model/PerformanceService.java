package com.opera.service.model;

import com.opera.model.Performance;
import java.util.List;

public interface PerformanceService {
    Performance add(Performance performance);

    List<Performance> getAll();

    Performance getById(Long id);
}

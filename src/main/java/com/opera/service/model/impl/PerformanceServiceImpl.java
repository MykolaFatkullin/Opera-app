package com.opera.service.model.impl;

import com.opera.dao.PerformanceDao;
import com.opera.model.Performance;
import com.opera.service.model.PerformanceService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PerformanceServiceImpl implements PerformanceService {
    private final PerformanceDao performanceDao;

    public PerformanceServiceImpl(PerformanceDao performanceDao) {
        this.performanceDao = performanceDao;
    }

    @Override
    public Performance add(Performance performance) {
        return performanceDao.add(performance);
    }

    @Override
    public List<Performance> getAll() {
        return performanceDao.getAll();
    }

    @Override
    public Performance getById(Long id) {
        return performanceDao.getById(id).orElseThrow(RuntimeException::new);
    }
}

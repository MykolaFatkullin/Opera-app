package com.tickets.service.model.impl;

import com.tickets.dao.StageHallDao;
import com.tickets.model.Stage;
import com.tickets.service.model.StageService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class StageServiceImpl implements StageService {
    private final StageHallDao stageHallDao;

    public StageServiceImpl(StageHallDao stageHallDao) {
        this.stageHallDao = stageHallDao;
    }

    @Override
    public Stage add(Stage stage) {
        return stageHallDao.add(stage);
    }

    @Override
    public List<Stage> getAll() {
        return stageHallDao.getAll();
    }

    @Override
    public Stage getById(Long id) {
        return stageHallDao.getById(id).orElseThrow(RuntimeException::new);
    }
}

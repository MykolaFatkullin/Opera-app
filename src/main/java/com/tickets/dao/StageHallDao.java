package com.tickets.dao;

import com.tickets.model.Stage;
import java.util.List;
import java.util.Optional;

public interface StageHallDao {
    Stage add(Stage stage);

    List<Stage> getAll();

    Optional<Stage> getById(Long id);
}

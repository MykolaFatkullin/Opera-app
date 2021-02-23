package com.opera.service.model;

import com.opera.model.Stage;
import java.util.List;

public interface StageService {
    Stage add(Stage stage);

    List<Stage> getAll();

    Stage getById(Long id);
}

package com.opera.model.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class StageRequestDto {
    @Min(value = 1, message = "Incorrect capacity, minimum 1")
    private int capacity;
    @NotNull
    private String description;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

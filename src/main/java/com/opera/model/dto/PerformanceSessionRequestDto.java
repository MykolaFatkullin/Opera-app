package com.opera.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class PerformanceSessionRequestDto {
    @Min(value = 1, message = "Incorrect movie Id, minimum 1")
    private Long performanceId;
    @Min(value = 1, message = "Incorrect cinema hall Id, minimum 1")
    private Long stageId;
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm")
    @NotNull
    private LocalDateTime showTime;

    public Long getPerformanceId() {
        return performanceId;
    }

    public void setPerformanceId(Long performanceId) {
        this.performanceId = performanceId;
    }

    public Long getStageId() {
        return stageId;
    }

    public void setStageId(Long stageId) {
        this.stageId = stageId;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }

}

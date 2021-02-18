package com.tickets.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import jakarta.validation.constraints.Min;
import java.time.LocalDateTime;

public class MovieSessionRequestDto {
    @Min(value = 1, message = "Incorrect movie Id, minimum 1")
    private Long movieId;
    @Min(value = 1, message = "Incorrect cinema hall Id, minimum 1")
    private Long cinemaHallId;
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm")
    @NotNull
    private LocalDateTime showTime;

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Long getCinemaHallId() {
        return cinemaHallId;
    }

    public void setCinemaHallId(Long cinemaHallId) {
        this.cinemaHallId = cinemaHallId;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }

}

package com.tickets.model.dto;

public class MovieSessionRequestDto {
    private String movieId;
    private String cinemaHallId;
    private String showTime;

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getCinemaHallId() {
        return cinemaHallId;
    }

    public void setCinemaHallId(String cinemaHallId) {
        this.cinemaHallId = cinemaHallId;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

}

package ru.afanasiev.domain;

import lombok.Data;

@Data
public class Rating {
    private double kp;
    private double imdb;
    private double filmCritics;
    private double russianFilmCritics;

    public double[] toDoubleArray() {
        return new double[]{kp, imdb, filmCritics, russianFilmCritics};
    }
}

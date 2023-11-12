package ru.afanasiev.domain;

import lombok.Data;

@Data
public class MovieDataSet {
    public static int DATA_ROW_SIZE = 4;

    private Rating rating;
    private double score;

    public double[] toDoubleArray() {
        return rating.toDoubleArray();
    }
}

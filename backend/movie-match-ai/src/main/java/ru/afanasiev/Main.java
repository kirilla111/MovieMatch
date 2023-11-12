package ru.afanasiev;

import org.neuroph.core.Layer;
import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.Neuron;
import org.neuroph.core.data.DataSet;
import org.neuroph.core.data.DataSetRow;
import org.neuroph.nnet.learning.BackPropagation;
import org.neuroph.util.ConnectionFactory;
import org.neuroph.util.NeuralNetworkType;
import ru.afanasiev.app.impl.MatchEngine;
import ru.afanasiev.app.impl.NeurophXOR;
import ru.afanasiev.domain.MovieDataSet;
import ru.afanasiev.domain.Rating;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MovieDataSet dataSet = new MovieDataSet();
        dataSet.setScore(0);
        dataSet.setRating(new Rating());

        MovieDataSet dataSet2 = new MovieDataSet();
        dataSet2.setScore(1);
        Rating rating2 = new Rating();
        rating2.setKp(1);
        rating2.setImdb(1);
        rating2.setFilmCritics(1);
        rating2.setRussianFilmCritics(1);
        dataSet2.setRating(rating2);

        MatchEngine engine = new MatchEngine();
        engine.assembleNeuralNetwork();
        engine.trainNeuralNetwork(dataSet, dataSet2);
        double score = engine.score(dataSet2);

        System.out.println(score);

        var a = NeurophXOR.assembleNeuralNetwork();
        NeurophXOR.trainNeuralNetwork(a);

        a.setInput(0, 1, 1);
        a.calculate();
        System.out.println(a.getOutput()[0]);
    }
}
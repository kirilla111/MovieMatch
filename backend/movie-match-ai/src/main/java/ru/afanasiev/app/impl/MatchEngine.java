package ru.afanasiev.app.impl;

import org.neuroph.core.Layer;
import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.Neuron;
import org.neuroph.core.data.DataSet;
import org.neuroph.core.data.DataSetRow;
import org.neuroph.nnet.learning.BackPropagation;
import org.neuroph.util.ConnectionFactory;
import org.neuroph.util.NeuralNetworkType;
import ru.afanasiev.domain.MovieDataSet;

import static ru.afanasiev.domain.MovieDataSet.DATA_ROW_SIZE;

public class MatchEngine {
    private NeuralNetwork ann;

    public void assembleNeuralNetwork() {
        Layer inputLayer = initLayer(DATA_ROW_SIZE);
        Layer hiddenLayerOne = initLayer(4);
        Layer hiddenLayerTwo = initLayer(4);
        Layer outputLayer = initLayer(1);
        ann = new NeuralNetwork();

        ann.addLayer(0, inputLayer);
        ann.addLayer(1, hiddenLayerOne);
        ConnectionFactory.fullConnect(ann.getLayerAt(0), ann.getLayerAt(1));
        ann.addLayer(2, hiddenLayerTwo);
        ConnectionFactory.fullConnect(ann.getLayerAt(1), ann.getLayerAt(2));
        ann.addLayer(3, outputLayer);
        ConnectionFactory.fullConnect(ann.getLayerAt(2), ann.getLayerAt(3));
        ConnectionFactory.fullConnect(ann.getLayerAt(0), ann.getLayerAt(ann.getLayersCount() - 1), false);
        ann.setInputNeurons(inputLayer.getNeurons());
        ann.setOutputNeurons(outputLayer.getNeurons());
        ann.setNetworkType(NeuralNetworkType.MULTI_LAYER_PERCEPTRON);
    }

    public void trainNeuralNetwork(MovieDataSet... movieDataSet) {
        int outputSize = 1;
        DataSet ds = new DataSet(DATA_ROW_SIZE, outputSize);

        for (MovieDataSet row : movieDataSet) {
            DataSetRow dataSetRow = new DataSetRow(row.toDoubleArray(), new double[]{row.getScore()});
            ds.addRow(dataSetRow);
        }

        BackPropagation backPropagation = new BackPropagation();
        backPropagation.setMaxIterations(1000);

        ann.learn(ds, backPropagation);
    }

    public double score(MovieDataSet movieDataSet) {
        ann.setInput(movieDataSet.toDoubleArray());
        ann.calculate();
        return ann.getOutput()[0];
    }

    // ===================================================================================================================
    // = Implementation
    // ===================================================================================================================

    private Layer initLayer(int neuronSize) {
        Layer layer = new Layer();
        for (int i = 0; i < neuronSize; i++) {
            layer.addNeuron(new Neuron());
        }
        return layer;
    }
}

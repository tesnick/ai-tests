package com.tesnick.ai.neuralnetworks;

import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.data.DataSet;
import org.neuroph.core.data.DataSetRow;
import org.neuroph.nnet.Perceptron;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by tesnick on 15/11/15.
 */
public class NeurophNeuralNetwork {

    public static final String OR_PERCEPTRON_NNET = "target/or_perceptron.nnet";

    public static void main(String[] args) throws FileNotFoundException {

        // create new perceptron network
        NeuralNetwork neuralNetwork = new Perceptron(2, 1);
        // create training set
        DataSet trainingSet =
                new DataSet(2, 1);
        // add training data to training set (logical OR function)
        trainingSet. addRow (new DataSetRow(new double[]{0, 0}, new double[]{0}));
        trainingSet. addRow (new DataSetRow (new double[]{0, 1}, new double[]{1}));
        trainingSet. addRow (new DataSetRow (new double[]{1, 0}, new double[]{1}));
        trainingSet. addRow (new DataSetRow (new double[]{1, 1}, new double[]{1}));
        // learn the training set
        neuralNetwork.learn(trainingSet);
        // save the trained network into file
        neuralNetwork.save(OR_PERCEPTRON_NNET);

        // load the saved network
        neuralNetwork = NeuralNetwork.load(new FileInputStream(new File(OR_PERCEPTRON_NNET)));
        // set network input
        neuralNetwork.setInput(1, 1);
        // calculate network
        neuralNetwork.calculate();
        // get network output
        double[] networkOutput = neuralNetwork.getOutput();

        for(double value : networkOutput) {
            System.out.println("NETWORK OUTPUT -> " + value);
        }

        // set network input
        neuralNetwork.setInput(0, 0);
        // calculate network
        neuralNetwork.calculate();
        // get network output
        networkOutput = neuralNetwork.getOutput();

        for(double value : networkOutput) {
            System.out.println("NETWORK OUTPUT -> " + value);
        }
    }

}

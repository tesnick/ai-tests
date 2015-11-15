package com.tesnick.ai.clustering;

/**
 * Created by tesnick on 15/11/15.
 */

import weka.clusterers.ClusterEvaluation;
import weka.clusterers.DensityBasedClusterer;
import weka.clusterers.EM;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

/**
 * An example class that shows the use of Weka clusterers from Java.
 *
 * @author FracPete (fracpete at waikato dot ac dot nz)
 * @version $Revision: 5628 $
 */
public class WekaClusteringExample {

    /**
     * Run clusterers
     *
     * @param filename      the name of the ARFF file to run on
     */
    public WekaClusteringExample(String filename) throws Exception {
        ClusterEvaluation eval;
        Instances               data;
        String[]                options;
        DensityBasedClusterer cl;
        double                  logLikelyhood;

        data = DataSource.read(filename);

        // normal
        System.out.println("\n--> normal");
        options    = new String[2];
        options[0] = "-t";
        options[1] = filename;
        System.out.println(ClusterEvaluation.evaluateClusterer(new EM(), options));

        // manual call
        System.out.println("\n--> manual");
        cl   = new EM();
        cl.buildClusterer(data);
        eval = new ClusterEvaluation();
        eval.setClusterer(cl);
        eval.evaluateClusterer(new Instances(data));
        System.out.println(eval.clusterResultsToString());

        // cross-validation for density based clusterers
        // NB: use MakeDensityBasedClusterer to turn any non-density clusterer
        //     into such.
        System.out.println("\n--> Cross-validation");
        cl = new EM();
        logLikelyhood = ClusterEvaluation.crossValidateModel(
                cl, data, 10, data.getRandomNumberGenerator(1));
        System.out.println("log-likelyhood: " + logLikelyhood);
    }

    /**
     * usage:
     *   ClusteringDemo arff-file
     */
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("usage: " + WekaClusteringExample.class.getName() + " <arff-file>");
            System.exit(1);
        }

        new WekaClusteringExample(args[0]);
    }
}
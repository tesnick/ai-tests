import weka.classifiers.Classifier;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.*;

/**
 * Created by tesnick on 15/11/15.
 *
 * From https://weka.wikispaces.com/Programmatic+Use#Step%202:%20Train%20a%20Classifier
 *
 */
public class WekaNaiveBayesClassifier {

    public static void main(String[] args) throws Exception {

        // Declare two numeric attributes
        Attribute Attribute1 = new Attribute("firstNumeric");
        Attribute Attribute2 = new Attribute("secondNumeric");

        // Declare a nominal attribute along with its values
        FastVector fvNominalVal = new FastVector(3);
        fvNominalVal.addElement("blue");
        fvNominalVal.addElement("gray");
        fvNominalVal.addElement("black");
        Attribute Attribute3 = new Attribute("aNominal", fvNominalVal);

        // Declare the class attribute along with its values
        FastVector fvClassVal = new FastVector(4);
        fvClassVal.addElement("positive");
        fvClassVal.addElement("negative");
        Attribute ClassAttribute = new Attribute("theClass", fvClassVal);

        // Declare the feature vector
        FastVector fvWekaAttributes = new FastVector(4);
        fvWekaAttributes.addElement(Attribute1);
        fvWekaAttributes.addElement(Attribute2);
        fvWekaAttributes.addElement(Attribute3);
        fvWekaAttributes.addElement(ClassAttribute);

        Instances isTrainingSet = prepareTrainingSet(fvWekaAttributes);

        // Create a naïve bayes classifier
        Classifier cModel = new NaiveBayes();
        cModel.buildClassifier(isTrainingSet);

        // Specify that the instance belong to the training set
        // in order to inherit from the set description
        Instance iUse = new SparseInstance(4);
        iUse.setValue((Attribute)fvWekaAttributes.elementAt(0), 1.0);
        iUse.setValue((Attribute)fvWekaAttributes.elementAt(1), 0.5);
        iUse.setValue((Attribute)fvWekaAttributes.elementAt(2), "gray");
        iUse.setValue((Attribute)fvWekaAttributes.elementAt(3), "positive");
        iUse.setDataset(isTrainingSet);

        // Get the likelihood of each classes
        // fDistribution[0] is the probability of being “positive”
        // fDistribution[1] is the probability of being “negative”
        double[] fDistribution = cModel.distributionForInstance(iUse);

        for(double values : fDistribution){
            System.out.println("Fdistribution for a really similar instance -> " + values);
        }

        iUse = new SparseInstance(4);
        iUse.setValue((Attribute)fvWekaAttributes.elementAt(0), 5000.0);
        iUse.setValue((Attribute)fvWekaAttributes.elementAt(1), 10000);
        iUse.setValue((Attribute)fvWekaAttributes.elementAt(2), "black");
        iUse.setValue((Attribute)fvWekaAttributes.elementAt(3), "negative");
        iUse.setDataset(isTrainingSet);

        fDistribution = cModel.distributionForInstance(iUse);

        for(double values : fDistribution){
            System.out.println("Fdistribution for a quite different instance -> " + values);
        }
    }

    private static Instances prepareTrainingSet(FastVector fvWekaAttributes){

        // Create an empty training set
        Instances isTrainingSet = new Instances("Rel", fvWekaAttributes, 10);
        // Set class index
        isTrainingSet.setClassIndex(3);

        // Create the instance
        Instance iExample = new SparseInstance(4);
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(0), 1.1);
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(1), 0.5);
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(2), "gray");
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(3), "positive");
        isTrainingSet.add(iExample);

        iExample = new SparseInstance(4);
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(0), 1.0);
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(1), 0.6);
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(2), "gray");
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(3), "positive");
        isTrainingSet.add(iExample);

        iExample = new SparseInstance(4);
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(0), 1.0);
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(1), 0.4);
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(2), "gray");
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(3), "positive");
        isTrainingSet.add(iExample);

        iExample = new SparseInstance(4);
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(0), 0.9);
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(1), 0.5);
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(2), "gray");
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(3), "positive");
        isTrainingSet.add(iExample);

        iExample = new SparseInstance(4);
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(0), 1.1);
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(1), 0.5);
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(2), "gray");
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(3), "positive");
        isTrainingSet.add(iExample);

        iExample = new SparseInstance(4);
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(0), 4999.0);
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(1), 10000);
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(2), "black");
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(3), "negative");
        isTrainingSet.add(iExample);

        iExample = new SparseInstance(4);
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(0), 5001.0);
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(1), 10000);
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(2), "black");
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(3), "negative");
        isTrainingSet.add(iExample);

        iExample = new SparseInstance(4);
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(0), 5000.0);
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(1), 10001);
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(2), "black");
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(3), "negative");
        isTrainingSet.add(iExample);

        iExample = new SparseInstance(4);
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(0), 5000.0);
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(1), 9999);
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(2), "black");
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(3), "negative");
        isTrainingSet.add(iExample);

        return isTrainingSet;
    }

}

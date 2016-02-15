package com.tesnick.ai.nlp.ner.stanford;

import edu.stanford.nlp.ie.AbstractSequenceClassifier;
import edu.stanford.nlp.ie.crf.CRFClassifier;
import edu.stanford.nlp.ling.CoreLabel;

import java.io.IOException;
import java.util.List;

/**
 * Created by tesnick on 12/02/16.
 */
public class StanfordNERExecutor {

    private String spanishSerializedClassifier = "spanish.ancora.distsim.s512.crf.ser.gz";

    private String englishSerializedClassifier = "english.all.3class.distsim.crf.ser.gz";

    private AbstractSequenceClassifier<CoreLabel> classifier;

    public StanfordNERExecutor() throws IOException, ClassNotFoundException {
        classifier = CRFClassifier.getClassifier(englishSerializedClassifier);
    }

    public StanfordNERExecutor(String language) throws IOException, ClassNotFoundException {

        if(language.equalsIgnoreCase("es"))
            classifier = CRFClassifier.getClassifier(spanishSerializedClassifier);
        else
            classifier = CRFClassifier.getClassifier(englishSerializedClassifier);
    }

    public List<List<CoreLabel>> apply(String text){
        return classifier.classify(text);
    }
}

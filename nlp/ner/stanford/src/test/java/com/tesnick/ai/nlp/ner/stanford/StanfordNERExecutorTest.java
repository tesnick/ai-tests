package com.tesnick.ai.nlp.ner.stanford;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * Created by tesnick on 15/02/16.
 */
public class StanfordNERExecutorTest {

    private StanfordNERExecutor target;

    @Test
    public void englishTest() throws IOException, ClassNotFoundException {

        StanfordNERExecutor target = new StanfordNERExecutor();
        List<List<CoreLabel>> apply = target.apply("A mini world war rages in the fields of Aleppo.");
        for (List<CoreLabel> coreLabels : apply) {
            System.out.println(coreLabels);

            for (CoreLabel word : coreLabels) {
                System.out.print(word.word() + '/' + word.get(CoreAnnotations.AnswerAnnotation.class) + ' ');
            }
        }
    }

    @Test
    public void spanishTest() throws IOException, ClassNotFoundException {

        StanfordNERExecutor target = new StanfordNERExecutor();
        List<List<CoreLabel>> apply = target.apply("David Bowie toma las calles del mundo.");
        for (List<CoreLabel> coreLabels : apply) {
            System.out.println(coreLabels);

            for (CoreLabel word : coreLabels) {
                System.out.print(word.word() + '/' + word.get(CoreAnnotations.AnswerAnnotation.class) + ' ');
            }
        }
    }
}

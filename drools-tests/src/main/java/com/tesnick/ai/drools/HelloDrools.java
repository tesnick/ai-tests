package com.tesnick.ai.drools;

/**
 * Created by tesnick on 15/11/15.
 */

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
  * This is a sample class to launch a rule.
*/
public class HelloDrools {

    private String topic;

    public HelloDrools(String topic) {
        this.topic = topic;
    }

    public static final void main(String[] args) {

        try {
            // load up the knowledge base
            KieServices ks = KieServices.Factory.get();
            KieContainer kContainer = ks.getKieClasspathContainer();
            KieSession kSession = kContainer.newKieSession("ksession-rules");

            HelloDrools droolsIntroduction = new HelloDrools("Drools");
            kSession.insert(droolsIntroduction);
            kSession.insert(new HelloDrools("spring"));
            kSession.insert(new HelloDrools("Drools"));
            kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public String getTopic() {
        return topic;
    }

    public String introduceYourself() {
        return "Drools 6.2.0.Final";
    }
}
package org.schoen.ben.patterns.observer;

/**
 * Created by ben on 29-11-16.
 */
public class VerifySubjectObserverBehaviour {

    public static void main(String[] args) {
        VerifySubjectObserverBehaviour verify = new VerifySubjectObserverBehaviour();
        verify.run();
    }

    private void run() {
        Subject subject = new Subject();
        ObserverNL observerNL = new ObserverNL(subject);
        ObserverEN observerEN = new ObserverEN(subject);
        subject.addObserver(observerNL);
        subject.addObserver(observerEN);
        subject.setUninterestingFact("en dit?");
        subject.setInterestingFact("hallo");
        subject.deleteObserver(observerNL);
        subject.setInterestingFact("hallo");
        subject.addObserver(observerNL);
        subject.setUninterestingFact("en dit?");
        subject.setInterestingFact("tot ziens");
    }
}

package org.schoen.ben.patterns.observer;

/**
 * Created by ben on 29-11-16.
 */
public class ObserverNL implements IObserver {

    private final Subject m_subject;
    private String m_interestingFact;

    public ObserverNL(Subject subject) {
        m_subject = subject;
        m_interestingFact = subject.getInterestingFact();
    }

    @Override
    public void update() {
        if(!m_subject.getInterestingFact().equals(m_interestingFact)) {
            System.out.printf("Er is iets gewijzigd van %s naar %s", m_interestingFact, m_subject.getInterestingFact());
            System.out.println();
            m_interestingFact = m_subject.getInterestingFact();
        }
    }
}

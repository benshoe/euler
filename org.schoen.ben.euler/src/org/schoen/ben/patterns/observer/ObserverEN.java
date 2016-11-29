package org.schoen.ben.patterns.observer;

/**
 * Created by ben on 29-11-16.
 */
public class ObserverEN implements IObserver {

    private final Subject m_subject;
    private String m_interestingFact;

    public ObserverEN(Subject subject) {
        m_subject = subject;
        m_interestingFact = subject.getInterestingFact();
    }

    @Override
    public void update() {
        if(!m_subject.getInterestingFact().equals(m_interestingFact)) {
            System.out.printf("Something has changed from %s to %s", m_interestingFact, m_subject.getInterestingFact());
            System.out.println();
            m_interestingFact = m_subject.getInterestingFact();
        }
    }
}

package org.schoen.ben.patterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 29-11-16.
 */
public class Subject implements ISubject {

    private List<IObserver> m_observers = new ArrayList<>();
    private String m_interestingFact = "";
    private String m_uninterestingFact;

    @Override
    public void addObserver(IObserver observer) {
        m_observers.add(observer);
    }

    @Override
    public void deleteObserver(IObserver observer) {
        m_observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (IObserver observer : m_observers) {
            observer.update();
        }
    }

    public String getInterestingFact() {
        return m_interestingFact;
    }

    public void setInterestingFact(String interestingFact) {
        m_interestingFact = interestingFact;
        notifyObservers();
    }

    public String getUninterestingFact() {
        return m_uninterestingFact;
    }

    public void setUninterestingFact(String uninterestingFact) {
        m_uninterestingFact = uninterestingFact;
        notifyObservers();
    }
}

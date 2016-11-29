package org.schoen.ben.patterns.observer;

/**
 * Created by ben on 29-11-16.
 */
public interface ISubject {
    void addObserver(IObserver observer);

    void deleteObserver(IObserver observer);

    void notifyObservers();
}

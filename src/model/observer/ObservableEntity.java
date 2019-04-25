package model.observer;

import java.util.ArrayList;
import java.util.List;

import model.entity.Entity;
/**
 * this class represents the Observable object and has
 * the methods to addObserver and notify them.

 */
public abstract class ObservableEntity implements Entity {

    private final List<Observer> observers = new ArrayList<>();

    /**
     * Method to add an observer.
     * @param o the observer who is going to watch this observable
     */
    public void addObserver(final Observer o) {
        this.observers.add(o);
    }

    /**
     * notify the observers who are watching this subject.
     */
    public void notifyObservers() {
        for (final Observer observer : observers) {
            observer.update(this);
        }
    }
}


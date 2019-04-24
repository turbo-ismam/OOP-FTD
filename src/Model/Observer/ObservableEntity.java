package model.observer;

import java.util.ArrayList;

import model.entity.Entity;

public abstract class ObservableEntity implements Entity {
	
	private ArrayList<Observer> observers = new ArrayList<>();
	
	public void addObserver(Observer o) {
		this.observers.add(o);
	}
	
	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update(this);
		}
	}
}

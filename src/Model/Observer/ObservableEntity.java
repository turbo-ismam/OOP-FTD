package Model.Observer;

import java.util.ArrayList;

import Model.Entity.Entity;

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

package Model.Observer;

import java.util.ArrayList;

public abstract class Observable {
	
	private ArrayList<Observer> observers = new ArrayList<>();
	
	public void setObserver(Observer o) {
		this.observers.add(o);
	}
	
	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update(this);
		}
	}
}

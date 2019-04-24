package model.observer;
import model.observer.ObservableEntity;
/**
 * Interface for the Observer
 */
public interface Observer {
	public void update(ObservableEntity subject);
}

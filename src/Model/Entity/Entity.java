package Model.Entity;

import utilityClasses.Pair;

public interface Entity {
	/**
	 * 
	 * @return a Pair that describes the position of the entity
	 */
	Pair<Integer, Integer> getLocation();
	
	/**
	 * 
	 * Each entity has its own way to "updatr" itself, and this method describes its behaviour
	 */
	void update();
	/**
	 * 
	 * @return true if the entity should be removed, false otherwise
	 */
	boolean shouldBeRemoved();
}

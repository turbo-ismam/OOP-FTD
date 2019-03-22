package Model.Entity;

import utilityClasses.Pair;

public interface Entity {
	
	Pair<Integer, Integer> getLocation();

	void update();
}

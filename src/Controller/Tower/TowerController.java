package Controller.Tower;

import Model.Tower.Tower;
import utilityClasses.Pair;

public interface TowerController {
	
	/**
	 * Method to buy a new tower
	 */
	public void buyTower(Pair<Integer,Integer> position);
	
	/**
	 * Method to sell a tower
	 */
	public void sellTower(int gridPosition, int towerPosition);
}

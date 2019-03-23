package Controller.Tower;

import Model.Tower.Tower;
import utilityClasses.Pair;

public interface TowerController {

	/**
	 * method to place a tower
	 */
	public void placeTower(Pair<Integer,Integer> position, Tower tw);
	
	/**
	 * Method to buy a new tower
	 */
	public Tower buyTower();
	
	/**
	 * Method to sell a tower
	 */
	public void sellTower(int position);
}

package Model;

import java.util.ArrayList;

import Model.Entity.Entity;
import utilityClasses.Pair;

public interface GameModel {
	/**
	 * Places a Tower in the current playing map
	 * @param location x, y position of the Tower
	 * @param cost Cost of the tower
	 */
	
	public void placeTower(Pair<Integer, Integer> location, int cost);
	/**
	 * Removes a Tower from the map
	 * @param location x, y position of the Tower
	 */
	public void removeTower(Pair<Integer, Integer> location);
	/**
	 * 
	 * @return list of all entities in the map
	 */
	
	public ArrayList<Entity> getEntities();
	/**
	 * 
	 * @return the GameStatus
	 */
	
	public GameStatus getGameStatus();
	/**
	 * Starts the next Wave
	 */
	
	public void nextWave();
	/**
	 * Update everything and moves the game forward by one tick
	 */
	public void update();
	
}

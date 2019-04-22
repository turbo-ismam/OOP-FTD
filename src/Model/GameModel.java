package Model;

import Model.Map.Map;
import Model.Player.Player;
import Model.Tower.TowerType;
import Model.Wave.Wave;
import utilityClasses.Pair;
/**
 * 
 * @author marco
 *
 */

public interface GameModel {
	
	/**
	 * Places a Tower in the current playing map
	 * @param location x, y position of the Tower
	 * @param tt Type of the tower that is going to be placed
	 * @return  True if the player has enought money, false otherwise
	 */
	public boolean placeTower(Pair<Integer, Integer> location, TowerType tt);
	
	/**
	 * Removes a Tower from the map
	 * @param location x, y position of the Tower
	 */
	public void removeTower(Pair<Integer, Integer> location);
	
	/**
	 * 
	 * @return the GameStatus
	 */
	public GameStatus getGameStatus();
	
	/**
	 * 
	 * @return return the Player
	 */
	public Player getPlayer();
	
	/**
	 * 
	 * @return return the Current Wave
	 */
	public Wave getCurrentWave();
	
	/**
	 * Starts the next Wave
	 */
	public void nextWave();
	
	/**
	 * Update everything and moves the game forward by one tick
	 */
	public void update();
	
	/**
	 *  Returns the map of the game
	 * @return the current Map
	 */
    public Map getMap();
    
    /**
     *  if true, starts the current wave
     * @param b boolean
     */
	void setReadyToSpawn(boolean b);
	
}

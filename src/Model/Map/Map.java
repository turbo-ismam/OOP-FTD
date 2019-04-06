package Model.Map;

import java.util.ArrayList;
import java.util.List;

import Model.Entity.Entity;
import utilityClasses.Pair;

/**
 * 
 * @author ismam
 *
 */
public interface Map{
	
	/**
	 * @return an ArrayList that contain all the tiles
	 */
	public ArrayList<MapTile> tileList();
	
	/**
	 * @return the map size
	 */
	public int getGridSize();
	
	/**
	 * 
	 * @return the initial position
	 */
	public MapTile initialPosition();
	
	/**
	 * 
	 * @return the end of the path
	 */
	public MapTile finalPosition();
	/**
	 * 
	 * @return ArrayList of entities
	 */
	public ArrayList<Entity> getEntities();
	
	public void addEntity(Entity e);
	
	public void removeEntity(Pair<Integer, Integer> location);
	
	
}

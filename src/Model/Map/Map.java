package Model.Map;

import java.util.ArrayList;

import Model.Entity.Entity;
import utilityClasses.Pair;

/**
 * 
 * @author ismam
 *
 */
public interface Map {
	
	/**
	 * 
	 * @return an ArrayList that contain all the entities in the map
	 */
	public ArrayList<Entity> getEntityList();
	
	/**
	 * 
	 * @return an ArrayList that contain all the tiles in the map
	 */
	public ArrayList<MapTile> getTileList();
	
	/**
	 * 
	 * @return an ArrayList that contain the path of the enemy
	 */
	public ArrayList<MapTile> getPathList();
	
	/**
	 * Method to add entity to the EntityList
	 * @param e 
	 */
	public void addEntity(Entity e);
	
	/**
	 * Method to remove an entity from the EntityList
	 * @param location
	 */
	public void removeEntity(Pair<Integer, Integer> location);
	
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
	 * @param position
	 * @return true if you can place a tower
	 */
	public boolean positionable(int position);
	
	/**
	 * 
	 * @return the tile
	 */
	public MapTile getTileInt(int position);
	
	/**
	 * 
	 * @param position: tile coordinates
	 * @return requested tile
	 */
	public MapTile getTilePair(Pair<Integer,Integer> position);
	
	/**
	 * 
	 * @param tile
	 */
	public void setTile(MapTile tile);
	
	/**
	 * from the arraylist position return a Pair
	 * @param position
	 * @return Pair<Integer,Integer>
	 */
	public Pair<Integer,Integer> fromIntToPair(int position);
	
	/**
	 * from the pair position return the position in the arraylist
	 * @param position
	 * @return
	 */
	public int fromPairToInt(Pair<Integer,Integer> position);

	public void removeEntity(Entity e);
	
}

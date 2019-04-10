package Model.Map;

import java.util.ArrayList;

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
=======
package Model.Map;

import java.util.ArrayList;
import java.util.List;

import Model.Enemy.Enemy;
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
	public ArrayList<Entity> entityList();
	
	/**
	 * @return an ArrayList that contain all the tiles in the map
	 */
	public ArrayList<MapTile> tileList();
	
	/**
	 * 
	 * @return an ArrayList that contain the path of the enemy
	 */
	public ArrayList<MapTile> pathList();
	
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
	
}

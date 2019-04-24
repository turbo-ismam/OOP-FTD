package model.map;

import java.util.ArrayList;

import model.entity.Entity;
import utilityclasses.Pair;

public interface Map {
	/**
	 * 
	 * @return an ArrayList that contain all the entities in the map
	 */
	ArrayList<Entity> getEntityList();
	
	/**
	 * 
	 * @return an ArrayList that contain all the tiles in the map
	 */
	ArrayList<MapTile> getTileList();
	
	/**
	 * 
	 * @return an ArrayList that contain the path of the enemy
	 */
	ArrayList<MapTile> getPathList();
	
	/**
	 * Method to add entity to the EntityList
	 * @param e 
	 */
	void addEntity(Entity e);
	
	/**
	 * Method to remove an entity from the EntityList
	 * @param location
	 */
	void removeEntity(Pair<Integer, Integer> location);
	
	/**
	 * @return the map size
	 */
	int getGridSize();
	
	/**
	 * 
	 * @return the initial position
	 */
	MapTile initialPosition();
	
	/**
	 * 
	 * @return the end of the path
	 */
	MapTile finalPosition();
	
	/**
	 * @param position
	 * @return true if you can place a tower
	 */
	boolean positionable(int position);
	
	/**
	 * 
	 * @return the tile
	 */
	MapTile getTileInt(int position);
	
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
	 * from the arraylist position return a Pair.
	 * @param position
	 * @return Pair<Integer,Integer>
	 */
	public Pair<Integer,Integer> fromIntToPair(int position);
	
	/**
	 * from the pair position return the position in the arraylist
	 * @param position
	 * @return
	 */
	int fromPairToInt(Pair<Integer,Integer> position);
	/**
	 * removes the entity from the entityList.
	 * @param e entity to remove
	 */
	void removeEntity(Entity e);
	
}

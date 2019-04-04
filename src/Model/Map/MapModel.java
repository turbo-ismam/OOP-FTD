package Model.Map;

import java.util.ArrayList;
import java.util.List;

import utilityClasses.Pair;

public interface MapModel {
	
	/**
	 * @return an ArrayList that contain all the tiles
	 */
	public ArrayList<MapTile> tileList();
	
	/**
	 * @return the map size
	 */
	public int getGridSize();
}

package Model.Map;

import java.util.ArrayList;

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

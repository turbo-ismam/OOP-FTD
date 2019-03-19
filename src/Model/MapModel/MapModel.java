package Model.MapModel;

import java.util.ArrayList;
import java.util.List;

import utilityClasses.Pair;

public interface MapModel {
	
	public enum Status {
		EMPTY,
		PATH,
		WITHTOWER,
	}
	
	/**
	 * @return an ArrayList that contain all the tiles
	 */
	public ArrayList<MapTile> tileList();
	
	/**
	 * @return the map size
	 */
	public int getGridSize();
}

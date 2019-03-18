package Map;

import java.util.ArrayList;
import java.util.List;

import utilityClasses.Pair;

public class SimpleMap implements Map {
	
	private List<MapTile> grid = new ArrayList<>();
	private final static int gridSize = 20;
	
	/**
	 * Constructor
	 */
	public SimpleMap() {

		for (int i=0;i<gridSize;i++) {
			for (int j=0;j<gridSize;j++) {
				MapTile tile = new MapTile(i,j);
				grid.add(tile);
			}
		}
		
		
	}
	
	public MapTile getTile(Pair<Integer,Integer> coordinates) {
		
		for (int i=0;i<gridSize;i++) {
			for (int j=0;j<gridSize;j++) {
				if(grid.get(i+j).position==coordinates)
				return grid.get(i+j);
			}
		}
		return null;
	}
	
	
	/**
	 * 
	 * @return the map grid size
	 */
	public static int getGridSize() {
		
		return gridSize;
	}
	
}

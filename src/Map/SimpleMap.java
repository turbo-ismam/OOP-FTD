package Map;

import java.util.ArrayList;
import java.util.List;

import utilityClasses.Pair;

public class SimpleMap implements Map {
	
	private List<MapTile> grid = new ArrayList<>();
	private final static int gridSize = 20;
	
	/**
	 * Method to generate a new map
	 * first for cycle generate the arraylist that contain the grid
	 * second for cycle generate the enemy moviment path
	 */
	public SimpleMap() {

		for (int i=0;i<gridSize;i++) {
			for (int j=0;j<gridSize;j++) {
				MapTile tile = new MapTile(i,j);
				grid.add(tile);
			}
		}
		
		for (int i=0;i<gridSize*gridSize;i++) {			//provalo, non sono convinto
			if (grid.get(i).getPosition().getX()==10) {
				grid.get(i).setStatus(Status.PATH);
			}
		}
	}
	
	/**
	 * Method to search for tiles
	 * @param coordinates of the searced tile
	 * @return the tile if it is found
	 */
	public MapTile getTile(Pair<Integer,Integer> coordinates) {
		
		for (int i=0;i<gridSize*gridSize;i++) {
			
			if(coordinates.getX()==grid.get(i).getPosition().getX() && coordinates.getY()==grid.get(i).getPosition().getY()) {
				return grid.get(i);
			}
		}
		return null;
	}
	
	/**
	 * @return the map size
	 */
	public static int getGridSize() {
		
		return gridSize;
	}

	

}

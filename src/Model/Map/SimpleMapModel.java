package Model.Map;

import java.util.ArrayList;

import java.util.List;

import Model.Entity.Entity;
import Model.Map.MapTile.Status;
import utilityClasses.Pair;

public class SimpleMapModel implements Map{

	private List<MapTile> grid = new ArrayList<>();
	private List<MapTile> enemyPath = new ArrayList<>();
	private ArrayList<Entity> entities = new ArrayList<>();
	private final int gridSize = 20;
	
	/**
	 * Constructor to generate a grid with a path
	 * first for cycle generate the arraylist that contain the grid
	 * second for cycle generate the enemy moviment path
	 */
	public SimpleMapModel() {

		for (int i=0;i<gridSize;i++) {
			for (int j=0;j<gridSize;j++) {
				MapTile tile = new MapTileImpl(i,j);
				grid.add(tile);
			}
		}
		//dovrebbe creare un percorso, in questo caso una linea orizzontale dritta
		for (int i=0;i<gridSize*gridSize;i++) {			//provalo, non sono convinto
			if (grid.get(i).getPosition().getY()==10) {
				grid.get(i).setStatus(Status.PATH);
				enemyPath.add(grid.get(i));	//aggiungo alla lista il path
			}
		}
	}
	
	public int getGridSize() {
		
		return gridSize;
	}

	@Override
	public ArrayList<MapTile> tileList() {

		return (ArrayList<MapTile>) this.grid;
	}

	@Override
	public MapTile initialPosition() {
		
		return enemyPath.get(0);
	}

	@Override
	public MapTile finalPosition() {
		
		return enemyPath.get(enemyPath.size());
	}

	@Override
	public ArrayList<Entity> getEntities() {
		// TODO Auto-generated method stub
		return entities;
	}

	@Override
	public void addEntity(Entity e) {
		this.entities.add(e);
		
	}

	@Override
	public void removeEntity(Pair<Integer, Integer> location) {
		entities.removeIf(e -> e.getLocation().equals(location));
		for (Entity e : entities) {
			System.out.println(e.getLocation() + " " + location);
		}
		
	}

}

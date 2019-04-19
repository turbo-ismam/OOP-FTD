package Model.Map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Model.Entity.Entity;
import Model.Map.MapTile.Status;
import utilityClasses.Pair;

public abstract class AbstractMapModel implements Map{

	protected List<MapTile> grid = new ArrayList<>();
	protected List<MapTile> enemyPath = new ArrayList<>();
	private ArrayList<Entity> entity = new ArrayList<>();
	protected final int gridSize = 20;
	
	/**
	 * Constructor to generate a grid with a path
	 * first for cycle generate the arraylist that contain the grid
	 * second for cycle generate the enemy moviment path
	 */
	public AbstractMapModel() {

		generateGrid();	//i metodi abstract dovrebbero essere di strategy, controlla
		
		generatePath();
		
	}
	
	private void generateGrid() {
		
		for (int i=0;i<gridSize;i++) {		//idea, fai un costruttore che richiama 2 metodi privati che fanno questi 2 cicli for
			for (int j=0;j<gridSize;j++) {
				MapTile tile = new MapTileImpl(i,j);
				grid.add(tile);
			}
		}
	}
	
	abstract void generatePath();
	
	public int getGridSize() {
		
		return gridSize;
	}

	public ArrayList<Entity> entityList(){
		ArrayList<Entity> copia = new ArrayList<>(entity);
		return copia;
	}
	
	@Override
	public ArrayList<MapTile> tileList() {

		return (ArrayList<MapTile>) this.grid;
	}
	
	@Override
	public ArrayList<MapTile> pathList() {

		return (ArrayList<MapTile>) this.enemyPath;
	}
	
	@Override
	public void addEntity(Entity e) {
		this.entity.add(e);
		
	}

	@Override
	public void removeEntity(Pair<Integer, Integer> location) {
		entity.removeIf(e -> e.getLocation().equals(location));
		
	}
	
	@Override
	public void removeEntity(Entity e) {
		entity.remove(e);
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
	public boolean positionable(int position) {
		
		if (grid.get(position).getStatus()==Status.EMPTY) {
			return true;
		} else return false;
	}

	@Override
	public MapTile getTileInt(int position) {
		
		return grid.get(position);
	}
	
	@Override
	public MapTile getTilePair(Pair<Integer, Integer> position) {

		for (int i=0;i<this.gridSize*this.gridSize;i++) {
			if(this.grid.get(i).getPosition().getX()==position.getX() && this.grid.get(i).getPosition().getY()==position.getY()) {
				return this.grid.get(i);
			}
		}
		return null;
	}

	@Override
	public void setTile(MapTile tile) {
		
		int tmp = tile.getPosition().getX()*this.gridSize+tile.getPosition().getY(); 
		grid.remove(tmp);
		grid.add(tmp, tile);
	}

	@Override
	public Pair<Integer, Integer> fromIntToPair(int position) {			//by marcopacco
		
		int x = position/this.gridSize;
		int y = position%this.gridSize;
		return new Pair<>(x,y);
	}

	@Override
	public int fromPairToInt(Pair<Integer, Integer> position) {
		
		return position.getX()*this.gridSize+position.getY();
	}

}

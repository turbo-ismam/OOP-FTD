package Controller.MapController;

import java.util.ArrayList; 

import java.util.List;

import Model.Map.MapTile.Status;
import Model.Map.MapTile;
import Model.Map.SimpleMapModel;
import utilityClasses.Pair;

public class SimpleMapController implements MapController {
	
	SimpleMapModel mapModel = new SimpleMapModel();
	private List<MapTile> tilelist = new ArrayList<>();
	private int gridSize;
	
	/**
	 * Constructor 
	 */
	public SimpleMapController() {
		this.tilelist = mapModel.tileList();
		gridSize = mapModel.getGridSize();
	}

	public SimpleMapModel getMapModel() {
		return mapModel;
	}

	public void setMapModel(SimpleMapModel mapModel) {
		this.mapModel = mapModel;
	}

	public int getGridSize() {
		return gridSize;
	}

	public void setGridSize(int gridSize) {
		this.gridSize = gridSize;
	}

	@Override
	public boolean positionable(int position) {
		
		if (tilelist.get(position).getStatus()==Status.EMPTY) {
			return true;
		} else return false;
	}

	@Override
	public boolean isEMPTY(int position) {

		if (tilelist.get(position).getStatus()==Status.EMPTY) {
			return true;
		} else return false;
	}

	@Override
	public boolean isPATH(int position) {
		if (tilelist.get(position).getStatus()==Status.PATH) {
			return true;
		} else return false;
	}

	@Override
	public boolean isWITHTOWER(int position) {
		if (tilelist.get(position).getStatus()==Status.WITHTOWER) {
			return true;
		} else return false;
	}
	
	@Override
	public boolean isWITHENEMY(int position) {
		if (tilelist.get(position).getStatus()==Status.WITHENEMY) {
			return true;
		} else return false;
	} 

	@Override
	public MapTile getTileInt(int position) {
		
		return tilelist.get(position);
	}
	
	@Override
	public MapTile getTilePair(Pair<Integer, Integer> position) {

		for (int i=0;i<this.gridSize*this.gridSize;i++) {
			if(this.tilelist.get(i).getPosition().getX()==position.getX() && this.tilelist.get(i).getPosition().getY()==position.getY()) {
				return this.tilelist.get(i);
			}
		}
		return null;
	}

	@Override
	public void setTile(MapTile tile) {
		
		int tmp = tile.getPosition().getX()*this.gridSize+tile.getPosition().getY()+1; //verifica che funzioni!
		tilelist.remove(tmp);
		tilelist.add(tmp, tile);
	}

	@Override
	public Pair<Integer, Integer> fromIntToPair(int position) {			//by marcopacco
		
		int x = position/this.gridSize;
		int y = position%this.gridSize;
		return new Pair<>(x,y);
	}

	@Override
	public int fromPairToInt(Pair<Integer, Integer> position) {
		
		return position.getX()*this.gridSize+position.getY()+1;
	}

	


	

	
	
	
	
	

}

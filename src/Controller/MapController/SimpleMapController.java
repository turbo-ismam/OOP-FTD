package Controller.MapController;

import java.util.ArrayList; 
import java.util.List;

import Model.MapModel.MapTile.Status;
import Model.MapModel.MapTile;
import Model.MapModel.SimpleMapModel;

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
	public MapTile getTile(int position) {
		
		return tilelist.get(position);
	}

	@Override
	public void placeTowerMap() {
		// TODO Auto-generated method stub
		
	}

	

	
	
	
	
	

}

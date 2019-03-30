package Controller.Tower;

import java.util.ArrayList;

import Controller.MapController.SimpleMapController;
import Model.Tower.Tower;
import Model.Tower.TowerModelImpl;
import utilityClasses.Pair;

public class TowerControllerImpl implements TowerController{

	private SimpleMapController map;
	public ArrayList<Tower> towerlist = new ArrayList<>();	//lista che contiene tutte le torri

	@Override
	public void buyTower(Pair<Integer,Integer> position) {
		
		Tower tw = new TowerModelImpl(position);	//gestire con enum se vuoi piu torri
		int p = map.fromPairToInt(position);
		map.setTile(map.getTileInt(p));
		
		
	}

	@Override
	public void sellTower(int gridPosition, int towerPosition) {

		
	}
}

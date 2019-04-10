package Controller.Tower;

import Model.Tower.Tower;
import utilityClasses.Pair;

public class TowerControllerImpl implements TowerController {
	Pair<Integer,Integer> position ; 
	Tower tw;
	@Override
	public void placeTower(Pair<Integer, Integer> position, Tower tw) {
		// TODO Auto-generated method stub
		this.position = position;
		this.tw = tw;
	}

	@Override
	public Tower buyTower() {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public void sellTower(int position) {
		// TODO Auto-generated method stub
		
	}

}

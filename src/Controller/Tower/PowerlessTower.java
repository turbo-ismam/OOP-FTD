package Controller.Tower;

import Controller.MapController.MapController; 
import Model.Player.Player;
import Model.Tower.PowerlessTowerModel;
import Model.Tower.Tower;
import utilityClasses.Pair;

public class PowerlessTower implements TowerController {

	Tower tower;
	MapController map;
	Player player;
	
	@Override
	public void placeTower(Pair<Integer, Integer> position, Tower tw) {
						
	}

	@Override
	public Tower buyTower() {
		
		if (this.player.getCoins()>this.tower.getCost()) {
			PowerlessTowerModel tower = new PowerlessTowerModel();
			player.setCoins(player.getCoins()-tower.getCost());
			return tower;
		} else return null;
		
	}

	@Override
	public void sellTower(int position) {

		
		
	}


}

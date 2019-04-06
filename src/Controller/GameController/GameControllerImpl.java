package Controller.GameController;

import Model.Map.Map;
import Model.Tower.Tower;
import Model.Tower.TowerImpl;
import Model.Map.SimpleMapModel;
import Model.Player.Player;
import Model.Player.PlayerImpl;
import Model.Wave.Wave;
import Model.Wave.WaveImpl;
import utilityClasses.Pair;

public class GameControllerImpl implements GameController {
	
	private Map m;
	private Player p;
	private Wave w;
	
	//private View v; La view va implementata
	
	@Override
	public void startWave() {
		w.getEnemies();
		
	}

	@Override
	public void init() {
		m = new SimpleMapModel();
		p = new PlayerImpl();
		w = new WaveImpl();
	}

	@Override
	public void placeTower(Pair<Integer, Integer> location) {
		Tower t = new TowerImpl(location);
		m.addEntity(t);
	}

	
	
	

}

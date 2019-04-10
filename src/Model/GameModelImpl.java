package Model;

import java.util.ArrayList;

import Model.Entity.Entity;
import Model.Map.HardMap;
import Model.Map.Map;
import Model.Player.PlayerImpl;
import Model.Tower.BasicTower;
import Model.Tower.TowerType;
import Model.Wave.Wave;
import Model.Wave.WaveImpl;
import utilityClasses.Pair;

/**
 * 
 * @author ismam.abu
 *
 */
public class GameModelImpl implements GameModel {
	
	private Map m;
	private PlayerImpl p;
	private Wave w;
	private GameStatus gs;
	private int tick = 0;
	
    
	public GameModelImpl(){
		m = new HardMap();
		p = new PlayerImpl("SexyIsmy",1000,300);
		p.setWave(1);
		w = new WaveImpl(1);
		gs = GameStatus.PLAYING;
		
	}

	@Override
	public void placeTower(Pair<Integer, Integer> location, int cost) {
		if (p.getCoins()<cost){
			return;
		}
		p.incrementCoins(cost); //player PAGA la torre
		m.addEntity(new BasicTower(location, TowerType.BASIC));
	}

	@Override
	public void removeTower(Pair<Integer, Integer> location) {
		m.removeEntity(location);
		
	}

	@Override
	public ArrayList<Entity> getEntities() {
		return m.entityList();
	}
	
	@Override
	public GameStatus getGameStatus() {
		return this.gs;
	}
	
	public void nextWave() {
		w.nextWave();
	}

	@Override
	public void update() {
		m.entityList().forEach(e->e.update());
		
		if(!w.isEmpty() && tick==100) {
			this.tick=0;
			w.spawn();
		}
		this.tick++;
		
		if (p.getHp()<=0) {
			this.gs=GameStatus.LOST;
		}
		if (p.getWave()>20) {
			this.gs=GameStatus.WON;
		}
		
	}
	
}
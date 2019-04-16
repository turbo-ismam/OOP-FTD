package Model;

import java.util.ArrayList;
import Model.Enemy.Enemy;
import Model.Entity.Entity;
import Model.Map.HardMap;
import Model.Map.Map;
import Model.Player.Player;
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
	private Player p;
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
	public void placeTower(Pair<Integer, Integer> location, TowerType tt) {
		if (p.getCoins()<tt.getCost()){
			return;
		}
		p.incrementCoins(tt.getCost()); //player PAGA la torre
		m.addEntity(new BasicTower(location, tt));
	}

	@Override
	public void removeTower(Pair<Integer, Integer> location) {
		m.removeEntity(location);
		
	}
	
	@Override
	public GameStatus getGameStatus() {
		return this.gs;
	}
	
	@Override
	public Player getPlayer() {
		return this.p;
	}
	
	@Override
	public Wave getCurrentWave() {
		return this.w;
	}
	
	@Override
	public Map getMap() {
	    return this.m;
	}
	
	@Override
	public void nextWave() {
		w=w.nextWave();
	}
	
	private void addEnemy(Enemy e) {
	    m.addEntity(e);
	}

	@Override
	public void update() {
		m.entityList().forEach(e->e.update());
		addEnemy(w.spawn());
		/*m.entityList().forEach(e -> {
			if(e instanceof Enemy) {
				e.
			}
				
				));
		}
		*/
		if (p.getHp()<=0) {
			this.gs=GameStatus.LOST;
			return;
		}
		if (p.getWave()>20) {
			this.gs=GameStatus.WON;
			return;
		}
		this.tick++;
	}
	
}
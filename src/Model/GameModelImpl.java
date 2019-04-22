package Model;

import Model.Enemy.Enemy;
import Model.Entity.Entity;
import Model.Map.HardMap;
import Model.Map.Map;
import Model.Map.NormalMap;
import Model.Map.SimpleMap;
import Model.Observer.ObservableEntity;
import Model.Observer.Observer;
import Model.Player.Player;
import Model.Player.PlayerImpl;
import Model.Tower.BasicTower;
import Model.Tower.Tower;
import Model.Tower.TowerType;
import Model.Wave.Wave;
import Model.Wave.WaveImpl;
import utilityClasses.Pair;

/**
 * 
 * @author marco
 *
 */
public class GameModelImpl implements GameModel, Observer {
	
	private Map m;
	private Player p;
	private Wave w;
	private GameStatus gs;
	private int tick=0;
	private boolean readyToSpawn;
	
    
	public GameModelImpl(int difficulty){
		p = new PlayerImpl("SexyIsmy",1,300);
		m = createMap(difficulty);
		WaveImpl.setPath(m.pathList());
		p.setWave(1);
		w = new WaveImpl(1);
		gs = GameStatus.PLAYING;
		this.readyToSpawn=false;
		
		
		
	}

	private Map createMap(int difficulty) {
		switch(difficulty) {
		case 1:
			return new SimpleMap();
		case 2:
			return new NormalMap();
		case 3:
			return new HardMap();
		default:
			throw new IllegalArgumentException();
		}
	}
	@Override
	public boolean placeTower(Pair<Integer, Integer> location, TowerType tt) {
		if (p.getCoins()<tt.getCost()){
			return false;
		}
		p.incrementCoins(tt.getCost()); //player PAGA la torre
		Tower t = new BasicTower(location, tt);
		((ObservableEntity) t).addObserver(this);
		m.addEntity(t);
		return true;
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
	@Override
	public void setReadyToSpawn(boolean b) {
		this.readyToSpawn=b;
	}
	
	private void addEntity(Entity e) {
	    m.addEntity(e);

	}


	@Override
	public void update() {
		m.entityList().forEach(e->e.update());
		
		if(w.hasEnemies()) {
			if (tick>=50 && readyToSpawn) {
				Enemy e = w.spawn();
				((ObservableEntity) e).addObserver(this);
				this.addEntity(e);
				tick=0;

			}
		}
		else {
			setReadyToSpawn(false);
		}
		this.tick++;
		m.entityList().stream()
		.filter(e -> e.ShouldBeRemoved())
		.forEach(e -> m.removeEntity(e));
		m.entityList().forEach(e -> {
			if (e instanceof Tower) {
				((Tower) e).setEnemies(m.entityList());
			}
		});
		if (p.getHp()<=0) {
			this.gs=GameStatus.LOST;
			return;
		}
		if (p.getWave()>20) {
			this.gs=GameStatus.WON;
			return;
		}
	}

	@Override
	public void update(ObservableEntity subject) {
		if (subject instanceof Tower) {
			addEntity(((Tower) subject).getProjectile());
		}
		else if (subject instanceof Enemy ) {
			Enemy e = (Enemy) subject;
			if(e.getLocation().equals(m.pathList().get(m.pathList().size()-1).getPosition())) {
				p.takeDamage(1);
				System.out.println("player took 1 damage");
			}
			else {
				p.incrementCoins(e.getValue());
			}
			
		}
		
	}
	
}
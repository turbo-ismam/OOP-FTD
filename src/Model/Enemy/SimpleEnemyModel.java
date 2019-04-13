package Model.Enemy;

import java.util.ArrayList;

import Model.Map.MapModel;
import Model.Map.MapTile;
import Model.Map.MapTileImpl;
import Model.Map.SimpleMapModel;
import utilityClasses.Pair;

public class SimpleEnemyModel implements Enemy{
	
	private static final int MAX_HP = 100;
	private static final int MAX_SPEED = 5;
	private static final int DEFAULT_VALUE = 20;
	
	private int hp;
	private int damage;
	private int speed;
	private int value;
	private boolean alive;
	public Direction direction;
	private ArrayList<MapTile> path = null;
	
	private MapTile actual = new MapTileImpl(path.get(0).getPosition().getX(),path.get(0).getPosition().getY());
	
	private int x = 1;
	private int tick = 0;

	public SimpleEnemyModel() {
		super();
		this.hp = MAX_HP;
		this.speed = MAX_SPEED;
		this.value = DEFAULT_VALUE;
		this.alive = false;
	}

	@Override
	public Pair<Integer, Integer> getLocation() {
		return actual.getPosition();
	}

	@Override
	public void update() {
		this.death();
		if(tick == 100) {
		this.walk();
		tick = 0;
		}
		else {
		tick++;
		}
	}

	@Override
	public void walk() {
		
		if(path == null) {
			throw new NullPointerException();
		}
		else {
		if(x > path.size()) {
			this.despawn();
		}
		
		if(this.alive == true) {
		MapTile next = new MapTileImpl(path.get(x).getPosition().getX(),path.get(x).getPosition().getY());
		if(next.getPosition().getX() > actual.getPosition().getX()) {
			actual = next;
			direction = Direction.RIGHT;
		}
		if(next.getPosition().getX() < actual.getPosition().getX()) {
			actual = next;
			direction = Direction.LEFT;
		}
		if(next.getPosition().getY() > actual.getPosition().getY()) {
			actual = next;
			direction = Direction.DOWN;
		}
		if(next.getPosition().getY() < actual.getPosition().getY()) {
			actual = next;
			direction = Direction.UP;
		}
		x++;
		}
	}
}

	@Override
	public void spawn() {
	alive = true;	
	}

	@Override
	public void despawn() {
		alive = false;
	}

	@Override
	public void death() {
		if(hp <= 0) {
			alive = false;
		}
	}

	@Override
	public int getHP() {
		return hp;
	}

	@Override
	public void setHP(int hp) {
		this.hp = hp;
	}

	@Override
	public void setDamage(int damage) {
		this.damage = damage;
		this.hp -= this.damage;
		if(this.hp <= 0) {
			this.death();
		}
	}

	@Override
	public int getValue() {
		return this.value;
	}

	@Override
	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public int getSpeed() {
		return this.speed;
	}

	@Override
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public void setPath(ArrayList<MapTile> sentiero) {
		this.path = sentiero;		
	}
	
	public boolean isAlive() {
		return alive;
	}

	@Override
	public Direction Direzione() {
		return direction;
	}
	
	
}
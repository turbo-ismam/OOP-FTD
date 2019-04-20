package Model.Enemy;

import java.util.ArrayList;

import Model.Enemy.Enemy.Direction;
import Model.Map.Map;
import Model.Map.MapTile;
import Model.Map.MapTileImpl;
import Model.Map.SimpleMap;
import utilityClasses.Pair;

public class Tank implements Enemy {

	private static final int MAX_HP = 200;
	private static final int MAX_SPEED = 3;
	private static final int DEFAULT_VALUE = 40;
	
	private int hp;
	private int damage;
	private int speed;
	private int value;
	private boolean alive;
	public Direction direction;
	private ArrayList<MapTile> path = null;
	
	private MapTile actual;
	
	private int x = 1;
	private int tick = 0;

	public Tank() {
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
		if(tick == 10) {
		this.walk();
		tick = 0;
		}
		tick++;
	}

	@Override
	public void walk() {
		if(path == null) {
			throw new NullPointerException();
		}
		else {
		if(x >= path.size()) {
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
		this.actual = sentiero.get(0);
	}
	
	@Override
	public Direction Direzione() {
		return direction;
	}

	@Override
	public boolean ShouldBeRemoved() {
		return alive;
	}
	
	@Override
	public boolean isAlive() {
		return alive;
	}

}

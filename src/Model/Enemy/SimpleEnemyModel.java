package Model.Enemy;

import java.util.ArrayList;
import java.util.List;

import Model.Map.MapModel;
import Model.Map.MapTile;
import Model.Map.MapTileImpl;
import Model.Map.SimpleMapModel;
import utilityClasses.Pair;

public class SimpleEnemyModel implements Enemy{
	
	private int hp;
	private int damage;
	private int speed;
	private int value;
	private boolean alive;
	public Direction direction;
	
	private MapModel map = new SimpleMapModel();
	private MapTile actual = new MapTileImpl(map.initialPosition().getPosition().getX(),map.initialPosition().getPosition().getY());
	
	private int x = 1;
	

	public SimpleEnemyModel() {
		super();
	}

	@Override
	public Pair<Integer, Integer> getLocation() {
		return actual.getPosition();
	}

	@Override
	public void update() {
		this.walk();
	}

	@Override
	public void walk() {
		MapTile next = new MapTileImpl(map.getEnemyPath().get(x).getPosition().getX(),map.getEnemyPath().get(x).getPosition().getY());
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

}
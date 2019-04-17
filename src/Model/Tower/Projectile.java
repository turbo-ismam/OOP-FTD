package Model.Tower;

import Model.Enemy.Enemy;
import Model.Entity.Entity;
import utilityClasses.Pair;

public class Projectile implements Entity {
	Pair<Integer,Integer> position;
	
	private float x, y, speed, tick;
	private int damage;
	private Enemy enemy;
	
	public Projectile(Pair <Integer,Integer> position, Enemy enemy, int damage, float speed){
		this.position = position;
		this.damage = damage;
		this.speed = speed;
		this.enemy = enemy;
		
	}
	
	@Override
	public void update() {
		
	}

	@Override
	public Pair<Integer, Integer> getLocation() {
		// TODO Auto-generated method stub
		return null;
	}
}

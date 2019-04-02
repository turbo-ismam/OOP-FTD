package Model.Tower;

import Model.Enemy.Enemy;
import utilityClasses.Pair;

public class Projectile {
	Pair<Integer,Integer> position;
	
	private float speed;
	private int damage;
	private Enemy enemy;
	
	public Projectile(Pair <Integer,Integer> position, Enemy enemy, int damage, float speed){
		this.position = position;
		this.damage = damage;
		this.speed = speed;
		this.enemy = enemy;
	}
	
	public void update() {
		draw();
	}
	
	public void draw() {
		
	}
	
}

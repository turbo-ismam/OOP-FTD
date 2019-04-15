package Model.Tower;

import Model.Enemy.Enemy;
import utilityClasses.Pair;

public class Projectile {
	Pair<Integer,Integer> position;
	
	private float x, y, speed, xVelocity, yVelocity;
	private int damage;
	private Enemy enemy;
	
	public Projectile(Pair <Integer,Integer> position, Enemy enemy, int damage, float speed){
		this.position = position;
		this.damage = damage;
		this.speed = speed;
		this.enemy = enemy;
		this.xVelocity = 0f;
		this.yVelocity = 0f;
	}
	
	public void update() {
		x += xVelocity * speed ;
		y += yVelocity * speed ;
	}
	
}

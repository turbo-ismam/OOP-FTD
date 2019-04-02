package Model.Tower;


import java.util.ArrayList;

import Model.Enemy.Enemy;
import utilityClasses.Pair;

public class BasicTower implements Tower{
	Pair<Integer,Integer> position ; 
	private int damage;
	private float firingSpeed, timeSinceLastShot;
	private ArrayList<Projectile> projectiles;
	
	
	public BasicTower(Pair<Integer, Integer> position, int damage) {
		this.damage = damage;
		this.position = position;
		this.firingSpeed = 30;
		this.timeSinceLastShot = 0;
		this.projectiles = new ArrayList<Projectile>();
	}

	@Override
	public Pair<Integer, Integer> getLocation() {
		// TODO Auto-generated method stub
	
		return position;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		
		return 0;
	}

	@Override
	public void setCost(int cost) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setType(String type) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getDamage() {
		// TODO Auto-generated method stub
		return damage;
	}

	@Override
	public void setDamage(int damage) {
		// TODO Auto-generated method stub
		this.damage=damage;
	}

	@Override
	public float getShootTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setShootTime() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void shoot() {
		// TODO Auto-generated method stub
		timeSinceLastShot = 0;
		projectiles.add(new Projectile(position, null, damage, firingSpeed)); 
	}

	@Override
	public boolean isShooting() {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public boolean isInRange() {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public Enemy getTarget() {
		// TODO Auto-generated method stub
		
		return null;
	}
	
}
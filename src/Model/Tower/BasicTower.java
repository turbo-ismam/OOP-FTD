package Model.Tower;


import java.util.ArrayList;

import Model.Enemy.Enemy;
import Model.Tower.Projectile;
import utilityClasses.Pair;

public class BasicTower implements Tower{
	Pair<Integer,Integer> position; 
	private int damage = 10;
	private float shootTime;
	private ArrayList<Projectile> projectiles;
	private Enemy target;
	private TowerType type;
	private boolean isShooting;
	private boolean isInRange;
	
	
	public BasicTower(Pair<Integer, Integer> position, TowerType type) {
		
		this.position = position;
		//this.target = target;
		this.shootTime = 20;
		this.projectiles = new ArrayList<Projectile>();
		this.type = type;
		this.isShooting = false;
	}

	@Override
	public Pair<Integer, Integer> getLocation() {
		
	
		return position;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}


	@Override

	public TowerType getType() {
		return type;
	}
	
	@Override
	public void setType(TowerType type) {
		this.type = type;
	}
	

	@Override
	public float getShootTime() {
		
		return shootTime;
	}

	
	@Override
	public void shoot() {
		projectiles.add(new Projectile(position, target, damage, 600));
	
		
	}

	@Override
	public boolean isShooting() {
				
		return isShooting;
	}

	@Override
	public boolean isInRange() {
		
		
		return isInRange;
	}

	@Override
	public Enemy getTarget() {
		
		return target;
		
	}
	
	
	
}
package Model.Tower;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Model.Enemy.Enemy;
import Model.Entity.Entity;
import Model.Observer.Observarble;
import Model.Tower.Projectile;
import utilityClasses.Pair;

public class BasicTower extends Observarble implements Tower {
	private static final int gridSize = 20;
	Pair<Integer,Integer> position; 
	private int damage = 10;
	private float shootTime;
	private Enemy target;
	private TowerType type;
	private boolean isShooting;
	private int range = 2;
	private ArrayList<Pair<Integer, Integer>> shootingZone;
	private List<Entity> enemies; 
	private Projectile projectiles;
	
	
	public Projectile getProjectiles() {
		return projectiles;
	}


	public BasicTower(Pair<Integer, Integer> position, TowerType type) {
		
		this.position = position;
		this.target = null;
		this.shootTime = 20;
		this.type = type;
		this.isShooting = false;
		this.shootingZone = new ArrayList<Pair<Integer, Integer>>();
		setRange();
		this.enemies = new ArrayList<>();
	}
	
	private void findTarget() {
		for(Entity e: enemies) {
			for(int i = 0; i < shootingZone.size(); i++) {
				if (e.getLocation().equals(shootingZone.get(i))) {
					if(e instanceof Enemy) {
						this.target =(Enemy) e;
						return;
					}else {
						throw new IllegalArgumentException();
					}
				}
			}
		}
		this.target = null;
	}
	
	private void setRange() {
		
		for(int i = position.getX() - range; i <= position.getX() + range; i++) {
			for(int j = position.getY() - range; j <= position.getX() + range; j++) {				
				if(position.getX() < gridSize && position.getY() < gridSize) {
					shootingZone.add(new Pair<>(i,j));
				}
				
			}
		}
		
	}
	
	@Override
	public void setEnemies(ArrayList<Entity> entities) {
		
		this.enemies = entities.stream()
				.filter(e -> e instanceof Enemy)
				.collect(Collectors.toList());
		
	}

	@Override
	public Pair<Integer, Integer> getLocation() {
		
	
		return position;
	}

	@Override
	public void update() {
		findTarget();
		if(isTargetSet())
			this.projectiles = shoot();
		notify();
		
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

	

	private Projectile shoot() {
		return new Projectile(position, target, damage, 600);
			
	}

	@Override
	public boolean isShooting() {
				
		return isShooting;
	}

	@Override
	public boolean isTargetSet() {
		if(target == null) {
			return false;
		}		
			return true;	
	}

	@Override
	public Enemy getTarget() {
		
		return target;
		
	}
	
}
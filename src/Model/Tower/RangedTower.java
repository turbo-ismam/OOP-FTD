package Model.Tower;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Model.Enemy.Enemy;
import Model.Entity.Entity;
import utilityClasses.Pair;

public class RangedTower implements Tower{

	private static final int gridSize = 20;
	Pair<Integer,Integer> position; 
	private int damage = 10;
	private float shootTime;
	private ArrayList<Projectile> projectiles;
	private Enemy target;
	private TowerType type;
	private boolean isShooting;
	private int range = 3;
	private ArrayList<Pair<Integer, Integer>> shootingZone;
	private List<Entity> enemies; 
	
	
	public RangedTower(Pair<Integer, Integer> position, TowerType type) {
		
		this.position = position;
		this.target = null;
		this.shootTime = 20;
		this.projectiles = new ArrayList<Projectile>();
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
			shoot();
		
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

	

	private void shoot() {
		projectiles.add(new Projectile(position, target, damage));
	
		
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

package model.tower;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import model.enemy.Enemy;
import model.entity.Entity;
import model.observer.ObservableEntity;
import model.projectile.Projectile;
import utilityclasses.Pair;

/**
 *  the class BasicTower for the model tower.
 * 
 *
 */
public class BasicTower extends ObservableEntity implements Tower {
    private static final int GRID_SIZE = 20;
    private Pair<Integer, Integer> position; 
    private int damage, range;
    private float shootTime;
    private Enemy target;
    private TowerType type;
    private boolean isShooting;
    private ArrayList<Pair<Integer, Integer>> shootingZone;
    private List<Entity> enemies; 
    private Projectile projectile;

    /**
     * 
     * @return array of range positions.
     */
    public ArrayList<Pair<Integer, Integer>> getShootingZone() {
        return shootingZone;
    }

    /**
     * 
     * @param shootingZone setted.
     */
    public void setShootingZone(final ArrayList<Pair<Integer, Integer>> shootingZone) {
        this.shootingZone = shootingZone;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Projectile getProjectile() {
         return projectile;
    }

    /**
     * costructor composed by position, and type of tower.
     * @param position of the tower
     * @param type of the tower
     */
    public BasicTower(final Pair<Integer, Integer> position, final TowerType type) {
        this.position = position;
        this.damage = type.getDamage();
        this.range = type.getRange();
        this.target = null;
        this.shootTime = 10;
        this.type = type;
        this.isShooting = false;
        this.shootingZone = new ArrayList<Pair<Integer, Integer>>();
        setRange();
        this.enemies = new ArrayList<>();
    }

    private void findTarget() {
        for (Entity e: enemies) {
            for (int i = 0; i < shootingZone.size(); i++) {
                if (e.getLocation().equals(shootingZone.get(i))) {
                    if (e instanceof Enemy) {
                        this.target = (Enemy) e;
                        System.out.println("target acquired");
                        return;
                    } else {
                        throw new IllegalArgumentException();
                    }
                }
            }
        }
        this.target = null;
    }

    private void setRange() {

        for (int i = position.getX() - range; i <= position.getX() + range; i++) {
            for (int j = position.getY() - range; j <= position.getY() + range; j++) {
                if (position.getX() < GRID_SIZE && position.getY() < GRID_SIZE) {
                    shootingZone.add(new Pair<>(i, j));
                }
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setEnemies(final ArrayList<Entity> entities) {
        this.enemies = entities.stream()
                .filter(e -> e instanceof Enemy)
                .collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Pair<Integer, Integer> getLocation() {
        return position;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update() {
        findTarget();
        if (isTargetSet()) {
            this.projectile = shoot();
            this.notifyObservers();
        }
    }


    /**
     * {@inheritDoc}
     */
    @Override

    public TowerType getType() {
        return type;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setType(final TowerType type) {
        this.type = type;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public float getShootTime() {
        return shootTime;
    }



    private Projectile shoot() {
        return new Projectile(position, target, damage);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isShooting() {
        return isShooting;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isTargetSet() {
        if (target == null) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Enemy getTarget() {
        return target;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public boolean shouldBeRemoved() {
        return false;
    }
}

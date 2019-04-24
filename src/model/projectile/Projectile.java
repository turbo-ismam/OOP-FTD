package model.projectile;

import utilityclasses.Pair;
import model.enemy.Enemy;
import model.entity.Entity;
/**
 * class for projectile.
 * 
 *
 */
public class Projectile implements Entity  {
    private Pair<Integer, Integer> position;
    private Enemy enemy;
    private int damage, tick;
    private boolean alive;

    /**
     * costructor of projectile.
     * @param position of the projectile
     * @param enemy target
     * @param damage of the projectile
     */
    public Projectile(final Pair<Integer, Integer> position, final Enemy enemy, final int damage) {
        this.position = position;
        this.damage = damage;
        this.enemy = enemy;
        this.alive = true;
}

    /**
     * {@inheritDoc}
     */
    @Override
    public void update() {
        if (alive) {
            tick++;
            if (tick == 1) {
                enemy.setDamage(damage);
                tick = 0;
                alive = false;
            }
        }
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
    public boolean shouldBeRemoved() {
        return !alive;
    }
}

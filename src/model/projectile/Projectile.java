package model.projectile;

import constants.TicksConstants;
import utilityclasses.Pair;
import model.enemy.Enemy;
import model.entity.Entity;
/**
 * class for projectile.
 * 
 *
 */
public class Projectile implements Entity  {
    private static final int PROJECTILE_HIT_ENEMY = TicksConstants.PROJECTILE_HIT_ENEMY;
    private final Pair<Integer, Integer> position;
    private final Enemy enemy;
    private final int damage;
    private int tick;
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
            if (tick > PROJECTILE_HIT_ENEMY) {
                enemy.setDamage(damage);
                this.alive = false;
            }
            this.tick++;
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

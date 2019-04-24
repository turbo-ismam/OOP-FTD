package model.tower;

import java.util.ArrayList;

import model.enemy.Enemy;
import model.entity.Entity;
import model.projectile.Projectile;

/**
 * Tower interface.
 * 
 *
 */
public interface Tower extends Entity {

    /**
     * get the shoot time.
     * @return shoot time
     */

    float getShootTime();

    /**
     * check if the tower is shooting.
     * @return isShooting
     */
    boolean isShooting();

    /**
     * find the target.
     * @return target
     */
    Enemy getTarget();

    /**
     * set type of tower.
     * @param type of the tower
     */
    void setType(TowerType type);

    /**
     * choose type of tower.
     * @return type
     **/
    TowerType getType();

    /**
     * filter of enemies.
     * @param entities of enemies
     **/
    void setEnemies(ArrayList<Entity> entities);

    /**
     * to verify the presence of the target.
     * @return isTargetSet
     */
    boolean isTargetSet();

    /**
     * 
     * @return the projectile that the tower has just shot.
     **/
    Projectile getProjectile();




}

package model.tower;
import constants.GameConstants;
/**
 * types of tower.
 * 
 *
 */
public enum TowerType {

    /**
     * basic tower.
     */
    BASIC(  GameConstants.BASIC_TOWER_COST,
            GameConstants.BASIC_TOWER_DAMAGE,
            GameConstants.BASIC_TOWER_RANGE,
            GameConstants.BASIC_TOWER_SPEED),

    /**
     * tower with higher range.
     */
    RANGED( GameConstants.RANGED_TOWER_COST,
            GameConstants.RANGED_TOWER_DAMAGE,
            GameConstants.RANGED_TOWER_RANGE,
            GameConstants.RANGED_TOWER_SPEED),
    /**
     * tower with higher damage.
     */
    CANNON( GameConstants.CANNON_TOWER_COST,
            GameConstants.CANNON_TOWER_DAMAGE,
            GameConstants.CANNON_TOWER_RANGE,
            GameConstants.CANNON_TOWER_SPEED);

    private int cost, damage, range, speed;
    TowerType(final int towerCost, final int damage, final int range, final int speed) {
         this.cost = towerCost;
         this.damage = damage;
         this.range = range;
         this.speed = speed;
    }

    /**
     * get the cost of the tower.
     * @return cost
     */
    public int getCost() {
        return this.cost;
    }

    /**
     * get the damage of the tower.
     * @return damage
     */
    public int getDamage() {
        return this.damage;
    }

    /**
     * get the range of the tower.
     * @return range
     */
    public int getRange() {
        return this.range;
    }

    /**
     * get the range of the tower.
     * @return range
     */
    public int getSpeed() {
        return this.speed;
    }


}

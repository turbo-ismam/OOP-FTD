package model.tower;

/**
 * types of tower.
 * 
 *
 */
public enum TowerType {

    /**
     * basic tower.
     */
    BASIC(50, true, 1, 2),

    /**
     * tower with higher range.
     */
    RANGED(100, false, 25, 3),

    /**
     * tower with higher damage.
     */
    CANNON(120, false, 50, 2);

    private int cost, damage, range;
    private boolean canAttack;
    TowerType(final int towerCost, final boolean canAttack, final int damage, final int range) {
         this.cost = towerCost;
         this.canAttack = canAttack;
         this.damage = damage;
         this.range = range;
    }

    /**
     * get the cost of the tower.
     * @return cost
     */
    public int getCost() {
        return this.cost;
    }

    /**
     * check if the tower can attack.
     * @return canAttack
     */
    public boolean canAttack() {
        return this.canAttack;
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


}

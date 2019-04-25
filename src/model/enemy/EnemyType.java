package model.enemy;
import constants.GameConstants;
/**
 * 
 * Type of enemy.
 *
 */

public enum EnemyType {
    /**
     * Basic type of enemy.
     */
        SIMPLE( GameConstants.SIMPLE_ENEMY_HP,
                GameConstants.SIMPLE_ENEMY_SPEED,
                GameConstants.SIMPLE_ENEMY_VALUE),
        /**
         * Enemy with more hp but slower.
         */
        TANK(   GameConstants.TANK_ENEMY_HP,
                GameConstants.TANK_ENEMY_SPEED,
                GameConstants.TANK_ENEMY_VALUE);
    private int health, speed, value;
    /**
     * 
     * @param health
     * @param speed
     * @param value
     */
    EnemyType(final int health, final int speed, final int value) {
        this.health = health;
         this.speed = speed;
         this.value = value;
    }
    /**
     * 
     * @return hp of enemy.
     */
    public int getHealth() {
        return this.health;
    }
/**
 * 
 * @return speed value of enemy.
 */
    public int getSpeed() {
        return this.speed;
    }
/**
 * 
 * @return value of gold
 */
    public int getValue() {
        return this.value;
    }
}

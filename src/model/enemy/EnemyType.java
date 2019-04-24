package model.enemy;
/**
 * 
 * Type of enemy.
 *
 */
public enum EnemyType {
    /**
     * Basic type of enemy.
     */
        SIMPLE(100, 5, 20),
        /**
         * Enemy with more hp but slower.
         */
        TANK(200, 3, 40);
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

package model.wave;

import model.enemy.Enemy;
import model.enemy.EnemyType;
/**
 * 
 * Interface for waves containing enemies.
 *
 */
public interface Wave {
/**
 * 
 * @return wave number.
 */
    int getWave();
    /**
     * Method to insert enemies in a wave.
     * @param quantity quantity
     * @param type type
     */
    void populate(int quantity, EnemyType type);
    /**
     * Method to spawn enemies.
     * @return enemy
     */
    Enemy spawn();
    /**
     * Method to get next wave.
     * @return wave
     */
    Wave nextWave();
/**
 * 
 * @return true if wave has enemies.
 */
    boolean hasEnemies();

}

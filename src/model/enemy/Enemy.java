package model.enemy;

import java.util.ArrayList;

import model.entity.Entity;
import model.map.MapTile;

/**
 * 
 * Interface for Entity enemy.
 *
 */
public interface Enemy extends Entity {
    /**
     * 
     *Enum to set enemy direction.
     *
     */
  enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
  }
  /**
   * Method to implement enemies movement.
   */
  void walk();
  /**
   * Method to spawn an enemy.
   */
  void spawn();
  /**
   * Method to kill an enemy.
   */
  void death();
  /**
   * @return enemy health points.
   */
  int getHP();
  /**
   * @return gold value dropped on enemy killed
   */
  int getValue();
   /**
   * @return speed of the enemy.
   */
  int getSpeed();
  /**
   * Method to set the damage inflict to an enemy.
   * @param damage damage.
   */
  void setDamage(int damage);
/**
 * Method to set the map path.
 * @param sentiero sentiero
 */
  void setPath(ArrayList<MapTile> sentiero);
  /**
   * 
   * @return Direction.
   */
  Direction getDirezione();
  /**
   * Method to despawn an enemy.
   */
  void despawn();
}

/**
 * 
 */
package Model.Enemy;

import Model.Entity.Entity;

/**
 * @author Vlad
 *
 */
public interface Enemy extends Entity {
	
	public enum Direction {
		UP,
		DOWN,
		LEFT,
		RIGHT
	}
	void walk(); //moving logics
	
	void spawn(); //enemy appearing on the map, ready to walk
	
	void despawn(); //ugual a quel di sotto,
	
	void death();// vedi sopra (?)
	
	int getHP();
	
	void setHP(int hp);
	
	void setDamage(int damage);
	
	int getValue(); //gold dropped when killed
	
	void setValue(int value);
	
	int getSpeed();
	
	void setSpeed(int speed);
	
}

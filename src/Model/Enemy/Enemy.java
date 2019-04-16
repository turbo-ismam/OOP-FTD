/**
 * 
 */
package Model.Enemy;

import java.util.ArrayList;

import Model.Entity.Entity;
import Model.Map.MapTile;

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
	
	public enum enemyType {
		BASIC,
		TANK
	}
	void walk(); //moving logics
	
	void spawn(); //enemy appearing on the map, ready to walk
	
	void death();// muore
	
	int getHP();
	
	void setHP(int hp);
	
	void setDamage(int damage);
	
	int getValue(); //gold dropped when killed
	
	void setValue(int value);
	
	int getSpeed();
	
	void setSpeed(int speed);

	void setPath(ArrayList<MapTile> sentiero);
	
	boolean isAlive();
	
	Direction Direzione();
	
	public void despawn();
	
}

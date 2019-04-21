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
public interface Enemy extends Entity{
	
	public enum Direction {
		UP,
		DOWN,
		LEFT,
		RIGHT
	}
	
	void walk(); //moving logics
	
	void spawn(); //enemy appearing on the map, ready to walk
	
	void death();// muore
	
	int getHP();
	
	int getValue(); //gold dropped when killed
	
	int getSpeed();
	
	public void setDamage(int damage);

	void setPath(ArrayList<MapTile> sentiero);
	
	Direction getDirezione();
	
	public void despawn();

	
	
}

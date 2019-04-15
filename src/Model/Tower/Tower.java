package Model.Tower;

import Model.Enemy.Enemy;
import Model.Entity.Entity;
import utilityClasses.Pair;

public interface Tower extends Entity {

	/**
	 * 
	 * @return
	 */
	float getShootTime(); 
	
	/**
	 * 	
	 */
	void shoot(); 		
	
	/**
	 * 
	 * @return
	 */
	boolean isShooting();
	
	/**
	 * 
	 * @return
	 */
	
	boolean isInRange();
	
	/**
	 * 
	 * @return
	 */
	Enemy getTarget();

	/**
	 * 
	 * @param type
	 */
	void setType(TowerType type);

	/**
	 * 
	 * @return
	 */
	TowerType getType();
	
	
	
	
}

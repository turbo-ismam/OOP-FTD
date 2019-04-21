package Model.Wave;

import Model.Enemy.Enemy;
import Model.Enemy.EnemyType;
/**
 * 
 * @author Vlad
 *
 */
public interface Wave {

	int getWave();
	
	void populate(int quantity, EnemyType type);
	
	Enemy spawn();
	
	Wave nextWave();

	boolean hasEnemies();

}

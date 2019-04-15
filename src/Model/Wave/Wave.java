package Model.Wave;
import Model.Enemy.Enemy;
/**
 * 
 * @author Vlad
 *
 */
public interface Wave {

	int getWave();
	
	void populate(int quantity, Enemy.enemyType type);
	
	void spawn();
	
	Wave nextWave();
}

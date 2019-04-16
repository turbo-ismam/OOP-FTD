package Model.Wave;
import java.util.ArrayList;

import Model.Enemy.Enemy;
import Model.Enemy.Enemy.EnemyType;
import Model.Map.MapTile;
/**
 * 
 * @author Vlad
 *
 */
public interface Wave {

	int getWave();
	
	void populate(int quantity, EnemyType type, ArrayList<MapTile> path);
	
	Enemy spawn();
	
	Wave nextWave();

}

package Model.Wave;

import java.util.ArrayList;

import Model.Enemy.Enemy;

public interface Wave {

	int getWave();
	
	void setWave(int wave);
	
	int getEnemies(ArrayList<Enemy> enemyList); /*da cambiare, penso*/
}

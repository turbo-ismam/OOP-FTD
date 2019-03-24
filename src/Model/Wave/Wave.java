package Model.Wave;

import java.util.ArrayList;

import Model.Enemy.Enemy;
/**
 * 
 * @author SCRIVI IL TUO NOME
 *
 */
public interface Wave {

	int getWave();
	
	void setWave(int wave);
	
	int getEnemies(ArrayList<Enemy> enemyList); /*da cambiare, penso*/
}

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
	
	void addEnemy(Enemy e);

	void nextWave();

	boolean isEmpty();

	void spawn();
}

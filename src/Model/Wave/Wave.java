package Model.Wave;

import java.util.ArrayList;

import Model.Enemy.Enemy;
/**
 * 
 * @author Vlad
 *
 */
public interface Wave {

	int getWave();
	
	void setWave(int wave);
	
	void populate(int quantity, Enemy nemico);
	
	void spawn();
	
	void nextWave();
	
	boolean isEmpty();
}

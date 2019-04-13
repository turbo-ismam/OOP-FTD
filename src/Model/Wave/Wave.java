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
	
	void populate(int quantity, Enemy nemico);
	
	void spawn();
	
	Wave nextWave();
}

package Controller.GameController;

import utilityClasses.Pair;

/**
 * 
 * @author ismam.abu
 *
 */
public interface GameController {
	
	public void init();
	
	public void startWave();
	
	public void placeTower(Pair<Integer, Integer> location);
	
	
	
}

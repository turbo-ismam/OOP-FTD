package Model;

import java.util.ArrayList;

import Model.Entity.Entity;
import utilityClasses.Pair;

public interface GameModel {
	
	public void placeTower(Pair<Integer, Integer> location, int cost);
	
	public void removeTower(Pair<Integer, Integer> location);
	
	public ArrayList<Entity> getEntities();
	
	public GameStatus getGameStatus();
	
	public void update();
	
}

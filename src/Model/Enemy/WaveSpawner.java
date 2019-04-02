package Model.Enemy;

import java.util.ArrayList;

public class WaveSpawner {
	
	private ArrayList<Enemy> spawn = new ArrayList<Enemy>();

	
	public WaveSpawner() {
		super();
	}
	
	public ArrayList<Enemy> getSpawn() {
		return spawn;
	}
	
	public void spawner(int x){
		for(Enemy e : spawn) {
			spawn.get(spawn.indexOf(e)).spawn();;
		}
		spawn.removeAll(spawn);
	}
	

}

package Model.Wave;

import java.util.ArrayList;

import Model.Enemy.Enemy;
import Model.Enemy.Enemy.EnemyType;
import Model.Map.MapTile;
import Model.Enemy.SimpleEnemyModel;
import Model.Enemy.Tank;

public class WaveImpl implements Wave{
	
	private ArrayList<Enemy> ondata = new ArrayList<>();
	private int Numero_Ondata;

	public WaveImpl(int numero_Ondata) {
		super();
		Numero_Ondata = numero_Ondata;
	}

	@Override
	public int getWave() {
		return this.Numero_Ondata;
	}

	@Override
	public void populate(int quantity, EnemyType type, ArrayList<MapTile> path) {
		for(int a=0; a<quantity; a++) {
			if(type == EnemyType.BASIC) {
				Enemy basic = new SimpleEnemyModel();
				basic.setPath(path);
				ondata.add(basic);
			}
			if(type == EnemyType.TANK) {
				Enemy tank = new Tank();
				tank.setPath(path);
				ondata.add(tank);
			}
		}
	}
	
	@Override
	public Enemy spawn() {
	    Enemy e = null;
		if(!ondata.isEmpty()) {
		e = ondata.get(0);
		e.spawn();
		ondata.remove(0);
		}
		return e;
		
	}

	public ArrayList<Enemy> getOndata() {
		return ondata;
	}
	
	@Override
	public Wave nextWave() {
		return new WaveImpl(this.getWave()+1);
	}
}

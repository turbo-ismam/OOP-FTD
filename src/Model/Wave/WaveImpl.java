package Model.Wave;

import java.util.ArrayList;

import Model.Enemy.Enemy;
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
	public void populate(int quantity, Enemy.enemyType type) {
		for(int a=0; a<quantity; a++) {
			if(type == Enemy.enemyType.BASIC) {
				Enemy basic = new SimpleEnemyModel();
				ondata.add(basic);
			}
			if(type == Enemy.enemyType.TANK) {
				Enemy tank = new Tank();
				ondata.add(tank);
			}
		}
	}
	
	@Override
	public void spawn() {
		if(!ondata.isEmpty()) {
		 ondata.get(0);
		ondata.remove(0);
		}
	}

	public ArrayList<Enemy> getOndata() {
		return ondata;
	}
	
	@Override
	public Wave nextWave() {
		return new WaveImpl(this.getWave()+1);
	}
}

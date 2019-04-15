package Model.Wave;

import java.util.ArrayList;

import Model.Enemy.Enemy;

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
	public void populate(int quantity, Enemy nemico) {
		for(int a=0; a<quantity; a++) {
			ondata.add(nemico);
		}
	}
	
	public void addEnemy(Enemy e) {
		
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

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	
}

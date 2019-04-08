package Model.Wave;

import java.util.ArrayList;

import Model.Enemy.Enemy;

public class WaveImpl implements Wave{
	
	int wave;

	public WaveImpl(int i) {
		this.wave=i;
	}

	@Override
	public int getWave() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setWave(int wave) {
		// TODO Auto-generated method stub
		
	}
	
	public void addEnemy(Enemy e) {
		
	}

	@Override
	public void nextWave() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void spawn() {
		// TODO Auto-generated method stub
		
	}
}

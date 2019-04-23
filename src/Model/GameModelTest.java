package Model;

import static org.junit.Assert.*;

import javax.swing.plaf.synth.SynthSeparatorUI;

import Model.Enemy.EnemyType;
import Model.Tower.TowerType;
import Model.Wave.Wave;
import utilityClasses.Pair;

public class GameModelTest {
	
	private static final int TICKS_TO_SPAWN_ENEMY = 10+1;
	private static final int TICKS_ENEMY_WALK = 10+1;
	GameModel gm = new GameModelImpl(1);


	@org.junit.Test
	public void PlaceAndRemoveTowersTest() {
		gm.placeTower(new Pair<>(1,2), TowerType.BASIC);
		assertTrue(gm.getGameStatus()==GameStatus.PLAYING);
		assertTrue(gm.getMap().getEntityList().stream().count()==1);
		gm.removeTower(new Pair<>(1, 2));
		assertTrue(gm.getMap().getEntityList().stream().count()==0);
		
	}
	
	@org.junit.Test
	public void SpawnEnemiesTest() {
	        Wave w = gm.getCurrentWave();
		w.populate(5, EnemyType.SIMPLE);
		assertEquals(true, w.hasEnemies());
		gm.setReadyToSpawn(true);
		for(int i=0; i<=TICKS_ENEMY_WALK*2; i++) {
        	gm.update();
        }
		assertEquals(gm.getMap().getEntityList().stream().count(), 2);
	}
	
	@org.junit.Test
	public void GoToNextWaveTest() {
		gm.nextWave();
		Wave w =gm.getCurrentWave();
		w.populate(1, EnemyType.TANK);	
		assertEquals(w.getWave(),2);
	}
	
	@org.junit.Test
        public void EnemyWalkTest() {
                gm.nextWave();
                Wave w =gm.getCurrentWave(); 
                gm.setReadyToSpawn(true);
                assertEquals(w.getWave(),2);
                
                for(int i=0; i<=TICKS_TO_SPAWN_ENEMY*2; i++) {
                	gm.update();
                	
                }
                assertEquals(2,gm.getMap().getEntityList().stream().count());
        }
	
	
	@org.junit.Test
	public void GameWinTest() {
		
		gm.getPlayer().setWave(21);
		gm.update();
		assertTrue(gm.getGameStatus()==GameStatus.WON);
	}

	@org.junit.Test
	public void GameLostTest() {
        gm.setReadyToSpawn(true);
        for(int i=0; i<=TICKS_TO_SPAWN_ENEMY*4; i++) {
        	gm.update();
        }
        for(int i=0; i<=TICKS_ENEMY_WALK*gm.getMap().getPathList().size()-1; i++) {
        	gm.update();
        }
		assertTrue(gm.getGameStatus()==GameStatus.LOST);
	}
}

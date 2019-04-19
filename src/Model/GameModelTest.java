package Model;

import static org.junit.Assert.*;

import Model.Enemy.Enemy;
import Model.Enemy.Enemy.EnemyType;
import Model.Tower.TowerType;
import Model.Wave.Wave;
import utilityClasses.Pair;

public class GameModelTest {
	
	GameModel gm = new GameModelImpl(1);


	@org.junit.Test
	public void PlaceAndRemoveTowersTest() {
		gm.placeTower(new Pair<>(1,2), TowerType.BASIC);
		assertTrue(gm.getGameStatus()==GameStatus.PLAYING);
		assertTrue(gm.getMap().entityList().stream().count()==1);
		gm.removeTower(new Pair<>(1, 2));
		assertTrue(gm.getMap().entityList().stream().count()==0);
		
	}
	
	@org.junit.Test
	public void SpawnEnemiesTest() {
	        Wave w = gm.getCurrentWave();
		w.populate(5, EnemyType.BASIC, gm.getMap().pathList());
		gm.update();
		gm.update();
		System.out.println(gm.getMap().entityList());
		assertEquals(gm.getMap().entityList().stream().count(), 2);
	}
	
	@org.junit.Test
	public void GoToNextWaveTest() {
		gm.nextWave();
		Wave w =gm.getCurrentWave();
		w.populate(1, EnemyType.TANK, gm.getMap().pathList());	
		assertEquals(w.getWave(),2);
	}
	
	@org.junit.Test
        public void EnemyWalkTest() {
                gm.nextWave();
                Wave w =gm.getCurrentWave();
                w.populate(5, EnemyType.TANK, gm.getMap().pathList());  
                assertEquals(w.getWave(),2);
                gm.update();
                gm.update();
                System.out.println(gm.getMap().entityList());
                assertEquals(gm.getMap().entityList().stream().count(), 2);
                System.out.println("hi ther");
                gm.getMap().entityList().stream().filter(e-> e instanceof Enemy).forEach(e-> System.out.println(e.getLocation()));
                gm.update();
                gm.getMap().entityList().stream().filter(e-> e instanceof Enemy).forEach(e-> System.out.println(e.getLocation()));
        }
	
	
	@org.junit.Test
	public void GameWinTest() {
		
		gm.getPlayer().setWave(21);
		gm.update();
		assertTrue(gm.getGameStatus()==GameStatus.WON);
	}

	@org.junit.Test
	public void GameLostTest() {
		
		gm.getPlayer().takeDamage(9999);
		gm.update();
		assertTrue(gm.getGameStatus()==GameStatus.LOST);
	}
}

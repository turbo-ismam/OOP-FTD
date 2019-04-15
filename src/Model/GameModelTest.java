package Model;

import static org.junit.Assert.*;

import Model.Tower.TowerType;
import utilityClasses.Pair;

class GameModelTest {
	
	GameModel gm = new GameModelImpl();


	@org.junit.Test
	void PlaceAndRemoveTowersTest() {
		
		gm.placeTower(new Pair<>(1,2), TowerType.BASIC);
		assertTrue(gm.getGameStatus()==GameStatus.PLAYING);
		assertTrue(gm.getEntities().stream().count()==1);
		gm.removeTower(new Pair<>(1, 2));
		assertTrue(gm.getEntities().stream().count()==0);
		
	}
	
	@org.junit.Test
	void SpawnEnemiesTest() {
		gm.nextWave();
	}
	
	@org.junit.Test
	void GoToNextWaveTest() {
		gm.nextWave();
	}
	
	
	@org.junit.Test
	void GameWinTest() {
		
		gm.getPlayer().setWave(21);
		gm.update();
		assertTrue(gm.getGameStatus()==GameStatus.WON);
	}

	@org.junit.Test
	void GameLostTest() {
		
		gm.getPlayer().takeDamage(9999);
		gm.update();
		assertTrue(gm.getGameStatus()==GameStatus.LOST);
	}
}

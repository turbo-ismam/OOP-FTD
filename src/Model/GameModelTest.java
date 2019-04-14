package Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Model.Tower.TowerType;
import utilityClasses.Pair;

class GameModelTest {
	
	GameModel gm = new GameModelImpl();

	@Test
	void PlaceAndRemoveTowersTest() {
		
		gm.placeTower(new Pair<>(1,2), TowerType.BASIC);
		assertTrue(gm.getGameStatus()==GameStatus.PLAYING);
		assertTrue(gm.getEntities().stream().count()==1);
		gm.removeTower(new Pair<>(1, 2));
		assertTrue(gm.getEntities().stream().count()==0);
		
	}
	
	@Test
	void SpawnEnemiesTest() {
		gm.nextWave();
	}
	
	@Test
	void GoToNextWaveTest() {
		gm.nextWave();
	}
	
	
	@Test
	void GameWinTest() {
		
		gm.getPlayer().setWave(21);
		gm.update();
		assertTrue(gm.getGameStatus()==GameStatus.WON);
	}

	@Test
	void GameLostTest() {
		
		gm.getPlayer().takeDamage(9999);
		gm.update();
		assertTrue(gm.getGameStatus()==GameStatus.LOST);
	}
}

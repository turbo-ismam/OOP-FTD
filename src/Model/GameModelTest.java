package Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import utilityClasses.Pair;

class GameModelTest {

	@Test
	void test() {
		GameModel gm = new GameModelImpl();
		gm.placeTower(new Pair<>(2, 6), 0);
		gm.placeTower(new Pair<>(3, 2), 0);
		gm.placeTower(new Pair<>(1, 2), 0);
		assertTrue(gm.getGameStatus()==GameStatus.PLAYING);
		assertTrue(gm.getEntities().stream().count()==3);
		gm.removeTower(new Pair<>(1, 2));
		assertTrue(gm.getEntities().stream().count()==2);
		
	}

}

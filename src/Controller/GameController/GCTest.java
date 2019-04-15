package Controller.GameController;

import static org.junit.Assert.*;

import Model.GameModel;
import Model.GameModelImpl;
import Model.GameStatus;

class GCTest {
	GameModel gm = new GameModelImpl();
	GameController gc = new GameControllerImpl(gm);

	@org.junit.Test
	void test() {
		gc.startGame();
		gm.getPlayer().takeDamage(220000);
		System.out.println(gm.getPlayer().getHp());
		assertTrue(gm.getGameStatus()== GameStatus.LOST);
	}

}

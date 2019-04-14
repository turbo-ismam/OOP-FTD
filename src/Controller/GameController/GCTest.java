package Controller.GameController;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Model.GameModel;
import Model.GameModelImpl;
import Model.GameStatus;

class GCTest {
	GameModel gm = new GameModelImpl();
	GameController gc = new GameControllerImpl(gm);

	@Test
	void testWin() {
		gc.startGame();
		gm.getPlayer().takeDamage(220000);
		System.out.println(gm.getPlayer().getHp());
		assertTrue(gm.getGameStatus()== GameStatus.LOST);
	}

}

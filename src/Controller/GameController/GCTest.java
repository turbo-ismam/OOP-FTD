package Controller.GameController;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Model.GameModel;
import Model.GameModelImpl;

class GCTest {
	GameModel gm = new GameModelImpl();
	GameController gc = new GameControllerImpl(gm);

	@Test
	void test() {
		gc.startGame();
	}

}

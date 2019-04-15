package Controller.GameController;



import Model.GameModel;
import Model.GameModelImpl;

class GCTest {
	GameModel gm = new GameModelImpl();
	GameController gc = new GameControllerImpl(gm);

	@org.junit.Test
	void test() {
		gc.startGame();
	}

}

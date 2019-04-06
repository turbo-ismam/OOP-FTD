package Controller.GameController;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import utilityClasses.Pair;


class ControllerTest {

	@Test
	void test() {
		GameController gc = new GameControllerImpl();
		gc.init();
		gc.placeTower(new Pair<Integer, Integer>(1,3));
		gc.placeTower(new Pair<Integer, Integer>(2,3));
		gc.placeTower(new Pair<Integer, Integer>(5,13));
		gc.placeTower(new Pair<Integer, Integer>(3,3));
		gc.placeTower(new Pair<Integer, Integer>(0,5));
		assertTrue(true);
		fail("Not yet implemented");
	}

}

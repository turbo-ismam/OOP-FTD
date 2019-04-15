package Controller.GameController;

import static org.junit.Assert.*;

import Model.GameModel;
import Model.GameModelImpl;
import Model.GameStatus;
import Model.Tower.TowerType;
import utilityClasses.Pair;

public class GCTest {
	
	public GCTest() {};
	
	
	GameModel gm = new GameModelImpl();
	GameController gc = new GameControllerImpl(gm);
	@org.junit.Test
	public void test() {
		gc.startGame();
		gm.getPlayer().takeDamage(220000);
		gm.update();
		System.out.println(gm.getPlayer().getHp());
		assertTrue(gm.getGameStatus()== GameStatus.LOST);
	}
	@org.junit.Test
	public void test2() {
		gm.placeTower(new Pair<Integer, Integer>(1,1), TowerType.BASIC);
		assertEquals(gm.getEntities().stream().count(), 1);
	}
	

}

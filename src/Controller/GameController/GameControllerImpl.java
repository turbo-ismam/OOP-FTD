package Controller.GameController;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import Model.GameModel;
import Model.GameModelImpl;
import Model.Enemy.Enemy.EnemyType;
import Model.Tower.TowerType;
import Model.Wave.Wave;
import View.Input.Input;
import View.Input.InputImpl;
import View.Input.InputType;
import utilityClasses.Pair;

public class GameControllerImpl implements GameController {
	private final GameModel gm;
	public final ScheduledThreadPoolExecutor ses;
	GameLoop gl;
	
	public GameControllerImpl(GameModel gm) {
		this.ses =new ScheduledThreadPoolExecutor(1);
		this.gm=gm;
		gl = new GameLoop(gm);
	}
	@Override
	public void startGame() {
			ses.scheduleWithFixedDelay(gl, 0, 16, TimeUnit.MILLISECONDS);
			System.out.println("Game is running...");
		
	}
	
	@Override 
	public void pauseGame() {
		gl.pause();
	}
	
	@Override
	public void resumeGame() {
		gl.resume();
	}
	
	@Override
	public void handleInput(Input i) {
		gl.addInput(i);
	}
	
	public static void main(String[] args) {
		GameModel gm = new GameModelImpl();
		GameController gc = new GameControllerImpl(gm);
		gc.startGame();
		Wave w=gm.getCurrentWave();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		w.populate(5, EnemyType.TANK, gm.getMap().pathList());  
		
		Input i1 = new InputImpl(InputType.ADD_TOWER, 1, 1);
		Input i2 = new InputImpl(InputType.ADD_TOWER, 1, 2);
		Input i3 = new InputImpl(InputType.ADD_TOWER, 1, 3);
		Input i4 = new InputImpl(InputType.REMOVE_TOWER, 1, 1);
		gc.handleInput(i1);
		gc.handleInput(i2);
		gc.handleInput(i3);
		gc.handleInput(i4);  
	}
}
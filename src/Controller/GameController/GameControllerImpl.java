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

public class GameControllerImpl implements GameController {
	private GameModel gm;
	private final ScheduledThreadPoolExecutor ses;
	private boolean running; 
	private int difficulty =3;
	GameLoop gl;
	
	public GameControllerImpl() {
		this.ses =new ScheduledThreadPoolExecutor(1);
		this.running = false;
		
	}
	@Override
	public void startGame() {
		gm = new GameModelImpl(difficulty);
		gl = new GameLoop(gm);
		if (!running) {
			ses.scheduleWithFixedDelay(gl, 0, 50, TimeUnit.MILLISECONDS);
			System.out.println("Game is starting");
			this.running=true;
		}
		
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
	
	@Override
	public GameModel getModel() {
		return this.gm;
	}
	@Override
	public void setDifficulty(int d) {
		this.difficulty=d;
		
	}
	
	public static void main(String[] args) {
		GameController gc = new GameControllerImpl();
		gc.startGame();
		Wave w=gc.getModel().getCurrentWave();
		
		/**gc.pauseGame();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		w.populate(5, EnemyType.TANK, gm.getMap().pathList());  
		gc.resumeGame();
		*/
		
		Input i1 = new InputImpl(InputType.ADD_TOWER, TowerType.BASIC, gc.getModel().getMap().pathList().get(0).getPosition().getX()+1,gc.getModel().getMap().pathList().get(0).getPosition().getY()+1);
		Input i2 = new InputImpl(InputType.ADD_TOWER, TowerType.BASIC,1, 1);
		Input i3 = new InputImpl(InputType.ADD_TOWER, TowerType.BASIC, 1, 3);
		Input i4 = new InputImpl(InputType.REMOVE_TOWER, TowerType.BASIC, 1, 1);
		gc.handleInput(i1);
		gc.handleInput(i2);
		gc.handleInput(i3);
		gc.handleInput(i4); 
		
	}
}
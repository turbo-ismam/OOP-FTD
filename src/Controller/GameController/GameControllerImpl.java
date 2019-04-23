package Controller.GameController;

import java.util.concurrent.ScheduledThreadPoolExecutor;

import java.util.concurrent.TimeUnit;
import Model.GameModel;
import Model.GameModelImpl;
import Model.Tower.TowerType;
import Model.Wave.Wave;
import View.GameView.GameScreen;
import View.Input.Input;
import View.Input.InputImpl;
import View.Input.InputType;

/**
 * 
 * @author marco
 *
 */
public class GameControllerImpl implements GameController {
	private GameModel gm;
	private GameScreen v;
	private final ScheduledThreadPoolExecutor ses;
	private boolean running; 
	private int difficulty =3;
	GameLoop gl;
	
	public GameControllerImpl() {
		this.ses =new ScheduledThreadPoolExecutor(1);
		this.running = false;
		
	}
	@Override
	public void init() {
		gm = new GameModelImpl(difficulty);
	}
	
	@Override
	public void startLoop(GameScreen v) {
		this.v=v;
		gm.setReadyToSpawn(true);
		gl = new GameLoop(gm, v);
		if (!running) {
			ses.scheduleWithFixedDelay(gl, 0, 16, TimeUnit.MILLISECONDS);
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
	public void killGameLoop() {
		ses.shutdown();
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
	
	/*public static void main(String[] args) {
		GameController gc = new GameControllerImpl();
		gc.init();
		Wave w=gc.getModel().getCurrentWave();
		
		/**gc.pauseGame();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		w.populate(5, EnemyType.TANK, gm.getMap().pathList());  
		gc.resumeGame();
		
		Input i1 = new InputImpl(InputType.ADD_TOWER, TowerType.BASIC, gc.getModel().getMap().pathList().get(0).getPosition().getX()+1,gc.getModel().getMap().pathList().get(0).getPosition().getY()+1);
		Input i2 = new InputImpl(InputType.ADD_TOWER, TowerType.BASIC,1, 1);
		Input i3 = new InputImpl(InputType.ADD_TOWER, TowerType.BASIC, 1, 3);
		Input i4 = new InputImpl(InputType.REMOVE_TOWER, TowerType.BASIC, 1, 1);
		gc.handleInput(i1);
		gc.handleInput(i2);
		gc.handleInput(i3);
		gc.handleInput(i4); 
		gc.handleInput(new InputImpl(InputType.START_WAVE, TowerType.BASIC, 2, 4));
		
	}
	*/
}
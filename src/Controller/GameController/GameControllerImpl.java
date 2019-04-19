package Controller.GameController;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import Model.GameModel;
import Model.GameModelImpl;
import Model.Enemy.Enemy.EnemyType;
import View.Input.Input;

public class GameControllerImpl implements GameController {
	private GameModel gm;
	private final ScheduledThreadPoolExecutor ses;
	private boolean running; 
	private int difficulty =1;
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
			ses.scheduleWithFixedDelay(gl, 0, 1, TimeUnit.SECONDS);
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
		gc.getModel().getCurrentWave().populate(5, EnemyType.TANK, gc.getModel().getMap().pathList());
		
		/**gc.pauseGame();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gc.resumeGame();
		*/
		
	
	}
}
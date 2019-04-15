package Controller.GameController;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import Model.GameModel;
import Model.GameModelImpl;
import Model.Tower.TowerType;
import utilityClasses.Pair;

public class GameControllerImpl implements GameController {
	private final GameModel gm;
	public final ScheduledThreadPoolExecutor ses;
	private boolean running; 
	GameLoop gl;
	
	public GameControllerImpl(GameModel gm) {
		this.ses =new ScheduledThreadPoolExecutor(1);
		this.gm=gm;
		this.running = false;
		gl = new GameLoop(gm);
	}
	@Override
	public void startGame() {
		if (!running) {
			ses.scheduleWithFixedDelay(gl, 0, 1, TimeUnit.SECONDS);
			System.out.println("hello world2");
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
	public void handleInput() {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		GameModel gm = new GameModelImpl();
		GameController gc = new GameControllerImpl(gm);
		gc.startGame();
		
		gc.pauseGame();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gc.resumeGame();
		System.out.println(gm.getEntities());
		gm.placeTower(new Pair<Integer,Integer>(2,3), TowerType.BASIC);
		System.out.println(gm.getEntities());
		
	
	}
}
package Controller.GameController;

import java.io.IOException;
import java.util.ArrayList;

import Model.GameModel;
import Model.Enemy.Enemy;
import Model.Tower.TowerType;
import View.GameView.GameScreen;
import View.Input.Input;
import utilityClasses.Pair;

public class GameLoop implements Runnable {
	private final GameModel gm;
	private boolean running;
	private int i;

	private ArrayList<Input> inputList;
	private GameScreen v;
 
	public GameLoop(GameModel gm, GameScreen v) {
		this.gm=gm;
		this.v=v;
		this.inputList = new ArrayList<>();
		this.running=true;

	}
	
	@Override
	public void run() {
				if(running) {

				//input process	
				this.processInput();
				//model update
				gm.update();
				System.out.println("update N-" +i);
				System.out.println("oggetti nella mappa : " + gm.getMap().entityList().stream().count());
				if(!gm.getMap().entityList().isEmpty()) {
					gm.getMap().entityList().stream()
					.forEach(e -> System.out.println(e));		
				}
				//render view
				v.render(gm.getMap().entityList());
				i++; //variabili di debug
				}
				else { //pause block
					try {
						Thread.sleep(500);
						System.out.println("PAUSED");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			
	}
	public void resume() {
		this.running=true;
	}
	
	public void pause() {
		this.running=false;
	}
	
	public void addInput(Input input) {
	    this.inputList.add(input);
	}
	
	private void processInput() {
		
		if(!inputList.isEmpty()) {
			inputList.forEach(e -> {
	            switch (e.getInputType()) {
	            case ADD_TOWER :
	            	gm.placeTower(new Pair<Integer,Integer>(e.getX(), e.getY()), TowerType.BASIC);
	            	System.out.println("torre piazzata in" + e.getX() + ","+ e.getY());
	                break;
	            case REMOVE_TOWER :
	            	gm.removeTower(new Pair<Integer,Integer>(e.getX(), e.getY()));
	                break;
	            case START_WAVE :
	            	gm.setReadyToSpawn(true);
	            	System.out.println("ready");
	            	break;
	            default:
	                break;
	            }
	        });
			inputList.clear();
		}
		
	}
}
package Controller.GameController;

import java.util.ArrayList;

import Model.GameModel;
import Model.Tower.TowerType;
import utilityClasses.Pair;

public class GameLoop implements Runnable {
	private final GameModel gm;
	private boolean running;
	private int i;
	
 
	public GameLoop(GameModel gm) {
		this.gm=gm;
		this.running= true;
	}
	
	@Override
	public void run() {
				if(running) {

				//input process
				this.processInput(new ArrayList<>());
				//model update
				gm.update();
				System.out.println("Update " +i);
				System.out.println(gm.getMap().entityList());
				
				//render view
				i++; //variabili di debug
				}
				else {
					try {
						Thread.sleep(500);
						System.out.println("PAUSED");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
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
	private void processInput(ArrayList<Integer> input) {
		
		input.stream().forEach(e -> {
            switch (e.intValue()) {
            case 1 :
            	gm.placeTower(new Pair<Integer,Integer>(1,1), TowerType.BASIC);
                break;
            case 2:
            	gm.removeTower(new Pair<Integer,Integer>(1,1));
                break;
            default:
                break;
            }
        });
	}
}
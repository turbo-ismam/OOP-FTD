package Controller.GameController;

import java.util.ArrayList;

import Model.GameModel;
import Model.Tower.TowerType;
import utilityClasses.Pair;

public class GameLoop implements Runnable {
	private GameModel gm;
	private boolean running;
	private int i;
	//private View v;
 
	public GameLoop(GameModel gm) {
		this.gm=gm;
	}
	
	@Override
	public void run() {
				if(running) {

				//input process
				this.processInput(new ArrayList<>());
				//model update
				gm.update();
				System.out.println("hello thread" +i);
				
				//render view
				i++;
				}
				else {
					try {
						Thread.sleep(500);
						System.out.println("im pausing but im running");
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
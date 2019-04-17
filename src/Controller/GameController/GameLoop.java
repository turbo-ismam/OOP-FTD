package Controller.GameController;

import java.util.ArrayList;

import Model.GameModel;
import Model.Tower.TowerType;
import View.Input.Input;
import View.Input.InputType;
import utilityClasses.Pair;

public class GameLoop implements Runnable {
	private GameModel gm;
	private boolean running;
	private int i;
	private ArrayList<Input> inputList;
	//private View v;
 
	public GameLoop(GameModel gm) {
		this.gm=gm;
		this.inputList = new ArrayList<>();
	}
	
	@Override
	public void run() {
				if(running) {

				//input process
				this.processInput();
				//model update
				gm.update();
				System.out.println("hello thread" +i);
				
				//render view
				i++;
				}
				else {
					try {
						Thread.sleep(500);
						System.out.println("Pause..");
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
	public void addInput(Input input) {
	    this.inputList.add(input);
	}
	private void processInput() {
		
		inputList.stream().forEach(e -> {
            switch (e.getInputType()) {
            case ADD_TOWER :
            	gm.placeTower(new Pair<Integer,Integer>(e.getX(), e.getY()), TowerType.BASIC);
                break;
            case REMOVE_TOWER :
            	gm.removeTower(new Pair<Integer,Integer>(e.getX(), e.getY()));
                break;
            default:
                break;
            }
        });
	}
}
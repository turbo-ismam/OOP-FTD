package Controller.GameController;

import Model.GameModel;

public class GameLoop extends Thread {
	
	private boolean running;
	private GameModel gm;
	//private View v;
	
	public GameLoop(GameModel gm) {
		this.running=true;
		this.gm=gm;
	}
	
	public void start() {
		long sleepTime = 1000L /60L;
	    int i=0;
		while(running) {
			//process input
			
			//update model
			gm.update();
			
			//render view
			//v.render();
			System.out.println("update :" + i); //debug printline, to be removed
			i++;
			try {
				sleep(sleepTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i>500) {
				this.running=false;
			}
			
		}
	}
	

}

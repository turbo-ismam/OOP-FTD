package Controller.GameController;

import Model.GameModel;
import Model.GameModelImpl;

public class GameControllerImpl implements GameController {
	
	//View v;
	private GameModel gm;
	
	public GameControllerImpl(GameModel gm) {
		this.gm=gm;
	}
	

	@Override
	public void startGame() {
		System.out.println("hello world");
		
		GameLoop gl = new GameLoop(gm);
		gl.start();

	}

}

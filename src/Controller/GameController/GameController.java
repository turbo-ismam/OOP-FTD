package Controller.GameController;

import View.Input.Input;

public interface GameController {
	
	void startGame();
	
	void handleInput(Input i);

	void pauseGame();
	
	void resumeGame();
	
}

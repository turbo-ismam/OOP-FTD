package Controller.GameController;

import Model.GameModel;
import View.Input.Input;

public interface GameController {
	
	void startGame();
	
	void handleInput(Input i);

	void pauseGame();
	
	void resumeGame();

	GameModel getModel();

	void setDifficulty(int d);
	
}

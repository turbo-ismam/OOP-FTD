package Controller.GameController;

import Model.GameModel;
import View.GameView.GameScreen;
import View.Input.Input;

public interface GameController {
	/**
	 * Starts the gameloop
	 */
	void init();
	
	/**
	 * pauses the game
	 */

	void pauseGame();
	
	/**
	 * resumes the game
	 */
	void resumeGame();

	GameModel getModel();

	void setDifficulty(int d);
	
	/**
	 * 	This method gets the input from the View and passes it to the GameLoop
	 * @param i
	 */
	void handleInput(Input i);

	void killGameLoop();

	void startLoop(GameScreen v);
	
}

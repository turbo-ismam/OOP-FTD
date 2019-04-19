package Controller.GameController;

import View.Input.Input;

public interface GameController {
	/**
	 * Starts the gameloop
	 */
	void startGame();
	
	/**
	 * pauses the game
	 */

	void pauseGame();
	
	/**
	 * resumes the game
	 */
	void resumeGame();
	
	/**
	 * 	This method gets the input from the View and passes it to the GameLoop
	 * @param i
	 */
	void handleInput(Input i);
	
}

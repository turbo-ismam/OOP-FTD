package View.Input;

import java.util.Optional;

import Model.Tower.TowerType;

/**
 * 
 * @author ismam
 * Public Classfor inputs
 *
 */
public interface Input {
	
	/**
     * Returns the horizontal position of the player's click in the window.
     * 
     * @return x position
     */
    double getX();

    /**
     * Returns the vertical position of the player's click in the window.
     * 
     * @return y position
     */
    double getY();

    /**
     * Method to return the type of the Input.
     * 
     * @return InputType (ADD,REMOVE)
     */
    InputType getInputType();

}

package View.Input;

import java.util.ArrayList;

/**
 * 
 * @author ismam
 * Class for inputs managing
 *
 */
public class InputManager {

	private ArrayList<InputImpl> inputList = new ArrayList<>();
	
	/**
	 * Public constructor
	 */
	public InputManager() {
		
	}
	
	/**
	 * Method to get the list of input
	 * 
	 * @return inputList
	 */
	public ArrayList<InputImpl> getList(){
		
		return this.inputList;
	}
	
	/**
	 * Method to add input to the list of input
	 * 
	 * @param input
	 */
	public void addInput(final InputImpl input) {
		
		this.inputList.add(input);
	}
	
	/**
	 * Method to clear the list of input
	 */
	public void clearList() {
		
		this.inputList.clear();
	}
	
}

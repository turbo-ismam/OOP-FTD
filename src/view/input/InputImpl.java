package view.input;

import model.tower.TowerType;

/**
 * This Class implements the interface Input.
 */
public class InputImpl implements Input{

	private final int x;
	private final int y;
	private final InputType inputType;
	private final TowerType tType;
	
	/**
     * Public constructor.
     * 
     * @param iType
     *            the type of the input
     * @param x
     *            the x position of the tower
     * @param y
     *            the y position of the tower
     */
	public InputImpl(final InputType iType,final TowerType tType,final int x,final int y) {
		this.x = x;
		this.y = y;
		this.inputType = iType;
		this.tType = tType;
	}
	
	@Override
	public int getX() {
		
		return this.x;
	}

	@Override
	public int getY() {

		return this.y;
	}

	@Override
	public InputType getInputType() {
		
		return this.inputType;
	}
	
	@Override
	public String toString() {
		return inputType.toString() + " "+ x + " " + y;
		
	}

	@Override
	public TowerType getTowerType() {
		return this.tType;
	}

}

package View.Input;

import java.util.Optional;

import Model.Tower.TowerType;

/**
 * Public Class fot inputs
 *
 */

public class InputImpl implements Input{

	private final int x;
	private final int y;
	private final InputType inputType;
	private final Optional<TowerType> towerType;
	
	/**
     * Public constructor.
     * 
     * @param iType
     *            the type of the input
     * @param x
     *            the x position of the tower
     * @param y
     *            the y position of the tower
     * @param tType
     *            the tower type
     */
	public InputImpl(final InputType iType, final int x, final int y, final TowerType tType) {
		this.x = x;
		this.y = y;
		this.inputType = iType;
		this.towerType = Optional.ofNullable(tType);
	}
	
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
	public InputImpl(final InputType iType, final int x, final int y) {
		this.x = x;
		this.y = y;
		this.inputType = iType;
		this.towerType = Optional.empty();
	}
	
	@Override
	public double getX() {
		
		return this.x;
	}

	@Override
	public double getY() {

		return this.y;
	}

	@Override
	public InputType getInputType() {
		
		return this.inputType;
	}

	@Override
	public Optional<TowerType> getTower() {
		
		return this.towerType;
	}

}

package Controller.MapController;

import Model.MapModel.MapTile;

public interface MapController {
		
	/**
	 * @param position
	 * @return true if you can place a tower
	 */
	public boolean positionable(int position);
	
	/**
	 * @param position
	 * @return true if the tile is empty
	 */
	public boolean isEMPTY(int position);
	
	/**
	 * @param position
	 * @return true if the tile is a path
	 */
	public boolean isPATH(int position);
	
	/**
	 * @param position
	 * @return true if the tile is taken by a tower
	 */
	public boolean isWITHTOWER(int position);
	
	/**
	 * @param position: index of the requested tile
	 * @return requested tile8
	 */
	public MapTile getTile(int position);
	
	/**
	 * Method to generate and place a new tower in the map
	 */
	public void placeTowerMap();
	
	
}

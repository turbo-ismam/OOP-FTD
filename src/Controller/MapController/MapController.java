package Controller.MapController;

import Model.Map.MapTile;

import utilityClasses.Pair;

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
	 * @param position
	 * @return true if the tile is taken by an enemy
	 */
	public boolean isWITHENEMY(int position);
	
	/**
	 * @param position: index of the requested tile
	 * @return requested tile
	 */
	public MapTile getTileInt(int position);
	
	/**
	 * 
	 * @param position: tile coordinates
	 * @return requested tile
	 */
	public MapTile getTilePair(Pair<Integer,Integer> position);
	
	/**
	 * Method to set a tile
	 */
	public void setTile(MapTile tile);
	
	/**
	 * from the arraylist position return a Pair
	 * @param position
	 * @return Pair<Integer,Integer>
	 */
	public Pair<Integer,Integer> fromIntToPair(int position);
	
	/**
	 * from the pair position return the position in the arraylist
	 * @param position
	 * @return
	 */
	public int fromPairToInt(Pair<Integer,Integer> position);

	
}

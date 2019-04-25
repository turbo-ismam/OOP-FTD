package model.map;

import utilityclasses.Pair;

/**
 * This class implements the interface MapTile
 */
public class MapTileImpl implements MapTile {

	private Pair<Integer,Integer> position;
	private Status status;
	
	/**
     * Constructor with position and status
     */
	public MapTileImpl(final int x,final int y) {
		
		position = new Pair<>(x,y);
		status = Status.EMPTY;
	}
	
	/**
	 * Empty Constructor
	 */
	public MapTileImpl() {
		
	}
	
	@Override
	public Pair<Integer, Integer> getPosition() {
		return position;
	}
	
	@Override
	public void setPosition(final Pair<Integer, Integer> position) {
		this.position = position;
	}
	
	@Override
	public Status getStatus() {
		return status;
	}
	
	@Override
	public void setStatus(final Status status) {
		this.status = status;
	}
	
}

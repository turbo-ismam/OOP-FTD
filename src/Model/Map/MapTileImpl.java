package Model.Map;

import utilityClasses.Pair;

public class MapTileImpl implements MapTile {


	Pair<Integer,Integer> position;
	Status status;
	
	/**
     * Constructor
     */
	public MapTileImpl(int o1,int o2) {
		
		position = new Pair<>(o1,o2);
		status = Status.EMPTY;
	}
	
	public Pair<Integer, Integer> getPosition() {
		return position;
	}
	
	public void setPosition(Pair<Integer, Integer> position) {
		this.position = position;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
	
}

package Map;
import utilityClasses.Pair;
import Map.Map.Status;

public class MapTile {

	Pair<Integer,Integer> position;
	Status status;
	
	/**
     * Constructor
     */
	public MapTile(int o1,int o2) {
		
		position = new Pair<>(o1,o2);
		status = Status.EMPTY;
		.
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

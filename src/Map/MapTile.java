package Map;
import utilityClasses.Pair;

public class MapTile {

	Pair<Integer,Integer> position;
	boolean status;
	
	/**
     * Constructor
     */
	public MapTile(int o1,int o2) {
		
		Pair<Integer,Integer> tmp = new Pair<>(o1,o2);
		position=tmp;
	}
	
	public Pair<Integer, Integer> getPosition() {
		return position;
	}
	
	public void setPosition(Pair<Integer, Integer> position) {
		this.position = position;
	}
	
	public boolean getStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
}

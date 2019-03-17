package Map;

import java.util.List;

public class SimpleMap implements Map {
	
	private List<MapTile> grid;

	public void createMap() {

		for (int i=0;i<20;i++) {
			for (int j=0;j<20;j++) {
				MapTile tile = new MapTile(i,j);
				grid.add(tile);
				
			}
		}
	}
	
	
	
	
}

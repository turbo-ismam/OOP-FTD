package Model.Map;

import Model.Map.MapTile.Status;

/**
 * 
 * @author ismam
 *
 */
public class HardMap extends AbstractMapModel {

	@Override
	void generatePath() {
		
		//dovrebbe creare un percorso, in questo caso una linea orizzontale dritta
				for (int i=0;i<gridSize*gridSize;i++) {			//provalo, non sono convinto
					if (grid.get(i).getPosition().getY()==10) {
						grid.get(i).setStatus(Status.PATH);
						enemyPath.add(grid.get(i));	//aggiungo alla lista il path
					}
				}
	}

}

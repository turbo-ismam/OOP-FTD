package model.map;


/**
 * This class extend the class AbstractMapModel to generate the path of the normal map
 */
public class NormalMap extends AbstractMapModel{

	@Override
	void generatePath() {

		for (int i=0;i<GRID_SIZE*GRID_SIZE;i++) {			// da 5,0 a 5,10 da sx a dx
			if (this.getTileList().get(i).getPosition().getX()==5 && this.getTileList().get(i).getPosition().getY()<=10) {
			    this.getTileList().get(i).setStatus(Status.PATH);
			    this.getPathList().add(this.getTileList().get(i));	
			}
		}
		for (int i=0;i<GRID_SIZE*GRID_SIZE;i++) {			// da 5,10 a 15,10 da sopra a sotto
			if (this.getTileList().get(i).getPosition().getX()>=5 && this.getTileList().get(i).getPosition().getX()<=15 && this.getTileList().get(i).getPosition().getY()==10) {
			    this.getTileList().get(i).setStatus(Status.PATH);
			    this.getPathList().add(this.getTileList().get(i));	
			}
		}
		for (int i=0;i<GRID_SIZE*GRID_SIZE;i++) {			// da 15,10 a 15,20 da sx a dx
			if (this.getTileList().get(i).getPosition().getX()==15 && this.getTileList().get(i).getPosition().getY()>=10) {
			    this.getTileList().get(i).setStatus(Status.PATH);
			    this.getPathList().add(this.getTileList().get(i));	
			}
		}
		
	}

}

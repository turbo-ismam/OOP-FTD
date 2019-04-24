package model.map;


/**
 * This class extend the class AbstractMapModel to generate the path of the Simple map
 */
public class SimpleMap extends AbstractMapModel {

	@Override	//ogni coppia è scritta come (x,y)
	void generatePath() {
		
		for (int i=0;i<gridSize*gridSize;i++) {			// da 5,0 a 5,10 da sx a dx
			if (this.getTileList().get(i).getPosition().getX()==5 && this.getTileList().get(i).getPosition().getY()<=10) {
			    this.getTileList().get(i).setStatus(Status.PATH);
			    this.getPathList().add(this.getTileList().get(i));	
			}
		}
		
		for (int i=0;i<gridSize*gridSize;i++) {			// da 5,10 a 10,10 da sopra a sotto
			if (this.getTileList().get(i).getPosition().getX()>=5 && this.getTileList().get(i).getPosition().getX()<=10 && this.getTileList().get(i).getPosition().getY()==10) {
			    this.getTileList().get(i).setStatus(Status.PATH);
			    this.getPathList().add(this.getTileList().get(i));	
			}
		}
		
		for (int i=0;i<gridSize*gridSize;i++) {			// da 10,10 a 10,5 da dx a sx
			if (this.getTileList().get(i).getPosition().getX()==10 && this.getTileList().get(i).getPosition().getY()>=5 && this.getTileList().get(i).getPosition().getY()<=10) {
			    this.getTileList().get(i).setStatus(Status.PATH);
			    this.getPathList().add(this.getTileList().get(i));	
			}
		}
		
		for (int i=0;i<gridSize*gridSize;i++) {			// da 10,5 a 15,5 da sopra a sotto
			if (this.getTileList().get(i).getPosition().getX()>=10 && this.getTileList().get(i).getPosition().getX()<=15 && this.getTileList().get(i).getPosition().getY()==5) {
			    this.getTileList().get(i).setStatus(Status.PATH);
			    this.getPathList().add(this.getTileList().get(i));	
			}
		}
		
		for (int i=0;i<gridSize*gridSize;i++) {			// da 15,5 a 15,15 da sx a dx
			if (this.getTileList().get(i).getPosition().getX()==15 && this.getTileList().get(i).getPosition().getY()>=5 && this.getTileList().get(i).getPosition().getY()<=15) {
			    this.getTileList().get(i).setStatus(Status.PATH);
			    this.getPathList().add(this.getTileList().get(i));	
			}
		}
		
		for (int i=0;i<gridSize*gridSize;i++) {			// da 15,15 a 2,15 da sotto a sopra
			if (this.getTileList().get(i).getPosition().getX()>=2 && this.getTileList().get(i).getPosition().getX()<=15 && this.getTileList().get(i).getPosition().getY()==15) {
			    this.getTileList().get(i).setStatus(Status.PATH);
			    this.getPathList().add(this.getTileList().get(i));	
			}
		}
		
		for (int i=0;i<gridSize*gridSize;i++) {			// da 2,15 a 2,20 da sx a dx
			if (this.getTileList().get(i).getPosition().getX()==2 && this.getTileList().get(i).getPosition().getY()>=15) {
			    this.getTileList().get(i).setStatus(Status.PATH);
			    this.getPathList().add(this.getTileList().get(i));	
			}
		}
		
		
	}

}

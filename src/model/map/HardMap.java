package model.map;


/**
 * This class extend the class AbstractMapModel to generate the path of the HardMap.
 */
public class HardMap extends AbstractMapModel {

    /**
     * {@inheritDoc}
     */
    @Override
    void generatePath() {
        for (int i = 0; i < this.getGridSize() * this.getGridSize(); i++) {
            if (this.getTileList().get(i).getPosition().getY() == 10) {
                this.getTileList().get(i).setStatus(Status.PATH);
                this.getPathList().add(this.getTileList().get(i));
            }
        }
    }
}

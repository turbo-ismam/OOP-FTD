package model.map;

import java.util.ArrayList;
import java.util.List;
import model.entity.Entity;
import utilityclasses.Pair;

/**
 * This class implements the interface Map.
 */
public abstract class AbstractMapModel implements Map {

    private List<MapTile> grid = new ArrayList<>();
    private List<MapTile> enemyPath = new ArrayList<>();
    private ArrayList<Entity> entity = new ArrayList<>();
    private final int gridSize = 20;

    /**
     * Constructor to generate a grid with a path
     * first for cycle generate the arraylist that contain the grid
     * second for cycle generate the enemy moviment path.
     */
    public AbstractMapModel() {
        generateGrid();
        generatePath();
    }

    /**
     * Method to generate the grid.
     */
    private void generateGrid() {
        for (int i = 0; i < gridSize; i++) { 
            for (int j = 0; j < gridSize; j++) {
                MapTile tile = new MapTileImpl(i, j);
                grid.add(tile);
            }
        }
    }

    /**
     * This method is an abstract method, other classes that extend this class will implement this method.
     */
    abstract void generatePath();

    /**
     * {@inheritDoc}
     */
    @Override
    public int getGridSize() {
        return gridSize;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArrayList<Entity> getEntityList(){
        ArrayList<Entity> copia = new ArrayList<>(entity);
        return copia;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArrayList<MapTile> getTileList() {
        return (ArrayList<MapTile>) this.grid;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArrayList<MapTile> getPathList() {
        return (ArrayList<MapTile>) this.enemyPath;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addEntity(final Entity e) {
        this.entity.add(e);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeEntity(final Pair<Integer, Integer> location) {
        entity.removeIf(e -> e.getLocation().equals(location));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeEntity(final Entity e) {
        entity.remove(e);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MapTile initialPosition() {
        return enemyPath.get(0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MapTile finalPosition() {
        return enemyPath.get(enemyPath.size());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean positionable(final Pair<Integer, Integer> position) {
        MapTile m = getTilePair(position);
        return m.getStatus() == Status.EMPTY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MapTile getTileInt(final int position) {
        return grid.get(position);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MapTile getTilePair(final Pair<Integer, Integer> position) {
        for (int i = 0; i < this.gridSize * this.gridSize; i++) {
            if (this.grid.get(i).getPosition().equals(position)) {
                return this.grid.get(i);
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setTile(final MapTile tile) {
        int tmp = tile.getPosition().getX() * this.gridSize + tile.getPosition().getY(); 
        grid.remove(tmp);
        grid.add(tmp, tile);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Pair<Integer, Integer> fromIntToPair(final int position) {
        int x = position / this.gridSize;
        int y = position % this.gridSize;
        return new Pair<>(x, y);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int fromPairToInt(final Pair<Integer, Integer> position) {
        return position.getX() * this.gridSize + position.getY();
    }
}


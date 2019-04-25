package model.map;

import java.util.ArrayList;
import java.util.List;
import model.entity.Entity;
import utilityclasses.Pair;

/**
 * This class implements the interface Map
 */
public abstract class AbstractMapModel implements Map {

    private final List<MapTile> grid = new ArrayList<>();
    private final List<MapTile> enemyPath = new ArrayList<>();
    private final List<Entity> entity = new ArrayList<>();
    protected static final int GRID_SIZE = 20;

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
        for (int i = 0; i < GRID_SIZE; i++) { 
            for (int j = 0; j < GRID_SIZE; j++) {
                final MapTile tile = new MapTileImpl(i, j);
                grid.add(tile);
            }
        }
    }
    
    /**
     * This method is an abstract method, other classes that extend this class will implement this method.
     */
    abstract void generatePath();

    @Override
    public int getGridSize() {
        return GRID_SIZE;
    }

    @Override
    public ArrayList<Entity> getEntityList(){
        return (ArrayList<Entity>) this.entity;
    }

    @Override
    public ArrayList<MapTile> getTileList() {
        return (ArrayList<MapTile>) this.grid;
    }

    @Override
    public ArrayList<MapTile> getPathList() {
        return (ArrayList<MapTile>) this.enemyPath;
    }

    @Override
    public void addEntity(final Entity e) {
        this.entity.add(e);
    }

    @Override
    public void removeEntity(final Pair<Integer, Integer> location) {
        entity.removeIf(e -> e.getLocation().equals(location));
    }

    @Override
    public void removeEntity(final Entity e) {
        entity.remove(e);
    }

    @Override
    public MapTile initialPosition() {
        return enemyPath.get(0);
    }

    @Override
    public MapTile finalPosition() {
        return enemyPath.get(enemyPath.size());
    }

    @Override
    public boolean positionable(final Pair<Integer, Integer> position) {
        final MapTile m = getTilePair(position);
        return m.getStatus() == Status.EMPTY;
    }

    @Override
    public MapTile getTileInt(final int position) {
        return grid.get(position);
    }

    @Override
    public MapTile getTilePair(final Pair<Integer, Integer> position) {
        for (int i = 0; i < GRID_SIZE * GRID_SIZE; i++) {
            if (this.grid.get(i).getPosition().equals(position)) {
                return this.grid.get(i);
            }
        }
        return null;
    }

    @Override
    public void setTile(final MapTile tile) {
        final int tmp = tile.getPosition().getX() * GRID_SIZE + tile.getPosition().getY(); 
        grid.remove(tmp);
        grid.add(tmp, tile);
    }

    @Override
    public Pair<Integer, Integer> fromIntToPair(final int position) {
        final int x = position / GRID_SIZE;
        final int y = position % GRID_SIZE;
        return new Pair<>(x, y);
    }

    @Override
    public int fromPairToInt(final Pair<Integer, Integer> position) {
        return position.getX() * GRID_SIZE + position.getY();
    }
}


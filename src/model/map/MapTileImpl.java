package model.map;

import utilityclasses.Pair;

/**
 * This class implements the interface MapTile.
 */
public class MapTileImpl implements MapTile {

    private Pair<Integer, Integer> position;
    private Status status;

    /**
     * Constructor with position and status.
     */
    public MapTileImpl(final int x, final int y) {

        position = new Pair<>(x, y);
        status = Status.EMPTY;
    }

    /**
     * Empty Constructor.
     */
    public MapTileImpl() {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Pair<Integer, Integer> getPosition() {
        return position;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPosition(final Pair<Integer, Integer> position) {
        this.position = position;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Status getStatus() {
        return status;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setStatus(final Status status) {
        this.status = status;
    }

}

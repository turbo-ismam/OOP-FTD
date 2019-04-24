package model.map;

/**
 * enumeration for the map tiles.
 */
public enum Status {

    /**
     * If there isn't anything in the tile.
     */
    EMPTY,
    /**
     * If in the tile is a pathTile.
     */
    PATH,
    /**
     * If in the tile is a tower.
     */
    WITHTOWER,
    /**
     * If in the tile is an enemy.
     */
    WITHENEMY
}

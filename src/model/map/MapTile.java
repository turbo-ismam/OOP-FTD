package model.map;

import utilityclasses.Pair;

/**
 * Interface of any MapTile.
 */
public interface MapTile {
		
        /**
         * Method to get the position
         * @return the position of the tile.
         */
		Pair<Integer, Integer> getPosition();
		
		/**
		 * Method to set the position of the tile
		 * @param position.
		 */
		void setPosition(Pair<Integer, Integer> position);
		
		/**
		 * Method to get the status
		 * @return the status of the tile.
		 */
		Status getStatus();
		
		/**
		 * Method to set the status of the tile
		 * @param status.
		 */
		void setStatus(Status status);
		
	}

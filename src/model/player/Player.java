package model.player;

/**
 * The interface of the Player.
 */
public interface Player {

    /**
     * Method to get the player name
     * @return name.
     */
	String getName();
	
	/**
	 * Method to get the player health point
	 * @return hp.
	 */
	int getHp();
	
	/**
	 * Metod to take damage
	 * @param damage.
	 */
	void takeDamage(int damage);
	
	/**
	 * Method to get che player coins
	 * @return coins.
	 */
	int getCoins();
	
	/**
	 * Method to add coins 
	 * @param coins.
	 */
	void incrementCoins(int coins);
	
	/**
	 * Method to get the number of the wave
	 * @return wave number.
	 */
	int getWave();
	
	/**
	 * Method to set the current wave
	 * @param wave.
	 */
	void setWave(int wave);

	/**
	 * Method to set the player name
	 * @param text.
	 */
	void setName(String text);

	
}

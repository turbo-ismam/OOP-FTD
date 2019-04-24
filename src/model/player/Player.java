package model.player;

/**
 * The interface of the Player.
 */
public interface Player {

    /**
     * Method to get the player name
     * @return name.
     */
	public String getName();
	
	/**
	 * Method to get the player health point
	 * @return hp.
	 */
	public int getHp();
	
	/**
	 * Metod to take damage
	 * @param damage.
	 */
	public void takeDamage(int damage);
	
	/**
	 * Method to get che player coins
	 * @return coins.
	 */
	public int getCoins();
	
	/**
	 * Method to add coins 
	 * @param coins.
	 */
	public void incrementCoins(int coins);
	
	/**
	 * Method to get the number of the wave
	 * @return wave number.
	 */
	public int getWave();
	
	/**
	 * Method to set the current wave
	 * @param wave.
	 */
	public void setWave(int wave);

	/**
	 * Method to set the player name
	 * @param text.
	 */
	public void setName(String text);

	
}

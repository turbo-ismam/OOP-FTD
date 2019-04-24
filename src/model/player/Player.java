package model.player;

/**
 * The interface of the Player.
 */
public interface Player {

    /**
     * Method to get the player name.
     * @return name name
     */
    String getName();

    /**
     * Method to get the player health point.
     * @return hp hp
     */
    int getHp();

    /**
     * Metod to take damage.
     * @param damage damage
     */
    void takeDamage(int damage);

    /**
     * Method to get che player coins.
     * @return coins coins
     */
    int getCoins();

    /**
     * Method to add coins. 
     * @param coins coins
     */
    void incrementCoins(int coins);

    /**
     * Method to get the number of the wave.
     * @return wave number.
     */
    int getWave();

    /**
     * Method to set the current wave.
     * @param wave wave
     */
    void setWave(int wave);

    /**
     * Method to set the player name.
     * @param text text
     */
    void setName(String text);
}

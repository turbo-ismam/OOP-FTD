package model.player;

/**
 * This Class implements the interface Player.
 */
public class PlayerImpl implements Player {

    private String name;
    private int hp;
    private int coins;
    private int wave;

    /**
     * Constructor to create a player.
     * @param name name
     * @param hp hp
     * @param coins coins
     */
    public PlayerImpl(final String name, final int hp, final int coins) {
        this.name = name;
        this.hp = hp;
        this.coins = coins;
        this.wave = 1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getHp() {
        return hp;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void takeDamage(final int damage) {
        this.hp = this.getHp() - damage;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getCoins() {
        return coins;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void incrementCoins(final int coins) {
        this.coins = this.coins + coins;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getWave() {
        return wave;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setWave(final int wave) {
        this.wave = wave;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setName(final String text) {
        this.name = text;
    }
}

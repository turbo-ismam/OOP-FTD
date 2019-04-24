package model.player;

/**
 * This Class implements the interface Player
 */
public class PlayerImpl implements Player{

	private String name;
	private int hp;
	private int coins;
	private int wave;
	
	/**
	 * Constructor to create a player
	 * @param name
	 * @param hp
	 * @param coins
	 * @param wave
	 */
	public PlayerImpl(String name,int hp,int coins) {
		this.name=name;
		this.hp=hp;
		this.coins=coins;
		this.wave=1;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public int getHp() {
		return hp;
	}
	
	@Override
	public void takeDamage(int damage) {
		this.hp = this.getHp()-damage;
	}
	
	@Override
	public int getCoins() {
		return coins;
	}
	
	@Override
	public void incrementCoins(int coins) {
		this.coins = this.coins + coins;
	}
	
	@Override
	public int getWave() {
		return wave;
	}
	
	@Override
	public void setWave(int wave) {
		this.wave = wave;
	}

	@Override
	public void setName(String text) {

		this.name=text;

	}
	
	

}

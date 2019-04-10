package Model.Player;

/**
 * 
 * @author ismam
 *
 */

public class PlayerImpl{

	/**
	 * 
	 */
	private String name;
	private int hp;
	private int coins;
	private int wave;
	
	/**
	 * Constructor
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
	
	public String getName() {
		return name;
	}
	
	public int getHp() {
		return hp;
	}
	
	public void takeDamage(int damage) {
		this.hp = this.getHp()-damage;
	}
	
	public int getCoins() {
		return coins;
	}
	
	public void incrementCoins(int coins) {
		this.coins = this.coins + coins;
	}
	
	public int getWave() {
		return wave;
	}
	
	public void setWave(int wave) {
		this.wave = wave;
	}
	
	

}

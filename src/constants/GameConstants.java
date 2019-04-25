package constants;

/**
 * This class collects the tick time that controls the game.
 */
public final class GameConstants {

    /**
     * Milliseconds of each update.
     */
    public static final int GAME_SPEED = 16;

    /**
     * Ticks that a monster need to wait before spawning.
     */
    public static final int MONSTER_SPAWN_RATE = 50;

    /**
     * Ticks before a monster can move forward.
     */
    public static final int MONSTER_WALK_RATE = 10;

    /**
     * Ticks a basic tower need to wait before shooting the next projectile.
     */
    public static final int TOWER_SHOOT_RATE = 5;

    /**
     * Ticks between the projectile being shot and enemy hit.
     */
    public static final int PROJECTILE_HIT_ENEMY = 1;

    /**
     * Initial coins of the player.
     */
    public static final int INITIAL_COINS = 100;

    /**
     * Initial hp of the player.
     */
    public static final int INITIAL_HP = 10;

    /**
     * Waves reached for the win condition.
     */
    public static final int WAVES_TO_WIN = 20;
    private GameConstants() { }
}

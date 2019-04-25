package constants;

/**
 * This class collects the tick time that controls the game.
 */
public final class GameConstants {
    
    //*****GAME PARAMETERS*****//
    /** Milliseconds of each update. */
    public static final int GAME_SPEED = 16;

    /** Waves reached for the win condition.*/
    public static final int WAVES_TO_WIN = 20;

    //*****PLAYER PARAMETERS*****//
    /** Initial coins of the player.*/
    public static final int INITIAL_COINS = 1000;

    /** Initial hp of the player.*/
    public static final int INITIAL_HP = 10;

    //*****ENEMY PARAMETERS*****//
    /** Ticks that a monster need to wait before spawning.*/
    public static final int MONSTER_SPAWN_RATE = 50;

    /** Ticks before a monster can move forward.*/
    public static final int MONSTER_WALK_RATE = 10;

    //SIMPLE
    /** Hp of the SIMPLE enemy.*/
    public static final int SIMPLE_ENEMY_HP = 100;

    /** speed of the SIMPLE enemy.*/
    public static final int SIMPLE_ENEMY_SPEED = -4;

    /** value of the SIMPLE enemy.*/
    public static final int SIMPLE_ENEMY_VALUE = 20;

    //TANK
    /** Hp of the TANK enemy.*/
    public static final int TANK_ENEMY_HP = 100;

    /** speed of the TANK enemy.*/
    public static final int TANK_ENEMY_SPEED = 4;

    /** value of the TANK enemy.*/
    public static final int TANK_ENEMY_VALUE = 40;

    //*****TOWER PARAMETERS*****//
    /** Ticks a basic tower need to wait before shooting the next projectile.*/
    public static final int TOWER_SHOOT_RATE = 5;

    /** Ticks between the projectile being shot and enemy hit.*/
    public static final int PROJECTILE_HIT_ENEMY = 1;

    //BASIC
    /** cost of the BASIC tower.*/
    public static final int BASIC_TOWER_COST = 50;

    /** damage of the BASIC tower.*/
    public static final int BASIC_TOWER_DAMAGE = 1;

    /** range of the BASIC tower.*/
    public static final int BASIC_TOWER_RANGE = 2;

    //RANGED
    /** cost of the RANGED tower.*/
    public static final int RANGED_TOWER_COST = 60;

    /** damage of the RANGED tower.*/
    public static final int RANGED_TOWER_DAMAGE = 1;

    /** range of the RANGED tower.*/
    public static final int RANGED_TOWER_RANGE = 2;

    //CANNON
    /** cost of the CANNON tower.*/
    public static final int CANNON_TOWER_COST = 70;

    /** damage of the CANNON tower.*/
    public static final int CANNON_TOWER_DAMAGE = 1;

    /** range of the CANNON tower.*/
    public static final int CANNON_TOWER_RANGE = 2;
    private GameConstants() { }
}

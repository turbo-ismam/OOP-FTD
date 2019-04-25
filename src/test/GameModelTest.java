package test;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import constants.GameConstants;

import static org.junit.Assert.assertEquals;

import model.GameModel;
import model.GameModelImpl;
import model.GameStatus;
import model.tower.TowerType;
import model.wave.Wave;

import utilityclasses.Pair;
/**
 * Test class for the Game logics and functionality.
 */
public class GameModelTest {
    private static final int TICKS_TO_SPAWN_ENEMY = GameConstants.MONSTER_SPAWN_RATE;
    private static final int TICKS_ENEMY_WALK = GameConstants.MONSTER_WALK_RATE + 1;
    private static final int WAVE_TO_WIN = GameConstants.WAVES_TO_WIN + 1;
    private static final int LOTS_OF_DAMAGE = 999;
    private final GameModel gm = new GameModelImpl(1);

    /**
     * test case : 
     * places a tower, 
     * checks if status is PLAYING
     * removes a tower
     * checks if it is removed correctly from the map.
     */
    @org.junit.Test
    public void placeAndRemoveTowersTest() {
        gm.placeTower(new Pair<>(1, 2), TowerType.BASIC);
        assertSame("Status should be equal", gm.getGameStatus(), GameStatus.PLAYING);
        assertSame("Entity shuold be increased to 1", 1L, gm.getMap().getEntityList().stream().count());
        gm.removeTower(new Pair<>(1, 2));
        assertSame("entity should be 0 now", 0L, gm.getMap().getEntityList().stream().count());
    }
    /**
     * Test case :
     * spawns 5 enemies on the map
     * checks if they appear on the map correctly.
     */
    @org.junit.Test
    public void spawnEnemiesTest() {
        final Wave w = gm.getCurrentWave();
        assertTrue("wave should contain enemies", w.hasEnemies());
        gm.setReadyToSpawn(true);
        for (int i = 0; i <= TICKS_TO_SPAWN_ENEMY * 2; i++) {
            gm.update();
        }
        for (int i = 0; i <= TICKS_ENEMY_WALK * 2; i++) {
            gm.update();
        }
        assertEquals("Entity should be 2", 2L, gm.getMap().getEntityList().stream().count());
    }

    /**
     * test case :
     * checks if the nextWave call functions properly.
     */
    @org.junit.Test
    public void goToNextWaveTest() {
        gm.nextWave();
        final Wave w = gm.getCurrentWave();
        w.clearWave();
        gm.nextWave();
        assertSame("correct wave number", 1, gm.getPlayer().getWave());
    }

    /**
     * Test case :
     * checks if the enemy walks on the map.
     */
    @org.junit.Test
        public void enemyWalkTest() {
                final Wave w = gm.getCurrentWave(); 
                gm.setReadyToSpawn(true);
                assertSame("correct wave number", w.getWave(), 0);
                for (int i = 0; i <= TICKS_TO_SPAWN_ENEMY * 2; i++) {
                    gm.update();
                }
                assertSame("maps entity object count equal", 2L, gm.getMap().getEntityList().stream().count());
        }

    /**
     * test case :
     * Checks the win condition of the game (wave>20).
     */
    @org.junit.Test
    public void gameWinTest() {
        gm.getPlayer().setWave(WAVE_TO_WIN);
        gm.update();
        assertSame("status equals", gm.getGameStatus(), GameStatus.WON);
    }

    /**
     * test case :
     * checks the lose condition of the game (player hp <0).
     */
    @org.junit.Test
    public void gameLostTest() {
        gm.setReadyToSpawn(true);
       gm.getPlayer().takeDamage(LOTS_OF_DAMAGE);
       gm.update();
        assertSame("status equal", gm.getGameStatus(), GameStatus.LOST);
    }
}

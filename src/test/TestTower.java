package test;

import static org.junit.Assert.assertEquals;


import model.enemy.Enemy;
import model.map.MapTile;
import model.map.MapTileImpl;
import model.projectile.Projectile;
import model.tower.BasicTower;
import model.tower.TowerType;
import utilityclasses.Pair;

/**
 * test for tower.
 * 
 *
 */
public class TestTower {

    private BasicTower t = new BasicTower(new Pair<>(1, 2), TowerType.BASIC);
    private MapTile m = new MapTileImpl(1, 2);
    private Enemy target; 
    private Projectile p = new Projectile(new Pair<>(2, 3), target, TowerType.BASIC.getRange());
    private MapTile mp = new MapTileImpl(2, 3);

    /**
     * test if the tower is placed in the right position of the map.
     */
    @org.junit.Test
    public void testLocation() {

        //check the tower position
        assertEquals(m.getPosition(), t.getLocation());
        Pair<Integer, Integer> b = new Pair<>(1, 3);

        //check the tower range
            for (int i = 0; i < t.getShootingZone().size(); i++) {
                Pair<Integer, Integer> s = t.getShootingZone().get(i);
                if (s.equals(b)) {
                    System.out.println(s);
                }
        }
    }

    /**
     * test if tower shoots.
     */
    @org.junit.Test
    public void testShoot() {
        t.update();
        assertEquals(p.getLocation(), mp.getPosition());
    }
}

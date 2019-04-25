package model.wave;

import java.util.ArrayList;
import java.util.List;

import model.enemy.Enemy;
import model.enemy.EnemyImpl;
import model.enemy.EnemyType;
import model.map.MapTile;

/**
 * 
 *
 */
public class WaveImpl implements Wave {
    private static List<MapTile> path = new ArrayList<>();
    private final List<Enemy> ondata;
    private final int numeroOndata;
/**
 * 
 * @param numeroOndata numeroOndata
 */
    public WaveImpl(final int numeroOndata) {
        super();
        ondata = new ArrayList<>();
        this.numeroOndata = numeroOndata;
        populate((1 + numeroOndata) * 2, EnemyType.SIMPLE);
        if (this.numeroOndata > 10) {
            populate((numeroOndata) / 2, EnemyType.TANK);
            populate((1 + numeroOndata) * 3, EnemyType.SIMPLE);

        }
    }
/**
 * 
 */
    @Override
    public int getWave() {
        return this.numeroOndata;
    }
/**
 * {@inheritDoc}
 */
    @Override
    public void populate(final int quantity, final EnemyType type) {
        for (int a = 0; a < quantity; a++) {
            final Enemy e = new EnemyImpl(type);
            if (this.numeroOndata>10) {
                e.setSpeed(e.getSpeed()*2);
            }
            e.setPath(path);
            ondata.add(e);
        }
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Enemy spawn() {
        Enemy e = null;
        if (!ondata.isEmpty()) {
            e = ondata.get(0);
            e.spawn();
            ondata.remove(0);
            return e;
        }
        throw new NullPointerException();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasEnemies() {
        return !ondata.isEmpty();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Wave nextWave() {
        return new WaveImpl(this.getWave() + 1);
    }
    /**
     * 
     * @param path path
     */
    public static void setPath(final List<MapTile> path) {
        WaveImpl.path = path;
    }
}

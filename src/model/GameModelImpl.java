package model;

import constants.GameConstants;
import model.GameModel;
import model.GameStatus;
import model.enemy.Enemy;
import model.entity.Entity;
import model.map.HardMap;
import model.map.Map;
import model.map.NormalMap;
import model.map.SimpleMap;
import model.observer.ObservableEntity;
import model.observer.Observer;
import model.player.Player;
import model.player.PlayerImpl;
import model.tower.BasicTower;
import model.tower.Tower;
import model.tower.TowerType;
import model.wave.Wave;
import model.wave.WaveImpl;
import utilityclasses.Pair;

/**
 * Implementation of the GameModel.
 */

public class GameModelImpl implements GameModel, Observer {
    private static final int INITIAL_COINS = GameConstants.INITIAL_COINS;
    private static final int INITIAL_HP = GameConstants.INITIAL_HP;
    private static final int ENEMY_SPAWN_RATE = GameConstants.MONSTER_SPAWN_RATE;
    private static final int WAVES_TO_WIN = GameConstants.WAVES_TO_WIN;
    private final Map m;
    private final Player p;
    private Wave w;
    private GameStatus gs;
    private int tick;
    private boolean readyToSpawn;

    /**
     * Constructor of the GameModel.
     * @param difficulty the difficulty of the game
     */

    public GameModelImpl(final int difficulty) {
        p = new PlayerImpl("SexyIsmy", INITIAL_HP, INITIAL_COINS);
        m = createMap(difficulty);
        WaveImpl.setPath(m.getPathList());
        w = new WaveImpl(0);
        gs = GameStatus.PLAYING;
        this.readyToSpawn = false;
    }

    private Map createMap(final int difficulty) {
        switch (difficulty) {
            case 1:
                return new SimpleMap();
            case 2:
                return new NormalMap();
            case 3:
                return new HardMap();
            default:
                throw new IllegalArgumentException();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean placeTower(final Pair<Integer, Integer> location, final TowerType tt) {
        if (p.getCoins() < tt.getCost() && m.positionable(location)) {
            return false;
        }
        p.incrementCoins(-tt.getCost()); //player PAGA la torre
        final Tower t = new BasicTower(location, tt);
        ((ObservableEntity) t).addObserver(this);
        m.addEntity(t);
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeTower(final Pair<Integer, Integer> location) {
        m.removeEntity(location);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GameStatus getGameStatus() {
        return this.gs;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Player getPlayer() {
        return this.p;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Wave getCurrentWave() {
        return this.w;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map getMap() {
        return this.m;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void nextWave() {
        if (!w.hasEnemies()) {
            w = w.nextWave();
            p.setWave(w.getWave());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setReadyToSpawn(final boolean b) {
        this.readyToSpawn = b;
    }
    private void addEntity(final Entity e) {
        m.addEntity(e);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update() {
        m.getEntityList().forEach(e -> e.update());
        m.getEntityList().stream()
        .filter(e -> e.shouldBeRemoved())
        .forEach(e -> m.removeEntity(e));
        m.getEntityList().forEach(e -> {
            if (e instanceof Tower) {
                ((Tower) e).setEnemies(m.getEntityList());
            }
        });
        if (w.hasEnemies()) {
            if (tick >= ENEMY_SPAWN_RATE && readyToSpawn) {
                final Enemy e = w.spawn();
                ((ObservableEntity) e).addObserver(this);
                this.addEntity(e);
                tick = 0;
            }
        }
        else {
            setReadyToSpawn(false);
        }
        if (p.getHp() <= 0) {
            this.gs = GameStatus.LOST;
            return;
        }
        if (p.getWave() > WAVES_TO_WIN) {
            this.gs = GameStatus.WON;
            return;
        }
        this.tick++;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final ObservableEntity subject) {
        if (subject instanceof Tower) {
            addEntity(((Tower) subject).getProjectile());
        }
        else if (subject instanceof Enemy) {
            final Enemy e = (Enemy) subject;
            if (e.getLocation().equals(m.getPathList().get(m.getPathList().size() - 1).getPosition())) {
                p.takeDamage(1);
            }
            else {
                p.incrementCoins(e.getValue());
            }
        }
    }
}

package model.enemy;

import java.util.List;

import constants.GameConstants;
import model.map.MapTile;
import model.map.MapTileImpl;
import model.observer.ObservableEntity;
import utilityclasses.Pair;
/**
 * 
 * Enemy implementation.
 *
 */
public class EnemyImpl extends ObservableEntity implements Enemy {
    private static final int TICKS_BEFORE_WALKING = GameConstants.MONSTER_WALK_RATE;
    private int hp;
    private final int speed;
    private final int value;
    private boolean alive;
    private Direction direction;
    private List<MapTile> path;
    private MapTile actual;
    private int x = 1;
    private int tick;
/**
 * 
 * @param type type
 */
    public EnemyImpl(final EnemyType type) {
        super();
        this.hp = type.getHealth();
        this.speed = type.getSpeed();
        this.value = type.getValue();
        this.alive = false;
    }
/**
 * {@inheritDoc}
 */
    @Override
    public Pair<Integer, Integer> getLocation() {
        return actual.getPosition();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void update() {
        this.death();
        if (tick == TICKS_BEFORE_WALKING) {
            this.walk();
            tick = 0;
        }
        else {
            tick++;
        }
    }
/**
 * {@inheritDoc}
 */
    @Override
    public void walk() {
        if (path == null) {
            throw new NullPointerException();
        }
        else {
            if (x >= path.size()) {
                this.despawn();
            }
            if (alive) {
                final MapTile next = new MapTileImpl(path.get(x).getPosition().getX(),
                    path.get(x).getPosition().getY());
                if (next.getPosition().getX() > actual.getPosition().getX()) {
                    direction = Direction.RIGHT;
                }
                if (next.getPosition().getX() < actual.getPosition().getX()) {
                    direction = Direction.LEFT;
                }
                if (next.getPosition().getY() > actual.getPosition().getY()) {
                    direction = Direction.DOWN;
                }
                if (next.getPosition().getY() < actual.getPosition().getY()) {
                    direction = Direction.UP;
                }
                actual = next;
                x++;
            }
        }
    }
/**
 * {@inheritDoc}
 */
    @Override
    public void spawn() {
        alive = true;
    }
/**
 * {@inheritDoc}
 */
    @Override
    public void despawn() {
        alive = false;
        notifyObservers();
    }
/**
 * {@inheritDoc}
 */
    @Override
    public void death() {
        if (hp <= 0) {
            alive = false;
        }
    }
/**
 * {@inheritDoc}
 */
    @Override
    public int getHP() {
        return hp;
    }
/**
 * {@inheritDoc}
 */
    @Override
    public void setDamage(final int damage) {
        this.hp -= damage;
        if (this.hp <= 0) { 
            this.death();
            notifyObservers();
        }
    }
/**
 * {@inheritDoc}
 */
    @Override
    public int getValue() {
        return this.value;
    }
/**
 * {@inheritDoc}
 */
    @Override
    public int getSpeed() {
        return this.speed;
    }
/**
 * {@inheritDoc}
 */
    @Override
    public void setPath(final List<MapTile> sentiero) {
        this.path = sentiero;
        this.actual = sentiero.get(0);
    }
/**
 * {@inheritDoc}
 */
    @Override
    public Direction getDirezione() {
        return direction;
    }
/**
 * {@inheritDoc}
 */
    @Override
    public boolean shouldBeRemoved() {
        return !isAlive();
    }
/**
 * {@inheritDoc}
 * @return
 */
    public boolean isAlive() {
        return alive;
    }
}

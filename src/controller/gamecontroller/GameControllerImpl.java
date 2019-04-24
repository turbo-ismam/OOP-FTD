package controller.gamecontroller;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import model.GameModel;
import model.GameModelImpl;
import view.gameview.GameScreen;
import view.input.Input;
/**
 * Implementation of the Controller of the game.
 */
public class GameControllerImpl implements GameController {
    private GameModel gm;
    private final ScheduledThreadPoolExecutor ses;
    private boolean running; 
    private int difficulty = 3;
    private GameLoop gl;
    /**
     * Constructor for the GameController.
     */
    public GameControllerImpl() {
        this.ses = new ScheduledThreadPoolExecutor(1);
        this.running = false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void init() {
        gm = new GameModelImpl(difficulty);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void startLoop(final GameScreen v) {
        gl = new GameLoop(gm, v);
        if (!running) {
            ses.scheduleWithFixedDelay(gl, 0, 16, TimeUnit.MILLISECONDS);
            System.out.println("Game is starting");
            this.running = true;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override 
    public void pauseGame() {
        gl.pause();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void resumeGame() {
        gl.resume();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void killGameLoop() {
        ses.shutdown();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void handleInput(final Input i) {
        gl.addInput(i);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GameModel getModel() {
        return this.gm;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setDifficulty(final int d) {
        this.difficulty = d;
    }
}

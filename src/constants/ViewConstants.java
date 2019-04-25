package constants;

import java.awt.Dimension;

import java.awt.Toolkit;

/**
 * This class collects all static parameters of the game.
 */
public final class ViewConstants {
    /**
     * ScreenSize of the current monitor.
     */
    public final static Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
    /**
     * Width of the current monitor.
     */
    public static final double WIDTH = SCREEN_SIZE.getWidth();
    /**
     * Height of the current monitor.
     */
    public static final double HEIGHT = SCREEN_SIZE.getHeight();
    /**
     * Wight and Height of a single square.
     */
    public static final double BUTTON_SIZE = HEIGHT / 30;
    /**
     * Width of the application.
     */
    public static final double GAME_WIDTH = BUTTON_SIZE * 38;
    /**
     * Height of the application.
     */
    public final static double GAME_HEIGHT = BUTTON_SIZE * 22;

    /**
     * Empty Constructor
     */
    private ViewConstants() { }
}

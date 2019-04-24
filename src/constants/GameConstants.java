package constants;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * This class collects all static parameters of the game.
 */
public final class GameConstants {
    private GameConstants() { }
    /**
     * ScreenSize of the current monitor.
     */
    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    /**
     * Width of the current monitor.
     */
    public static final double width = screenSize.getWidth();
    /**
     * Height of the current monitor.
     */
    public static final double height = screenSize.getHeight();
    /**
     * Wight and Height of a single square.
     */
    public static final double buttonSize = height/30;
    /**
     * Width of the application.
     */
    public static final double gameWidth = buttonSize*38;
    /**
     * Height of the application.
     */
    public final static double gameHeight = buttonSize*22;
}

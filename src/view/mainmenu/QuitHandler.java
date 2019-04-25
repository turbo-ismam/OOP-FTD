package view.mainmenu;

import controller.gamecontroller.GameController;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;
/**
 * Class that instructs what to do when the 'X' Button is clicked to close.
 */
public class QuitHandler implements EventHandler<WindowEvent> {
    private final GameController gc;
    /**
     * 
     * @param gc game controller
     */
    public QuitHandler(final GameController gc) {
        this.gc = gc;
    }

    @Override
    public final void handle(final WindowEvent arg0) {
       gc.killGameLoop();
       Platform.exit();

    }

}

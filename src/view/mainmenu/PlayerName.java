package view.mainmenu;

import java.io.IOException;
import java.io.InputStream;

import constants.ViewConstants;
import controller.gamecontroller.GameController;
import controller.gamecontroller.GameControllerImpl;
import view.gameview.GameScreen;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
/**
 * 
 * View of "insert name" pane.
 *
 */
public class PlayerName extends Region {
    private GameController gc;
    private GameScreen game;
    private double volume;
    
    public PlayerName(final GameController gc, final double d) {
        this.gc = gc;
        this.volume = d;
    }
    /**
     * 
     * @return pane
     * @throws IOException exception
     */
    public Parent createContent() throws IOException {

        final Pane root = new Pane();

        final TextField box = new TextField();
        box.setPrefSize(ViewConstants.BUTTON_SIZE * 7, ViewConstants.BUTTON_SIZE);
        box.setTranslateX(ViewConstants.BUTTON_SIZE * 16);
        box.setTranslateY(ViewConstants.BUTTON_SIZE * 13);

        final Rectangle bg = new Rectangle(ViewConstants.GAME_WIDTH + ViewConstants.BUTTON_SIZE, ViewConstants.GAME_HEIGHT + ViewConstants.BUTTON_SIZE);
        bg.setFill(Color.GREY);
        bg.setOpacity(0.5);

        final Text tx = new Text("Inserisci il\ntuo nome!");
        final InputStream is = this.getClass().getResourceAsStream("/JOJO____.ttf");
        tx.setFont(Font.loadFont(is, ViewConstants.BUTTON_SIZE));
        tx.setFill(Color.INDIGO);
        tx.setTranslateY(ViewConstants.BUTTON_SIZE * 5);
        tx.setTranslateX(ViewConstants.BUTTON_SIZE * 2);

        final ImageLoader im = new ImageLoader("/player.png");
        im.getImage().prefHeight(ViewConstants.HEIGHT);
        im.getImage().prefWidth(ViewConstants.WIDTH);
        //root.setPrefSize(ViewConstants.gameWidth, ViewConstants.gameHeight);

        final VBox mn = new VBox(ViewConstants.BUTTON_SIZE);
        mn.setPrefSize(ViewConstants.WIDTH, ViewConstants.HEIGHT);
        mn.getChildren().add(im.getImage());
        root.getChildren().add(mn);

        final ButtonD d = new ButtonD("start");
        d.setTranslateX(ViewConstants.BUTTON_SIZE * 16.5);
        d.setTranslateY(ViewConstants.BUTTON_SIZE * 16);
        d.setOnMouseClicked(event -> {
            gc.init();
            game = new GameScreen(gc, volume);
            gc.getModel().getPlayer().setName(box.getText());
            root.getChildren().setAll(game.createContent());
        });


        root.getChildren().addAll(bg, d, box, tx);

        return root;
    }
    public void setVol(double d) {
        this.volume = d;
    }
/**
 * 
 * Button style.
 *
 */
    public class ButtonD extends StackPane {

        private final Text text;
/**
 * 
 * @param name name
 */
        public ButtonD(final String name) {
            super();
            final InputStream is = this.getClass().getResourceAsStream("/JOJO____.ttf");
            text = new Text(name);
            text.setFont(Font.loadFont(is, ViewConstants.BUTTON_SIZE));
            text.setFill(Color.INDIGO);

            final Rectangle bg = new Rectangle(ViewConstants.BUTTON_SIZE * 6, ViewConstants.BUTTON_SIZE * 3);
            bg.setOpacity(0.8);
            bg.setFill(Color.CYAN);

            setAlignment(Pos.CENTER);
            setRotate(-0.5);
            getChildren().addAll(bg, text);

            setOnMouseEntered(event -> {
                bg.setFill(Color.WHITE);
                text.setFill(Color.BLACK);
            });

            setOnMouseExited(event -> {
                bg.setFill(Color.CYAN);
                text.setFill(Color.INDIGO);
            });

            final DropShadow drop = new DropShadow(50, Color.WHITE);
            drop.setInput(new Glow());

            setOnMousePressed(event -> setEffect(drop));
            setOnMouseReleased(event -> setEffect(null));
        }
    }
    /**
     * {@inheritDoc}
     * @return controller
     */
    public GameController getgc() {
        return this.gc;
    }
}

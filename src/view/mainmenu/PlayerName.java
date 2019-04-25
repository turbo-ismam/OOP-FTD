package view.mainmenu;

import java.io.IOException;

import constants.GameConstants;
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

    private GameScreen game;
    private final GameController gc = new GameControllerImpl();
    /**
     * 
     * @return pane
     * @throws IOException exception
     */
    public Parent createContent() throws IOException {

        final Pane root = new Pane();

        final TextField box = new TextField();
        box.setPrefSize(GameConstants.BUTTON_SIZE * 7, GameConstants.BUTTON_SIZE);
        box.setTranslateX(GameConstants.BUTTON_SIZE * 16);
        box.setTranslateY(GameConstants.BUTTON_SIZE * 13);

        final Rectangle bg = new Rectangle(GameConstants.GAME_WIDTH + GameConstants.BUTTON_SIZE, GameConstants.GAME_HEIGHT + GameConstants.BUTTON_SIZE);
        bg.setFill(Color.GREY);
        bg.setOpacity(0.5);

        final Text tx = new Text("Inserisci il\ntuo nome!");
        tx.setFont(Font.loadFont("file:res/JOJO____.ttf", GameConstants.BUTTON_SIZE));
        tx.setFill(Color.INDIGO);
        tx.setTranslateY(GameConstants.BUTTON_SIZE * 5);
        tx.setTranslateX(GameConstants.BUTTON_SIZE * 2);

        final ImageLoader im = new ImageLoader("res/player.png");
        im.getImage().prefHeight(GameConstants.HEIGHT);
        im.getImage().prefWidth(GameConstants.WIDTH);
        //root.setPrefSize(GameConstants.gameWidth, GameConstants.gameHeight);

        final VBox mn = new VBox(GameConstants.BUTTON_SIZE);
        mn.setPrefSize(GameConstants.WIDTH, GameConstants.HEIGHT);
        mn.getChildren().add(im.getImage());
        root.getChildren().add(mn);

        final ButtonD d = new ButtonD("start");
        d.setTranslateX(GameConstants.BUTTON_SIZE * 16.5);
        d.setTranslateY(GameConstants.BUTTON_SIZE * 16);
        d.setOnMouseClicked(event -> {
            gc.init();
            game = new GameScreen(gc);
            gc.getModel().getPlayer().setName(box.getText());
            root.getChildren().setAll(game.createContent());
        });


        root.getChildren().addAll(bg, d, box, tx);

        return root;
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
            text = new Text(name);
            text.setFont(Font.loadFont("file:res/JOJO____.ttf", GameConstants.BUTTON_SIZE));
            text.setFill(Color.INDIGO);

            final Rectangle bg = new Rectangle(GameConstants.BUTTON_SIZE * 6, GameConstants.BUTTON_SIZE * 3);
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

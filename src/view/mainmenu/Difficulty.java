package view.mainmenu;

import java.io.InputStream;

import constants.ViewConstants;
import view.gameview.GameScreen;
import view.gameview.Lose.ButtonD;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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
import javafx.stage.Stage;
/**
 * 
 * Difficulty buttons.
 *
 */
public class Difficulty extends Region {
/**
 * Difficulty buttons.
 * @param primaryStage stage
 * @throws Exception exception
 */
    public void start(final Stage primaryStage) throws Exception {

        final Pane pane = new Pane();
        pane.setPrefSize(ViewConstants.GAME_WIDTH / 2, ViewConstants.GAME_HEIGHT / 2);
        final Text text = new Text("Difficulty changed!");
        final InputStream is = this.getClass().getResourceAsStream("/JOJO____.ttf");
        text.setFont(Font.loadFont(is, 25));
        text.setFill(Color.WHITE);

        final VBox space = new VBox();
        space.setTranslateX((ViewConstants.GAME_WIDTH / 2) / 2 - ViewConstants.BUTTON_SIZE * 2.75);
        space.setTranslateY((ViewConstants.GAME_HEIGHT / 2) / 2 - ViewConstants.BUTTON_SIZE * 1.5);

        final ImageLoader im = new ImageLoader("/difficoulty.jpg");
        im.getImage().prefHeight(ViewConstants.GAME_HEIGHT / 8);
        im.getImage().prefWidth(ViewConstants.GAME_WIDTH / 8);

        pane.getChildren().add(im.getImage());
        final String style3 = "-fx-background-color: rgba(0, 0, 0, 0.5);"; //verde
        pane.setStyle(style3);

        final ButtonD bt = new ButtonD("Ok");
        bt.setOnMouseClicked(event -> {
            primaryStage.close();
        });
        final Rectangle bg = new Rectangle(ViewConstants.GAME_WIDTH, ViewConstants.GAME_HEIGHT);
        bg.setFill(Color.GREY);
        bg.setOpacity(0.5);
        bg.setTranslateX(-ViewConstants.BUTTON_SIZE * 10);
        bg.setTranslateY(-ViewConstants.BUTTON_SIZE * 10);

        bt.setTranslateX(-ViewConstants.BUTTON_SIZE * 16);
        bt.setTranslateY(-ViewConstants.BUTTON_SIZE * 22);
        text.setTranslateX(-ViewConstants.BUTTON_SIZE * 5);
        text.setTranslateY(-ViewConstants.BUTTON_SIZE * 23.5);
        space.getChildren().addAll(bg, text, bt);
        pane.getChildren().add(space);

        final Scene scene = new Scene(pane);
            primaryStage.setTitle("Difficulty");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
    }
    /**
     * 
     * Button style.
     *
     */
    public class ButtonD extends StackPane {

        private final Text text;
/**
 * Button style.
 * @param name name
 */
        public ButtonD(final String name) {
            super();
            final InputStream is = this.getClass().getResourceAsStream("/JOJO____.ttf");
            text = new Text(name);
            
            text.setFont(Font.loadFont(is, 15));
            text.setFill(Color.DEEPPINK);

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
                text.setFill(Color.DEEPPINK);
            });

            final DropShadow drop = new DropShadow(50, Color.WHITE);
            drop.setInput(new Glow());

            setOnMousePressed(event -> setEffect(drop));
            setOnMouseReleased(event -> setEffect(null));
        }
    }
}


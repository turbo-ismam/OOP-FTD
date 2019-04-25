package view.mainmenu;

import constants.GameConstants;
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

public class Difficulty extends Region{

    public void start(Stage primaryStage) throws Exception {

        Pane pane = new Pane();
        pane.setPrefSize(GameConstants.GAME_WIDTH / 2, GameConstants.GAME_HEIGHT / 2);
        Text text = new Text("Difficulty changed!");
        text.setFont(Font.loadFont("file:res/JOJO____.ttf", 25));
        text.setFill(Color.WHITE);

        VBox space = new VBox();
        space.setTranslateX((GameConstants.GAME_WIDTH / 2) / 2 - GameConstants.BUTTON_SIZE * 2.75);
        space.setTranslateY((GameConstants.GAME_HEIGHT / 2) / 2 - GameConstants.BUTTON_SIZE * 1.5);

        ImageLoader im = new ImageLoader("res/difficoulty.jpg");
        im.getImage().prefHeight(GameConstants.GAME_HEIGHT / 8);
        im.getImage().prefWidth(GameConstants.GAME_WIDTH / 8);

        pane.getChildren().add(im.getImage());
        String style3 = "-fx-background-color: rgba(0, 0, 0, 0.5);"; //verde
        pane.setStyle(style3);

        ButtonD bt = new ButtonD("Ok");
        bt.setOnMouseClicked(event -> {
            primaryStage.close();
        });
        Rectangle bg = new Rectangle(GameConstants.GAME_WIDTH, GameConstants.GAME_HEIGHT);
        bg.setFill(Color.GREY);
        bg.setOpacity(0.5);
        bg.setTranslateX(-GameConstants.BUTTON_SIZE * 10);
        bg.setTranslateY(-GameConstants.BUTTON_SIZE * 10);

        bt.setTranslateX(-GameConstants.BUTTON_SIZE * 16);
        bt.setTranslateY(-GameConstants.BUTTON_SIZE * 22);
        text.setTranslateX(-GameConstants.BUTTON_SIZE * 5);
        text.setTranslateY(-GameConstants.BUTTON_SIZE * 23.5);
        space.getChildren().addAll(bg, text, bt);
        pane.getChildren().add(space);

         Scene scene = new Scene(pane);
            primaryStage.setTitle("Difficulty");
            primaryStage.setScene(scene);
            primaryStage.setResizable(true);
            primaryStage.show();
    }
    public class ButtonD extends StackPane{

        private Text text;

        public ButtonD(final String name) {

            text = new Text(name);
            text.setFont(Font.loadFont("file:res/JOJO____.ttf", 15));
            text.setFill(Color.DEEPPINK);

            Rectangle bg = new Rectangle(GameConstants.BUTTON_SIZE * 6,GameConstants.BUTTON_SIZE*3);
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

            DropShadow drop = new DropShadow(50, Color.WHITE);
            drop.setInput(new Glow());

            setOnMousePressed(event -> setEffect(drop));
            setOnMouseReleased(event -> setEffect(null));  
        }
    }
}


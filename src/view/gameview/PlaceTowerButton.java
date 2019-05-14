package view.gameview;

import java.io.InputStream;

import constants.ViewConstants;
import javafx.geometry.Pos;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class PlaceTowerButton extends StackPane{

        private final Text text;

        public PlaceTowerButton(final String name) {
            super();
            text = new Text(name);
            final InputStream is = this.getClass().getResourceAsStream("/JOJO____.ttf");
            text.setFont(Font.loadFont(is, ViewConstants.BUTTON_SIZE/2));
            text.setFill(Color.BLACK);

            final Rectangle bg = new Rectangle(ViewConstants.BUTTON_SIZE*5,ViewConstants.BUTTON_SIZE*2);
            bg.setOpacity(0.8);
            bg.setFill(Color.DARKORANGE);
            setAlignment(Pos.CENTER);
            setRotate(-0.5);
            getChildren().addAll(bg, text);
            setOnMouseEntered(event -> {
                bg.setFill(Color.VIOLET);
                text.setFill(Color.WHITE);
            });
            setOnMouseExited(event -> {
                bg.setFill(Color.DARKORANGE);
                text.setFill(Color.BLACK);
            });

            final DropShadow drop = new DropShadow(50, Color.WHITE);
            drop.setInput(new Glow());

            setOnMousePressed(event -> setEffect(drop));
            setOnMouseReleased(event -> setEffect(null));  
        }
}

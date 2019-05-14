package view.mainmenu;

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
/**
 * 
 * Volume button.
 *
 */
public class VolumeButton extends StackPane {

private final Text text;
/**
 * Volume button.
 * @param name name
 */
    public VolumeButton(final String name) {
        super();
        text = new Text(name);
        final InputStream is = this.getClass().getResourceAsStream("/JOJO____.ttf");
        text.setFont(Font.loadFont(is, ViewConstants.BUTTON_SIZE / 2)); 
        text.setFill(Color.DEEPPINK);

        final Rectangle bg = new Rectangle(300,70);
        bg.setOpacity(0.8);
        bg.setFill(Color.CYAN);

        setAlignment(Pos.CENTER);
            setRotate(-0.5);
            getChildren().addAll(bg, text);

            setOnMouseEntered(event -> {
                bg.setTranslateX(10);
                text.setTranslateX(10);
                bg.setFill(Color.WHITE);
                text.setFill(Color.BLACK);
            });

            setOnMouseExited(event -> {
                bg.setTranslateX(0);
                text.setTranslateX(0);
                bg.setFill(Color.CYAN);
                text.setFill(Color.DEEPPINK);
            });

            final DropShadow drop = new DropShadow(50, Color.WHITE);
            drop.setInput(new Glow());

            setOnMousePressed(event -> setEffect(drop));
            setOnMouseReleased(event -> setEffect(null));
    }

}

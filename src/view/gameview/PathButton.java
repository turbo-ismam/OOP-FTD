package view.gameview;

import constants.ViewConstants;
import javafx.geometry.Pos;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import utilityclasses.Pair;

public class PathButton extends StackPane {
    private static final Image LOGO = new Image("path.png");
    private final Text text;
    public Pair<Integer,Integer> position;
    public PathButton(final String name) {
        text = new Text(name);

        text.setFill(Color.DEEPPINK);
        /* REALIZZAZIONE DI OGNI TILE */
        final Rectangle bg = new Rectangle(ViewConstants.BUTTON_SIZE,ViewConstants.BUTTON_SIZE);
        bg.setOpacity(100);
        /* grass image */
        final ImageView img = new ImageView(LOGO);
        img.setFitWidth(50);
        img.setFitHeight(50);
        bg.setFill(new ImagePattern(LOGO));
        
          setAlignment(Pos.CENTER);
            setRotate(-0.5);
            getChildren().addAll(bg, text);

            setOnMouseEntered(event -> {
                text.setTranslateX(10);
                bg.setFill(Color.CYAN);
                text.setFill(Color.BLACK);
            });

            setOnMouseExited(event -> {
                bg.setTranslateX(0);
                text.setTranslateX(0);
                bg.setFill(new ImagePattern(LOGO));
                text.setFill(Color.DEEPPINK);
            });

            final DropShadow drop = new DropShadow(50, Color.WHITE);
            drop.setInput(new Glow());

            setOnMousePressed(event -> setEffect(drop));
            setOnMouseReleased(event -> setEffect(null));  
    }
    public void setPosition(final Pair<Integer, Integer> p){
        this.position=p;
        }
    	
    public Pair<Integer, Integer> getPosition() {
        return this.position;
        }


}

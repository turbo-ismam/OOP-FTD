package View.GameView;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import Constants.GameConstants;
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

public class GridButton extends StackPane{

	private Text text;
	public String position;
	
	public GridButton(String name) throws IOException {
		
		text = new Text(name);

		text.setFill(Color.DEEPPINK);
		
		/* REALIZZAZIONE DI OGNI TILE */
		Rectangle bg = new Rectangle(GameConstants.buttonSize,GameConstants.buttonSize);
		bg.setOpacity(100);
		/* grass image */
		InputStream is = Files.newInputStream(Paths.get("res/grass.jpg"));
		Image logo = new Image(is);
		is.close();
		ImageView img = new ImageView(logo);
		img.setFitWidth(50);
		img.setFitHeight(50);
		bg.setFill(new ImagePattern(logo));
		
		
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
                bg.setFill(new ImagePattern(logo));
                text.setFill(Color.DEEPPINK);
            });

            DropShadow drop = new DropShadow(50, Color.WHITE);
            drop.setInput(new Glow());

            setOnMousePressed(event -> setEffect(drop));
            setOnMouseReleased(event -> setEffect(null));  
	}
}


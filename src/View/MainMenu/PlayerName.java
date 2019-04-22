package View.MainMenu;

import java.io.IOException;

import Constants.GameConstants;
import Controller.GameController.GameController;
import Controller.GameController.GameControllerImpl;
import View.GameView.GameScreen;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class PlayerName extends Region{

	GameScreen game;
	private GameController gc = new GameControllerImpl();
	public Parent createContent() throws IOException {
		Pane root = new Pane();
			
		  TextField box = new TextField();
		     box.setPrefSize(GameConstants.buttonSize*7, GameConstants.buttonSize);
		     box.setTranslateX(GameConstants.buttonSize*16);
		     box.setTranslateY(GameConstants.buttonSize*13);
		
		 Rectangle bg = new Rectangle(GameConstants.gameWidth,GameConstants.gameHeight);
         bg.setFill(Color.GREY);
         bg.setOpacity(0.5);
		
		ButtonD d = new ButtonD("start");
		d.setTranslateX(GameConstants.buttonSize*16.5);
	     d.setTranslateY(GameConstants.buttonSize*16);
		d.setOnMouseClicked(event -> {
			gc.startGame();
			game = new GameScreen(gc);
			gc.getModel().getPlayer().setName(box.getText());
			try {
				root.getChildren().setAll(game.createContent());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		
		root.getChildren().addAll(bg,d,box);
		
		return root;
	}
	
	public class ButtonD extends StackPane{

		private Text text;
		
		public ButtonD(String name) {
			
			text = new Text(name);
			text.setFont(Font.loadFont("file:res/JOJO____.ttf", 15));
			text.setFill(Color.DEEPPINK);
			
			Rectangle bg = new Rectangle(GameConstants.buttonSize*6,GameConstants.buttonSize*3);
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

package View.MainMenu;

import Constants.GameConstants;
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
    	pane.setPrefSize(GameConstants.gameWidth/2, GameConstants.gameHeight/2);
    	Text text = new Text("Difficulty changed!");
    	text.setFont(Font.loadFont("file:res/JOJO____.ttf", 15));
		text.setFill(Color.DARKVIOLET);
		
    	VBox space = new VBox();
    	space.setTranslateX((GameConstants.gameWidth/2)/2-GameConstants.buttonSize*2.75);
    	space.setTranslateY((GameConstants.gameHeight/2)/2-GameConstants.buttonSize*2);
    	
    	ImageLoader im = new ImageLoader("res/difficoulty.jpg");
    	im.getImage().prefHeight(GameConstants.gameHeight/8);
    	im.getImage().prefWidth(GameConstants.gameWidth/8);

    	pane.getChildren().add(im.getImage());
    	 String style3 = "-fx-background-color: rgba(0, 0, 0, 0.5);"; //verde
    	 pane.setStyle(style3);

    	
    	ButtonD bt = new ButtonD("Ok");
    	bt.setOnMouseClicked(event -> {
    		primaryStage.close();
    	});
    	
    	
    	space.getChildren().add(bt);
    	pane.getChildren().add(space);
    	

		 Scene scene = new Scene(pane);
	        primaryStage.setTitle("Difficulty");
	        primaryStage.setScene(scene);
	        primaryStage.setResizable(false);
	        primaryStage.show();
		
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

package View.MainMenu;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Difficulty extends Region{
	
	private final double size;

	public Difficulty(double buttonsize) {
		super();
		this.size = buttonsize;
	}
	
	public void start(Stage primaryStage) throws Exception {
		
		Pane pane = new Pane();
    	pane.setPrefSize(size*9.5, size*2);
    	Text text = new Text("Difficulty changed");
    	text.setFont(Font.loadFont("file:res/JOJO____.ttf", 15));
		text.setFill(Color.DARKVIOLET);
    	VBox space = new VBox();
    	Button b = new Button("ok");
    	
    	 String style3 = "-fx-background-color: rgba(0, 0, 0, 0.5);"; //verde
    	 pane.setStyle(style3);
    	
    	space.getChildren().add(text);
    	space.getChildren().add(b);
    	text.setTranslateY(size/3.5);
    	b.setTranslateX(size*4.5);
    	b.setTranslateY(size/2.5);
    	pane.getChildren().add(space);
    	
    	b.setOnAction(event -> {
    		primaryStage.close();
    	});
		
		 Scene scene = new Scene(pane);
	        primaryStage.setTitle("Difficulty");
	        primaryStage.setScene(scene);
	        primaryStage.setResizable(false);
	        primaryStage.show();
		
	}
	
}

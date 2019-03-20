package View.MainMenu;

import java.io.FileNotFoundException;

import View.GameView.GameView;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MainMenu extends Application{
	Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
	Button buttonStart, buttonExit, b3;
	Scene menu, gameWindow;
	
	public void start(Stage stage){
		
			stage.setTitle("FantasyTD 1.0");
			buttonStart = new Button();
			buttonStart.setText("Start game");
			//buttonStart.setOnAction(e -> stage.setScene(gameWindow));
			buttonStart.setOnAction(e ->{
				stage.setScene(new GameView());
				stage.centerOnScreen();
			});
			buttonExit = new Button();
			buttonExit.setText("Exit");
			buttonExit.setOnAction(e -> stage.close());
			
			b3 = new Button();
			b3.setText("Back to main menu");
			b3.setOnAction(e -> stage.setScene(menu));
			
			VBox layout = new VBox(10);
			layout.setAlignment(Pos.CENTER);
			layout.getChildren().add(buttonStart);
			layout.getChildren().add(buttonExit);
			
			VBox layout2 = new VBox();
			layout2.setAlignment(Pos.CENTER);
			layout2.getChildren().add(b3);
			
			
			menu= new Scene(layout, 300, 300);
			stage.setScene(menu);
			stage.show();
			
			gameWindow= new Scene(layout2, 300, 300);
			
		}

}

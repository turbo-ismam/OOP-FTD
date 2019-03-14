package Main;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class FantasyTD extends Application implements EventHandler<ActionEvent>{
	
	public static void main(String[] args) {
		launch(args);
	}
	Button buttonStart;
	Button buttonExit;
	
	@Override
	public void start(Stage PrimaryStage) throws Exception {
			PrimaryStage.setTitle("FantasyTD 1.0");
			
			buttonStart = new Button();
			buttonStart.setText("Start game");
			buttonStart.setOnAction(this);
			
			buttonExit = new Button();
			buttonExit.setText("Exit");
			buttonExit.setOnAction(this);
			
			
			 VBox layout = new VBox();
			    layout.setPadding(new Insets(10));
			    layout.setSpacing(8);
			    layout.setAlignment(Pos.CENTER);
			layout.getChildren().add(buttonStart);
			layout.getChildren().add(buttonExit);
			
			
			Scene scene = new Scene(layout, 150, 150);
			PrimaryStage.setScene(scene);
			PrimaryStage.show();
		}
	
	@Override
	public void handle(ActionEvent event) {
			Platform.exit();
	        System.exit(0);
	}
	

}

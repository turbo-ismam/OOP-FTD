package View.MainMenu;


import View.GameView.GameView;
import View.Options.Options;
import View.SceneChanger.SceneChanger;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MainMenu extends Scene{
	private final static Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
	private final static double SCENE_HEIGHT = primScreenBounds.getHeight();
	private final static double SCENE_WIDTH = primScreenBounds.getWidth();
	private final static Stage stage = SceneChanger.getStage();
	
	Button buttonStart, buttonExit, buttonOptions;
	Scene menu;
	
	public MainMenu(){
		super( new StackPane(), SCENE_WIDTH/2, SCENE_HEIGHT/2);
			
			buttonStart = new Button("Start game");
			buttonStart.setOnAction(e -> stage.setScene(new GameView()));
			
			buttonOptions = new Button("Options");
			buttonOptions.setOnAction(e -> stage.setScene(new Options()));
			
			buttonExit = new Button("Exit");
			buttonExit.setOnAction(e -> SceneChanger.getStage().close());
			
			VBox layout = new VBox(10);
			layout.setAlignment(Pos.CENTER);
			layout.getChildren().addAll(buttonStart, buttonOptions, buttonExit);
			this.setRoot(layout);
		}

}

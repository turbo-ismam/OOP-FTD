package View.Options;
import View.GameView.GameView;
import View.MainMenu.MainMenu;
import View.SceneChanger.SceneChanger;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;

public class Options extends Scene{
	
		private final static Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
		private final static double SCENE_HEIGHT = primScreenBounds.getHeight();
		private final static double SCENE_WIDTH = primScreenBounds.getWidth();
		
		private final ToggleGroup rbGroup;
		private final Button buttonMenu;
		private final RadioButton rb1, rb2, rb3;
		
		public Options(){
			super( new StackPane(), SCENE_WIDTH/4, SCENE_HEIGHT/3);
			
			rbGroup = new ToggleGroup();

			rb1 = new RadioButton("Easy");
			rb1.setToggleGroup(rbGroup);
			
			rb2 = new RadioButton("Medium");
			rb2.setToggleGroup(rbGroup);
			 
			rb3 = new RadioButton("Hard");
			rb3.setToggleGroup(rbGroup);
			
			buttonMenu = new Button("Back");
			buttonMenu.setOnAction(e-> {
				System.out.println(rbGroup.getSelectedToggle());
				SceneChanger.getStage().setScene(new MainMenu());
				
			});
			
				VBox layout = new VBox(10);
				layout.setAlignment(Pos.CENTER);
				layout.getChildren().addAll(rb1, rb2, rb3, buttonMenu);
				this.setRoot(layout);
			}
}


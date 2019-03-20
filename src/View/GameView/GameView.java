package View.GameView;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class GameView extends Scene{
	private Image logo = new Image("grass.png", 30, 30, true, true);
	public GameView() {
		super( new StackPane(), 850, 650);
		
		Button btnTower = new Button("Torre");
		Button btnStart = new Button("Start");
		btnTower.setOnAction(e->System.out.println("Tower"));
		
		final BorderPane root = new BorderPane();
		
		final VBox rightLayout = new VBox(10);
		rightLayout.setAlignment(Pos.TOP_LEFT);
		rightLayout.getChildren().add(btnTower);
		
		final HBox bottomLayout = new HBox(10);
		bottomLayout.setAlignment(Pos.BOTTOM_RIGHT);
		bottomLayout.getChildren().add(btnStart);
		
		final GridPane centerLayout = new GridPane();
		for(int i=0; i<15; i++) {
			for(int j=0; j<15; j++) {
				ToggleButton btn = new ToggleButton ("", new ImageView(logo));
				centerLayout.add(btn, i, j);
			}
		}
		root.setCenter(centerLayout);
        //root.setId("simpleMenu");
        root.setRight(rightLayout);
        //root.setTop(im);
        root.setBottom(bottomLayout);
        //root.setCenter(iv);
        this.setRoot(root);
        
        
		
	}
}

package View.GameView;

import View.SceneChanger.SceneChanger;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameView extends Scene{
	private final static Stage stage = SceneChanger.getStage();
	private static final double SCENE_HEIGHT = stage.getHeight();
	private static final double SCENE_WIDTH = stage.getWidth();
	private static final Image grass = new Image("grass.png", 45, 45, true, true);
	private static final Image sand = new Image("sand.jpg", 45, 45, true, true);
	private static final Image tower = new Image("tower.png", 45, 45, true, true);
	
	private Group group = new Group();
	private final ToggleButton btnTower;
	private final Button btnStart;
	
	private final VBox rightLayout;
	private final GridPane centerLayout;
	private final HBox bottomLayout;
	
	public GameView() {
		super( new StackPane(), SCENE_WIDTH,SCENE_HEIGHT );
		
		btnTower = new ToggleButton("Torre");
		btnStart = new Button("Start");
		final BorderPane root = new BorderPane();
		
		rightLayout = new VBox(10);
		rightLayout.setAlignment(Pos.TOP_LEFT);
		rightLayout.getChildren().add(btnTower);
		
		bottomLayout = new HBox(10);
		bottomLayout.setAlignment(Pos.BOTTOM_RIGHT);
		bottomLayout.getChildren().add(btnStart);
		
		centerLayout = new GridPane();
		drawMap();
		
		root.setCenter(centerLayout);
        root.setRight(rightLayout);
        //root.setTop(im);
        root.setBottom(bottomLayout);
        this.setRoot(root);
	}
	
	private void drawMap() {
		final double imageSize = SCENE_HEIGHT/16;
		for(int i=0; i<15; i++) {
			for(int j=0; j<15; j++) {
				Canvas cnv = new Canvas(imageSize, imageSize);
				cnv.setOnMouseClicked(e -> {
					if ( btnTower.isSelected()) {
						cnv.getGraphicsContext2D().drawImage(tower, 0, 0);
						btnTower.setSelected(false);
					}
				});
				group.getChildren().add(cnv);
				Image texture;
				texture= j==7? sand : grass;
				GraphicsContext gc = cnv.getGraphicsContext2D();
				gc.drawImage(texture, 0, 0);
				
				centerLayout.add(cnv, i, j);
			}
		}
	}
}

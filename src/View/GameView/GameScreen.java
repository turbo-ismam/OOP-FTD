package View.GameView;

import java.io.IOException;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import Constants.GameConstants;
import Model.Map.MapTile;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import java.awt.Dimension;
import java.awt.Toolkit;

public class GameScreen extends Region {
	
	private static final int gridSize=20;
	private ArrayList<GridButton> btList = new ArrayList<>();
	private ArrayList<MapTile> path = new ArrayList<>(); 
	
    private static final double buttonSize = GameConstants.buttonSize;
        
	//MainMenu test = new MainMenu();    
        
	public Parent createContent() throws IOException {
		
		 String style3 = "-fx-background-color: rgba(75, 250, 30, 0.5);"; //verde
		 String style2 = "-fx-background-color: rgba(50, 100, 200, 0.5);"; //trasparente
		 String style4 = "-fx-background-color: rgba(200, 50, 100, 0.5);"; //rosso
		 String style = "-fx-background-color: rgba(150, 100, 50, 0.5);"; //marrone
		
	/* FINESTRA GENERALE */
        Pane root = new Pane(); 
        root.setPrefSize(buttonSize*38, buttonSize*25);
        InputStream is = Files.newInputStream(Paths.get("res/gameMenuImage.png"));
	Image img = new Image(is);
	is.close();
	ImageView imgv = new ImageView(img);
	imgv.setFitWidth(buttonSize*40);
	imgv.setFitHeight(buttonSize*26);
	root.setOpacity(1);
	root.getChildren().add(imgv);
        
	/* SIDEBAR */
        FlowPane flow = new FlowPane();
        flow.setPrefSize(buttonSize*15, buttonSize*20);
        flow.setTranslateX(buttonSize*22);
        flow.setTranslateY(buttonSize);
        flow.setBackground(Background.EMPTY);
        flow.setVgap(4);
        flow.setHgap(4);
        flow.setStyle(style);
        
        /* MENU1: START AND OPTION */
        HBox menu1 = new HBox(buttonSize);
        menu1.setPrefSize(buttonSize, buttonSize);
        menu1.setTranslateY(buttonSize);
        menu1.setTranslateX(buttonSize);
        menu1.setSpacing(buttonSize);
        MenuButton start = new MenuButton("start");
        menu1.getChildren().add(start);
        flow.getChildren().add(menu1);
        MenuButton menu = new MenuButton("menu");
        menu.setOnMouseClicked(event -> {
        	//TODO ACTIN LISTENER DEI BOTTONI
        });
        menu1.getChildren().add(menu);
        
        /* MENU2: INFO HP, COINS, WAVE */
        VBox menu2 = new VBox();
        menu2.setPrefSize(buttonSize*13, buttonSize*9);
        menu2.setTranslateY(buttonSize*2);
        menu2.setTranslateX(buttonSize);
        menu2.setBackground(Background.EMPTY);
       
        menu2.setStyle(style2);
        flow.getChildren().add(menu2);
        
        /* MENU3: TOWERS */
        HBox menu3 = new HBox();
        menu3.setPrefSize(buttonSize*14,buttonSize* 6);
        menu3.setTranslateX(buttonSize);
        menu3.setTranslateY(buttonSize*2);
        menu3.setSpacing(buttonSize);
        //menu3.setBackground(Background.EMPTY);
        //menu3.setPadding(new Insets(25,0,0,15));
        PlaceTowerButton tower1 = new PlaceTowerButton("type 1");
        menu3.getChildren().add(tower1);
        PlaceTowerButton tower2 = new PlaceTowerButton("type 2");
        menu3.getChildren().add(tower2);
        flow.getChildren().add(menu3);
        
        /* GRIGLIA DI GIOCO */
        GridPane grid = new GridPane();
        grid.setPrefSize(buttonSize*20, buttonSize*20);

        for (Integer i=0;i<gridSize;i++) {
        	for(Integer j=0;j<gridSize;j++) {
        		GridButton bt = new GridButton("");
        		bt.position= i.toString() + " " + j.toString();
        		bt.setOnMouseClicked(event -> {
        			System.out.println(bt.position);
        		});
        		btList.add(bt);
            	grid.add(bt, j, i);
        	}
        }
        grid.setTranslateX(buttonSize);
        grid.setTranslateY(buttonSize);
        root.getChildren().addAll(grid,flow);
        
        System.out.println(GameConstants.height);
        System.out.println(GameConstants.width);
        
        return root;
	}

}

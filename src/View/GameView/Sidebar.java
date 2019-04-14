package View.GameView;

import java.io.IOException;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import Model.Map.Map;
import Model.Map.MapTile;
import Model.Map.MapTileImpl;
import Model.Map.MapTile.Status;
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
import utilityClasses.Pair;

public class Sidebar extends Region {
	
	private static final int gridSize=20;
	private ArrayList<Button> btList = new ArrayList<>();
	private Map grid;
	//MainMenu test = new MainMenu();
	
	public Parent createContent() throws IOException {
        Pane root = new Pane();
        root.setPrefSize(1500, 800);
        
        FlowPane flow = new FlowPane();
        flow.setPrefSize(500, 800);
        
        flow.setBackground(Background.EMPTY);
        String style = "-fx-background-color: rgba(150, 100, 50, 1);";
        flow.setStyle(style);
        
        //flow.setPadding(new Insets(50,50,50,50));
        flow.setVgap(4);
        flow.setHgap(4);
        String style4 = "-fx-background-color: rgba(200, 50, 100, 0.5);";
        HBox menu1 = new HBox(10);        
        menu1.setPrefSize(300, 200);
        menu1.setTranslateY(-35);
        menu1.setTranslateX(25);
        menu1.setSpacing(10);
        MenuButton start = new MenuButton("start");
        menu1.getChildren().add(start);
        flow.getChildren().add(menu1);
        MenuButton menu = new MenuButton("menu");
        menu.setOnMouseClicked(event -> {
        	
        	
        	
        	
        	
        });
       //menu1.setBackground(Background.EMPTY);
        //menu1.setStyle(style4);
        menu1.getChildren().add(menu);
        
        VBox menu2 = new VBox();
        menu2.setPrefSize(450, 300);
        menu2.setTranslateY(-80);
        menu2.setTranslateX(25);
        menu2.setBackground(Background.EMPTY);
        String style2 = "-fx-background-color: rgba(50, 100, 200, 0.5);";
        menu2.setStyle(style2);
        flow.getChildren().add(menu2);
        
        FlowPane menu3 = new FlowPane();
        menu3.setPrefSize(450, 260);
        menu3.setTranslateY(-75);
        menu3.setTranslateX(25);
        menu3.setBackground(Background.EMPTY);
        String style3 = "-fx-background-color: rgba(75, 250, 30, 0.5);";
        menu3.setStyle(style3);
        menu3.setPadding(new Insets(25,0,0,15));
        menu3.setHgap(15);
        menu3.setVgap(15);
        MenuButton1 tower1 = new MenuButton1("type 1");
        MenuButton1 tower2 = new MenuButton1("type 2");
        MenuButton1 tower3 = new MenuButton1("type 3");
        MenuButton1 tower4 = new MenuButton1("type 4");
        menu3.getChildren().addAll(tower1,tower2,tower3,tower4);
        flow.getChildren().add(menu3);

        
        /* GRID */
        
        GridPane grid = new GridPane();
        grid.setPrefSize(800, 800);

        for (Integer i=0;i<gridSize;i++) {
        	for(Integer j=0;j<gridSize;j++) {
        		Button bt = new Button("");
        		bt.position= i.toString() + " " + j.toString();
        		bt.tile.setPosition(new Pair<Integer,Integer>(i,j));
        		
        		bt.tile.setStatus(Status.EMPTY);
        		bt.setOnMouseClicked(event -> {
        			System.out.println(bt.position);
        		});
        		btList.add(bt);
            	grid.add(bt, j, i);
        	}
        }
        flow.setTranslateX(950);
        root.getChildren().addAll(grid,flow);
        
        return root;
	}
	
	private static class MenuButton extends StackPane {
		private Text text;
		
		public MenuButton(String name) {
			
			text = new Text(name);
			text.setFont(Font.loadFont("file:res/JOJO____.ttf", 30));
			text.setFill(Color.DEEPPINK);
			
			Rectangle bg = new Rectangle(220,110);
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
	
	private static class MenuButton1 extends StackPane {
		private Text text;
		
		public MenuButton1(String name) {
			
			text = new Text(name);
			text.setFont(Font.loadFont("file:res/JOJO____.ttf", 30));
			text.setFill(Color.BLACK);
			
			Rectangle bg = new Rectangle(200,100);
			bg.setOpacity(0.8);
			bg.setFill(Color.DARKORANGE);
			
			  setAlignment(Pos.CENTER);
	            setRotate(-0.5);
	            getChildren().addAll(bg, text);

	            setOnMouseEntered(event -> {
	                bg.setFill(Color.VIOLET);
	                text.setFill(Color.WHITE);
	            });

	            setOnMouseExited(event -> {
	                bg.setFill(Color.DARKORANGE);
	                text.setFill(Color.BLACK);
	            });

	            DropShadow drop = new DropShadow(50, Color.WHITE);
	            drop.setInput(new Glow());

	            setOnMousePressed(event -> setEffect(drop));
	            setOnMouseReleased(event -> setEffect(null));  
		}
	}
	
private static class Button extends StackPane {
		
		private Text text;
		private String position;
		public MapTile tile = new MapTileImpl();
		
		public Button(String name) throws IOException {
			
			text = new Text(name);
			text.setFont(text.getFont().font(10));
			//text.setFont(Font.loadFont("file:res/JOJO__.ttf", 30));

			text.setFill(Color.DEEPPINK);
			
			/* REALIZZAZIONE DI OGNI TILE */
			Rectangle bg = new Rectangle(50,50);
			bg.setOpacity(0.3);
			/* grass image */
			InputStream is = Files.newInputStream(Paths.get("res/grass.jpg"));
			Image logo = new Image(is);
    		is.close();
    		ImageView img = new ImageView(logo);
    		img.setFitWidth(50);
    		img.setFitHeight(50);
			//Image logo = new Image("grass.png", 30, 30, true, true);
			bg.setFill(new ImagePattern(logo));
			
			
			  setAlignment(Pos.CENTER);
	            setRotate(-0.5);
	            getChildren().addAll(bg, text);

	            setOnMouseEntered(event -> {
	                //bg.setTranslateX(10);
	                text.setTranslateX(10);
	                bg.setFill(Color.CYAN);
	                text.setFill(Color.BLACK);
	            });

	            setOnMouseExited(event -> {
	                bg.setTranslateX(0);
	                text.setTranslateX(0);
	                bg.setFill(new ImagePattern(logo));
	                text.setFill(Color.DEEPPINK);
	            });

	            DropShadow drop = new DropShadow(50, Color.WHITE);
	            drop.setInput(new Glow());

	            setOnMousePressed(event -> setEffect(drop));
	            setOnMouseReleased(event -> setEffect(null));  
		}
	}

}

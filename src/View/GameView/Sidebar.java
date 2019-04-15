package View.GameView;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

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


public class Sidebar extends Region {
	
	private static final int gridSize=20;
	private ArrayList<Button> btList = new ArrayList<>();
	
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    static final double width = screenSize.getWidth();
    static final double height = screenSize.getHeight();
    static final double buttonSize = height/30;
    
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
        menu3.setTranslateY(this.buttonSize*2);
        menu3.setSpacing(buttonSize);
        //menu3.setBackground(Background.EMPTY);
        //menu3.setPadding(new Insets(25,0,0,15));
        MenuButton1 tower1 = new MenuButton1("type 1");
        menu3.getChildren().add(tower1);
        MenuButton1 tower2 = new MenuButton1("type 2");
        menu3.getChildren().add(tower2);
        flow.getChildren().add(menu3);

        /* GRIGLIA DI GIOCO */
        GridPane grid = new GridPane();
        grid.setPrefSize(buttonSize*20, buttonSize*20);

        for (Integer i=0;i<gridSize;i++) {
        	for(Integer j=0;j<gridSize;j++) {
        		Button bt = new Button("");
        		bt.position= i.toString() + " " + j.toString();
        		bt.setOnMouseClicked(event -> {
        			System.out.println(bt.position);
        		});
        		btList.add(bt);
            	grid.add(bt, j, i);
        	}
        }
        grid.setTranslateX(this.buttonSize);
        grid.setTranslateY(this.buttonSize);
        root.getChildren().addAll(grid,flow);
        
        
        
        System.out.println(this.height);
        System.out.println(this.width);
        
        return root;
	}
	
	/* START AND OPTION BUTTONS */
	private static class MenuButton extends StackPane {
		private Text text;
		
		public MenuButton(String name) {
			
			text = new Text(name);
			text.setFont(Font.loadFont("file:res/JOJO____.ttf", 22));
			text.setFill(Color.DEEPPINK);
			
			Rectangle bg = new Rectangle(buttonSize*6,buttonSize*3);
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
	
	/* TOWER BUTTONS */
	private static class MenuButton1 extends StackPane {
		private Text text;
		
		public MenuButton1(String name) {
			
			text = new Text(name);
			text.setFont(Font.loadFont("file:res/JOJO____.ttf", 22));
			text.setFill(Color.BLACK);
			
			Rectangle bg = new Rectangle(buttonSize*6,buttonSize*3);
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
	
	/* GRID BUTTONS */
	private static class Button extends StackPane {
		
		private Text text;
		private String position;
		
		public Button(String name) throws IOException {
			
			text = new Text(name);

			text.setFill(Color.DEEPPINK);
			
			/* REALIZZAZIONE DI OGNI TILE */
			Rectangle bg = new Rectangle(buttonSize,buttonSize);
			bg.setOpacity(100);
			/* grass image */
			InputStream is = Files.newInputStream(Paths.get("res/grass.jpg"));
			Image logo = new Image(is);
    		is.close();
    		ImageView img = new ImageView(logo);
    		img.setFitWidth(50);
    		img.setFitHeight(50);
			bg.setFill(new ImagePattern(logo));
			
			
			  setAlignment(Pos.CENTER);
	            setRotate(-0.5);
	            getChildren().addAll(bg, text);

	            setOnMouseEntered(event -> {
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

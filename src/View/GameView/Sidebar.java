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
    static final double buttonSize = height/42;
    static final double sidebarHeight = (height/41.5)*gridSize;
    
	//MainMenu test = new MainMenu();
	
	public Parent createContent() throws IOException {
		
        Pane root = new Pane(); //finestra
        root.setPrefSize(this.width/2, this.height/2);
        InputStream is = Files.newInputStream(Paths.get("res/gameMenuImage.png"));
		Image img = new Image(is);
		is.close();
		
		ImageView imgv = new ImageView(img);
		imgv.setFitWidth(this.width/2);
		imgv.setFitHeight(this.height/2);
		root.setOpacity(1);
		root.getChildren().add(imgv);
        
        FlowPane flow = new FlowPane();
        flow.setPrefSize(500, this.sidebarHeight-this.sidebarHeight*0.025); //sidebar
        
        flow.setBackground(Background.EMPTY);
        String style = "-fx-background-color: rgba(150, 100, 50, 0.5);";
        flow.setStyle(style);
        
        //flow.setPadding(new Insets(50,50,50,50));
        flow.setVgap(4);
        flow.setHgap(4);
        String style4 = "-fx-background-color: rgba(200, 50, 100, 0.5);";
        HBox menu1 = new HBox(10);        
        menu1.setPrefSize(300, 200);
        menu1.setTranslateY(0);
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
        menu2.setPrefSize(450, 400);
        menu2.setTranslateY(this.buttonSize*0.5);
        menu2.setTranslateX(25);
        menu2.setBackground(Background.EMPTY);
        String style2 = "-fx-background-color: rgba(50, 100, 200, 0.5);";
        menu2.setStyle(style2);
        flow.getChildren().add(menu2);
        
        FlowPane menu3 = new FlowPane();
        menu3.setPrefSize(buttonSize*9,buttonSize* 5);
        menu3.setTranslateY(this.buttonSize*2);
        menu3.setTranslateX(buttonSize/2.5);
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
        
        flow.setTranslateY(this.buttonSize);
        flow.setTranslateX(this.buttonSize*25);
        
        grid.setTranslateX(this.buttonSize/2);
        grid.setTranslateY(this.buttonSize/2);
        root.getChildren().addAll(grid,flow);
        
        
        
        System.out.println(this.height);
        System.out.println(this.width);
        
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

package view.gameview;

import constants.GameConstants;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import view.mainmenu.ImageLoader;

public class Win extends Region{
    
    public void start(Stage primaryStage) throws Exception {
        
        Pane pane = new Pane();
        pane.setPrefSize(1920, 1080);
        Text text = new Text("Yare Yare Daze... You win!");
        text.setFont(Font.loadFont("file:res/JOJO____.ttf", 40));
        text.setFill(Color.FUCHSIA);
        
        VBox space = new VBox();
        
        ImageLoader im = new ImageLoader("res/win.jpg");

        pane.getChildren().add(im.getImage());
        
        ButtonD bt = new ButtonD("Play again\nIts a bait");
        bt.setOnMouseClicked(event -> {
            System.exit(0);
        });     
        
        Rectangle bg = new Rectangle(1920,1080);
        bg.setFill(Color.GREY);
        bg.setOpacity(0.5);
         
        bt.setTranslateY(-540);
        text.setTranslateY(-700);
        text.setTranslateX(425);
        space.getChildren().addAll(bg,text,bt);
        pane.getChildren().add(space);

         Scene scene = new Scene(pane);
            primaryStage.setTitle("Difficulty");
            primaryStage.setScene(scene);
            primaryStage.setResizable(true);
            primaryStage.show();
        
    }
    
    public class ButtonD extends StackPane{

        private Text text;
        
        public ButtonD(String name) {
            
            text = new Text(name);
            text.setFont(Font.loadFont("file:res/JOJO____.ttf", 25));
            text.setFill(Color.DEEPPINK);
            
            Rectangle bg = new Rectangle(GameConstants.BUTTON_SIZE * 10, GameConstants.BUTTON_SIZE * 3);
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
    
}

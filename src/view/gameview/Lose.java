package view.gameview;

import java.io.InputStream;

import constants.ViewConstants;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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


public class Lose extends Region{
    
    public void start(final Stage primaryStage) throws Exception {
        
        final Pane pane = new Pane();
        pane.setPrefSize(1920, 1080);
        final Text text = new Text("Yare Yare Daze...\n    Game Lost!\n      Loooser!");
        final InputStream is = this.getClass().getResourceAsStream("/JOJO____.ttf");
        text.setFont(Font.loadFont(is, 40));
        text.setFill(Color.FUCHSIA);
        
        final VBox space = new VBox();
        final Image img = new Image(this.getClass().getResourceAsStream("/lose.jpg"));
        final ImageView imgv = new ImageView(img);
        pane.getChildren().add(imgv);
        
        final ButtonD bt = new ButtonD("Press here\n   Loser!");
        bt.setOnMouseClicked(event -> {
            System.exit(0);
        });     
        
        final Rectangle bg = new Rectangle(1920,1080);
        bg.setFill(Color.GREY);
        bg.setOpacity(0.4);
         
        bt.setTranslateY(-540);
        text.setTranslateY(-700);
        text.setTranslateX(675);
        space.getChildren().addAll(bg,text,bt);
        pane.getChildren().add(space);

        final Scene scene = new Scene(pane);
            primaryStage.setTitle("Difficulty");
            primaryStage.setOnCloseRequest(e -> Platform.exit());
            primaryStage.setScene(scene);
            primaryStage.setResizable(true);
            primaryStage.show();
        
    }
    
    public class ButtonD extends StackPane{

        private final Text text;
        
        public ButtonD(final String name) {
            
            text = new Text(name);
            text.setFont(Font.loadFont("file:res/JOJO____.ttf", 30));
            text.setFill(Color.DEEPPINK);
            
            final Rectangle bg = new Rectangle(ViewConstants.BUTTON_SIZE*10,ViewConstants.BUTTON_SIZE*3);
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

                final DropShadow drop = new DropShadow(50, Color.WHITE);
                drop.setInput(new Glow());

                setOnMousePressed(event -> setEffect(drop));
                setOnMouseReleased(event -> setEffect(null));  
        }
    }
    
}

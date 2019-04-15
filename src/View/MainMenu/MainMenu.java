package View.MainMenu;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.imageio.stream.ImageInputStream;

import View.GameView.Sidebar;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainMenu extends Application{
	
	private Sidebar game = new Sidebar();
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    static final double width = screenSize.getWidth();
    static final double height = screenSize.getHeight();
    static final double buttonSize = height/42;
    static final int offset = 400;
	
	 public Parent createContent() throws IOException {
		 
	        String musicFile = "res/Jojo.mp3";
			Media sound = new Media(new File(musicFile).toURI().toString());
			MediaPlayer mediaPlayer1 = new MediaPlayer(sound);
			mediaPlayer1.setVolume(0.1);
			
			Pane root = new Pane();
			root.setPrefSize(buttonSize*38, buttonSize*22);
			
			InputStream is = Files.newInputStream(Paths.get("res/62266.jpg"));
			Image img = new Image(is);
			is.close();
			
			ImageView imgv = new ImageView(img);
			imgv.setFitWidth(buttonSize*39);
			imgv.setFitHeight(buttonSize*23);
			
			//gameMenu = new GameMenu();
			
			root.getChildren().add(imgv);
			
			String musicFile1 = "res/ZA WARUDO.mp3";
			Media sound1 = new Media(new File(musicFile1).toURI().toString());
			MediaPlayer mediaPlayer = new MediaPlayer(sound1);
			mediaPlayer.setVolume(1);
			mediaPlayer.setStopTime(Duration.seconds(1.9));
			
            VBox menu0 = new VBox(20);
            VBox menu1 = new VBox(20);
            VBox menu2 = new VBox(20);
            VBox menu3 = new VBox(20);
            VBox menu4 = new VBox(20);
            VBox menu5 = new VBox(20);
            VBox menu6 = new VBox(20);
            
            Rectangle bg = new Rectangle(buttonSize*39, buttonSize*23);
            bg.setFill(Color.GREY);
            bg.setOpacity(0.4);
            

            
            InputStream is2 = Files.newInputStream(Paths.get("res/logo.png"));
    		Image logo = new Image(is2);
    		is2.close();
    		ImageView imgv1 = new ImageView(logo);
    		imgv1.setFitWidth(550);
    		imgv1.setFitHeight(250);
    		
    		InputStream is1 = Files.newInputStream(Paths.get("res/giorno.jpg"));
    		Image logo2 = new Image(is1);
    		is1.close();
    		ImageView imgv2 = new ImageView(logo2);
    		imgv2.setFitWidth(buttonSize*39);
    		imgv2.setFitHeight(buttonSize*23);
    		imgv2.setTranslateX(-buttonSize*3.25);
    		
    		InputStream is3 = Files.newInputStream(Paths.get("res/jotaro.png"));
    		Image logo3 = new Image(is3);
    		is3.close();
    		ImageView imgv3 = new ImageView(logo3);
    		imgv3.setFitWidth(buttonSize*39);
    		imgv3.setFitHeight(buttonSize*23);
    		imgv3.setTranslateX(-buttonSize*3.25);
            	    		
            //menu2.setTranslateX(500);
            //menu2.setTranslateY(80);
            menu2.getChildren().add(imgv1);
            menu4.getChildren().addAll(imgv2);
            menu5.getChildren().add(bg);
            menu6.getChildren().add(imgv3);
            
            
            menu0.setTranslateX(buttonSize*15); //start-play-option, prima schermata
            menu0.setTranslateY(buttonSize*12);

            menu1.setTranslateY(buttonSize*12);	//options
            
            //menu4.setTranslateX(buttonSize*39);  //giorno
            //menu6.setTranslateX(buttonSize*39);  //jotaro
            
            menu3.setTranslateX(buttonSize*15);  // difficoltá
            menu3.setTranslateY(buttonSize*12);

            

            //menu1.setTranslateX(offset);
            //menu1.setTranslateX(900);

            MenuButton btnResume = new MenuButton("play");
            btnResume.setOnMouseClicked(event -> {
            
            	try {
					root.getChildren().setAll(game.createContent());
				} catch (IOException e) {
					
					e.printStackTrace();
				}
            	mediaPlayer1.stop();
            });

            /* ANIMAZIONI BOTTONI */
            MenuButton btnOptions = new MenuButton("options");
            btnOptions.setOnMouseClicked(event -> {
            	mediaPlayer.stop();
            	mediaPlayer.play();
            	root.getChildren().remove(menu5);
            	root.getChildren().add(menu4);
            	root.getChildren().add(menu5);
                root.getChildren().add(menu1);
                
                TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu0);
                tt.setToX(menu0.getTranslateX() - offset);
                
                TranslateTransition t0 = new TranslateTransition(Duration.seconds(0.25), menu2);
                t0.setToX(menu2.getTranslateX() - offset);
                
                TranslateTransition t4 = new TranslateTransition(Duration.seconds(0.5), menu4);
                t4.setToX(menu0.getTranslateX() - 600);

                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu1);
                tt1.setToX(menu0.getTranslateX());

                tt.play();
                t0.play();
                t4.play();
                tt1.play();

                tt.setOnFinished(evt -> {
                    root.getChildren().remove(menu0);
                    root.getChildren().remove(menu2);
                });
            });

            MenuButton btnExit = new MenuButton("exit");
            btnExit.setOnMouseClicked(event -> {
                System.exit(0);
            });

            MenuButton btnBack = new MenuButton("back");
            btnBack.setOnMouseClicked(event -> {
            	mediaPlayer.stop();
            	mediaPlayer.play();
            	root.getChildren().add(menu2);
                root.getChildren().add(menu0);

                TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu1);
                tt.setToX(menu1.getTranslateX() + offset);
                
                TranslateTransition t4 = new TranslateTransition(Duration.seconds(0.25), menu4);
                t4.setToX(menu4.getTranslateX() + offset + 1200);

                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu0);
                tt1.setToX(menu1.getTranslateX());
                
                TranslateTransition tt0 = new TranslateTransition(Duration.seconds(0.5), menu2);
                tt0.setToX(menu1.getTranslateX() - 100);
                
                t4.play();
                tt.play();
                tt1.play();
                tt0.play();

                tt.setOnFinished(evt -> {
                   root.getChildren().remove(menu1);
                   root.getChildren().remove(menu4);
                });
            });

            MenuButton btnSound = new MenuButton("sound");
            btnSound.setOnMouseClicked(event -> {
            	mediaPlayer.stop();
            	mediaPlayer.play();
            });
            
            
            MenuButton btnDiff = new MenuButton("difficulty");
            btnDiff.setOnMouseClicked(event -> {
            	mediaPlayer.stop();
            	mediaPlayer.play();
            	root.getChildren().add(menu6);
                root.getChildren().add(menu3);

                TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu1);
                tt.setToX(menu1.getTranslateX() - offset);

                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu3);
                tt1.setToX(menu1.getTranslateX());
                
                TranslateTransition tt2 = new TranslateTransition(Duration.seconds(0.5), menu6);
                tt2.setToX(menu1.getTranslateX() - 600);

                tt.play();
                tt2.play();
                tt1.play();

                tt.setOnFinished(evt -> {
                    root.getChildren().remove(menu1);                 
                    
                });
            });
            
            MenuButton btnEasy = new MenuButton("easy");
            MenuButton btnMedium = new MenuButton("medium");
            MenuButton btnHard = new MenuButton("hard");
            MenuButton btnBack1 = new MenuButton("back");
            
            btnBack1.setOnMouseClicked(event -> {
            	mediaPlayer.stop();
            	mediaPlayer.play();
                root.getChildren().add(menu1);

                TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu3);
                tt.setToX(menu3.getTranslateX() + offset);

                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu1);
                tt1.setToX(menu3.getTranslateX());
                
                TranslateTransition tt0 = new TranslateTransition(Duration.seconds(0.25), menu6);
                tt0.setToX(menu6.getTranslateX() + offset + 1200);

                tt0.play();
                tt.play();
                tt1.play();

                tt.setOnFinished(evt -> {
                    root.getChildren().remove(menu3);
                    root.getChildren().remove(menu6);
                });
            });

            menu0.getChildren().addAll(btnResume, btnOptions, btnExit);
            menu1.getChildren().addAll(btnBack, btnSound, btnDiff);
            menu3.getChildren().addAll(btnBack1,btnEasy,btnMedium,btnHard);

            root.getChildren().addAll(menu5,menu2, menu0);
        
    
			
			
			mediaPlayer1.play();
	        return root;
	    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		 Scene scene = new Scene(createContent());
	        primaryStage.setTitle("Jojo Menu");
	        primaryStage.setScene(scene);
	        primaryStage.setResizable(false);
	        primaryStage.show();
		
	}
	
	
	public static class MenuButton extends StackPane {
		private Text text;
		
		public MenuButton(String name) {
			
			text = new Text(name);
			text.setFont(Font.loadFont("file:res/JOJO____.ttf", 30));
			text.setFill(Color.DEEPPINK);
			
			Rectangle bg = new Rectangle(300,70);
			bg.setOpacity(0.8);
			bg.setFill(Color.CYAN);
			
			  setAlignment(Pos.CENTER);
	            setRotate(-0.5);
	            getChildren().addAll(bg, text);

	            setOnMouseEntered(event -> {
	                bg.setTranslateX(10);
	                text.setTranslateX(10);
	                bg.setFill(Color.WHITE);
	                text.setFill(Color.BLACK);
	            });

	            setOnMouseExited(event -> {
	                bg.setTranslateX(0);
	                text.setTranslateX(0);
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

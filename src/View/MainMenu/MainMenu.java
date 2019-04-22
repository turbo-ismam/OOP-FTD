
package View.MainMenu;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;


import Constants.GameConstants;
import Controller.GameController.GameController;
import Controller.GameController.GameControllerImpl;
import View.GameView.GameScreen;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainMenu extends Application{
	
	private GameScreen game;
	private Difficulty avviso = new Difficulty();
	private GameController gc = new GameControllerImpl();
	
    static final double buttonSize = GameConstants.buttonSize;
    static final double width = GameConstants.gameWidth;
    static final double height = GameConstants.gameHeight;
    private double vol;
    
    static final int offset = 400;
	
	 public Parent createContent() throws IOException {
		 
	        String musicFile = "res/Jojo.mp3";
			Media sound = new Media(new File(musicFile).toURI().toString());
			MediaPlayer mediaPlayer1 = new MediaPlayer(sound);
			this.vol=0.1;
			mediaPlayer1.setVolume(this.vol);	//SISTEMA QUI IL VOLUME
			
			Pane root = new Pane();
			root.setPrefSize(width, height);
			
			LayoutImages im = new LayoutImages();
			
			root.getChildren().add(im.getImgv());
			
			/* Effetto sonoro per i bottoni */
			String musicFile1 = "res/ZA WARUDO.mp3";
			Media sound1 = new Media(new File(musicFile1).toURI().toString());
			MediaPlayer mediaPlayer = new MediaPlayer(sound1);
			mediaPlayer.setVolume(0.1);
			mediaPlayer.setStopTime(Duration.seconds(1.5));
			
			
            VBox menu0 = new VBox(buttonSize);	// box bottoni start-options-exit
            menu0.setPrefSize(buttonSize*10, buttonSize*3);
            menu0.setTranslateX(buttonSize*19.5-buttonSize*5); 
            menu0.setTranslateY(buttonSize*11.5-buttonSize*2);
            
            VBox menu1 = new VBox(buttonSize);	// box bottoni back-sound-difficoulty
            menu1.setTranslateY(buttonSize*12);
            menu1.setTranslateX(buttonSize*19.5-buttonSize*5); 
            menu1.setTranslateY(buttonSize*11.5-buttonSize*2);
            
            VBox menu3 = new VBox(buttonSize);	//box bottoni back-easy-medium-hard
            menu3.setTranslateX(buttonSize*15);  // difficoltá
            menu3.setTranslateY(buttonSize*12);
            menu3.setTranslateX(buttonSize*19.5-buttonSize*5); 
            menu3.setTranslateY(buttonSize*11.5-buttonSize*2);
            
            VBox menu4 = new VBox(buttonSize);	// sfondo giorno
            VBox menu2 = new VBox(buttonSize);	// logo prima schermata
            VBox menu5 = new VBox(buttonSize);	// rettangolo grigio per rendere bello tutti gli sfondi
            VBox menu6 = new VBox(buttonSize);	// sfondo jotaro
            
            Rectangle bg = new Rectangle(width+buttonSize,height+buttonSize);
            bg.setFill(Color.GREY);
            bg.setOpacity(0.4);
            
    		
            menu2.getChildren().add(im.getimgv1());
            menu4.getChildren().addAll(im.getImgv2());
            menu5.getChildren().add(bg);
            menu6.getChildren().add(im.getImgv3());
            
            
            MenuButton btnResume = new MenuButton("play");
            btnResume.setOnMouseClicked(event -> {
            	gc.startGame();
            	game = new GameScreen(gc);
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
            

            btnEasy.setOnMouseClicked(event -> {
            	gc.setDifficulty(1);
            	System.out.println("facile");
            	Stage stage = new Stage();
            	try {
					avviso.start(stage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            });

            btnMedium.setOnMouseClicked(event -> {
            	gc.setDifficulty(2);
            	System.out.println("normale");
            	Stage stage = new Stage();
            	try {
					avviso.start(stage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            });
            
            btnHard.setOnMouseClicked(event -> {
            	gc.setDifficulty(3);
            	System.out.println("difficile");
            	Stage stage = new Stage();
            	try {
					avviso.start(stage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
	
	public void setVol(double volume) {
		this.vol=volume;
	}
	

}

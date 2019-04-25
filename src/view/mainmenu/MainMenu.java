package view.mainmenu;

import java.io.File;
import java.io.IOException;
import constants.GameConstants;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import view.gameview.GameScreen;


public class MainMenu extends Application{
    private double volume = 0.1;
    private PlayerName name;
    private QuitHandler quitHandler;
    private final Difficulty avviso = new Difficulty();

    static final double BUTTONSIZE = GameConstants.BUTTON_SIZE;
    static final double WIDTH = GameConstants.GAME_WIDTH;
    static final double HEIGHT = GameConstants.GAME_HEIGHT;
    private double vol;

/**
 * 
 * @return pane
 * @throws IOException 
 */
    public Parent createContent() throws IOException {

            final String musicFile = "res/Jojo.mp3";
            final Media sound = new Media(new File(musicFile).toURI().toString());
            final MediaPlayer mediaPlayer1 = new MediaPlayer(sound);
            this.vol = 0;
            mediaPlayer1.setVolume(0.1); //SISTEMA QUI IL VOLUME

            final Pane root = new Pane();
            root.setPrefSize(WIDTH, HEIGHT);

            final LayoutImages im = new LayoutImages();

            root.getChildren().add(im.getImgv());

            /* Effetto sonoro per i bottoni */
            final String musicFile1 = "res/ZA WARUDO.mp3";
            final Media sound1 = new Media(new File(musicFile1).toURI().toString());
            final MediaPlayer mediaPlayer = new MediaPlayer(sound1);
            mediaPlayer.setVolume(1);
            mediaPlayer.setStopTime(Duration.seconds(1.5));


            final VBox menu0 = new VBox(BUTTONSIZE); // box bottoni start-options-exit
            menu0.setTranslateX(BUTTONSIZE * 19.5 - BUTTONSIZE * 5); 
            menu0.setTranslateY(BUTTONSIZE * 11.5 - BUTTONSIZE * 2); 

            final VBox menu1 = new VBox(BUTTONSIZE); // box bottoni back-sound-difficoulty
            menu1.setTranslateX(BUTTONSIZE * 19.5 - BUTTONSIZE * 5); 
            menu1.setTranslateY(BUTTONSIZE * 11.5 - BUTTONSIZE * 2);

            final VBox menu3 = new VBox(BUTTONSIZE); //box bottoni back-easy-medium-hard
            menu3.setTranslateX(BUTTONSIZE * 19.5 - BUTTONSIZE * 5); 
            menu3.setTranslateY(BUTTONSIZE * 11.5 - BUTTONSIZE * 2);

            final VBox menu8 = new VBox(BUTTONSIZE); //box bottoni volume low-medium-high
            menu8.setTranslateX(BUTTONSIZE * 19.5 - BUTTONSIZE * 5); 
            menu8.setTranslateY(BUTTONSIZE * 11.5 - BUTTONSIZE * 2);

            final VBox menu4 = new VBox(BUTTONSIZE); // sfondo giorno
            final VBox menu2 = new VBox(BUTTONSIZE); // logo prima schermata
            final VBox menu5 = new VBox(BUTTONSIZE); // rettangolo grigio per rendere bello tutti gli sfondi
            final VBox menu6 = new VBox(BUTTONSIZE); // sfondo jotaro
            final VBox menu7 = new VBox(BUTTONSIZE); //sfondo sound


            final Rectangle bg = new Rectangle(WIDTH + BUTTONSIZE, HEIGHT + BUTTONSIZE);
            bg.setFill(Color.GREY);
            bg.setOpacity(0.4);


            menu2.getChildren().add(im.getimgv1());
            menu4.getChildren().add(im.getImgv2());
            menu5.getChildren().add(bg);
            menu6.getChildren().add(im.getImgv3());
            menu7.getChildren().add(im.getImgv7());

            menu4.setTranslateX(BUTTONSIZE * 30);
            menu6.setTranslateX(BUTTONSIZE * 30);
            menu3.setTranslateX(BUTTONSIZE * 30);
            menu7.setTranslateX(-BUTTONSIZE * 2);
            menu7.setTranslateY(BUTTONSIZE * 30);
            menu8.setTranslateY(BUTTONSIZE * 30);

            final VolumeButton soundback = new VolumeButton("Back");
            final VolumeButton low = new VolumeButton("Low");
            final VolumeButton medium = new VolumeButton("Medium");
            final VolumeButton high = new VolumeButton("High");
            final VolumeButton mute = new VolumeButton("Mute");

            low.setOnMouseClicked(event -> {
                volume = 0.1;
            mediaPlayer1.setVolume(0.1);
            });

            medium.setOnMouseClicked(event -> {
                volume = 0.5;
            mediaPlayer1.setVolume(0.5);
            });

            high.setOnMouseClicked(event -> {
                volume = 1;
            mediaPlayer1.setVolume(1);
            });

            mute.setOnMouseClicked(event -> {
                volume = 0;
            mediaPlayer1.setVolume(0);
            });

            soundback.setOnMouseClicked(event -> {
            mediaPlayer.stop();
            mediaPlayer.play();
                root.getChildren().add(menu1);

                final TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu7);
                tt.setToY(menu3.getTranslateY() + HEIGHT);

                final TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu1);
                tt1.setToY(menu3.getTranslateY());

                final TranslateTransition tt0 = new TranslateTransition(Duration.seconds(0.25), menu8);
                tt0.setToY(menu6.getTranslateY() - HEIGHT);

                tt0.play();
                tt.play();
                tt1.play();

                tt.setOnFinished(evt -> {
                    root.getChildren().remove(menu7);
                    root.getChildren().remove(menu8);
                });
            });

            final MenuButton btnSound = new MenuButton("sound");
            btnSound.setOnMouseClicked(event -> {
                mediaPlayer.stop();
                mediaPlayer.play();
                root.getChildren().remove(menu5);
                root.getChildren().add(menu7);
                root.getChildren().add(menu5);
                root.getChildren().add(menu8);

                final TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu1);
                tt.setToY(menu1.getTranslateY() - HEIGHT);

                final TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu7);
                tt1.setToY(menu1.getTranslateY() - HEIGHT * 0.439);

                final TranslateTransition tt2 = new TranslateTransition(Duration.seconds(0.5), menu8);
                tt2.setToY(menu1.getTranslateY() - BUTTONSIZE * 3);

                tt.play();
                tt2.play();
                tt1.play();

                tt.setOnFinished(evt -> {
                    root.getChildren().remove(menu1); 
                });

            });
            final MenuButton btnResume = new MenuButton("play");
            btnResume.setOnMouseClicked(event -> {
                name = new PlayerName(volume);
                quitHandler = new QuitHandler(name.getgc());
                try {
                    root.getChildren().setAll(name.createContent());
                } catch (IOException e) {

                    e.printStackTrace();
                }
                mediaPlayer1.stop();
            });

            /* ANIMAZIONI BOTTONI */
            final MenuButton btnOptions = new MenuButton("options");
            btnOptions.setOnMouseClicked(event -> {
                mediaPlayer.stop();
                mediaPlayer.play();
                root.getChildren().remove(menu5);
                root.getChildren().add(menu4);
                root.getChildren().add(menu5);
                root.getChildren().add(menu1);

                final TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu0);
                tt.setToX(menu0.getTranslateX() - WIDTH);

                final TranslateTransition t0 = new TranslateTransition(Duration.seconds(0.25), menu2);
                t0.setToX(menu2.getTranslateX() - WIDTH);

                final TranslateTransition t4 = new TranslateTransition(Duration.seconds(0.5), menu4);
                t4.setToX(menu0.getTranslateX() - WIDTH * 0.439);

                final TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu1);
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

            final MenuButton btnExit = new MenuButton("exit");
            btnExit.setOnMouseClicked(event -> {
                System.exit(0);
            });

            final MenuButton btnBack = new MenuButton("back");
            btnBack.setOnMouseClicked(event -> {
                mediaPlayer.stop();
                mediaPlayer.play();
                root.getChildren().add(menu2);
                root.getChildren().add(menu0);

                final TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu1);
                tt.setToX(menu1.getTranslateX() + WIDTH);

                final TranslateTransition t4 = new TranslateTransition(Duration.seconds(0.25), menu4);
                t4.setToX(menu4.getTranslateX() + WIDTH);

                final TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu0);
                tt1.setToX(menu1.getTranslateX());

                final TranslateTransition tt0 = new TranslateTransition(Duration.seconds(0.5), menu2);
                tt0.setToX(menu1.getTranslateX() - WIDTH / 2.25);

                t4.play();
                tt.play();
                tt1.play();
                tt0.play();

                tt.setOnFinished(evt -> {
                   root.getChildren().remove(menu1);
                   root.getChildren().remove(menu4);
                });
            });

            final MenuButton btnDiff = new MenuButton("difficulty");
            btnDiff.setOnMouseClicked(event -> {
                mediaPlayer.stop();
                mediaPlayer.play();
                root.getChildren().add(menu6);
                root.getChildren().add(menu3);

                final TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu1);
                tt.setToX(menu1.getTranslateX() - WIDTH);

                final TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu3);
                tt1.setToX(menu1.getTranslateX());

                final TranslateTransition tt2 = new TranslateTransition(Duration.seconds(0.5), menu6);
                tt2.setToX(menu1.getTranslateX() - WIDTH / 2.265);

                tt.play();
                tt2.play();
                tt1.play();

                tt.setOnFinished(evt -> {
                    root.getChildren().remove(menu1);

                });
            });

            final MenuButton btnEasy = new MenuButton("easy");
            final MenuButton btnMedium = new MenuButton("medium");
            final MenuButton btnHard = new MenuButton("hard");
            final MenuButton btnBack1 = new MenuButton("back");

            btnBack1.setOnMouseClicked(event -> {
                mediaPlayer.stop();
                mediaPlayer.play();
                root.getChildren().add(menu1);

                final TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu3);
                tt.setToX(menu3.getTranslateX() + WIDTH);

                final TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu1);
                tt1.setToX(menu3.getTranslateX());

                final TranslateTransition tt0 = new TranslateTransition(Duration.seconds(0.25), menu6);
                tt0.setToX(menu6.getTranslateX() + WIDTH);

                tt0.play();
                tt.play();
                tt1.play();

                tt.setOnFinished(evt -> {
                    root.getChildren().remove(menu3);
                    root.getChildren().remove(menu6);
                });
            });


            btnEasy.setOnMouseClicked(event -> {
                name.getgc().setDifficulty(1);
                System.out.println("facile");
                final Stage stage = new Stage();
                try {
                    avviso.start(stage);
                } catch (Exception e) {

                    e.printStackTrace();
                }
            });

            btnMedium.setOnMouseClicked(event -> {
                name.getgc().setDifficulty(2);
                System.out.println("normale");
                final Stage stage = new Stage();
                try {
                    avviso.start(stage);
                } catch (Exception e) {

                    e.printStackTrace();
                }
            });

            btnHard.setOnMouseClicked(event -> {
                name.getgc().setDifficulty(3);
                System.out.println("difficile");
                final Stage stage = new Stage();
                try {
                    avviso.start(stage);
                } catch (Exception e) {

                    e.printStackTrace();
                }
            });

            menu8.getChildren().addAll(soundback, low, medium, high, mute);
            menu0.getChildren().addAll(btnResume, btnOptions, btnExit);
            menu1.getChildren().addAll(btnBack, btnSound, btnDiff);
            menu3.getChildren().addAll(btnBack1, btnEasy, btnMedium, btnHard);

            root.getChildren().addAll(menu5, menu2, menu0);

            mediaPlayer1.play();
            return root;
        }
/**
 * {@inheritDoc}
 */
    @Override
    public void start(final Stage primaryStage) throws Exception {

        final Scene scene = new Scene(createContent());
        primaryStage.setTitle("Jojo Menu");
        primaryStage.setOnCloseRequest(quitHandler);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }
    /**
     * Method to set volume.
     * @param volume volume
     */
    public void setVol(final double volume) {
        this.vol = volume;
    }
}

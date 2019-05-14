package view.gameview;

import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import constants.ViewConstants;
import constants.GameConstants;
import controller.gamecontroller.GameController;
import model.GameStatus;
import model.enemy.Enemy;
import model.enemy.EnemyType;
import model.entity.Entity;
import model.map.MapTile;
import model.map.Status;
import model.projectile.Projectile;
import model.tower.Tower;
import model.tower.TowerType;
import view.input.InputImpl;
import view.input.InputType;
import javafx.application.Platform;
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
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import utilityclasses.Pair;

/**
 * 
 * Game view.
 *
 */
public class GameScreen extends Region {
    
    private final Image logo = new Image(this.getClass().getResourceAsStream("/path.png"));
    private final Image towerlogo = new Image(this.getClass().getResourceAsStream("/hierophant.png"));
    private final Image towerlogo1 = new Image(this.getClass().getResourceAsStream("/magician.png"));
    private final Image towerlogo2 = new Image(this.getClass().getResourceAsStream("/star.png"));
    private final Image grasslogo = new Image(this.getClass().getResourceAsStream("/grass.jpg"));
    private final Image emerald = new Image(this.getClass().getResourceAsStream("/1.png"));
    private final Image ruby = new Image(this.getClass().getResourceAsStream("/ruby.png"));
    private final Image amethyst = new Image(this.getClass().getResourceAsStream("/amethyst2.png"));
    private final Image enemy = new Image(this.getClass().getResourceAsStream("/dio.png"));
    private final Image tank = new Image(this.getClass().getResourceAsStream("/stand.png"));
    private final List<GridButton> btList = new ArrayList<>();
    private final List<MapTile> mappa;
    private final GameController gc;
    private boolean type1;
    private boolean type2;
    private boolean type3;
    private boolean remove;
    private final Text text = new Text("COINS" + "  " +  0);
    private final Text text1 = new Text("HP" + "  " + 0);
    private final Text text2 = new Text("WAVE" + "  " + 0);
    private final Text text3 = new Text("NAME" + "  " + 0);
    private final List<PathButton> btlist2 = new ArrayList<>();
    private static final double BUTTONSIZE = ViewConstants.BUTTON_SIZE;
    private final Win vittoria = new Win();
    private final Lose sconfitta = new Lose();
    private final double volume;
   
/**
 * Main method to create the view.
 * @return root pane
 */
    @SuppressWarnings({ "PMD.AvoidDuplicateLiterals", "PMD.AvoidThrowingNullPointerException" })
    public Parent createContent() {
        
        Media sound = null;
        try {
            sound = new Media(this.getClass().getResource("/ost.mp3").toURI().toString());
        } catch (URISyntaxException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        final MediaPlayer mediaPlayer = new MediaPlayer(sound);
        
        final String style2 = "-fx-background-color: rgba(50, 100, 200, 0.5);"; //trasparente
        final String style = "-fx-background-color: rgba(150, 100, 50, 0.5);"; //marrone
        
        /* FINESTRA GENERALE */
        final Pane root = new Pane(); 
        root.setPrefSize(BUTTONSIZE * 38, BUTTONSIZE * 25);
        final Image img = new Image("/gameMenuImage.png");
        final ImageView imgv = new ImageView(img);
        imgv.setFitWidth(BUTTONSIZE * 40);
        imgv.setFitHeight(BUTTONSIZE * 26);
        root.setOpacity(1);
        root.getChildren().add(imgv);

        /* SIDEBAR */
        final FlowPane flow = new FlowPane();
        flow.setPrefSize(BUTTONSIZE * 15, BUTTONSIZE * 20);
        flow.setTranslateX(BUTTONSIZE * 22);
        flow.setTranslateY(BUTTONSIZE);
        flow.setBackground(Background.EMPTY);
        flow.setVgap(4);
        flow.setHgap(4);
        flow.setStyle(style);

        /* MENU1: START AND OPTION */
        final HBox menu1 = new HBox(BUTTONSIZE);
        menu1.setPrefSize(BUTTONSIZE, BUTTONSIZE);
        menu1.setTranslateY(BUTTONSIZE);
        menu1.setTranslateX(BUTTONSIZE);
        menu1.setSpacing(BUTTONSIZE);
        final MenuButton start = new MenuButton("start");
        menu1.getChildren().add(start);
        final MenuButton pause = new MenuButton("pause");
        pause.setOnMouseClicked(event -> {
            gc.pauseGame();
        });
        menu1.getChildren().add(pause);
        final MenuButton resume = new MenuButton("resume");
        menu1.getChildren().add(resume);
        resume.setOnMouseClicked(event -> {
            gc.resumeGame();
        });
        flow.getChildren().add(menu1);

        /* MENU2: INFO HP, COINS, WAVE */
        final VBox menu2 = new VBox();

        menu2.setSpacing(BUTTONSIZE / 3);
        menu2.setPrefSize(BUTTONSIZE * 13, BUTTONSIZE * 8);
        menu2.setTranslateY(BUTTONSIZE * 2);
        menu2.setTranslateX(BUTTONSIZE);
        menu2.setBackground(Background.EMPTY);
        final InputStream is = this.getClass().getResourceAsStream("/JOJO____.ttf");
        final Font f = Font.loadFont(is, 25);
        text.setFont(f);
        text.setFill(Color.GOLD);
        text.setTranslateY(BUTTONSIZE);

        text1.setFont(f);
        text1.setFill(Color.LAWNGREEN);
        text1.setTranslateY(BUTTONSIZE);

        text2.setFont(f);
        text2.setFill(Color.DARKRED);
        text2.setTranslateY(BUTTONSIZE);

        text3.setFont(f);
        text3.setFill(Color.DARKBLUE);
        text3.setTranslateY(BUTTONSIZE);

        menu2.getChildren().addAll(text3, text, text1, text2);

        menu2.setStyle(style2);
        flow.getChildren().add(menu2);

        /* MENU3: TOWERS */
        final FlowPane menu3 = new FlowPane();
        menu3.setPrefSize(BUTTONSIZE * 14, BUTTONSIZE * 6);
        menu3.setTranslateX(BUTTONSIZE * 2.125);
        menu3.setTranslateY(BUTTONSIZE * 2.5);
        //menu3.setSpacing(buttonSize); //se usi hbox
        menu3.setBackground(Background.EMPTY);
        //menu3.setPadding(new Insets(buttonSize,buttonSize,buttonSize,buttonSize));
        menu3.setHgap(BUTTONSIZE);
        menu3.setVgap(BUTTONSIZE);
        final PlaceTowerButton tower1 = new PlaceTowerButton("Basic (" + GameConstants.BASIC_TOWER_COST + ")");
        menu3.getChildren().add(tower1);
        final PlaceTowerButton tower2 = new PlaceTowerButton("Ranged ("+ GameConstants.RANGED_TOWER_COST + ")");
        menu3.getChildren().add(tower2);
        final PlaceTowerButton tower3 = new PlaceTowerButton("Cannon ("+ GameConstants.CANNON_TOWER_COST + ")");
        menu3.getChildren().add(tower3);
        final PlaceTowerButton remove = new PlaceTowerButton("remove");
        menu3.getChildren().add(remove);
        flow.getChildren().add(menu3);

        /* GRIGLIA DI GIOCO */
        final GridPane grid = new GridPane();
        grid.setPrefSize(BUTTONSIZE * 20, BUTTONSIZE * 20);

        for (final MapTile m:this.mappa) {
            final int x = m.getPosition().getX();
            final int y = m.getPosition().getY();
            /*se è un percorso*/
            if (m.getStatus() == Status.PATH) {
                final PathButton b2 = new PathButton("");
                b2.setPosition(new Pair<Integer, Integer>(x, y));
                btlist2.add(b2);
                grid.add(b2, x, y);
            }
            else { /*se non è percorso*/
                final GridButton bt = new GridButton("");
                bt.setPosition(new Pair<Integer, Integer>(x, y));
                bt.setOnMouseClicked(event -> {
                    if (gc == null) {
                        throw new NullPointerException();
                    }
                    else {
                        if (this.type1) {
                            final ImageView imgt = new ImageView(towerlogo);
                            imgt.setFitWidth(BUTTONSIZE);
                            imgt.setFitHeight(BUTTONSIZE);
                            bt.getChildren().add(imgt);
                            gc.handleInput(new InputImpl(InputType.ADD_TOWER, TowerType.BASIC, x, y));
                        }
                        else if (this.type2) {
                            final ImageView imgt = new ImageView(towerlogo1);
                            imgt.setFitWidth(BUTTONSIZE);
                            imgt.setFitHeight(BUTTONSIZE);
                            bt.getChildren().add(imgt);

                            gc.handleInput(new InputImpl(InputType.ADD_TOWER, TowerType.RANGED, x, y));
                        }

                        else if (this.type3) {
                            final ImageView imgt = new ImageView(towerlogo2);
                            imgt.setFitWidth(BUTTONSIZE);
                            imgt.setFitHeight(BUTTONSIZE);
                            bt.getChildren().add(imgt);

                            gc.handleInput(new InputImpl(InputType.ADD_TOWER, TowerType.CANNON, x, y));
                        }

                        else if (this.remove) {
                            final ImageView imgt = new ImageView(grasslogo);
                            imgt.setFitWidth(BUTTONSIZE);
                            imgt.setFitHeight(BUTTONSIZE);
                            bt.getChildren().setAll(imgt);

                            gc.handleInput(new InputImpl(InputType.REMOVE_TOWER, null, x, y));
                            System.out.println("rimuovo torre");
                        }

                        for (final GridButton n:this.btList) {
                            n.setEffect(null);
                        }
                        this.type1 = false;
                        this.type2 = false;
                        this.type3 = false;
                        this.remove = false;
                    }
                });
                btList.add(bt);
                grid.add(bt, x, y);
            }
        }
        grid.setTranslateX(BUTTONSIZE);
        grid.setTranslateY(BUTTONSIZE);
        root.getChildren().addAll(grid, flow);

        tower1.setOnMouseClicked(event -> {
            this.type1 = true;
            for (final GridButton b:this.btList) {
                final DropShadow drop = new DropShadow(10, Color.WHITE); 
             drop.setInput(new Glow());
             b.setEffect(drop); 
        }
        });

        tower2.setOnMouseClicked(event -> {
            this.type2 = true;
            for (final GridButton b:this.btList) {
                final DropShadow drop = new DropShadow(10, Color.WHITE);
                drop.setInput(new Glow());
                b.setEffect(drop); 
            }
        });

        tower3.setOnMouseClicked(event -> {
            this.type3 = true;
            for (final GridButton b:this.btList) {
                final DropShadow drop = new DropShadow(10, Color.WHITE); 
                drop.setInput(new Glow());
                b.setEffect(drop); 
            }
        });

        remove.setOnMouseClicked(event -> {
            this.remove = true;
            for (final GridButton b:this.btList) {
                final DropShadow drop = new DropShadow(10, Color.WHITE); 
                drop.setInput(new Glow());
                b.setEffect(drop); 
            }
        });

        start.setOnMouseClicked(event -> {
            gc.handleInput(new InputImpl(InputType.START_WAVE, null, 1, 2));
            this.gc.getModel().nextWave();
        });
        mediaPlayer.setVolume(volume);
        mediaPlayer.setAutoPlay(true);

        return root;
    }
    /**
     *  constructor.
     * @param gc game controller
     */

    public GameScreen(final GameController gc,double volume) {
        this.volume = volume;
        this.gc = gc;
        this.mappa = gc.getModel().getMap().getTileList();
        gc.startLoop(this);

    }
    /**
     * Game render.
     * @param entityList EntityList
     */

    public void render(final ArrayList<Entity> entityList,final GameStatus status) {
        ArrayList<Enemy> p = new ArrayList<Enemy>();
        ArrayList<Projectile> j = new ArrayList<Projectile>();
        ArrayList<Tower> t = new ArrayList<Tower>();
        Platform.runLater(() -> {

            if(status.WON == gc.getModel().getGameStatus()) {
                final Stage stage = new Stage();
                gc.killGameLoop();
                try {
                    vittoria.start(stage);
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
            else {
                if (status.LOST == gc.getModel().getGameStatus()) {
                    final Stage stage = new Stage();
                    gc.killGameLoop();
                    try {
                        sconfitta.start(stage);
                    } catch (Exception e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }

                }
            }

            for (Entity e:entityList) {
                if (e instanceof Tower) {
                    t.add((Tower) e);
                }
                if (e instanceof Enemy) {
                    p.add((Enemy) e);
                    for (final PathButton b:btlist2) {
                        if (e.getLocation().equals(b.getPosition())) {
                            final ImageView r = new ImageView(enemy);
                            r.setFitWidth(BUTTONSIZE);
                            r.setFitHeight(BUTTONSIZE);

                            final ImageView r2 = new ImageView(tank);
                            r2.setFitWidth(BUTTONSIZE);
                            r2.setFitHeight(BUTTONSIZE);

                            if (((Enemy) e).getEnemyType() == EnemyType.SIMPLE) {
                            b.getChildren().add(r);
                            }
                            else {
                                b.getChildren().add(r2);
                            }
                        }
                        else {
                            final ImageView img = new ImageView(logo);
                            img.setFitWidth(BUTTONSIZE);
                            img.setFitHeight(BUTTONSIZE);
                            b.getChildren().setAll(img);
                            for (final Enemy q:p) {
                                if (q.getLocation().equals(b.getPosition())) {
                                    final ImageView r = new ImageView(enemy);
                                    r.setFitWidth(BUTTONSIZE);
                                    r.setFitHeight(BUTTONSIZE);

                                    final ImageView r2 = new ImageView(tank);
                                    r2.setFitWidth(BUTTONSIZE);
                                    r2.setFitHeight(BUTTONSIZE);

                                    if (((Enemy) e).getEnemyType() == EnemyType.SIMPLE) {
                                    b.getChildren().add(r);
                                    }
                                    else {
                                        b.getChildren().add(r2);
                                    }
                                }
                            }
                        }
                    }
                }
                if (e instanceof Projectile) {
                    j.add((Projectile) e);
                    for (final GridButton b:btList) {
                        if (e.getLocation().getX() == b.position.getX() && e.getLocation().getY() == b.position.getY()) {


                            for (Tower v:t) {
                                if (v.getLocation().equals(b.getPosition())) {
                                    if (v.getType() == TowerType.BASIC) {
                                        final ImageView img = new ImageView(emerald);
                                        img.setFitWidth(BUTTONSIZE);
                                        img.setFitHeight(BUTTONSIZE);
                                        b.getChildren().add(img);
                                    }
                                    if (v.getType() == TowerType.CANNON) {
                                        final ImageView img2 = new ImageView(amethyst);
                                        img2.setFitWidth(BUTTONSIZE);
                                        img2.setFitHeight(BUTTONSIZE);
                                        b.getChildren().add(img2);
                                    }
                                    if (v.getType() == TowerType.RANGED) {
                                        final ImageView img4 = new ImageView(ruby);
                                        img4.setFitWidth(BUTTONSIZE);
                                        img4.setFitHeight(BUTTONSIZE);
                                        b.getChildren().add(img4);
                                    }
                                }
                            }
                        }
                        else {
                            final ImageView img1 = new ImageView(grasslogo);
                            img1.setFitWidth(BUTTONSIZE);
                            img1.setFitHeight(BUTTONSIZE);

                            final ImageView img3 = new ImageView(towerlogo);
                            img3.setFitWidth(BUTTONSIZE);
                            img3.setFitHeight(BUTTONSIZE);
                            b.getChildren().setAll(img1);

                            for (final Tower v:t) {
                                if (v.getLocation().equals(b.getPosition())) {
                                    if (v.getType() == TowerType.BASIC) {
                                        b.getChildren().add(img3);
                                    }
                                    if (v.getType() == TowerType.CANNON) {
                                        final ImageView img4 = new ImageView(towerlogo2);
                                        img4.setFitWidth(BUTTONSIZE);
                                        img4.setFitHeight(BUTTONSIZE);
                                        b.getChildren().add(img4);
                                    }
                                    if (v.getType() == TowerType.RANGED) {
                                        final ImageView img5 = new ImageView(towerlogo1);
                                        img5.setFitWidth(BUTTONSIZE);
                                        img5.setFitHeight(BUTTONSIZE);
                                        b.getChildren().add(img5);
                                    }
                                }
                            }
                            for (final Projectile q:j) {
                                if (q.getLocation().equals(b.getPosition())) {

                                    for (Tower v:t) {
                                        if (v.getLocation().equals(b.getPosition())) {
                                            if (v.getType() == TowerType.BASIC) {
                                                final ImageView img = new ImageView(emerald);
                                                img.setFitWidth(BUTTONSIZE);
                                                img.setFitHeight(BUTTONSIZE);
                                                b.getChildren().add(img);
                                            }
                                            if (v.getType() == TowerType.CANNON) {
                                                final ImageView img2 = new ImageView(amethyst);
                                                img2.setFitWidth(BUTTONSIZE);
                                                img2.setFitHeight(BUTTONSIZE);
                                                b.getChildren().add(img2);
                                            }
                                            if (v.getType() == TowerType.RANGED) {
                                                final ImageView img4 = new ImageView(ruby);
                                                img4.setFitWidth(BUTTONSIZE);
                                                img4.setFitHeight(BUTTONSIZE);
                                                b.getChildren().add(img4);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (entityList.isEmpty() || (entityList.get(entityList.size() - 1) instanceof Tower)) {
                for (final PathButton b:btlist2) {
                    final ImageView img = new ImageView(logo);
                    img.setFitWidth(BUTTONSIZE);
                    img.setFitHeight(BUTTONSIZE);
                    b.getChildren().setAll(img);
                }
                for (final GridButton d:btList) {
                    for (final Tower v:t) {
                        if (v.getLocation().equals(d.getPosition())) {
                            final ImageView img2 = new ImageView(towerlogo);
                            img2.setFitWidth(BUTTONSIZE);
                            img2.setFitHeight(BUTTONSIZE);

                            final ImageView img3 = new ImageView(towerlogo2);
                            img3.setFitWidth(BUTTONSIZE);
                            img3.setFitHeight(BUTTONSIZE);

                            final ImageView img5 = new ImageView(towerlogo1);
                            img5.setFitWidth(BUTTONSIZE);
                            img5.setFitHeight(BUTTONSIZE);

                            final ImageView img4 = new ImageView(grasslogo);
                            img4.setFitWidth(BUTTONSIZE);
                            img4.setFitHeight(BUTTONSIZE);
                            d.getChildren().setAll(img4);
                            if (v.getType() == TowerType.BASIC) {
                                d.getChildren().add(img2);
                            }
                            if (v.getType() == TowerType.CANNON) {
                                d.getChildren().add(img3);
                            }
                            if (v.getType() == TowerType.RANGED) {
                                d.getChildren().add(img5);
                            }
                        }
                    }
                }
            }
            text.setText("COINS" + "  " + this.gc.getModel().getPlayer().getCoins());
            text1.setText("HP" + "  " + this.gc.getModel().getPlayer().getHp());
            text2.setText("WAVE" + "  " + this.gc.getModel().getPlayer().getWave());
            text3.setText("NAME" + "  " + this.gc.getModel().getPlayer().getName());
        });
    }
}

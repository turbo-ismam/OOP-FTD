package view.gameview;

import java.util.ArrayList;


import constants.GameConstants;
import controller.gamecontroller.GameController;
import model.enemy.Enemy;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import utilityclasses.Pair;

/**
 * 
 * Game view.
 *
 */
public class GameScreen extends Region {

    private static final Image LOGO = new Image("path.png");
    private static final Image TOWERLOGO = new Image("hierophant.png");
    private static final Image TOWERLOGO1 = new Image("hierophant.png");
    private static final Image TOWERLOGO2 = new Image("star.png");
    private static final Image GRASSLOGO = new Image("grass.jpg");
    private static final Image EMERALD = new Image("1.png");
    private static final Image ENEMY = new Image("dio.png");
    private ArrayList<GridButton> btList = new ArrayList<>();
    private ArrayList<MapTile> mappa;
    private GameController gc;
    private boolean type1 = false;
    private boolean type2 = false;
    private boolean type3 = false;
    private boolean remove = false;
    private Text text = new Text("COINS" + "  " +  0);
    private Text text1 = new Text("HP" + "  " + 0);
    private Text text2 = new Text("WAVE" + "  " + 0);
    private Text text3 = new Text("NAME" + "  " + 0);
    private ArrayList<PathButton> btlist2 = new ArrayList<>();
    private static final double BUTTONSIZE = GameConstants.BUTTON_SIZE;
    //MainMenu test = new MainMenu();
/**
 * Main method to create the view.
 * @return root pane
 */
    public Parent createContent() {

        String style2 = "-fx-background-color: rgba(50, 100, 200, 0.5);"; //trasparente
        String style = "-fx-background-color: rgba(150, 100, 50, 0.5);"; //marrone

        /* FINESTRA GENERALE */
        Pane root = new Pane(); 
        root.setPrefSize(BUTTONSIZE * 38, BUTTONSIZE * 25);
        Image img = new Image("gameMenuImage.png");
        ImageView imgv = new ImageView(img);
        imgv.setFitWidth(BUTTONSIZE * 40);
        imgv.setFitHeight(BUTTONSIZE * 26);
        root.setOpacity(1);
        root.getChildren().add(imgv);

        /* SIDEBAR */
        FlowPane flow = new FlowPane();
        flow.setPrefSize(BUTTONSIZE * 15, BUTTONSIZE * 20);
        flow.setTranslateX(BUTTONSIZE * 22);
        flow.setTranslateY(BUTTONSIZE);
        flow.setBackground(Background.EMPTY);
        flow.setVgap(4);
        flow.setHgap(4);
        flow.setStyle(style);

        /* MENU1: START AND OPTION */
        HBox menu1 = new HBox(BUTTONSIZE);
        menu1.setPrefSize(BUTTONSIZE, BUTTONSIZE);
        menu1.setTranslateY(BUTTONSIZE);
        menu1.setTranslateX(BUTTONSIZE);
        menu1.setSpacing(BUTTONSIZE);
        MenuButton start = new MenuButton("start");
        menu1.getChildren().add(start);
        MenuButton pause = new MenuButton("pause");
        pause.setOnMouseClicked(event -> {
            gc.pauseGame();
        });
        menu1.getChildren().add(pause);
        MenuButton resume = new MenuButton("resume");
        menu1.getChildren().add(resume);
        resume.setOnMouseClicked(event -> {
            gc.resumeGame();
        });
        flow.getChildren().add(menu1);

        /* MENU2: INFO HP, COINS, WAVE */
        VBox menu2 = new VBox();

        menu2.setSpacing(BUTTONSIZE / 3);
        menu2.setPrefSize(BUTTONSIZE * 13, BUTTONSIZE * 8);
        menu2.setTranslateY(BUTTONSIZE * 2);
        menu2.setTranslateX(BUTTONSIZE);
        menu2.setBackground(Background.EMPTY);

        text.setFont(Font.loadFont("file:res/JOJO____.ttf", 25));
        text.setFill(Color.GOLD);
        text.setTranslateY(BUTTONSIZE);

        text1.setFont(Font.loadFont("file:res/JOJO____.ttf", 25));
        text1.setFill(Color.LAWNGREEN);
        text1.setTranslateY(BUTTONSIZE);

        text2.setFont(Font.loadFont("file:res/JOJO____.ttf", 25));
        text2.setFill(Color.DARKRED);
        text2.setTranslateY(BUTTONSIZE);

        text3.setFont(Font.loadFont("file:res/JOJO____.ttf", 25));
        text3.setFill(Color.DARKBLUE);
        text3.setTranslateY(BUTTONSIZE);

        menu2.getChildren().addAll(text3, text, text1, text2);

        menu2.setStyle(style2);
        flow.getChildren().add(menu2);

        /* MENU3: TOWERS */
        FlowPane menu3 = new FlowPane();
        menu3.setPrefSize(BUTTONSIZE * 14, BUTTONSIZE * 6);
        menu3.setTranslateX(BUTTONSIZE * 2.125);
        menu3.setTranslateY(BUTTONSIZE * 2.5);
        //menu3.setSpacing(buttonSize); //se usi hbox
        menu3.setBackground(Background.EMPTY);
        //menu3.setPadding(new Insets(buttonSize,buttonSize,buttonSize,buttonSize));
        menu3.setHgap(BUTTONSIZE);
        menu3.setVgap(BUTTONSIZE);
        PlaceTowerButton tower1 = new PlaceTowerButton("type 1");
        menu3.getChildren().add(tower1);
        PlaceTowerButton tower2 = new PlaceTowerButton("type 2");
        menu3.getChildren().add(tower2);
        PlaceTowerButton tower3 = new PlaceTowerButton("Type 3");
        menu3.getChildren().add(tower3);
        PlaceTowerButton remove = new PlaceTowerButton("remove");
        menu3.getChildren().add(remove);
        flow.getChildren().add(menu3);

        /* GRIGLIA DI GIOCO */
        GridPane grid = new GridPane();
        grid.setPrefSize(BUTTONSIZE * 20, BUTTONSIZE * 20);

        for (MapTile m:this.mappa) {
            int x = m.getPosition().getX();
            int y = m.getPosition().getY();
            /*se è un percorso*/
            if (m.getStatus() == Status.PATH) {
                PathButton b2 = new PathButton("");
                b2.setPosition(new Pair<Integer, Integer>(x, y));
                btlist2.add(b2);
                grid.add(b2, x, y);
            }
            else { /*se non è percorso*/
                GridButton bt = new GridButton("");
                bt.setPosition(new Pair<Integer, Integer>(x, y));
                bt.setOnMouseClicked(event -> {
                    if (gc == null) {
                        throw new NullPointerException();
                    }
                    else {
                        if (this.type1) {
                            ImageView imgt = new ImageView(TOWERLOGO);
                            imgt.setFitWidth(BUTTONSIZE);
                            imgt.setFitHeight(BUTTONSIZE);
                            bt.getChildren().add(imgt);
                            gc.handleInput(new InputImpl(InputType.ADD_TOWER, TowerType.BASIC, x, y));
                            System.out.println("droppo torre 1 in");
                        }
                        else if (this.type2) {
                            ImageView imgt = new ImageView(TOWERLOGO1);
                            imgt.setFitWidth(BUTTONSIZE);
                            imgt.setFitHeight(BUTTONSIZE);
                            bt.getChildren().add(imgt);

                            gc.handleInput(new InputImpl(InputType.ADD_TOWER, TowerType.RANGED, x, y));
                            System.out.println("droppo torre 2");
                        }

                        else if (this.type3) {
                            ImageView imgt = new ImageView(TOWERLOGO2);
                            imgt.setFitWidth(BUTTONSIZE);
                            imgt.setFitHeight(BUTTONSIZE);
                            bt.getChildren().add(imgt);

                            gc.handleInput(new InputImpl(InputType.ADD_TOWER, TowerType.CANNON, x, y));
                            System.out.println("droppo torre 3");
                        }

                        else if (this.remove) {
                            ImageView imgt = new ImageView(GRASSLOGO);
                            imgt.setFitWidth(BUTTONSIZE);
                            imgt.setFitHeight(BUTTONSIZE);
                            bt.getChildren().setAll(imgt);

                            gc.handleInput(new InputImpl(InputType.REMOVE_TOWER, null, x, y));
                            System.out.println("rimuovo torre");
                        }

                        for (GridButton n:this.btList) {
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
            for (GridButton b:this.btList) {
                DropShadow drop = new DropShadow(10, Color.WHITE); 
             drop.setInput(new Glow());
             b.setEffect(drop); 
        }
        });

        tower2.setOnMouseClicked(event -> {
            this.type2 = true;
            for (GridButton b:this.btList) {
                DropShadow drop = new DropShadow(10, Color.WHITE);
                drop.setInput(new Glow());
                b.setEffect(drop); 
            }
        });

        tower3.setOnMouseClicked(event -> {
            this.type3 = true;
            for (GridButton b:this.btList) {
                DropShadow drop = new DropShadow(10, Color.WHITE); 
                drop.setInput(new Glow());
                b.setEffect(drop); 
            }
        });

        remove.setOnMouseClicked(event -> {
            this.remove = true;
            for (GridButton b:this.btList) {
                DropShadow drop = new DropShadow(10, Color.WHITE); 
                drop.setInput(new Glow());
                b.setEffect(drop); 
            }
        });

        start.setOnMouseClicked(event -> {
            gc.handleInput(new InputImpl(InputType.START_WAVE, null, 1, 2));
            this.gc.getModel().nextWave();
        });

        return root;
    }
    /**
     *  constructor.
     * @param gc game controller
     */
    public GameScreen(final GameController gc) {

        this.gc = gc;
        this.mappa = gc.getModel().getMap().getTileList();
        gc.startLoop(this);

    }
    /**
     * Game render.
     * @param entityList EntityList
     */
    public void render(final ArrayList<Entity> entityList) {
        ArrayList<Enemy> p = new ArrayList<Enemy>();
        ArrayList<Projectile> j = new ArrayList<Projectile>();
        ArrayList<Tower> t = new ArrayList<Tower>();
        Platform.runLater(() -> {

            for (Entity e:entityList) {
                if (e instanceof Tower) {
                    t.add((Tower) e);
                }
                if (e instanceof Enemy) {
                    p.add((Enemy) e);
                    for (PathButton b:btlist2) {
                        ImageView r = new ImageView(ENEMY);
                        r.setFitWidth(BUTTONSIZE);
                        r.setFitHeight(BUTTONSIZE);

                        ImageView img = new ImageView(LOGO);
                        img.setFitWidth(BUTTONSIZE);
                        img.setFitHeight(BUTTONSIZE);

                        if (e.getLocation().equals(b.getPosition())) {
                            b.getChildren().add(r);

                        }
                        else {
                            b.getChildren().setAll(img);
                            for (Enemy q:p) {
                                if (q.getLocation().equals(b.getPosition())) {
                                    b.getChildren().add(r);
                                }
                            }
                        }
                    }
                }
                if (e instanceof Projectile) {
                    j.add((Projectile) e);
                    for (GridButton b:btList) {

                        ImageView img = new ImageView(EMERALD);
                        img.setFitWidth(BUTTONSIZE);
                        img.setFitHeight(BUTTONSIZE);
                        if (e.getLocation().getX() == b.position.getX() && e.getLocation().getY() == b.position.getY()) {
                            b.getChildren().add(img);
                        }
                        else {
                            ImageView img1 = new ImageView(GRASSLOGO);
                            img1.setFitWidth(BUTTONSIZE);
                            img1.setFitHeight(BUTTONSIZE);

                            ImageView img3 = new ImageView(TOWERLOGO);
                            img3.setFitWidth(BUTTONSIZE);
                            img3.setFitHeight(BUTTONSIZE);
                            b.getChildren().setAll(img1);

                            for (Tower v:t) {
                                if (v.getLocation().equals(b.getPosition())) {
                                    if (v.getType() == TowerType.BASIC) {
                                        b.getChildren().add(img3);
                                    }
                                    if (v.getType() == TowerType.CANNON) {
                                        ImageView img4 = new ImageView(TOWERLOGO2);
                                        img4.setFitWidth(BUTTONSIZE);
                                        img4.setFitHeight(BUTTONSIZE);
                                        b.getChildren().add(img4);
                                    }
                                }
                            }
                            for (Projectile q:j) {
                                if (q.getLocation().equals(b.getPosition())) {

                                    b.getChildren().add(img);
                                }
                            }
                        }
                    }
                }
            }
            if (entityList.isEmpty() || (entityList.get(entityList.size() - 1) instanceof Tower)) {
                for (PathButton b:btlist2) {
                    ImageView img = new ImageView(LOGO);
                    img.setFitWidth(BUTTONSIZE);
                    img.setFitHeight(BUTTONSIZE);
                    b.getChildren().setAll(img);
                }

                for (GridButton d:btList) {
                    for (Tower v:t) {
                        if (v.getLocation().equals(d.getPosition())) {
                            ImageView img2 = new ImageView(TOWERLOGO);
                            img2.setFitWidth(BUTTONSIZE);
                            img2.setFitHeight(BUTTONSIZE);

                            ImageView img3 = new ImageView(TOWERLOGO2);
                            img3.setFitWidth(BUTTONSIZE);
                            img3.setFitHeight(BUTTONSIZE);

                            ImageView img5 = new ImageView(TOWERLOGO1);
                            img5.setFitWidth(BUTTONSIZE);
                            img5.setFitHeight(BUTTONSIZE);

                            ImageView img4 = new ImageView(GRASSLOGO);
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

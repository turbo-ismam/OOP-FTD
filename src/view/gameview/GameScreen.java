package view.gameview;

import java.util.ArrayList;
import java.util.List;

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

public class GameScreen extends Region {
	private static final Image LOGO = new Image("path.png");
	private static final Image TOWERLOGO = new Image("hierophant.png");
	private static final Image TOWERLOGO1 = new Image("hierophant.png");
	private static final Image TOWERLOGO2 = new Image("star.png");
	private static final Image GRASSLOGO = new Image("grass.jpg");
	private static final Image EMERALD = new Image("1.png");
	private static final Image ENEMY = new Image("dio.png");
	private final List<GridButton> btList = new ArrayList<>();
	private final List<MapTile> mappa;
	private final GameController gc;
	private static boolean type1;
	private static boolean type2;
	private static boolean type3;
	private static boolean remove;
	
	private final Text text = new Text("COINS"+"  "+ 0);
	private final Text text1 = new Text("HP" +"  "+ 0);
	private final Text text2 = new Text("WAVE" + "  " + 0);
	private final Text text3 = new Text("NAME" + "  " + 0);
	private final List<PathButton> btlist2 = new ArrayList<>();
	
    private static final double BUTTON_SIZE = GameConstants.BUTTON_SIZE;
        
	//MainMenu test = new MainMenu();    
        
	@SuppressWarnings({ "PMD.AvoidDuplicateLiterals", "PMD.AvoidThrowingNullPointerException", "static-access" })
    public Parent createContent(){
		
		 final String style2 = "-fx-background-color: rgba(50, 100, 200, 0.5);"; //trasparente
		 final String style = "-fx-background-color: rgba(150, 100, 50, 0.5);"; //marrone
		
	/* FINESTRA GENERALE */
        final Pane root = new Pane(); 
        root.setPrefSize(BUTTON_SIZE*38, BUTTON_SIZE*25);
	final Image img = new Image("gameMenuImage.png");
	final ImageView imgv = new ImageView(img);
	imgv.setFitWidth(BUTTON_SIZE*40);
	imgv.setFitHeight(BUTTON_SIZE*26);
	root.setOpacity(1);
	root.getChildren().add(imgv);
        
	/* SIDEBAR */
        final FlowPane flow = new FlowPane();
        flow.setPrefSize(BUTTON_SIZE*15, BUTTON_SIZE*20);
        flow.setTranslateX(BUTTON_SIZE*22);
        flow.setTranslateY(BUTTON_SIZE);
        flow.setBackground(Background.EMPTY);
        flow.setVgap(4);
        flow.setHgap(4);
        flow.setStyle(style);
        
        /* MENU1: START AND OPTION */
        final HBox menu1 = new HBox(BUTTON_SIZE);
        menu1.setPrefSize(BUTTON_SIZE, BUTTON_SIZE);
        menu1.setTranslateY(BUTTON_SIZE);
        menu1.setTranslateX(BUTTON_SIZE);
        menu1.setSpacing(BUTTON_SIZE);
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
        
        menu2.setSpacing(BUTTON_SIZE/3);
        menu2.setPrefSize(BUTTON_SIZE*13, BUTTON_SIZE*8);
        menu2.setTranslateY(BUTTON_SIZE*2);
        menu2.setTranslateX(BUTTON_SIZE);
        menu2.setBackground(Background.EMPTY);
        
    	text.setFont(Font.loadFont("file:res/JOJO____.ttf", 25));
		text.setFill(Color.GOLD);
        text.setTranslateY(BUTTON_SIZE);
        
    	text1.setFont(Font.loadFont("file:res/JOJO____.ttf", 25));
		text1.setFill(Color.LAWNGREEN);
        text1.setTranslateY(BUTTON_SIZE);
        
    	text2.setFont(Font.loadFont("file:res/JOJO____.ttf", 25));
		text2.setFill(Color.DARKRED);
        text2.setTranslateY(BUTTON_SIZE);
        
        text3.setFont(Font.loadFont("file:res/JOJO____.ttf", 25));
		text3.setFill(Color.DARKBLUE);
        text3.setTranslateY(BUTTON_SIZE);
        
        menu2.getChildren().addAll(text3,text,text1,text2);
       
        menu2.setStyle(style2);
        flow.getChildren().add(menu2);
        
        /* MENU3: TOWERS */
        final FlowPane menu3 = new FlowPane();
        menu3.setPrefSize(BUTTON_SIZE*14,BUTTON_SIZE* 6);
        menu3.setTranslateX(BUTTON_SIZE*2.125);
        menu3.setTranslateY(BUTTON_SIZE*2.5);
        //menu3.setSpacing(BUTTON_SIZE); //se usi hbox
        menu3.setBackground(Background.EMPTY);
        //menu3.setPadding(new Insets(BUTTON_SIZE,BUTTON_SIZE,BUTTON_SIZE,BUTTON_SIZE));
        menu3.setHgap(BUTTON_SIZE);
        menu3.setVgap(BUTTON_SIZE);
        final PlaceTowerButton tower1 = new PlaceTowerButton("type 1");
        menu3.getChildren().add(tower1);
        final PlaceTowerButton tower2 = new PlaceTowerButton("type 2");
        menu3.getChildren().add(tower2);
        final PlaceTowerButton tower3 = new PlaceTowerButton("Type 3");
        menu3.getChildren().add(tower3);
        final PlaceTowerButton remove = new PlaceTowerButton("remove");
        menu3.getChildren().add(remove);
        flow.getChildren().add(menu3);

        /* GRIGLIA DI GIOCO */
        final GridPane grid = new GridPane();
        grid.setPrefSize(BUTTON_SIZE*20, BUTTON_SIZE*20);

        for(final MapTile m:this.mappa){
            final int x = m.getPosition().getX();
            final int y = m.getPosition().getY();
    		/*se è un percorso*/
        	if(m.getStatus()==Status.PATH) {
        	    final PathButton b2 = new PathButton("");
				b2.setPosition(new Pair<Integer,Integer>(x,y));
				btlist2.add(b2);
            	grid.add(b2,x,y);
        	}
        	else { /*se non è percorso*/
        	    final GridButton bt = new GridButton("");
        		bt.setPosition(new Pair<Integer,Integer>(x, y));
        		bt.setOnMouseClicked(event -> {
        			if(gc == null) {
        				throw new NullPointerException();
        			}
        			else {
        				if(type1) {
        				    final ImageView imgt = new ImageView(TOWERLOGO);
        					imgt.setFitWidth(BUTTON_SIZE);
        					imgt.setFitHeight(BUTTON_SIZE);
        					bt.getChildren().add(imgt);
        					gc.handleInput(new InputImpl(InputType.ADD_TOWER,TowerType.BASIC, x, y));
        				System.out.println("droppo torre 1 in");
        				}
        				else if(type2) {
        				    final ImageView imgt = new ImageView(TOWERLOGO1);
        					imgt.setFitWidth(BUTTON_SIZE);
        					imgt.setFitHeight(BUTTON_SIZE);
        					bt.getChildren().add(imgt);
        					
        					gc.handleInput(new InputImpl(InputType.ADD_TOWER,TowerType.RANGED, x, y));
        					System.out.println("droppo torre 2");
        				}   
        				
        				else if(type3) {
        				    final ImageView imgt = new ImageView(TOWERLOGO2);
        					imgt.setFitWidth(BUTTON_SIZE);
        					imgt.setFitHeight(BUTTON_SIZE);
        					bt.getChildren().add(imgt);
        					
        					gc.handleInput(new InputImpl(InputType.ADD_TOWER,TowerType.CANNON, x, y));
        					System.out.println("droppo torre 3");
        				}
        				
        				else if(this.remove) {
        				    final ImageView imgt = new ImageView(GRASSLOGO);
        					imgt.setFitWidth(BUTTON_SIZE);
        					imgt.setFitHeight(BUTTON_SIZE);
        					bt.getChildren().setAll(imgt);
        					
        					gc.handleInput(new InputImpl(InputType.REMOVE_TOWER, null, x, y));
        					System.out.println("rimuovo torre");
        				}
        				
        				for(final GridButton n:this.btList) {  
        					n.setEffect(null);
        				}
        				this.type1 = false;
        				this.type2 = false;
        				this.type3 = false;
        				this.remove = false;
        			}
        		});
        		btList.add(bt);
            	grid.add(bt,x,y);
        	}
        }
        grid.setTranslateX(BUTTON_SIZE);
        grid.setTranslateY(BUTTON_SIZE);
        root.getChildren().addAll(grid,flow);
        
        tower1.setOnMouseClicked(event -> {
        	this.type1 = true;
        	for(final GridButton b:this.btList) {
        	    final DropShadow drop = new DropShadow(10, Color.WHITE); 
 	            drop.setInput(new Glow());
 	            b.setEffect(drop); 
        	}
        });
        
        tower2.setOnMouseClicked(event -> {
        	this.type2 = true;
        	for(final GridButton b:this.btList) {
        	    final DropShadow drop = new DropShadow(10, Color.WHITE);
 	            drop.setInput(new Glow());
 	            b.setEffect(drop); 
        	}
        });
        
        tower3.setOnMouseClicked(event -> {
        	this.type3 = true;
        	for(final GridButton b:this.btList) {
        	    final DropShadow drop = new DropShadow(10, Color.WHITE); 
 	            drop.setInput(new Glow());
 	            b.setEffect(drop); 
        	}
        });
        
        remove.setOnMouseClicked(event -> {
        	this.remove = true;
        	for(final GridButton b:this.btList) {
        	    final DropShadow drop = new DropShadow(10, Color.WHITE); 
 	            drop.setInput(new Glow());
 	            b.setEffect(drop); 
        	}
        });
        
        start.setOnMouseClicked(event -> {
        	gc.handleInput(new InputImpl(InputType.START_WAVE,null,1,2));
        	this.gc.getModel().nextWave();
        });

        return root;
	}
	
	public GameScreen(final GameController gc) {

		this.gc = gc;
		this.mappa = gc.getModel().getMap().getTileList();
		gc.startLoop(this);

	}
	
	
	public void render(final List<Entity> entityList)  {	
	    final List<Enemy> p = new ArrayList<Enemy>();
	    final List<Projectile> j = new ArrayList<Projectile>();
	    final List<Tower> t = new ArrayList<Tower>();
		Platform.runLater(() -> {
		
			for(final Entity e:entityList) {
				if(e instanceof Tower) {
					t.add((Tower) e);
				}
				if(e instanceof Enemy) {
					p.add((Enemy) e);
					for(final PathButton b:btlist2) {
						
					    final ImageView r = new ImageView(ENEMY);
						r.setFitWidth(BUTTON_SIZE);
						r.setFitHeight(BUTTON_SIZE);
						
						final ImageView img = new ImageView(LOGO);
						img.setFitWidth(BUTTON_SIZE);
						img.setFitHeight(BUTTON_SIZE);
						
						if(e.getLocation().equals(b.getPosition())) {
							b.getChildren().add(r);
							
						}
						else {
							b.getChildren().setAll(img);
							for(final Enemy q:p) {
								if(q.getLocation().equals(b.getPosition())){
									b.getChildren().add(r);
								}
							}
						}
					}			
				}
				if(e instanceof Projectile) {
					j.add((Projectile) e);
					for(final GridButton b:btList) {
						
					    final ImageView img = new ImageView(EMERALD);
						img.setFitWidth(BUTTON_SIZE);
						img.setFitHeight(BUTTON_SIZE);					
						if(e.getLocation().getX() == b.position.getX() && e.getLocation().getY() == b.position.getY()) {
							b.getChildren().add(img);			
						}	
						else {
						    final ImageView img1 = new ImageView(GRASSLOGO);
							img1.setFitWidth(BUTTON_SIZE);
							img1.setFitHeight(BUTTON_SIZE);
							
							final ImageView img3= new ImageView(TOWERLOGO);
							img3.setFitWidth(BUTTON_SIZE);
							img3.setFitHeight(BUTTON_SIZE);						
							b.getChildren().setAll(img1);
							
							for(final Tower v:t) {
								if(v.getLocation().equals(b.getPosition())){								
									if(v.getType() == TowerType.BASIC) {
										b.getChildren().add(img3);
									}
									if(v.getType() == TowerType.CANNON) {
									    final ImageView img4 = new ImageView(TOWERLOGO2);
										img4.setFitWidth(BUTTON_SIZE);
										img4.setFitHeight(BUTTON_SIZE);
										b.getChildren().add(img4);
									}									
								}
							}
							for(final Projectile q:j) {
								if(q.getLocation().equals(b.getPosition())){
								
									b.getChildren().add(img);
								}
							}
						}
					}					
				}
				}
			if (entityList.isEmpty() || (entityList.get(entityList.size()-1) instanceof Tower)) {
				for(final PathButton b:btlist2) {
				    final ImageView img = new ImageView(LOGO);
					img.setFitWidth(BUTTON_SIZE);
					img.setFitHeight(BUTTON_SIZE);
					b.getChildren().setAll(img);
				}

				for(final GridButton d:btList) {
					for(final Tower v:t) {
						if(v.getLocation().equals(d.getPosition())){
						    final ImageView img2 = new ImageView(TOWERLOGO);
							img2.setFitWidth(BUTTON_SIZE);
							img2.setFitHeight(BUTTON_SIZE);
							
							final ImageView img3 = new ImageView(TOWERLOGO2);
							img3.setFitWidth(BUTTON_SIZE);
							img3.setFitHeight(BUTTON_SIZE);
							
							final ImageView img5 = new ImageView(TOWERLOGO1);
							img5.setFitWidth(BUTTON_SIZE);
							img5.setFitHeight(BUTTON_SIZE);
							
							final ImageView img4 = new ImageView(GRASSLOGO);
							img4.setFitWidth(BUTTON_SIZE);
							img4.setFitHeight(BUTTON_SIZE);
							d.getChildren().setAll(img4);					
							if(v.getType() == TowerType.BASIC) {
								d.getChildren().add(img2);
							}
							if(v.getType() == TowerType.CANNON) {
								d.getChildren().add(img3);
							}
							if(v.getType() == TowerType.RANGED) {
								d.getChildren().add(img5);
							}
						}
					}
				}
				
			}
		text.setText("COINS"+"  " + this.gc.getModel().getPlayer().getCoins());
		text1.setText("HP"+"  " + this.gc.getModel().getPlayer().getHp());
		text2.setText("WAVE"+"  " + this.gc.getModel().getPlayer().getWave());
		text3.setText("NAME"+"  " + this.gc.getModel().getPlayer().getName());
		});
	}
}

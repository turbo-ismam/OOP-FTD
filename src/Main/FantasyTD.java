package Main;

import View.MainMenu.MainMenu;
import View.SceneChanger.SceneChanger;
import javafx.application.Application;
import javafx.stage.Stage;

public class FantasyTD extends Application{
 
 public static void main(String[] args){
     launch(args);
     
 }

    @Override
    public void start(Stage stage) throws Exception {
        SceneChanger.setPrimaryStage(stage);
        stage.setTitle("FantasyTD 1.0");
        stage.setScene(new MainMenu());
        stage.show();
    }
}
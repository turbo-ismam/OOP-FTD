package View.SceneChanger;

import javafx.stage.Stage;

/**
 * 
 * Implementation of the interface for setting the stage.
 *
 */
public class SceneChanger {
	static Stage currentStage= new Stage();

	private SceneChanger() {}
	
    static void setStage(double width, double height) {
    	
    }
    
    public static Stage getStage() {
    	return currentStage;
    };
	public static void setPrimaryStage(Stage stage) {
		currentStage = stage;
	}

}
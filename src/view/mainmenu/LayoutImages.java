package view.mainmenu;

import java.io.IOException;

import constants.GameConstants;
import javafx.scene.image.ImageView;

/**
 * This class contains all the imgaes used in the class MainMenu.
 */
public class LayoutImages {
	
	private final static double buttonSize = GameConstants.BUTTON_SIZE;
	private static final double width = GameConstants.GAME_WIDTH;
    private static final double height = GameConstants.GAME_HEIGHT;
    
    /**
     * Empty Constructor.
     * @throws IOException
     */
	public LayoutImages() throws IOException {
		
	}
	
	/**
	 * Method to get the logo.
	 * @return image of the logo
	 * @throws IOException
	 */
	public ImageView getimgv1() throws IOException {
		
		ImageLoader imgv1 = new ImageLoader("res/logo.png");
		imgv1.getImage().setFitWidth(buttonSize*13);
		imgv1.getImage().setFitHeight(buttonSize*5);
		imgv1.getImage().setTranslateX(buttonSize*13);
		imgv1.getImage().setTranslateY(buttonSize*2);
		return imgv1.getImage();
	}
	
	/**
     * Method to get an image of the menu option.
     * @return scene image
     * @throws IOException
     */
	public ImageView getImgv2() throws IOException {
		
		ImageLoader imgv2 = new ImageLoader("res/giorno.jpg");
		imgv2.getImage().setFitWidth(buttonSize*39);
		imgv2.getImage().setFitHeight(buttonSize*23);
		imgv2.getImage().setTranslateX(buttonSize*1.45);
		return imgv2.getImage();
	}
	
	/**
     * Method to get an image of the menu difficulty.
     * @return scene image
     * @throws IOException
     */
	public ImageView getImgv3() throws IOException {
		
		ImageLoader imgv3 = new ImageLoader("res/jotaro.png");
		imgv3.getImage().setFitWidth(buttonSize*39);
		imgv3.getImage().setFitHeight(buttonSize*23);
		imgv3.getImage().setTranslateX(buttonSize*1.45);
		return imgv3.getImage();
	}
	
	/**
     * Method to get an image of the main menu.
     * @return main menu image
     * @throws IOException
     */
	public ImageView getImgv() throws IOException {
		
		ImageLoader imgv = new ImageLoader("res/62266.jpg");
		imgv.getImage().setFitWidth(width+buttonSize/2);
		imgv.getImage().setFitHeight(height+buttonSize/2);
		return imgv.getImage();
		
	}
	
	/**
     * Method to get an image of the sound menu.
     * @return scene image
     * @throws IOException
     */
	public ImageView getImgv7() throws IOException {
		
		ImageLoader imgv7 = new ImageLoader("res/sound.jpg");
		imgv7.getImage().setFitWidth(buttonSize*39);
		imgv7.getImage().setFitHeight(buttonSize*23);
		imgv7.getImage().setTranslateX(buttonSize*1.45);
		return imgv7.getImage();
		
	}
}

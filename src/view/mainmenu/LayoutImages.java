package view.mainmenu;

import java.io.IOException;

import constants.ViewConstants;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * This class contains all the imgaes used in the class MainMenu.
 */
public class LayoutImages {

    private static final double BUTTONSIZE = ViewConstants.BUTTON_SIZE;
    private static final double WIDTH = ViewConstants.GAME_WIDTH;
    private static final double HEIGHT = ViewConstants.GAME_HEIGHT;

    /**
     * Empty Constructor.
     * @throws IOException exception
     */


    /**
     * Method to get the logo.
     * @return image of the logo
     * @throws IOException exception
     */
    public ImageView getimgv1() throws IOException {

        //final Image imgv1 = new Image(this.getClass().getResourceAsStream("/logo.png"));
        final ImageLoader imgv1 = new ImageLoader("/logo.png");
        imgv1.getImage().setFitWidth(BUTTONSIZE * 13);
        imgv1.getImage().setFitHeight(BUTTONSIZE * 5);
        imgv1.getImage().setTranslateX(BUTTONSIZE * 13);
        imgv1.getImage().setTranslateY(BUTTONSIZE * 2);
        return imgv1.getImage();
    }

    /**
     * Method to get an image of the menu option.
     * @return scene image
     * @throws IOException exception
     */
    public ImageView getImgv2() throws IOException {

        final ImageLoader imgv2 = new ImageLoader("/giorno.jpg");
        imgv2.getImage().setFitWidth(BUTTONSIZE * 39); 
        imgv2.getImage().setFitHeight(BUTTONSIZE * 23); 
        imgv2.getImage().setTranslateX(BUTTONSIZE * 1.45); 
        return imgv2.getImage();
    }

    /**
     * Method to get an image of the menu difficulty.
     * @return scene image
     * @throws IOException exception
     */
    public ImageView getImgv3() throws IOException {

        final ImageLoader imgv3 = new ImageLoader("/jotaro.png");
        imgv3.getImage().setFitWidth(BUTTONSIZE * 39); 
        imgv3.getImage().setFitHeight(BUTTONSIZE * 23); 
        imgv3.getImage().setTranslateX(BUTTONSIZE * 1.45); 
        return imgv3.getImage();
    }

    /**
     * Method to get an image of the main menu.
     * @return main menu image
     * @throws IOException exception
     */
    public ImageView getImgv() throws IOException {

        final ImageLoader imgv = new ImageLoader("/62266.jpg");
        imgv.getImage().setFitWidth(WIDTH + BUTTONSIZE / 2);
        imgv.getImage().setFitHeight(HEIGHT + BUTTONSIZE / 2);
        return imgv.getImage();

    }

    /**
     * Method to get an image of the sound menu.
     * @return scene image
     * @throws IOException exception
     */
    public ImageView getImgv7() throws IOException {

        final ImageLoader imgv7 = new ImageLoader("/sound.jpg");
        imgv7.getImage().setFitWidth(BUTTONSIZE * 39);
        imgv7.getImage().setFitHeight(BUTTONSIZE * 23);
        imgv7.getImage().setTranslateX(BUTTONSIZE * 1.45);
        return imgv7.getImage();

    }
}

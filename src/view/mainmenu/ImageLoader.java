package view.mainmenu;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * This class is used to get the images from a local directory.
 */
public class ImageLoader {

	private ImageView imgv1 = new ImageView();
	
	/**
	 * Constructor that take in input the uri of the image.
	 * @param directory
	 * @throws IOException
	 */
	public ImageLoader(String directory) throws IOException {
		
		InputStream is = Files.newInputStream(Paths.get(directory));
		Image logo = new Image(is);
		is.close();
		this.imgv1 = new ImageView(logo);
	}
	
	/**
	 * Method to get the image.
	 * @return image
	 */
	public ImageView getImage() {
		return this.imgv1;
	}
}

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Image {
	public static BufferedImage getImage(String imageName){
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(imageName + ".png"));
		} catch (IOException e) {
			System.out.println("Image loading problem: " + e);
		}
		return image;
	}
}

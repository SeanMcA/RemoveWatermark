import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PrintImage {

	public static void print(BufferedImage cleanedImage, String name){
		File outputfile = new File(name + ".png");
		try {
			ImageIO.write(cleanedImage, "png", outputfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Finished.");
	    System.out.println(name + " has been saved.");
	}
}

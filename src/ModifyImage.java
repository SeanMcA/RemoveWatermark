import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.List;

public class ModifyImage {
	
	
	public static BufferedImage Modify(BufferedImage image, List<RgbValue> pixelsToChange){
		for(int i = 0; i < pixelsToChange.size(); i++){
			int pixelX = pixelsToChange.get(i).pixelX;
			int pixelY = pixelsToChange.get(i).pixelY;
			int r = pixelsToChange.get(i).r;
			int g = pixelsToChange.get(i).g;
			int b = pixelsToChange.get(i).b;
			int rgb = 0;
			try {
				rgb = new Color(r, g, b).getRGB();
			} catch (Exception e) {
				System.out.println("Blue is: " + b);
				e.printStackTrace();
			}
			image.setRGB(pixelX, pixelY, rgb);
		}
		return image;
	}
	
	public static BufferedImage Modify2(BufferedImage image, List<RgbValue> pixelsToCompareTo){
		//TODO
		return image;		
	}
	
}

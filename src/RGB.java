
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
 * Get the RGB value for each pixel and put the value along with the pixel x and y coordinates into a List.
 */
public class RGB {
	static List<RgbValue> rgbValues;
	static Map<Integer, RgbValue> rgbValuesMap;
	private static double slope = 0.63478;
	private static Point refValue = new Point(139, 182); // The ref values were calculated by hand from the original image.
	
  public static List<RgbValue> getRgbValuesFrom(BufferedImage image, List<Point> pointsInPolygon) {
	    rgbValues = new ArrayList<>();
	    for(int i = 0; i < pointsInPolygon.size(); i++){    	
	    	int x = pointsInPolygon.get(i).x;
	    	int y = pointsInPolygon.get(i).y;
	        int pixelRgb = image.getRGB(x, y);
	        putPixelARGBInList(pixelRgb, x, y);	        
	    }
    return rgbValues;
  }
  
  private static void putPixelARGBInList(int pixelRgb, int x, int y) {
	    int red = (pixelRgb >> 16) & 0xff;
	    int green = (pixelRgb >> 8) & 0xff;
	    int blue = (pixelRgb) & 0xff;
	    rgbValues.add(new RgbValue(red, green, blue, x, y));
	    //System.out.println("argb: " + alpha + ", " + red + ", " + green + ", " + blue);
  }
  
  
  /*
   * The Integer (Key) is the pixels RGB value
   * The RgbValue is the rgbvalue of the Key and its x and y coordinates.
   */
  public static Map<Integer, RgbValue> getRgbValuesMapFrom(BufferedImage image, List<Point> pointsInPolygon) {
	  rgbValuesMap = new HashMap<>();
	    for(int i = 0; i < pointsInPolygon.size(); i++){    	
	    	int x = pointsInPolygon.get(i).x;
	    	int y = pointsInPolygon.get(i).y;
	        int pixelRgb = image.getRGB(x, y);
	        putPixelRGBInHashMap(pixelRgb, x, y);	        
	    }
  return rgbValuesMap;
}
  
  private static void putPixelRGBInHashMap(int pixelRgb, int x, int y) {
	    int red = (pixelRgb >> 16) & 0xff;
	    int green = (pixelRgb >> 8) & 0xff;
	    int blue = (pixelRgb) & 0xff;
	    rgbValuesMap.put(pixelRgb, new RgbValue(red, green, blue, x, y));
  }

    
  /*
   * Takes the original Rgb values for each pixel and removes the logo from it.
   * Determining which pixels are in the logo is not an exact science!
   * This is done by changing the r, g and b values by a predetermined amount.   * 
   */
  public static List<RgbValue> getAlteredRgbValues(List<RgbValue> originalRgbValues){
	  List<RgbValue> alteredRgbValues = new ArrayList<>();
	  for(int i = 0; i < originalRgbValues.size(); i++){
		  int currentRedValue = originalRgbValues.get(i).r;
		  int newRedValue = (int) (((currentRedValue - refValue.y) / (slope)) + (refValue.x));
		  if(newRedValue < 0) newRedValue = 0;
		  if(newRedValue > 255) newRedValue = 255;
		  
		  int currentGreenValue = originalRgbValues.get(i).g;
		  int newGreenValue = (int) (((currentGreenValue - refValue.y) / (slope)) + (refValue.x));
		  if(newGreenValue < 0) newGreenValue = 0;
		  if(newGreenValue > 255) newGreenValue = 255;
		  
		  int currentBlueValue = originalRgbValues.get(i).b;
		  int newBlueValue = (int) (((currentBlueValue - refValue.y) / (slope)) + (refValue.x));
		  if(newBlueValue < 0) newBlueValue = 0;
		  if(newBlueValue > 255) newBlueValue = 255;
		 
		  alteredRgbValues.add(new RgbValue(newRedValue, newGreenValue, newBlueValue, originalRgbValues.get(i).pixelX, originalRgbValues.get(i).pixelY));
	  }
	  return alteredRgbValues;	  
  }

}
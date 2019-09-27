import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Method2 {
	 /*
	   * This method gets pixels from different parts of the image and puts them into a List.
	   * The RGB values for these pixels are identified and put into another List.
	   * A rectangle is identified (by hand) in which the logo lies.
	   * The logo rectangle is looked at and any pixel RGB that are not in previous List are deemed to be part of the logo.
	   * Theses pixels are then alterd to remove the opacity. 
	   */
	public void start(){
		  BufferedImage logoImage = Image.getImage("Frame1");
		  List<RgbValue> logoRgbValues = new ArrayList<>();
		  System.out.println("topRectangle points sent in");
		  //Polygon topRectangle = new Polygon( new Point(1,1), new Point(3836,1), new Point(3836,908), new Point(2,908));
		  
		  //Polygon bottomRectangle = new Polygon( new Point(2,1260), new Point(3836,1260), new Point(3836,2156), new Point(2,2156));
		  Polygon bottomRectangle = bottomRectanglePoints();
		  
		  Polygon insideO = getInsideOPoints();	  
		  Polygon face = getFacePoints();	  
		  
		  
		  List<Point> bottomRectanglePixels = bottomRectangle.pointsInsidePolygon;
		  System.out.println("No of bottomRectangle pixels: " + bottomRectanglePixels.size());
		  
		  List<Point> insideOpixels = insideO.pointsInsidePolygon;
		  System.out.println("No of InsideO pixels: " + insideOpixels.size());
		  
		  List<Point> facePixels = face.pointsInsidePolygon;
		  System.out.println("No of face pixels: " + facePixels.size());
		  
		  bottomRectanglePixels.addAll(insideOpixels);
		  System.out.println("No of bottomRectangle + InsideO pixels: " + bottomRectanglePixels.size());
		  
		  bottomRectanglePixels.addAll(facePixels);
		  System.out.println("No of bottomRectangle + Inside0 + face pixels: " + bottomRectanglePixels.size());
		  
		  /*
		   * The Integer (Key) is the pixels RGB value
		   * The RgbValue is the rgbvalue of the Key and its x and y coordinates.
		   */
		  Map<Integer, RgbValue> segmentRgbValues = RGB.getRgbValuesMapFrom(logoImage, bottomRectanglePixels);
		  
		  Polygon logoRectangle = new Polygon( new Point(1489,972), new Point(2850,972), new Point(2850,1200), new Point(1489,1200));
		  
		  List<Point> logoPoints = logoRectangle.pointsInsidePolygon;
		 
		  logoRgbValues = getLogoRgbValues(logoPoints, logoImage, segmentRgbValues, logoRgbValues);
		  
		  List<RgbValue> alteredlogoRGBValues= RGB.getAlteredRgbValues(logoRgbValues);
		  BufferedImage finalImage = ModifyImage.Modify(logoImage, alteredlogoRGBValues);
		  PrintImage.print(finalImage, "Method2");
	}
	
	
	private List<RgbValue> getLogoRgbValues(List<Point> logoPoints, BufferedImage logoImage, Map<Integer, RgbValue> segmentRgbValues, List<RgbValue> logoRgbValues){
		  // loop through the points in the logo polygon.
		  // Get the rgb value for the point / pixel.
		  // Convert through values to a single digit.
		  // See if the value is in the Hashmap.
		  // If it is not then this should be a point / pixel in the logo and put in ArrayList.
		  // Convert each rgb value using the alterRgbValue method in RGB class.
		  // Modify the image.
		  for(int i = 0; i < logoPoints.size(); i++){
			  int x = logoPoints.get(i).x;
			  int y = logoPoints.get(i).y;
			  int pixelRgb = logoImage.getRGB(x, y);
			  if(!segmentRgbValues.containsKey(pixelRgb)){
				    int red = (pixelRgb >> 16) & 0xff;
				    int green = (pixelRgb >> 8) & 0xff;
				    int blue = (pixelRgb) & 0xff;
				  logoRgbValues.add(new RgbValue(red, green, blue, x, y));
			  }
		  } // looping through image	return null;
		  return logoRgbValues;
	  }

	  private Polygon bottomRectanglePoints(){
		  List<Point> bottomRectanglePointList = new ArrayList<>();
		  bottomRectanglePointList.add(new Point(2,1260));
		  bottomRectanglePointList.add(new Point(3836,1260));
		  bottomRectanglePointList.add(new Point(3836,2156));
		  bottomRectanglePointList.add(new Point(2,2156));
		  System.out.println("Sending in bottomRectangle points:" + bottomRectanglePointList.size());
		  Polygon bottomRectangle = new Polygon(bottomRectanglePointList);
		  return bottomRectangle;
	  }
	  
	  private Polygon getInsideOPoints(){
		  List<Point> insideOPointList = new ArrayList<>();
		  insideOPointList.add(new Point(1862,1066));
		  insideOPointList.add(new Point(1882,1072));
		  insideOPointList.add(new Point(1898,1091));
		  insideOPointList.add(new Point(1906,1124));
		  insideOPointList.add(new Point(1818,1131));
		  insideOPointList.add(new Point(1821,1100));
		  insideOPointList.add(new Point(1846,1070));
		  System.out.println("Sending in O points");
		  Polygon insideO = new Polygon(insideOPointList);
		return insideO;		  
	  }
	  
	  private Polygon getFacePoints(){
		  List<Point> insideFaceList = new ArrayList<>();
		  insideFaceList.add(new Point(1772,993));
		  insideFaceList.add(new Point(1785,993));
		  insideFaceList.add(new Point(1810,964));
		  insideFaceList.add(new Point(1903,964));
		  insideFaceList.add(new Point(1813,1053));
		  insideFaceList.add(new Point(1778,1061));
		  insideFaceList.add(new Point(1772,1051));
		  System.out.println("Sending in face points");
		  Polygon face = new Polygon(insideFaceList);
		return face;
	  }
}

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import polygon.Polygon;
import polygon.Point;


public class Watermark {
		
	List<RgbValue> cleanStockRgbValues = new ArrayList<>();// a list of pixel coordinates and their RGB values for a clean area where Stock would be.
	
	public void getStockWordCleanRgbValues(BufferedImage cleanImage, Polygon shape){
		List<Point> pointsInsidePolygon = shape.pointsInsidePolygon;
		cleanStockRgbValues = RGB.getRgbValuesFrom(cleanImage, pointsInsidePolygon);
	}
	
	public BufferedImage removeStockWordFromImage(BufferedImage imageToClean){
		BufferedImage cleanedImage = ModifyImage.Modify(imageToClean, cleanStockRgbValues);
		
		return cleanedImage;
	}
	
	/*
	 *  1. get points in polygon
	 *  2. get RGB values for points
	 *  3. for each point convert r by slope etc...then g then b and put them in convertedRgbValues List
	 *  4. modify image with new values.
	 */
	public BufferedImage removeLeftPartOfAFromImage(BufferedImage image, Polygon shape){
		List<Point> pointsInsidePolygon = shape.pointsInsidePolygon;
		//List<Point> pointsInsidePolygon = getPointsInsidePolygon(shape.a, shape.b, shape.c, shape.d);
		List<RgbValue> shapeOriginalRgbValues = RGB.getRgbValuesFrom(image, pointsInsidePolygon);
		//List<RgbValue> shapeAlteredRgbValues = RGB.getAlteredRgbValues(shapeOriginalRgbValues);
		List<RgbValue> alteredRgbVales = RGB.getAlteredRgbValues(shapeOriginalRgbValues);
		BufferedImage cleanedImage = ModifyImage.Modify(image, alteredRgbVales);
		//System.out.println("Left pixels size: " + leftPixels.size());
		return cleanedImage;		
	}
		
	/*
	 * Get the min x and y as well as the max x and y
	 * This creates a square around the Polygon. (Easy to loop through a square.)
	 * Then iterate through each point in the square (pointToCheck) and record any that are in the Polygon.
	 */
//	private List<Point> getPointsInsidePolygon(Point a, Point b, Point c, Point d){
//		List<Point> pointsInsidePolygon = new ArrayList<>();
//		
//		int minX = a.x;
//		int maxX = a.x;
//		int minY = a.y;
//		int maxY = a.y;
//		if(b.x < minX)minX = b.x;
//		if(c.x < minX)minX = c.x;
//		if(d.x < minX)minX = d.x;
//		
//		if(b.x > maxX)maxX = b.x;
//		if(c.x > maxX)maxX = c.x;
//		if(d.x > maxX)maxX = d.x;
//		
//		if(b.y < minY)minY = b.y;
//		if(c.y < minY)minY = c.y;
//		if(d.y < minY)minY = d.y;
//		
//		if(b.y > maxY)maxY = b.y;
//		if(c.y > maxY)maxY = c.y;
//		if(d.y > maxY)maxY = d.y;
//		
//		for(int i = minX; i <= maxX; i++){
//			for(int j = minY; j <= maxY; j++){
//				Point pointToCheck = new Point(i, j);
//				Boolean isInside = Polygon.isPointInsidePolygon(a, b, c, d, pointToCheck);
//				if(isInside){
//					pointsInsidePolygon.add(pointToCheck);					
//				}
//			} 
//		} 		
//		return pointsInsidePolygon;		
//	}
	
	
	
	


} // class

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Map;

public class Method3 {
	
	/*
	 * In this method: 
	 * 1. The areas / polygons where the logo are, are identified roughly, by hand.
	 * 2. Then the points within the polygon is identified.
	 * 3. For each row i.e. value of Y the center of the row is identified.
	 * 4. Then the row is traversed left and right and at each pixel the difference in RGB values is compared the the previous pixel. 
	 * 5. If there is a large enough difference (The threshold will be determined by hand)
	 * then the previous pixel is classed as the edge and all pixels within will be altered by the predefined 
	 * opacity value.
	 */
	public void start(){
		BufferedImage logoImage = Image.getImage("Frame1");
		Polygon LeftPartOfARectangle = new Polygon( new Point(1569,1004), new Point(1580,1004), new Point(1515,1188), new Point(1503,1188));
		List<Point> leftPartOfARectanglePixels = LeftPartOfARectangle.pointsInsidePolygon;
		Map<Integer, Integer> leftEdgePartOfARectanglePixels = LeftPartOfARectangle.polygonLeftPixels; // <Y cood, X coord>
		
	}

}

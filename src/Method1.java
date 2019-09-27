import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
/*
 * In this method rectangles are identified by hand into which different parts of the logo are located.
 * The Pixels in these boxes are altered to remove the opacity.
 * The edges of the rectangles are then blended in to the surrounding image.
 */
public class Method1 {
	private Watermark wk;
	public void start(){
	  wk = new Watermark();
	  BufferedImage cleanImage = Image.getImage("Frame1NoStock");
	  BufferedImage logoImage = Image.getImage("Frame59");
	  
	  //System.out.println("stockRectangle points sent in");
	  Polygon stockRectangle = new Polygon( new Point(2178,961), new Point(2877,961), new Point(2877,1222), new Point(2178,1222));
	  //System.out.println("LeftPartOfA points sent in");
	  //Polygon leftPartOfARectangle = new Polygon( new Point(1569,1004), new Point(1580,1004), new Point(1515,1188), new Point(1503,1188));
	  Polygon leftPartOfARectangle = leftArmOfA();
	  Polygon rightPartOfARectangle = new Polygon( new Point(1573,1003), new Point(1586,1003), new Point(1652,1190), new Point(1636,1190));
	  Polygon middleBarOfARectangle = new Polygon( new Point(1543,1109), new Point(1610,1109), new Point(1614,1121), new Point(1538,1121));
	  //Polygon bodyOfD = new Polygon(new Point(1757,1053), new Point(1753,1052),new Point(1718,1052),new Point(1693,1063),new Point(1679,1077),new Point(1669,1094),new Point(1666,1115),new Point(1666,1136),new Point(1667,1147),new Point(1679,1170),new Point(1693,1183),new Point(1709,1191),new Point(1724,1193),new Point(1748,1190),new Point(1764,1185),new Point(1770,1180),new Point(1757,1175),new Point(1751,1178),new Point(1732,1182),new Point(1719,1180),new Point(1705,1176),new Point(1696,1168),new Point(1686,1155),new Point(1679,1141),new Point(1679,1114),new Point(1685,1093),new Point(1700,1074),new Point(1713,1067),new Point(1731,1062),new Point(1746,1062),new Point(1757,1067));  		   		   	
	  //Polygon bodyOfD = bodyOfDPoints();
	  //Polygon bodyOfD = new Polygon(new Point(1718,1052),new Point(1731,1062),new Point(1713,1067) , new Point(1693,1063));
	  Polygon bodyOfD = new Polygon(new Point(1679,1077),new Point(1713,1067),new Point(1679,1114) , new Point(1666,1115));
	  
	  wk.getStockWordCleanRgbValues(cleanImage, stockRectangle);
	  
	  BufferedImage image = wk.removeStockWordFromImage(logoImage);
	  
	  // Left arm of A
		  image = wk.removeLeftPartOfAFromImage(image, leftPartOfARectangle);	  
		  image = BlendEdges.begin(image, leftPartOfARectangle);
	  
	  // Right arm of A
		  image = wk.removeLeftPartOfAFromImage(image, rightPartOfARectangle);	  
		  image = BlendEdges.begin(image, rightPartOfARectangle);
	  
	// Middle arm of A
		  image = wk.removeLeftPartOfAFromImage(image, middleBarOfARectangle);	  
		  image = BlendEdges.begin(image, middleBarOfARectangle);
	  
	// Middle body of D
		  image = wk.removeLeftPartOfAFromImage(image, bodyOfD);	  
		  image = BlendEdges.begin(image, bodyOfD);	  
		  
	// Put dots on image to help testing
		  image = putDotsOnImage(image);
	  
	  PrintImage.print(image, "Method1F59RemoveAandD...");
	}
	
	private Polygon leftArmOfA(){
		  List<Point> leftArmOfADPointList = new ArrayList<>();
		  leftArmOfADPointList.add(new Point(1569,1004));
		  leftArmOfADPointList.add(new Point(1580,1004));
		  leftArmOfADPointList.add(new Point(1515,1188));
		  leftArmOfADPointList.add(new Point(1503,1188));
		  //System.out.println("Sending in left arm of A points");
		  Polygon leftArmOfA = new Polygon(leftArmOfADPointList);
		return leftArmOfA;		  
	  }
	
	private Polygon bodyOfDPoints(){
		  List<Point> bodyOfDPointList = new ArrayList<>();
//		  bodyOfDPointList.add(new Point(1757,1053));
//		  bodyOfDPointList.add(new Point(1753,1052));
		  bodyOfDPointList.add(new Point(1718,1052));
		  bodyOfDPointList.add(new Point(1693,1063));
//		  bodyOfDPointList.add(new Point(1679,1077));
//		  bodyOfDPointList.add(new Point(1669,1094));
//		  bodyOfDPointList.add(new Point(1666,1115));
//		  bodyOfDPointList.add(new Point(1666,1136));
//		  bodyOfDPointList.add(new Point(1667,1147));
//		  bodyOfDPointList.add(new Point(1679,1170));
//		  bodyOfDPointList.add(new Point(1693,1183));
//		  bodyOfDPointList.add(new Point(1709,1191));
//		  bodyOfDPointList.add(new Point(1724,1193));
//		  bodyOfDPointList.add(new Point(1748,1190));
//		  bodyOfDPointList.add(new Point(1764,1185));
//		  bodyOfDPointList.add(new Point(1770,1180));
//		  bodyOfDPointList.add(new Point(1757,1175));
//		  bodyOfDPointList.add(new Point(1751,1178));
//		  bodyOfDPointList.add(new Point(1732,1182));
//		  bodyOfDPointList.add(new Point(1719,1180));
//		  bodyOfDPointList.add(new Point(1705,1176));
//		  bodyOfDPointList.add(new Point(1696,1168));
//		  bodyOfDPointList.add(new Point(1686,1155));
//		  bodyOfDPointList.add(new Point(1679,1141));
//		  bodyOfDPointList.add(new Point(1679,1114));
//		  bodyOfDPointList.add(new Point(1685,1093));
//		  bodyOfDPointList.add(new Point(1700,1074));
		  bodyOfDPointList.add(new Point(1713,1067));
		  bodyOfDPointList.add(new Point(1731,1062));
//		  bodyOfDPointList.add(new Point(1746,1062));
//		  bodyOfDPointList.add(new Point(1757,1067));
		  //System.out.println("Sending in D body points");
		  Polygon bodyOfD = new Polygon(bodyOfDPointList);
		return bodyOfD;		  
	  }
	
	
	
	private static BufferedImage putDotsOnImage(BufferedImage cleanImage){
		int rgb = new Color(255, 0, 0).getRGB();
		cleanImage.setRGB(1757,1053, rgb);
		cleanImage.setRGB(1753,1052, rgb);
		cleanImage.setRGB(1718,1052, rgb);
		cleanImage.setRGB(1693,1063, rgb);
		cleanImage.setRGB(1679,1077, rgb);
		cleanImage.setRGB(1669,1094, rgb);
		cleanImage.setRGB(1666,1115, rgb);
		cleanImage.setRGB(1666,1136, rgb);
		cleanImage.setRGB(1667,1147, rgb);
		cleanImage.setRGB(1679,1170, rgb);
		cleanImage.setRGB(1693,1183, rgb);
		cleanImage.setRGB(1709,1191, rgb);
		cleanImage.setRGB(1724,1193, rgb);
		cleanImage.setRGB(1748,1190, rgb);
		cleanImage.setRGB(1764,1185, rgb);
		cleanImage.setRGB(1770,1180, rgb);
		cleanImage.setRGB(1757,1175, rgb);
		cleanImage.setRGB(1751,1178, rgb);
		cleanImage.setRGB(1732,1182, rgb);
		cleanImage.setRGB(1719,1180, rgb);
		cleanImage.setRGB(1705,1176, rgb);
		cleanImage.setRGB(1696,1168, rgb);
		cleanImage.setRGB(1686,1155, rgb);
		cleanImage.setRGB(1679,1141, rgb);
		cleanImage.setRGB(1679,1114, rgb);
		cleanImage.setRGB(1685,1093, rgb);
		cleanImage.setRGB(1700,1074, rgb);
		cleanImage.setRGB(1713,1067, rgb);
		cleanImage.setRGB(1731,1062, rgb);
		cleanImage.setRGB(1746,1062, rgb);
		cleanImage.setRGB(1757,1067, rgb);	
		return cleanImage;		
	}
	
} // Class

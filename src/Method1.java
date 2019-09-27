import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import polygon.Point;
import polygon.Polygon;
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
	  BufferedImage logoImage = Image.getImage("Frame1");	  
	  
	  Polygon stockRectangle = stockRectangle();
	  stockRectangle.getAllPointsInsidePolygonList(stockRectangle);
	  
	  Polygon leftPartOfARectangle = leftArmOfA();
	  leftPartOfARectangle.getAllPointsInsidePolygonList(leftPartOfARectangle);
	  
	  Polygon rightPartOfARectangle = rightArmOfA();
	  rightPartOfARectangle.getAllPointsInsidePolygonList(rightPartOfARectangle);
	  
	  Polygon middleBarOfARectangle = middleBarOfA();
	  middleBarOfARectangle.getAllPointsInsidePolygonList(middleBarOfARectangle);
	  
	  Polygon bodyOfD = bodyOfDPoints();
	  bodyOfD.getAllPointsInsidePolygonList(bodyOfD);
	  
	  Polygon armOfD = armOfDPoints();
	  armOfD.getAllPointsInsidePolygonList(armOfD);
	  
	  Polygon letterO = letterOPoints();
	  letterO.getAllPointsInsidePolygonList(letterO);
	  
	  Polygon letterB = letterBPoints();
	  letterB.getAllPointsInsidePolygonList(letterB);
	  
	  Polygon letterE = letterEPoints();
	  letterE.getAllPointsInsidePolygonList(letterE);
	  
	  
	   
	  	 
	  // Start removing logo parts
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
		  
	 // Arm of D
		  image = wk.removeLeftPartOfAFromImage(image, armOfD);	  
		  image = BlendEdges.begin(image, armOfD);	
		  
	 // Letter O
		  image = wk.removeLeftPartOfAFromImage(image, letterO);	  
		  image = BlendEdges.begin(image, letterO);
		  
	 // Letter b
		  image = wk.removeLeftPartOfAFromImage(image, letterB);	  
		  image = BlendEdges.begin(image, letterB);
		  
     // Letter e
		  image = wk.removeLeftPartOfAFromImage(image, letterE);	  
		  image = BlendEdges.begin(image, letterE);
		  
	// Put dots on image to help testing
		  //image = putDotsOnImage(image);
	  
	  PrintImage.print(image, "Method1F1NewPolyLetterE");
	}
	
	private Polygon stockRectangle(){
		Polygon polygon = Polygon.Builder()
				.addVertex(new Point(2178,961))
                .addVertex(new Point(2877,961))
                .addVertex(new Point(2877,1222))
                .addVertex(new Point(2178,1222))
                .build();
		return polygon;
	}
	
	private Polygon leftArmOfA(){
		  Polygon polygon = Polygon.Builder()
		  .addVertex(new Point(1569,1004))
		  .addVertex(new Point(1580,1004))
		  .addVertex(new Point(1515,1188))
		  .addVertex(new Point(1503,1188))
		  .build();
		return polygon;		  
	}
	
	private Polygon rightArmOfA(){
		Polygon polygon = Polygon.Builder()
				.addVertex(new Point(1573,1003))
                .addVertex(new Point(1586,1003))
                .addVertex(new Point(1652,1190))
                .addVertex(new Point(1636,1190))
                .build();
		return polygon;
	}
	
	private Polygon middleBarOfA(){
		Polygon polygon = Polygon.Builder()
				.addVertex(new Point(1543,1109))
                .addVertex(new Point(1610,1109))
                .addVertex(new Point(1614,1121))
                .addVertex(new Point(1538,1121))
                .build();
		return polygon;
	}
	
	private Polygon bodyOfDPoints(){
		  Polygon polygon = Polygon.Builder()
		  .addVertex(new Point(1757,1051))
		  //.addVertex(new Point(1753,1052))
		  .addVertex(new Point(1718,1052))
		  .addVertex(new Point(1693,1063))
		  .addVertex(new Point(1679,1077))
		  .addVertex(new Point(1669,1094))
		  .addVertex(new Point(1666,1115))
		  .addVertex(new Point(1666,1136))
		  .addVertex(new Point(1667,1147))
		  .addVertex(new Point(1679,1170))
		  .addVertex(new Point(1693,1183))
		  .addVertex(new Point(1709,1191))
		  .addVertex(new Point(1724,1193))
		  .addVertex(new Point(1748,1190))
		  .addVertex(new Point(1764,1185))
		  .addVertex(new Point(1770,1180))
		  .addVertex(new Point(1757,1175))
		  .addVertex(new Point(1751,1178))
		  .addVertex(new Point(1732,1182))
		  .addVertex(new Point(1719,1180))
		  .addVertex(new Point(1705,1176))
		  .addVertex(new Point(1696,1168))
		  .addVertex(new Point(1686,1155))
		  .addVertex(new Point(1679,1141))
		  .addVertex(new Point(1679,1114))
		  .addVertex(new Point(1685,1093))
		  .addVertex(new Point(1700,1074))
		  .addVertex(new Point(1713,1067))
		  .addVertex(new Point(1731,1062))
		  .addVertex(new Point(1746,1062))
		  .addVertex(new Point(1757,1067))
		  .build();
		return polygon;		  
	  }
	
	private Polygon armOfDPoints(){
		Polygon polygon = Polygon.Builder()
				.addVertex(new Point(1757,988))
                .addVertex(new Point(1770,989))
                .addVertex(new Point(1769,1178))
                .addVertex(new Point(1757,1176))
                .build();
		return polygon;
	}
	
	private Polygon letterOPoints(){
		Polygon polygon = Polygon.Builder()
	            .addVertex(new Point(1859,1052)) // polygon
	            .addVertex(new Point(1844,1055))
	            .addVertex(new Point(1831,1061))
	            .addVertex(new Point(1818,1075))
	            .addVertex(new Point(1809,1090))
	            .addVertex(new Point(1804,1110))
	            .addVertex(new Point(1804,1128))
	            .addVertex(new Point(1806,1148))
	            .addVertex(new Point(1813,1164))
	            .addVertex(new Point(1825,1181))
	            .addVertex(new Point(1841,1191))
	            .addVertex(new Point(1852,1193))
	            .addVertex(new Point(1866,1194))
	            .addVertex(new Point(1878,1193))
	            .addVertex(new Point(1890,1187))
	            .addVertex(new Point(1904,1174))
	            .addVertex(new Point(1917,1153))
	            .addVertex(new Point(1921,1123))
	            .addVertex(new Point(1918,1097))
	            .addVertex(new Point(1909,1075))
	            .addVertex(new Point(1894,1061))
	            .addVertex(new Point(1879,1053))
	            .close()
	            .addVertex(new Point(1863,1062)) // middle hole
	            .addVertex(new Point(1850,1065))
	            .addVertex(new Point(1839,1069))
	            .addVertex(new Point(1828,1079))
	            .addVertex(new Point(1819,1094))
	            .addVertex(new Point(1815,1113))
	            .addVertex(new Point(1815,1130))
	            .addVertex(new Point(1820,1147))
	            .addVertex(new Point(1827,1163))
	            .addVertex(new Point(1838,1173))
	            .addVertex(new Point(1850,1180))
	            .addVertex(new Point(1862,1182))
	            .addVertex(new Point(1876,1180))
	            .addVertex(new Point(1890,1170))
	            .addVertex(new Point(1900,1157))
	            .addVertex(new Point(1907,1140))
	            .addVertex(new Point(1908,1123))
	            .addVertex(new Point(1906,1105))
	            .addVertex(new Point(1900,1087))
	            .addVertex(new Point(1891,1074))
	            .addVertex(new Point(1880,1066))
	            .close()
	            .build();
		return polygon;
	}
	
	private Polygon letterBPoints(){
		Polygon polygon = Polygon.Builder()
	            .addVertex(new Point(1950,988)) // polygon
	            .addVertex(new Point(1950,1186))
	            .addVertex(new Point(1958,1190))
	            .addVertex(new Point(1967,1193))
	            .addVertex(new Point(2002,1192))
	            .addVertex(new Point(2022,1183))
	            .addVertex(new Point(2039,1167))
	            .addVertex(new Point(2050,1148))
	            .addVertex(new Point(2055,1125))
	            .addVertex(new Point(2054,1102))
	            .addVertex(new Point(2045,1076))
	            .addVertex(new Point(2034,1064))
	            .addVertex(new Point(2019,1056))
	            .addVertex(new Point(2006,1052))
	            .addVertex(new Point(1982,1051))
	            .addVertex(new Point(1964,1056))
	            .addVertex(new Point(1963,988))
	            .close()
	            .addVertex(new Point(1963,1072)) // middle hole
	            .addVertex(new Point(1963,1176))
	            .addVertex(new Point(1977,1181))
	            .addVertex(new Point(1991,1181))
	            .addVertex(new Point(2007,1177))
	            .addVertex(new Point(2021,1168))
	            .addVertex(new Point(2032,1154))
	            .addVertex(new Point(2039,1140))
	            .addVertex(new Point(2042,1123))
	            .addVertex(new Point(2041,1103))
	            .addVertex(new Point(2033,1084))
	            .addVertex(new Point(2023,1072))
	            .addVertex(new Point(2012,1066))
	            .addVertex(new Point(1996,1063))
	            .addVertex(new Point(1985,1064))
	            .addVertex(new Point(1973,1067))
	            .close()
	            .build();
		return polygon;
	}
	
	private Polygon letterEPoints(){
		Polygon polygon = Polygon.Builder()
	            .addVertex(new Point(2184,1120)) // polygon
	            .addVertex(new Point(2185,1106))
	            .addVertex(new Point(2184,1091))
	            .addVertex(new Point(2178,1076))
	            .addVertex(new Point(2170,1063))
	            .addVertex(new Point(2155,1055))
	            .addVertex(new Point(2139,1051))
	            .addVertex(new Point(2121,1053))
	            .addVertex(new Point(2099,1067))
	            .addVertex(new Point(2086,1090))
	            .addVertex(new Point(2080,1120))
	            .addVertex(new Point(2083,1149))
	            .addVertex(new Point(2097,1177))
	            .addVertex(new Point(2111,1185))
	            .addVertex(new Point(2125,1191))
	            .addVertex(new Point(2139,1193))
	            .addVertex(new Point(2152,1192))
	            .addVertex(new Point(2164,1189))
	            .addVertex(new Point(2177,1183))
	            .addVertex(new Point(2177,1172))
	            .addVertex(new Point(2157,1178))
	            .addVertex(new Point(2131,1180))
	            .addVertex(new Point(2116,1173))
	            .addVertex(new Point(2104,1162))
	            .addVertex(new Point(2094,1139))
	            .addVertex(new Point(2093,1120))
	            .close()
	            .addVertex(new Point(2094,1109)) // middle hole
	            .addVertex(new Point(2098,1090))
	            .addVertex(new Point(2103,1081))
	            .addVertex(new Point(2112,1071))
	            .addVertex(new Point(2124,1064))
	            .addVertex(new Point(2137,1063))
	            .addVertex(new Point(2147,1065))
	            .addVertex(new Point(2160,1073))
	            .addVertex(new Point(2170,1088))
	            .addVertex(new Point(2174,1109))
	            .close()
	            .build();
		return polygon;
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

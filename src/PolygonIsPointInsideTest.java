import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;


public class PolygonIsPointInsideTest {
	 List<Point> bodyOfDPointList;
	 @Before
	 public void executedBeforeEach() {
		 bodyOfDPointList = new ArrayList<>();
		  bodyOfDPointList.add(new Point(1757,1053));
		  bodyOfDPointList.add(new Point(1753,1052));
		  bodyOfDPointList.add(new Point(1718,1052));
		  bodyOfDPointList.add(new Point(1693,1063));
		  bodyOfDPointList.add(new Point(1679,1077));
		  bodyOfDPointList.add(new Point(1669,1094));
		  bodyOfDPointList.add(new Point(1666,1115));
		  bodyOfDPointList.add(new Point(1666,1136));
		  bodyOfDPointList.add(new Point(1667,1147));
		  bodyOfDPointList.add(new Point(1679,1170));
		  bodyOfDPointList.add(new Point(1693,1183));
		  bodyOfDPointList.add(new Point(1709,1191));
		  bodyOfDPointList.add(new Point(1724,1193));
		  bodyOfDPointList.add(new Point(1748,1190));
		  bodyOfDPointList.add(new Point(1764,1185));
		  bodyOfDPointList.add(new Point(1770,1180));
		  bodyOfDPointList.add(new Point(1757,1175));
		  bodyOfDPointList.add(new Point(1751,1178));
		  bodyOfDPointList.add(new Point(1732,1182));
		  bodyOfDPointList.add(new Point(1719,1180));
		  bodyOfDPointList.add(new Point(1705,1176));
		  bodyOfDPointList.add(new Point(1696,1168));
		  bodyOfDPointList.add(new Point(1686,1155));
		  bodyOfDPointList.add(new Point(1679,1141));
		  bodyOfDPointList.add(new Point(1679,1114));
		  bodyOfDPointList.add(new Point(1685,1093));
		  bodyOfDPointList.add(new Point(1700,1074));
		  bodyOfDPointList.add(new Point(1713,1067));
		  bodyOfDPointList.add(new Point(1731,1062));
		  bodyOfDPointList.add(new Point(1746,1062));
		  bodyOfDPointList.add(new Point(1757,1067));
	 }

    @Test
    public void alteredRgbTestMethod() {  
//    	 assertEquals(false, Polygon.isPointInsidePolygonList(bodyOfDPointList, new Point(1672,1074)));
//    	 assertEquals(false, Polygon.isPointInsidePolygonList(bodyOfDPointList, new Point(1690,1060)));
//    	 assertEquals(true, Polygon.isPointInsidePolygonList(bodyOfDPointList, new Point(1680,1093)));
    	 assertEquals(false, Polygon.isPointInsidePolygonList(bodyOfDPointList, new Point(1730,1067)));
    	 assertEquals(true, Polygon.isPointInsidePolygonList(bodyOfDPointList, new Point(1680,1155)));
    }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * This is a Java Program to check whether a point lies inside, outside or on the Polygon. 
 * It follows a simple idea to check whether a point is inside or outside.
1) Draw a horizontal line to the right of each point and extend it to infinity
2) Count the number of times the line intersects with polygon edges.
3) A point is inside the polygon if either count of intersections is odd or point lies on an edge of polygon. 
	If none of the conditions is true, then point lies outside.
 */

/*
 * This class takes in a List of Points defining a polygon.
 * It then works out the bounding box of the polygon.
 * Then it loops through all the points of the box and checks which ones are in the Polygon.
 * It keeps a List of all points in the polygon, all points on the left edges and all points on the right edges.
 */
    

     

    public class Polygon {   
    	Point a;
		Point b;
		Point c;
		Point d;
		Point e;
		Point f;
		Point g;
		public Map<Integer, Integer> polygonLeftPixels; // <Y cood, X coord>
		public Map<Integer, Integer> polygonRightPixels; // <Y cood, X coord>
		public List<Point> pointsInsidePolygon;
		
		public Polygon(List<Point> points){  
			//System.out.println("Polygon LIST called");
    		getPointsInsidePolygonList(points);
    	}
    	
    	public Polygon(Point a, Point b, Point c, Point d){
    		//System.out.println("Polygon NO list Called");
    		this.a = a;
    		this.b = b;
    		this.c = c;
    		this.d = d;    		
    		getPointsInsidePolygon(a, b, c, d);
    	}
    	
    	
    	    	
    	public static boolean onSegment(Point p, Point q, Point r){
            if (q.x <= Math.max(p.x, r.x) && q.x >= Math.min(p.x, r.x)
                    && q.y <= Math.max(p.y, r.y) && q.y >= Math.min(p.y, r.y))
                return true;
            return false;
        }
     

        public static int orientation(Point p, Point q, Point r){
            int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);    

            if (val == 0)
                return 0;
            return (val > 0) ? 1 : 2;
        }
     

        public static boolean doIntersect(Point p1, Point q1, Point p2, Point q2) { 
            int o1 = orientation(p1, q1, p2);
            int o2 = orientation(p1, q1, q2);
            int o3 = orientation(p2, q2, p1);
            int o4 = orientation(p2, q2, q1);    

            if (o1 != o2 && o3 != o4)
                return true;     

            if (o1 == 0 && onSegment(p1, p2, q1))
                return true;     

            if (o2 == 0 && onSegment(p1, q2, q1))
                return true;     

            if (o3 == 0 && onSegment(p2, p1, q2))
                return true;     

            if (o4 == 0 && onSegment(p2, q1, q2))
                return true;     

            return false;
        }
     

        public static boolean isInside(Point polygon[], int n, Point p) {
            int INF = 10000;
            if (n < 3)
                return false;     

            Point extreme = new Point(INF, p.y);     

            int count = 0, i = 0;
            do {
                int next = (i + 1) % n;
                if (doIntersect(polygon[i], polygon[next], p, extreme))
                {
                    if (orientation(polygon[i], p, polygon[next]) == 0)
                        return onSegment(polygon[i], p, polygon[next]); 
                    count++;
                }

                i = next;
            } while (i != 0);     

            return (count & 1) == 1 ? true : false;
        }
    

        //Points must be clockwise or anti-clockwise.!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        public static boolean isPointInsidePolygon(Point a, Point b, Point c, Point d, Point toCheck){
            Point polygon1[] = { a, b, c, d};
            //System.out.println("isPointInsidePolygon Points size: " + polygon1.length);
            int n = polygon1.length;  
            Point p = toCheck;
            
            return isInside(polygon1, n, p);
        }
        
        //Points must be clockwise or anti-clockwise.!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        public static boolean isPointInsidePolygonList(List<Point> points, Point toCheck){
        	Point polygon1[] = new Point[points.size()];
        	for(int i = 0; i < points.size(); i++) polygon1[i] = points.get(i);
            int n = polygon1.length;  
            //System.out.println("Number of Polygon points: " + n);
            Point p = toCheck;
            
            return isInside(polygon1, n, p);
        }
        
        private void getPointsInsidePolygonList(List<Point> points){
        	//System.out.println("getPointsInsidePolygonList No of points sent in: " + points.size());
        	pointsInsidePolygon = new ArrayList<>();
    		polygonLeftPixels = new HashMap<>();
    		polygonRightPixels = new HashMap<>();
    		
    		// Find the 4 corners of a box that bounds the Polygon.
    		int minX = Integer.MAX_VALUE;
    		int maxX = Integer.MIN_VALUE;
    		int minY = Integer.MAX_VALUE;
    		int maxY = Integer.MIN_VALUE;
    		
    		for(int i = 0; i < points.size(); i++){
    			int x = points.get(i).x;
    			int y = points.get(i).y;
    			if(x < minX)minX = x;
        		if(x > maxX)maxX = x;
        		
        		if(y < minY)minY = y;
        		if(y > maxY)maxY = y;        		
    		}
//    		System.out.println("Min X = " + minX);
//    		System.out.println("Max X = " + maxX);
//    		System.out.println("Min Y = " + minY);
//    		System.out.println("Max Y = " + maxY);
    		
    		// Loop through all the points in the bounding box and see which ones are in the Polygon.
    		for(int i = minX; i <= maxX; i++){
    			for(int j = minY; j <= maxY; j++){
    				Point pointToCheck = new Point(i, j);
    				Boolean isInside = Polygon.isPointInsidePolygonList(points, pointToCheck);
    				if(isInside){
    					//System.out.println("X : " + i + "--- Y : " + j);
    					pointsInsidePolygon.add(pointToCheck);
    					getPolygonLeftPixels(pointToCheck);
    					getPolygonRightPixels(pointToCheck);
    				}
    			} 
    		} 
        }
        
        
        private void getPointsInsidePolygon(Point a, Point b, Point c, Point d){
        	//System.out.println("Points inside polygon***");
    		pointsInsidePolygon = new ArrayList<>();
    		polygonLeftPixels = new HashMap<>();
    		polygonRightPixels = new HashMap<>();
    		
    		int minX = a.x;
    		int maxX = a.x;
    		int minY = a.y;
    		int maxY = a.y;
    		if(b.x < minX)minX = b.x;
    		if(c.x < minX)minX = c.x;
    		if(d.x < minX)minX = d.x;
    		
    		if(b.x > maxX)maxX = b.x;
    		if(c.x > maxX)maxX = c.x;
    		if(d.x > maxX)maxX = d.x;
    		
    		if(b.y < minY)minY = b.y;
    		if(c.y < minY)minY = c.y;
    		if(d.y < minY)minY = d.y;
    		
    		if(b.y > maxY)maxY = b.y;
    		if(c.y > maxY)maxY = c.y;
    		if(d.y > maxY)maxY = d.y;
    		
//    		System.out.println("Min X = " + minX);
//    		System.out.println("Max X = " + maxX);
//    		System.out.println("Min Y = " + minY);
//    		System.out.println("Max Y = " + maxY);
    		for(int i = minX; i <= maxX; i++){
    			for(int j = minY; j <= maxY; j++){
    				Point pointToCheck = new Point(i, j);
    				Boolean isInside = Polygon.isPointInsidePolygon(a, b, c, d, pointToCheck);
    				if(isInside){
    					//System.out.println("X : " + i + "--- Y : " + j);
    					pointsInsidePolygon.add(pointToCheck);
    					getPolygonLeftPixels(pointToCheck);
    					getPolygonRightPixels(pointToCheck);
    				}
    			} 
    		} 			
    	}
        
        
        
        
        private void getPolygonLeftPixels(Point toCheck){      	  
	          int x = toCheck.x;
	  		  int minX = x;
	  		  int y = toCheck.y;
	  		  
	  		  if(polygonLeftPixels.containsKey(y)){
	  			  if(minX < polygonLeftPixels.get(y)) {
	  				polygonLeftPixels.put(y, minX);
	  		  }
	  		  }else{// if no value for y in the hashmap, put it in.
	  			polygonLeftPixels.put(y, x);
	  		  }
        }
        
        private void getPolygonRightPixels(Point toCheck){        	  
  	          int x = toCheck.x;
  	  		  int maxX = x;
  	  		  int y = toCheck.y;
  	  		  
  	  		  if(polygonRightPixels.containsKey(y)){
  	  			  if(maxX > polygonRightPixels.get(y)) { //get(y)...y is the key of the Hashmap so it returns the value which is x.
  	  				polygonRightPixels.put(y, maxX);
  	  		  }
  	  		  }else{// if no value for y in the hashmap, put it in.
  	  			polygonRightPixels.put(y, x);
  	  		  }
          }
        

    }
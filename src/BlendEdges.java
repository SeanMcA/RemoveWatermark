import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class BlendEdges {
	private static int[][] blendFilter = new int[][]{
											  {1, 1, 1},
											  {1, 1, 1},
											  {1, 1, 1},
											  {9}
											};
	private static int[][] leftBlendFilter = new int[][]{
											  {1, 1, 0},
											  {1, 1, 0},
											  {1, 1, 0},
											  {6}
											};
							
							
	
	public static BufferedImage begin(BufferedImage image, Polygon LeftPartOfARectangle){		
		image = blendEdgeOfLeftA(image, LeftPartOfARectangle.polygonLeftPixels, 1);
		image = blendEdgeOfLeftA(image, LeftPartOfARectangle.polygonRightPixels, -1);
		return image;		
	}
		/*
		 * To blend in the left edge of the A from Adobe we get the left pixels and copy over the
		 * rgb values from the pixels to their left.
		 * The inputs to this method are the image to be corrected and a HashMap.
		 * A hashMap was used as it was easiest to implement in another method.
		 * The Integer 'Key' of the hashMap is not used here.
		 * The RgbValue 'Values' of the Hashmap are the RgbValues for the left most pixels of the A character in the image.
		 */
		// The input side effectively changes a (-) to a (+) or vice versa. 
		public static BufferedImage blendEdgeOfLeftA(BufferedImage image, Map<Integer, Integer> edgePixels, int side){
			Iterator<Entry<Integer, Integer>> it = edgePixels.entrySet().iterator();
			List<RgbValue>alteredRgbValues = new ArrayList<>();
			// Loop down through all the left edge pixels and get their x and y coordinates
		    while (it.hasNext()) {
		        Map.Entry<Integer, Integer> pair = (Map.Entry<Integer, Integer>)it.next();
		        int x = (int) pair.getValue();
		        int y = (int) pair.getKey();
		        //System.out.println("left edge pixels are=> X - " + x + " : Y - " + y);
		       x = x + (2 * side); // move x two pixels to the right.
		       
		        //for i values of x moving to the left...find the avg rgb value of the pixels ? to the left
		        for(int i = 0; i < 5; i++){
		        	x = x - (1 * side); // move x one pixel to the left on each loop.
		        	int pixelToAvg = x;
		        	//System.out.println("X is: " + x);
		        	int[] alteredRgbArray = applyFilter(image, blendFilter, pixelToAvg - (3 * side), y);
		        	alteredRgbValues.add(new RgbValue(alteredRgbArray[0],alteredRgbArray[1], alteredRgbArray[2], x, y ));
		        }
		        			    		    
	        it.remove(); // avoids a ConcurrentModificationException
	    }
		    //System.out.println("Edge pixels finished\n\n");
	    image = ModifyImage.Modify(image, alteredRgbValues);
		return image;
		}
		
		

		// Applys the filter centered on the x and y coordinates sent in.
		// Then returns the red, green and blue values in an int array. 
		private static int[] applyFilter(BufferedImage image, int[][] filter, int x, int y){
			int[] alteredRgbVlaues = new int[3];
			 	int pixel1Value = (image.getRGB(x - 1, y - 1)) * filter[0][0];			 	
		        int pixel2Value = (image.getRGB(x, y - 1)) * filter[0][1];
		        int pixel3Value = (image.getRGB(x + 1, y - 1)) * filter[0][2];
		        int pixel4Value = (image.getRGB(x - 1, y)) * filter[1][0];
		        int pixel5Value = (image.getRGB(x, y)) * filter[1][1];
		        int pixel6Value = (image.getRGB(x + 1, y)) * filter[1][2];
		        int pixel7Value = (image.getRGB(x - 1, y + 1)) * filter[2][0];
		        int pixel8Value = (image.getRGB(x, y + 1)) * filter[2][1];
		        int pixel9Value = (image.getRGB(x + 1, y + 1)) * filter[2][2];
		        
		        int redAvg = (((pixel1Value >> 16) & 0xff) +
	        					((pixel2Value >> 16) & 0xff) + 
	        					((pixel3Value >> 16) & 0xff) +
	        					((pixel4Value >> 16) & 0xff) +
	        					((pixel5Value >> 16) & 0xff) +
	        					((pixel6Value >> 16) & 0xff) +
						        ((pixel7Value >> 16) & 0xff) + 
								((pixel8Value >> 16) & 0xff) +
								((pixel9Value >> 16) & 0xff)) / filter[3][0];
		        
		        int greenAvg = (((pixel1Value >> 8) & 0xff) +
		    					((pixel2Value >> 8) & 0xff) + 
		    					((pixel3Value >> 8) & 0xff) +
		    					((pixel4Value >> 8) & 0xff) +
		    					((pixel5Value >> 8) & 0xff) +
		    					((pixel6Value >> 8) & 0xff) +
						        ((pixel7Value >> 8) & 0xff) + 
								((pixel8Value >> 8) & 0xff) +
								((pixel9Value >> 8) & 0xff)) / filter[3][0];
		        
		        int blueAvg = (((pixel1Value >> 0) & 0xff) +
		    					((pixel2Value >> 0) & 0xff) + 
		    					((pixel3Value >> 0) & 0xff) +
		    					((pixel4Value >> 0) & 0xff) +
		    					((pixel5Value >> 0) & 0xff) +
		    					((pixel6Value >> 0) & 0xff) +
						        ((pixel7Value >> 0) & 0xff) + 
								((pixel8Value >> 0) & 0xff) +
								((pixel9Value >> 0) & 0xff)) / filter[3][0];
		        alteredRgbVlaues[0] = redAvg;
		        alteredRgbVlaues[1] = greenAvg;
		        alteredRgbVlaues[2] = blueAvg;
		        return alteredRgbVlaues;
			//return new RgbValue(redAvg, greenAvg, blueAvg, x , y);			
		}

} // class

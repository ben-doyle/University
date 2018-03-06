package week5;

import extra.week1.Shape;
import extra.week1.Delay;

/** Displays a shape with continuously moving vertices.
 */
public class ShapeViewer {

	private static final int WIDTH = 392;  // the width of the window
	private static final int HEIGHT = 268; // the height of the window
	
	public static void main(String [] args) {
		final int NUM = Integer.parseInt(args[0]);  // the number of vertices
		int [] x = new int [NUM];  // the x vertices of the shape
		int [] y = new int [NUM];  // the y vertices of the shape
		int [] xDir = new int [NUM];  // the directions to move the x vertices
		int [] yDir = new int [NUM];  // the directions to move the y vertices
		
		Shape.create();
		initialiseVertices(x,y);
		Shape.draw(x,y);
		while (true) {
			selectDirections(xDir,yDir);
			for (int i=0; i < 150; i++) {
				Delay.milliseconds(10);
				moveInGivenDirections(x,y,xDir,yDir);
				Shape.draw(x,y);
			}	
		}
	}
		
	/** Initialise the vertices of the shape.
	 * @param x  the x vertices
	 * @param y  the y vertices
	 */
	private static void initialiseVertices(int [] x, int [] y) {	
		for (int i=0; i < x.length; i++) {
			x[i] = (int)(WIDTH*Math.random());
			y[i] = (int)(HEIGHT*Math.random());
		}
	}
	
	/** Select the directions for the vertices of the shape to move.
	 * @param xDir  the directions to move the x vertices
	 * @param yDir  the directions to move the y vertices
	 */
	private static void selectDirections(int [] xDir, int [] yDir) {
			for (int i=0; i < xDir.length; i++) {
				xDir[i] = (int)(3*Math.random())-1;
				yDir[i] = (int)(3*Math.random())-1;
			}
	}
	
	/** Move the vertices of the shape in the given directions rebounding off 
	 * the edges of the window when required.
	 * @param x  the x vertices of the shape
	 * @param y  the y vertices of the shape
	 * @param xDir  the directions to move the x vertices
	 * @param yDir  the directions to move the y vertices
	 */
	private static void moveInGivenDirections(int [] x, int []y, int [] xDir,
					int [] yDir) {
		for (int j=0; j < x.length; j++) {
			if (x[j]==0 && xDir[j]==-1)
				xDir[j] = 1;
			if (x[j]==WIDTH && xDir[j]==1)
				xDir[j] = -1;
			x[j] += xDir[j];
			if (y[j]==0 && yDir[j]==-1)
				yDir[j] = 1;
			if (y[j]==HEIGHT && yDir[j]==1)
				yDir[j] = -1;
			y[j] += yDir[j];
		}		
	}
}
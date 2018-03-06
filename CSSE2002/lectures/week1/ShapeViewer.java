package week1;

//import extra.week1.Shape;
//import extra.week1.Delay;
import extra.week1.*;

public class ShapeViewer {

	public static void main(String[] args) {
		// final int num = 5;
		final int num = Integer.parseInt(args[0]);
		final int width = 392;
		final int height = 268;
		// int [] x = {195,300,250,150,100};
		// int [] y = {50,135,250,220,100};
		int[] x = new int[num];
		int[] y = new int[num];
		int[] xDir = new int[num];
		int[] yDir = new int[num];

		Shape.create();
		// initialize vertices
		for (int i = 0; i < x.length; i++) {
			x[i] = (int) (width * Math.random());
			y[i] = (int) (height * Math.random());
		}
		Shape.draw(x, y);
		while (true) {
			// pick random directions for each vertex to move in
			for (int i = 0; i < x.length; i++) {
				xDir[i] = (int) (3 * Math.random()) - 1;
				yDir[i] = (int) (3 * Math.random()) - 1;
			}
			for (int i = 0; i < 150; i++) {
				// move vertices in the given directions
				Delay.milliseconds(10);
				for (int j = 0; j < x.length; j++) {
					if (x[j] == 0 && xDir[j] == -1) {
						xDir[j] = 1;
					}
					if (x[j] == width && xDir[j] == 1) {
						xDir[j] = -1;
					}
					if (y[j] == 0 && yDir[j] == -1) {
						yDir[j] = 1;
					}
					if (y[j] == height && yDir[j] == 1) {
						yDir[j] = -1;
					}
					x[j] = x[j] + xDir[j];
					y[j] += yDir[j];
				}
				System.out.println("\n" + x.toString());
				Shape.draw(x, y);
			}
		}

	}
}

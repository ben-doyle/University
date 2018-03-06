package prac1;

import javax.swing.*;
import java.awt.*;

/** A panel for displaying the Neko the Cat animation. */
@SuppressWarnings("serial")
public class NekoPanel extends JPanel {
	
	// still images of Neko the Cat
	private Image [] nekoPics = new Image[9];
	// current image
	private Image currentImage = null;
	// x-position of the current image
	private int xPos;
	// y-position of the current image
	private int yPos = 30;
	
	/** Create a new NekoPanel. */
	public NekoPanel() {
		setBackground(Color.white);
		// the image files
		String nekosrc[] = { "images/right1.gif", "images/right2.gif",
				"images/stop.gif", "images/yawn.gif", "images/scratch1.gif",
				"images/scratch2.gif", "images/sleep1.gif", "images/sleep2.gif",
				"images/awake.gif" };
		// toolkit to create image object from .gif file
		Toolkit tk = Toolkit.getDefaultToolkit();
		for (int i=0; i < nekoPics.length; i++) 
			nekoPics[i] = tk.getImage(nekosrc[i]);
	}
	
	/** Display the current state of the animation. */
	public void paint(Graphics g) {
		super.paintComponent(g);
		g.drawImage(currentImage, xPos, yPos, this);
	}
	
	/** Run the animation. */
	public void nekoRun() {
		moveIn();
		nekoScratch();
		nekoScratch(3);
		moveOut();
		nekoSleep();
	}
	
	/* Move Neko to the centre of the panel. */
	private void moveIn() {
		for (int i = 0; i < getWidth()/2; i+=10) {
			xPos = i;
			// swap images
			if (currentImage == nekoPics[0]) 
				currentImage = nekoPics[1];
			else 
				currentImage = nekoPics[0];
			repaint();
			pause(150);
		}	
	}
	
	/* Move Neko from the centre to the end of the panel. */
	private void moveOut() {
		for (int i = getWidth()/2; i < getWidth() - 30 ; i+=10) {
			xPos = i;
			// swap images
			if (currentImage == nekoPics[0]) 
				currentImage = nekoPics[1];
			else 
				currentImage = nekoPics[0];
			repaint();
			pause(150);
		}	
	}
	
	/* Have neko scratch his neck twice */
	private void nekoScratch() {
		for (int i = 0; i < 4; i += 1) {
			if (currentImage == nekoPics[4]) 
				currentImage = nekoPics[5];
			else 
				currentImage = nekoPics[4];
			repaint();
			pause(150);
		}

	}
	
	/* Have neko scratch his neck num of times */
	private void nekoScratch(int num) {
		for (int i = 0; i < num * 2; i += 1) {
			if (currentImage == nekoPics[4]) 
				currentImage = nekoPics[5];
			else 
				currentImage = nekoPics[4];
			repaint();
			pause(150);
		}

	}
	
	/* Have neko sleep at the end of the frame */
	private void nekoSleep() {
		for (int i = 0; i < 50; i += 1) {
			if (currentImage == nekoPics[6]) 
				currentImage = nekoPics[7];
			else 
				currentImage = nekoPics[6];
			repaint();
			pause(350);
		}

	}
	
	/* Wait for "time" milliseconds. */
	private void pause(int time) {
	    try {Thread.sleep(time);}
	    catch (InterruptedException e ) { }
    }
	
}

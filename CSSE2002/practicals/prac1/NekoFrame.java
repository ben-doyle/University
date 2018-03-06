package prac1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/** A window for displaying the Neko the Cat animation. */
@SuppressWarnings("serial")
public class NekoFrame extends JFrame {

	// a panel for displaying the animation
	private NekoPanel panel = new NekoPanel();
	
	/** Create a new NekoFrame. */
	public NekoFrame() {
		setTitle("Neko the Cat");
		setBounds(100,50,440,100);
		Container c = getContentPane();
		c.add(panel);
		addWindowListener(new WindowAdapter ( ) {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}
	
	/** Start the animation. */  
	public void nekoRun() {
		panel.nekoRun();
	}
}


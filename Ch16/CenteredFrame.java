// CenteredFrame.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import javax.swing.*;
import java.awt.*;

// This special subclass of JFrame will automatically center itself!
// We can use it anywhere that we'd use a JFrame; the client code would
// look as follows:
/*
	CenteredFrame myFrame = new CenteredFrame("Self-Centering Frame", 200, 200);

	// Add whatever components we wish, just as we do with a JFrame (because
	// a CenteredFrame IS a JFrame) ... details omitted.

	// Make the frame visible.
	myFrame.setVisible(true);
*/

public class CenteredFrame extends JFrame {
	// Constructor.
	public CenteredFrame(String title, int width, int height) {
		super(title);
           	super.setSize(width, height);  

		Dimension frameSize = this.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		// Compute the center of the screen.
		int centerX = screenSize.width/2;
		int centerY = screenSize.height/2;

		// We want half of the frame to be to the left of center,
		// and half to be above center.
		int halfWidth = frameSize.width/2;
		int halfHeight = frameSize.height/2;
		this.setLocation(centerX - halfWidth, centerY - halfHeight);

		// We WON'T make the frame appear on the screen; we'll allow the 
		// client code using this class to do so.
      	}

	// "Test scaffold" main method.
	public static void main(String[] args) {
		CenteredFrame cf = new CenteredFrame("Taa daa", 200, 200);
		cf.setVisible(true);
	}
}

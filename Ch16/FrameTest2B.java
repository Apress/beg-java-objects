// FrameTest2B.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import javax.swing.*;

// Import a few classes from the AWT API.

import java.awt.Dimension;
import java.awt.Toolkit;

public class FrameTest2B {
	public static void main(String[] args) {
		// Create the frame by calling the appropriate constructor 
		// (we are passing in a title to the frame).

           	JFrame theFrame = new JFrame("Whee!!!");

		// Set the size to something reasonable (the default JFrame
		// size is 0 pixels wide by 0 pixels high, which isn't visible).

           	theFrame.setSize(200, 200);  // width, height in pixels

		// Technique for centering a frame on the screen.

		// First, obtain the size of the frame to be centered.  
		// Invoking the getSize() method on a Component returns
		// returns a Dimension object which in turn has two 
		// public int attributes:  width (in pixels) and height
		// (in pixels).

		Dimension frameSize = theFrame.getSize();

		// Now, invoke the static getDefaultToolkit() method on the
		// Toolkit class to obtain a handle on the AWT Toolkit object 
		// for this platform, and then invoke its getScreenSize()
		// method to obtain a second Dimension object.

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		// We want the offset of the upper left hand corner of the
		// frame to "split the difference" between the screen size
		// and the frame size.

		theFrame.setLocation((screenSize.width - frameSize.width)/2, 
			             (screenSize.height - frameSize.height)/2);

		// Make the frame appear on the screen.

           	theFrame.setVisible(true);
      	}
}

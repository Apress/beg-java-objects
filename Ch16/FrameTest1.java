// FrameTest1.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import javax.swing.*;

public class FrameTest1 {
	public static void main(String[] args) {
		// Create the frame by calling the appropriate constructor 
		// (we are passing in a title to the frame).

           	JFrame theFrame = new JFrame("Whee!!!");

		// Set the size to something reasonable (the default JFrame
		// size is 0 pixels wide by 0 pixels high, which isn't visible).

           	theFrame.setSize(200, 200);  // width, height in pixels

		// Position the upper left hand corner of the frame
		// at the coordinate (300, 400).

		theFrame.setLocation(300, 400);

		// Make the frame appear on the screen.

           	theFrame.setVisible(true);
      	}
}

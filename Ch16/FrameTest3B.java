// FrameTest3B.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// Note that we can import individual classes, to better document where
// each class that we are using originates.

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Container;
import java.awt.Toolkit;
import java.awt.Dimension;

public class FrameTest3B {
	public static void main(String[] args) {
		// Create the frame by calling the appropriate constructor 
		// (we are passing in a title to the frame).

           	JFrame theFrame = new JFrame("Whee!!!");

		// Set the size to something reasonable (the default JFrame
		// size is 0 pixels wide by 0 pixels high, which isn't visible).

           	theFrame.setSize(200, 200);  // width, height in pixels

		// Technique for centering a frame on the screen.

		Dimension frameSize = theFrame.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		theFrame.setLocation((screenSize.width - frameSize.width)/2, 
				         (screenSize.height - frameSize.height)/2);

		// Let's add a component.

		Container contentPane = theFrame.getContentPane( );
		JLabel stuff = new JLabel("I am a label");
		contentPane.add(stuff);

		// Make the frame appear on the screen.

           	theFrame.setVisible(true);
      	}
}

// DialogDriver.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import javax.swing.*;

public class DialogDriver {
	public static void main(String[] args) {
		// Create a frame to serve as the parent for the dialog.
           	JFrame theFrame = new JFrame("Daddy Frame");
           	theFrame.setSize(200, 200);  // width, height in pixels
           	theFrame.setVisible(true);

		// Now, create and display a custom dialog!
		// Because the dialog's constructor contains the
		// logic to make the dialog visible, we needn't do
		// so in this program.
		MyDialog theDialog = new MyDialog(theFrame);
      	}
}

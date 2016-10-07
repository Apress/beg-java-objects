// FrameTest6B.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import javax.swing.*;
import java.awt.*;

public class FrameTest6B {
	public static void main(String[] args) {
		// Create the frame by calling the appropriate constructor 
		// (we are passing in a title to the frame).

           	JFrame theFrame = new JFrame("Whee!!!");

		// Set the size to something reasonable (the default JFrame
		// size is 0 pixels wide by 0 pixels high, which isn't visible).

           	theFrame.setSize(400, 400);  // width, height in pixels

		// Technique for centering a frame on the screen.

		Dimension frameSize = theFrame.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		theFrame.setLocation((screenSize.width - frameSize.width)/2, 
			             (screenSize.height - frameSize.height)/2);

		// Assign a grid layout to the frame.

		Container contentPane = theFrame.getContentPane( );
		contentPane.setLayout(new GridLayout(3, 2));  // 3 rows, 2 cols.

		// Create some components to attach.

 		JLabel l = new JLabel("Name:");
 		JLabel l2 = new JLabel("Address:");
 		JLabel l3 = new JLabel("SSN:");

		// This next component, a text area, is a multi-line 
		// text component; we're asking for it to be six lines
		// "tall" vs. 20 characters wide.

 		JTextArea t = new JTextArea("This is a MULTI-LINE text area, " +
					    "which can contain a lot of text." +
					    "  We've asked it to wrap along " +
					    "word boundaries.",
					    6, 20);

		// Turn on line wrapping ...
		t.setLineWrap(true);

		// ... along word boundaries.
		t.setWrapStyleWord(true);

		// Creating two single-line text fields.

 		JTextField t2 = new JTextField("This is a SINGLE LINE text field.");
 		JTextField t3 = new JTextField("Another text field.");

 		// Add in ascending row, then column, order.

 		contentPane.add(l);    	// row 1, col. 1
 		contentPane.add(t);	// row 1, col. 2
 		contentPane.add(l2);   	// row 2, col. 1 (etc.)
 		contentPane.add(t2);
 		contentPane.add(l3);
 		contentPane.add(t3);

		// Create ONE TOO MANY component!

 		JTextField t4 = new JTextField("ONE TOO MANY! :op");

		// Add it, even though there really is no more room.

		contentPane.add(t4);

             	theFrame.setVisible(true);
         }
 }

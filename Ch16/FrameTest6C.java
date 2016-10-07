// FrameTest6C.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import javax.swing.*;
import java.awt.*;

public class FrameTest6C {
	public static void main(String[] args) {
		// Create the frame by calling the appropriate constructor 
		// (we are passing in a title to the frame).

           	JFrame theFrame = new JFrame();

		// Set the size to something reasonable (the default JFrame
		// size is 0 pixels wide by 0 pixels high, which isn't visible).

           	theFrame.setSize(300, 300);  // width, height in pixels

		// Technique for centering a frame on the screen.

		Dimension frameSize = theFrame.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		theFrame.setLocation((screenSize.width - frameSize.width)/2, 
				         (screenSize.height - frameSize.height)/2);

		// Assign a grid layout to the frame.

		Container contentPane = theFrame.getContentPane( );
		contentPane.setLayout(new GridLayout(3, 2));  // 3 rows, 2 cols.

		// Create some components to attach.

 		JLabel l1 = new JLabel("Name:");
 		JLabel l2 = new JLabel("Fred");
 		JLabel l3 = new JLabel("SSN:");
 		JLabel l4 = new JLabel("123-45-6789");

 		// Add in ascending row, then column, order.

 		contentPane.add(l1);    	   // row 1, col. 1
 		contentPane.add(l2);	           // row 1, col. 2

		// Create two blank labels "on the fly", and add them
		// to the 2nd row.

 		contentPane.add(new JLabel(""));   // row 2, col. 1
 		contentPane.add(new JLabel(""));   // row 2, col. 2

 		contentPane.add(l3);	           // row 3, col. 1
 		contentPane.add(l4);		   // row 3, col. 2

             	theFrame.setSize(200, 200);
             	theFrame.setVisible(true);
         }
 }

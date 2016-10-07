// FrameTest7.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import javax.swing.*;
import java.awt.*;

public class FrameTest7 {
	public static void main(String[] args) {
		// Create the frame by calling the appropriate constructor 
		// (we are passing in a title to the frame).

           	JFrame theFrame = new JFrame("Whee!!!");

		// Technique for centering a frame on the screen.

		Dimension frameSize = theFrame.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		theFrame.setLocation((screenSize.width - frameSize.width)/2, 
				         (screenSize.height - frameSize.height)/2);

		// Override the default layout manager.

		Container contentPane = theFrame.getContentPane( );
		contentPane.setLayout(new FlowLayout());

		// Create several labels.

		JLabel l1 = new JLabel("A short label");
		JLabel l2 = new JLabel("A rather long label");
		JLabel l3 = new JLabel("Another fairly long label");

		// Play with the colors.

		l1.setBackground(Color.cyan);
		l1.setForeground(Color.black);
		l2.setBackground(Color.white);
		l2.setForeground(Color.black);
		l3.setBackground(Color.yellow);
		l3.setForeground(Color.black);

		// Make the labels opaque (the default is transparent)
		// so that their background colors show up.

		l1.setOpaque(true);
		l2.setOpaque(true);
		l3.setOpaque(true);

		// Add them to the GUI.

		contentPane.add(l1);
		contentPane.add(l2);
		contentPane.add(l3);

		// Set the size to something reasonable (the default is 0 x 0,
		// which isn't visible).

              	theFrame.setSize(200,200);  // width, height

		// Make the frame appear on the screen.

              	theFrame.setVisible(true);
       }
}

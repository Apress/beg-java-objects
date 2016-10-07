// EditableExample.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import java.awt.*;
import javax.swing.*;

public class EditableExample {
	public static void main(String args[]) {
              	JFrame theFrame = new JFrame("");
		Container contentPane = theFrame.getContentPane( );
		contentPane.setLayout(new GridLayout(4, 1)); 

 		JTextField l1 = new JTextField("Editable and Enabled");
		l1.setEditable(true);
		l1.setEnabled(true);
 		JTextField l2 = new JTextField("Editable and Disabled");
		l2.setEditable(true);
		l2.setEnabled(false);
 		JTextField l3 = new JTextField("Not Editable and Enabled");
		l3.setEditable(false);
		l3.setEnabled(true);
 		JTextField l4 = new JTextField("Not Editable and Disabled");
		l4.setEditable(false);
		l4.setEnabled(false);

 		contentPane.add(l1);
 		contentPane.add(l2);
 		contentPane.add(l3);
 		contentPane.add(l4);
 
              	theFrame.setSize(300, 200);
              	theFrame.setVisible(true);
         }
 }

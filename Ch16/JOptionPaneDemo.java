// JOptionPaneDemo.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import javax.swing.*;

public class JOptionPaneDemo {
  	public static void main(String[] args) {
		// We'll demo only one of the flavors of JOptionPane:
		// namely, a message dialog, which simply displays a 
		// message, and automatically provides an "OK" button 
		// for dismissing the dialog.

		// This static method call takes four arguments:
		//
		// The first is a reference to the "parent"
		// component, and can be left null.
		//
		// The second is the message text.
		//
		// The third is the title for the dialog.
		//
		// The fourth is a constant defined by the 
		// JOptionPane class to 
		JOptionPane.showMessageDialog(
			null, 
			"Click this dialog when you are ready.",
			"Whenever",
			JOptionPane.INFORMATION_MESSAGE);
	}
}

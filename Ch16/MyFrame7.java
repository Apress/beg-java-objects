// MyFrame7.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MyFrame7 extends JFrame {
	JButton showButton;

	// Constructor.
	public MyFrame7() {
		super("Main GUI Window");
 		showButton = new JButton("Click Me");

		this.getContentPane().setLayout(new GridLayout(3, 1));
		this.getContentPane().add(new Label("Here is a button:"));  
		this.getContentPane().add(showButton);
		this.getContentPane().add(new Label("(Big deal!)")); 

		this.setSize(200, 100);

		showButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Create and display a dialog.
				MyDialog my = new MyDialog(MyFrame7.this);
			}
		});

		// Always make the setVisible call the LAST call in
		// the constructor.  For some strange reason, if you
		// don't, then the listeners don't always work 
		// properly.
		this.setVisible(true);
	}

	// An inner class.
	class MyDialog extends JDialog {
		JButton okButton;

		// Constructor.
		public MyDialog(JFrame parent) {
			// Let's make it modal.
			super(parent, "Modal Dialog", true); 

			okButton = new JButton("OK");

			this.getContentPane().setLayout(new GridLayout(3, 3));
			this.getContentPane().add(new Label(""));  
			this.getContentPane().add(new Label(""));  
			this.getContentPane().add(new Label(""));  
			this.getContentPane().add(new Label(""));  
			this.getContentPane().add(okButton);
			this.getContentPane().add(new Label(""));  
			this.getContentPane().add(new Label(""));  
			this.getContentPane().add(new Label(""));  
			this.getContentPane().add(new Label("")); 

			this.setSize(200, 100);

			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// Close the dialog.
					System.out.println("OK clicked");
					MyDialog.this.dispose();
				}
			});

			// Always make the setVisible call the LAST call in
			// the constructor.  For some strange reason, if you
			// don't, then the listeners don't always work 
			// properly.
			this.setVisible(true);
		}
	}

	// Test scaffold.
	public static void main(String[] args) {
		MyFrame7 mf = new MyFrame7();
	}
}
		

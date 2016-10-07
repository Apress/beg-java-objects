// MyDialog.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MyDialog extends JDialog {
	// Components as attributes.

	JButton okButton;

	// Constructor.

	// We need to pass in a reference to the "parent" frame from
	// which this dialog was launched, because we will need to
	// hand it, in turn, to the generic JDialog constructor
	// (see the first line of code inside of the constructor).

	public MyDialog(JFrame parent) {
		// Let's make this dialog modal by invoking the generic
		// JDialog constructor with a value of "true" for the 
		// final argument.  We're also passing through the
		// reference to our parent frame, as the first argument.

		super(parent, "Modal Dialog", true); 

		okButton = new JButton("OK");

		this.getContentPane().setLayout(new GridLayout(3, 1));
		this.getContentPane().add(new Label(""));  
		this.getContentPane().add(okButton);
		this.getContentPane().add(new Label("")); 

		this.setSize(200, 100);

		// Attach an ActionListener to the button, so that
		// when it is clicked, the dialog will close.  

		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Close the dialog.
				System.out.println("OK clicked");
				MyDialog.this.setVisible(false);
				MyDialog.this.dispose();

				// Note that we DON'T call System.exit(0),
				// because if we did, then the whole 
				// application will come to a screeching 
				// halt when the dialog is closed.
				// NO!!!!!!  System.exit(0);
			}
		});

		// If we also want to be able to close the dialog via
		// the "close" button at the upper right hand corner
		// of the dialog, we have to provide a WindowListener,
		// as well.
		WindowListener w = new WindowAdapter() { 
		    public void windowClosing(WindowEvent e) {
			// Note the need to preface "this." with
			// the name of the outer class.
			MyDialog.this.setVisible(false);
			MyDialog.this.dispose();

			// Note that we DON'T call System.exit(0),
			// because if we did, then the whole application
			// will come to a screeching halt when the
			// dialog is closed.
			// NO!!!!!!  System.exit(0);
		    }
		};  

		this.addWindowListener(w);

		// Always make the setVisible call the LAST call in
		// the constructor.  For some strange reason, if you
		// don't, then the listeners don't always work 
		// properly.

		this.setVisible(true);
	}
}

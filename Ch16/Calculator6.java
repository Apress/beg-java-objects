// Calculator6.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import java.awt.*;
import javax.swing.*;
import java.awt.event.*; // added

public class Calculator6 extends JFrame {
	// Components are treated as attributes, so that they will be
	// visible to all of the methods of the class.

	private Container contentPane;

	// Use descriptive names for components where possible; it makes
	// your job easier later on!

	private JPanel leftPanel; 
	private JPanel centerPanel; 
	private JPanel buttonPanel; 
	private JTextField input1TextField; 
	private JTextField input2TextField; 
	private JLabel answerLabel; 
	private JButton plusButton; 
	private JButton minusButton; 

	// Constructor.
	public Calculator6() {	
		// Invoke the generic JFrame constructor.
		super("Simple Calculator");

		// The content pane container is now declared to be an
		// attribute.  Note that the use of "this." is unnecessary;
		// we could have simply written:
		// contentPane = getContentPane();
		contentPane = this.getContentPane();
		this.setSize(250, 100);

		// Technique for centering a frame on the screen.
		Dimension frameSize = this.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - frameSize.width)/2, 
			             (screenSize.height - frameSize.height)/2);

		leftPanel = new JPanel();
		leftPanel.setLayout(new GridLayout(3, 1));
		leftPanel.add(new JLabel("Input 1:  "));
		leftPanel.add(new JLabel("Input 2:  "));
		leftPanel.add(new JLabel("Answer:  "));
		contentPane.add(leftPanel, BorderLayout.WEST);

		centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(3, 1));
		input1TextField = new JTextField(10);
		input2TextField = new JTextField(10);
		answerLabel = new JLabel();
		centerPanel.add(input1TextField);
		centerPanel.add(input2TextField);
		centerPanel.add(answerLabel);
		contentPane.add(centerPanel, BorderLayout.CENTER);

		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(2, 1));
		plusButton = new JButton("+");
		minusButton = new JButton("-");
		buttonPanel.add(plusButton);
		buttonPanel.add(minusButton);
		contentPane.add(buttonPanel, BorderLayout.EAST);

		// Add behaviors!  

		ActionListener l = new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
			double d1 = 
			    Double.parseDouble(input1TextField.getText());
			double d2 = 
			    Double.parseDouble(input2TextField.getText());
			if (e.getSource() == plusButton)
				answerLabel.setText("" + (d1 + d2));
			else answerLabel.setText("" + (d1 - d2));
		    }
		};

		plusButton.addActionListener(l);
		minusButton.addActionListener(l);

		// We want to use a WindowListener to terminate the
		// application when the user closes the window.
		// Create the listener as an instance of an anonymous
		// inner class ...

		WindowListener w = new WindowAdapter() { 
		    public void windowClosing(WindowEvent e) {
			// Note the need to preface "this." with
			// the name of the outer class.
			Calculator6.this.dispose();
			System.exit(0);
		    }

                    // Because we are using an Adapter class vs. a Listener
		    // interface, we don't have to "stub out" the other six 
		    // methods ... "do-nothing" versions of these are 
		    // inherited from WindowAdapter.
		};  

		// ... and register it with the frame, since it will be
		// the JFrame object that generates the window closing
		// event.

		this.addWindowListener(w);

  		this.setVisible(true);
  	}

	public static void main(String[] args) {
		// Instantiate the calculator!
		new Calculator6();
	}
}

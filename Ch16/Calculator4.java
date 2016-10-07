// Calculator4.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import java.awt.*;
import javax.swing.*;
import java.awt.event.*; // added

public class Calculator4 extends JFrame {
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
	public Calculator4() {	
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

		// Add behaviors!  This time we use the SAME
		// listener object to listen to BOTH buttons.

		ActionListener l = new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
			double d1 = 
			    Double.parseDouble(input1TextField.getText());
			double d2 = 
			    Double.parseDouble(input2TextField.getText());
			// By retrieving the source of the event, and
			// testing its identity, we can determine where
			// the event originated, and act accordingly:
			// if the source was the plusButton, we add the 
			// two values; otherwise, we subtract.

			if (e.getSource() == plusButton)
				answerLabel.setText("" + (d1 + d2));
			else answerLabel.setText("" + (d1 - d2));
		    }
		};

		plusButton.addActionListener(l);
		minusButton.addActionListener(l);

  		this.setVisible(true);
  	}

	public static void main(String[] args) {
		// Instantiate the calculator!
		new Calculator4();
	}
}

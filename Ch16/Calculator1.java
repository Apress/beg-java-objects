// Calculator1.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import java.awt.*;
import javax.swing.*;

public class Calculator1 {
	public static void main(String[ ] args) {
		JFrame aFrame = new JFrame("Simple Calculator");
		Container contentPane = aFrame.getContentPane();
		aFrame.setSize(250, 100);

		// We don't need to set the layout manager for
		// a JFrame's content pane - it is automatically a 
		// BorderLayout by default!

		// Technique for centering a frame on the screen.

		Dimension frameSize = aFrame.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		aFrame.setLocation((screenSize.width - frameSize.width)/2, 
			             (screenSize.height - frameSize.height)/2);

		// Let's create the leftmost panel.  Note that we use names
		// for our components that are somewhat self-documenting.

		JPanel leftPanel = new JPanel();

		// We'll assign the panel a GridLayout (it would otherwise
		// default to FlowLayout).

		leftPanel.setLayout(new GridLayout(3, 1));

		// We'll create three labels on the fly and hand them
		// to the panel; there's no need to bother maintaining
		// a named handle on any of these labels.

		leftPanel.add(new JLabel("Input 1:  "));
		leftPanel.add(new JLabel("Input 2:  "));
		leftPanel.add(new JLabel("Answer:  "));

		// Now, we'll attach the panel to the frame.

		contentPane.add(leftPanel, BorderLayout.WEST);

		// Repeat the process with the center panel.

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(3, 1));
		JTextField input1TextField = new JTextField(10);
		JTextField input2TextField = new JTextField(10);

		// We use a JLabel to display the answer of the
		// calculation, although we could have also used
		// a non-editable JTextField instead.

		JLabel answerLabel = new JLabel();
		centerPanel.add(input1TextField);
		centerPanel.add(input2TextField);
		centerPanel.add(answerLabel);
		contentPane.add(centerPanel, BorderLayout.CENTER);

		// The third, and final, panel.

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(2, 1));
		JButton plusButton = new JButton("+");
		JButton minusButton = new JButton("-");
		buttonPanel.add(plusButton);
		buttonPanel.add(minusButton);
		contentPane.add(buttonPanel, BorderLayout.EAST);

  		aFrame.setVisible(true);
  	}
}

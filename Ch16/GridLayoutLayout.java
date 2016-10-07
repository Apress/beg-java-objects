// GridLayoutLayout.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import javax.swing.*;
import java.awt.*;

public class GridLayoutLayout extends JFrame {
	public GridLayoutLayout() {
		this.getContentPane().setLayout(new GridLayout(3, 2));
		this.getContentPane().add(new JButton("Row 1, Column 1"));
		this.getContentPane().add(new JButton("Row 1, Column 2"));
		this.getContentPane().add(new JButton("Row 2, Column 1"));
		this.getContentPane().add(new JButton("Row 2, Column 2"));
		this.getContentPane().add(new JButton("Row 3, Column 1"));
		this.getContentPane().add(new JButton("Row 3, Column 2"));
		this.setSize(400, 200);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new GridLayoutLayout();
	}
}
	

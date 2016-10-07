// BorderLayoutLayout.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import javax.swing.*;
import java.awt.*;

public class BorderLayoutLayout extends JFrame {
	public BorderLayoutLayout() {
		JButton north = new JButton();
		north.setLayout(new GridLayout(3, 1));
		JLabel l1 = new JLabel("NORTH", JLabel.CENTER);
		l1.setForeground(Color.black);
		north.add(new JLabel(""));
		north.add(l1);
		north.add(new JLabel(""));
		JButton south = new JButton();
		south.setLayout(new GridLayout(3, 1));
		JLabel l2 = new JLabel("SOUTH", JLabel.CENTER);
		l2.setForeground(Color.black);
		south.add(new JLabel(""));
		south.add(l2);
		south.add(new JLabel(""));
		JButton east = new JButton("  EAST  ");
		JButton west = new JButton("  WEST  ");
		JButton center = new JButton("CENTER");
		this.getContentPane().add(north, BorderLayout.NORTH);
		this.getContentPane().add(south, BorderLayout.SOUTH);
		this.getContentPane().add(east, BorderLayout.EAST);
		this.getContentPane().add(west, BorderLayout.WEST);
		this.getContentPane().add(center, BorderLayout.CENTER);
		this.setSize(400, 300);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new BorderLayoutLayout();
	}
}
	

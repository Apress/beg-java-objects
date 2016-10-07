// BorderLayoutLayout3.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import javax.swing.*;
import java.awt.*;

public class BorderLayoutLayout3 extends JFrame {
	public BorderLayoutLayout3() {
		JButton center = new JButton("CENTER");
		this.getContentPane().add(center, BorderLayout.CENTER);
		this.setSize(400, 300);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new BorderLayoutLayout3();
	}
}
	

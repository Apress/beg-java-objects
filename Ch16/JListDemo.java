// JListDemo.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import javax.swing.*;
import java.awt.*;

public class JListDemo {
	public static void main(String[] args) {
		JFrame theFrame = new JFrame("Sample JList");
		Container contentPane = theFrame.getContentPane( );

		// Create a Collection of students.
		Student[] v = new Student[3];
		v[0] = new Student("123456789", "Joe Blow");
		v[1] = new Student("987654321", "Fred Schnurd");
		v[2] = new Student("000000000", "Englebert Humperdink");

		// Create a list based on this Collection.  The reason that
		// we can do this is because the Student class defines
		// a toString() method, which causes each Student object to 
		// be rendered in terms of its name and SSN in the list.
		JList myList = new JList(v);
		contentPane.add(myList);

	       	theFrame.setSize(300, 100);  
	       	theFrame.setVisible(true);
	}
}

// JListDemo2.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*; // added

public class JListDemo2 {
	public static void main(String[] args) {
		JFrame theFrame = new JFrame("Sample JList");
		Container contentPane = theFrame.getContentPane();

		// Create a Collection of students.
		Student[] v = new Student[3];
		v[0] = new Student("123456789", "Joe Blow");
		v[1] = new Student("987654321", "Fred Schnurd");
		v[2] = new Student("000000000", "Englebert Humperdink");

		// Create a list based on this collection.  
		JList myList = new JList(v);
		contentPane.add(myList);

		// Add a listener to note when an item has been selected.
		ListSelectionListener lListener = new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				// When an item is selected in this list,
				// display it at the command line.
				JList list = (JList) e.getSource();

				if (!(list.isSelectionEmpty())) {
				    Student s = (Student) list.getSelectedValue();
				    System.out.println("Selected " + s);
				}
				else System.out.println("Nothing is selected.");
			}
		};

		myList.addListSelectionListener(lListener);

	       	theFrame.setSize(300, 100); 
	       	theFrame.setVisible(true);
	}
}

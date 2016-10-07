// JListDemo4.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import java.awt.*;
import javax.swing.*;
import java.awt.event.*; 

public class JListDemo4 extends JFrame {
    private JList myList;

    public JListDemo4() {
        super("Sample JList");
        Container contentPane = this.getContentPane();

        // Create a Collection of students.
        Student[] v = new Student[3];
        v[0] = new Student("123456789", "Joe Blow");
        v[1] = new Student("987654321", "Fred Schnurd");
        v[2] = new Student("000000000", "Englebert Humperdink");

        // Create a list based on this collection.  
        myList = new JList(v);
        contentPane.add(myList, BorderLayout.CENTER);

        // Create a button that will pull the selected entry
        // from the list when the button is clicked.
        JButton selectButton = new JButton("Select");
        contentPane.add(selectButton, BorderLayout.SOUTH);

        // Add a listener to the button.
        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Student s = (Student) myList.getSelectedValue();
                System.out.println("Selected " + s);
            }
        };

        selectButton.addActionListener(listener);

        this.setSize(300, 130);  
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new JListDemo4();
    }
}

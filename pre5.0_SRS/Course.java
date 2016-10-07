// Course.java - Chapter 14, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// A MODEL class.


import java.util.ArrayList;
import java.util.Collection;

public class Course {
	//------------
	// Attributes.
	//------------

	private String courseNo;
	private String courseName;
	private double credits;
	private ArrayList offeredAsSection; // of Sections 
	private ArrayList prerequisites; // of Courses 
	
	//----------------
	// Constructor(s).
	//----------------

	public Course(String cNo, String cName, double credits) {
		setCourseNo(cNo);
		setCourseName(cName);
		setCredits(credits);

		// Note that we're instantiating empty support Collection(s).

		offeredAsSection = new ArrayList();
		prerequisites = new ArrayList();
	}

	//------------------
	// Accessor methods.
	//------------------

	public void setCourseNo(String cNo) {
		courseNo = cNo;
	}
	
	public String getCourseNo() {
		return courseNo;
	}
	
	public void setCourseName(String cName) {
		courseName = cName;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public void setCredits(double c) {
		credits = c;
	}
	
	public double getCredits() {
		return credits;
	}
	
	//-----------------------------
	// Miscellaneous other methods.
	//-----------------------------

	public void display() {
		System.out.println("Course Information:");
		System.out.println("\tCourse No.:  " + getCourseNo());
		System.out.println("\tCourse Name:  " + getCourseName());
		System.out.println("\tCredits:  " + getCredits());
		System.out.println("\tPrerequisite Courses:");

		for (int i = 0; i < prerequisites.size(); i++) {
			Course c = (Course) prerequisites.get(i);
			System.out.println("\t\t" + c.toString());
		}

		// Note use of print vs. println in next line of code.

		System.out.print("\tOffered As Section(s):  ");
		for (int i = 0; i < offeredAsSection.size(); i++) {
			Section s = (Section) offeredAsSection.get(i);
			System.out.print(s.getSectionNo() + " ");
		}

		// Finish with a blank line.

		System.out.println();
	}
	
	public String toString() {
		return getCourseNo() + ":  " + getCourseName();
	}

	public void addPrerequisite(Course c) {
		prerequisites.add(c);
	}

	public boolean hasPrerequisites() {
		if (prerequisites.size() > 0) return true;
		else return false;
	}

	public Collection getPrerequisites() {
		return prerequisites;
	}

	public Section scheduleSection(char day, String time, String room,
				       int capacity) {
		// Create a new Section (note the creative way in
		// which we are assigning a section number) ...

		Section s = new Section(offeredAsSection.size() + 1, 
				day, time, this, room, capacity);
		
		// ... and then remember it!

		addSection(s);
		
		return s;
	}

	public void addSection(Section s) {
		offeredAsSection.add(s);
	}
}

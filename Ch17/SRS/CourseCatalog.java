// CourseCatalog.java - Chapter 15, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// An IMPLEMENTATION class.


// As mentioned in Chapter 14, we've decided to encapsulate a Collection
// of Courses within the CourseCatalog class the way that we encapsulated a
// Collection of Sections within the ScheduleOfClasses class in Chapter 14.
// This provides an increased level of abstraction in our application.

import java.util.*;
import java.io.*;

public class CourseCatalog {
	//------------
	// Attributes.
	//------------

	// This HashMap stores Course object references, using
	// the course no. of the Course (a String) as the key.

	private HashMap<String, Course> courses;

	//----------------
	// Constructor(s).
	//----------------

	public CourseCatalog() {
		// Note that we're instantiating empty support Collection(s).

		courses = new HashMap<String, Course>();
	}

	//------------------
	// Accessor methods.
	//------------------

	// None!

	//-----------------------------
	// Miscellaneous other methods.
	//-----------------------------

	public void display() {
		// Iterate through the HashMap and display all entries.

		for (Course c : courses.values()) {
			c.display();
			System.out.println();
		}
	}

	public void addCourse(Course c) {
		// We use the course no. as the key.

		String key = c.getCourseNo();
		courses.put(key, c);
	}

	public Course findCourse(String courseNo) {
		return courses.get(courseNo);
	}

	public boolean isEmpty() {
		if (courses.size() == 0) return true;
		else return false;
	}
}

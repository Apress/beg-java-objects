// Faculty.java - Chapter 15, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// An IMPLEMENTATION class.


// As mentioned in Chapter 14, we've decided to encapsulate a Collection
// of Professors within the Faculty class the way that we encapsulated a
// Collection of Sections within the ScheduleOfClasses class in Chapter 14.
// This provides an increased level of abstraction in our application.

import java.util.*;
import java.io.*;

public class Faculty {
	//------------
	// Attributes.
	//------------

	// This HashMap stores Professor object references, using
	// the (String) ssn of the Professor as the key.

	private HashMap<String, Professor> professors;

	//----------------
	// Constructor(s).
	//----------------

	public Faculty() {
		// Note that we're instantiating empty support Collection(s).

		professors = new HashMap<String, Professor>();
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

		for (Professor p : professors.values()) {
			p.display();
			System.out.println();
		}
	}

	public void addProfessor(Professor p) {
		professors.put(p.getSsn(), p);
	}

	public Professor findProfessor(String ssn) {
		return (Professor) professors.get(ssn);
	}

	public boolean isEmpty() {
		if (professors.size() == 0) return true;
		else return false;
	}
}

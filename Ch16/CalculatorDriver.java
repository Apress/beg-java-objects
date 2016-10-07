// CalculatorDriver.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

public class CalculatorDriver {
	// We use public static attributes to make data/objects "globally
	// accessible" to an application as a whole.  In this simple
	// example, we don't have a need to do so; but, we will do so
	// when we develop the SRS GUI.
	public static void main(String[] args) {
		// Instantiate the main window and maintain a
		// handle on it -- the Calculator constructor does the 
		// rest of the work!
		new Calculator2();
	}
}


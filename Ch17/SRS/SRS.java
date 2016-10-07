// SRS.java - Chapter 16, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// The main driver for the command-line driven version of the SRS, with
// a graphical user interface and object persistence added.


import java.util.*;

public class SRS {
	// We can effectively create "global" data by declaring
	// collections of objects as public static attributes in 
	// the main class; these can then be accessed throughout the
	// SRS application as:  SRS.collectionName; e.g., SRS.faculty.  

	public static Faculty faculty; 
	public static CourseCatalog courseCatalog; 
	public static ScheduleOfClasses scheduleOfClasses;

	// We aren't creating a collection for Student objects, however, because
	// we're only going to handle one Student at a time -- namely, whichever 
	// Student is currently logged on.

	public static void main(String[] args) {
		// Initialize all objects.  The method by which we are accessing
		// data (in this case, from ASCII files) is "transparent" to this
		// application by virtue of our introduction of the SRSDataAccess class
		// as a data layer utility class.

		// We're using custom exceptions ...

		try {
			// The order in which we create these is important:
			// creating the ScheduleOfClasses relies on the existence of 
			// the CourseCatalog, and creating the Faculty relies on the 
			// existence of the ScheduleOfClasses.

			courseCatalog = SRSDataAccess.initializeCourseCatalog();
			scheduleOfClasses = 
				SRSDataAccess.initializeScheduleOfClasses("SP2005");
			faculty = SRSDataAccess.initializeFaculty();
		}
		catch (SRSInitializationException e) {
			System.out.println("ERROR:  " + e.getMessage() + "-- GOODBYE!");
			System.exit(0);	
		}

		// Create and display an instance of the main GUI window.

		new MainFrame();
	}
}

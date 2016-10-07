// SRS.java - Chapter 15, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// The main driver for the command-line driven version of the SRS, with
// object persistence added.


import java.util.*;

public class SRS {
	// We can effectively create "global" data by declaring
	// collections of objects as public static attributes in 
	// the main class; these can then be accessed throughout the
	// SRS application as:  SRS.collectionName; e.g., SRS.faculty.  

	// We've gone ahead and encapsulated what were previously declared as ArrayLists
	// in the Chapter 14 version of the SRS class:
	//
	//	public static ArrayList<Professor> faculty; 
	//	public static ArrayList<Course> courseCatalog; 
	//
	// in specialized Collection classes named Faculty and CourseCatalog instead,
	// to make them a bit more abstract.  (ScheduleOfClasses was implemented this
	// way from the beginning.)

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

		// We're using custom exceptions to signal various errors that may
		// arise when attempting to reconstitute objects from persistent
		// storage.

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

		// Let's see if everything got initialized properly by calling 
		// various display methods.
		
		System.out.println("====================");
		System.out.println("Course Catalog:");
		System.out.println("====================");
		System.out.println();
		courseCatalog.display();

		System.out.println("====================");
		System.out.println("Schedule of Classes:");
		System.out.println("====================");
		System.out.println();
		scheduleOfClasses.display();

		System.out.println("====================");
		System.out.println("Faculty Information:");
		System.out.println("====================");
		System.out.println();
		faculty.display();

		// Simulate one student logging on.  Note that this Student
		// has previously registered for one or more courses based
		// on the preexisting content of his/her ssn.dat file (see 
		// file 111-11-1111.dat for details).

		Student student = null;

		// We're using custom exceptions to signal various errors that may
		// arise when attempting to reconstitute objects from persistent
		// storage.

		try {
			student = SRSDataAccess.initializeStudent("111-11-1111");
		}
		catch (InvalidStudentException e) {
			System.out.println("ERROR:  " + e.getMessage() + "-- GOODBYE!");
			System.exit(0);	
		}

		// Review student's preexisting information.

		System.out.println("===========================");
		System.out.println("Student Information BEFORE:");
		System.out.println("===========================");
		System.out.println();
		student.display();

		// Simulate the Student enrolling in another course.

		Section sec = scheduleOfClasses.findSection("ART101 - 1");
		sec.enroll(student);

		// Review student's updated information.

		System.out.println("==========================");
		System.out.println("Student Information AFTER:");
		System.out.println("==========================");
		System.out.println();
		student.display();

		// Simulate the Student logging off, so that we may persist his updated
		// course load (you may check the contents of file 111-11-1111.dat to verify
		// that it has changed).

		try {
			SRSDataAccess.persistStudent(student);  
		}
		catch (StudentPersistenceException e) {
			System.out.println("ERROR:  " + e.getMessage() + "-- GOODBYE!");
			System.exit(0);	
		}

		// * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
		// * Before rerunning this program, use the reset.bat command-line script  *
		// * to refresh the contents of the 111-11-1111.dat data file.             *
		// * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	}
}

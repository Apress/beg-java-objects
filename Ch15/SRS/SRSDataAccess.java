// SRSDataAccess.java - Chapter 15, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// A DATA ACCESS LAYER class.


// By hiding all of the details of object persistence in this class, we minimize the impact
// to our application if such details need to change down the road; e.g., if we decide to
// adopt relational database technology rather than file persistence.

import java.io.*;
import java.util.*;

public class SRSDataAccess {
	// We declare String variables to hold onto the names of the data files that we
	// need to read, but store the actual file names in an external Properties file 
	// rather than hardcoding them here.  This technique allows us to easily 
	// change the paths/names to such files without having to make changes to 
	// our code.

	// Schedule of Classes is defined by one file:

	private static String scheduleFileName;

	// Faculty is defined by two files: 

	private static String facultyFileName;
	private static String assignmentsFileName; 

	// CourseCatalog is defined by two files: 

	private static String courseFileName;
	private static String prereqFileName;

	// We don't need to declare a static String attribute for the student file, 
	// because this file name is derived on the fly when a particular Student logs 
	// on, by concatenating his/her student ID number with a ".dat" extension.

	// Obtain the name of the relevant files from an external Properties file. 
	// "static" code blocks are executed only once, when the SRSDataAccess class's
        // byte code is first loaded into the JVM at runtime.

	static {
	    try {
		Properties fileNames = new Properties();
		fileNames.load(new FileInputStream("FileNames.properties"));

		facultyFileName = fileNames.getProperty("facultyFile");
		assignmentsFileName = fileNames.getProperty("assignmentsFile");
		courseFileName = fileNames.getProperty("courseFile");
		prereqFileName = fileNames.getProperty("prereqFile");
		scheduleFileName = fileNames.getProperty("scheduleFile");
	    }
	    catch (IOException e) {
		// If the properties file cannot be found, we abort the application.

		System.out.println("ERROR:  unable to read FileNames.properties file " +
			"-- GOODBYE!");
		System.exit(0);
	    }
	}

	// Initialize Faculty.  Note that we're using a custom Exception type to
	// signal various errors that may arise during object "reconstitution"
	// from persistent storage. 

	public static Faculty initializeFaculty() throws SRSInitializationException {
		Faculty faculty = new Faculty();
		String line = null;
		BufferedReader bIn = null;

		try {
			// Open the first file. 
			bIn = new BufferedReader(new FileReader(facultyFileName));

		    	line = bIn.readLine();
		    	while (line != null) {
				// We're going to parse tab-delimited records into
				// four attributes -- name, ssn, title, and dept --
				// and then call the Professor constructor to fabricate a new
				// professor.

				StringTokenizer st = new StringTokenizer(line, "\t");

				// If there aren't four columns, signal an error.

				if (st.countTokens() != 4) {
					throw new SRSInitializationException(
						"File format error on record |" + 
						line + "| -- should have 4 tokens -- in file " + 
						facultyFileName);
				}
				else {
					String name = st.nextToken();
					String ssn = st.nextToken();
					String title = st.nextToken();
					String dept = st.nextToken();

					// Create a Person instance and store it in
					// the collection.

					Professor p = new Professor(name, ssn, title, dept);
					faculty.addProfessor(p);
				}
				
		    		line = bIn.readLine();
			}

			bIn.close();
		}
		catch (IOException i) { 
			throw new SRSInitializationException("Error accessing file " + 
				facultyFileName);
		}

		// Process the second file, which defines teaching assignments.

		try {
			// Open the file. 
			bIn = new BufferedReader(
			    new FileReader(assignmentsFileName));

			line = bIn.readLine();
			while (line != null) {
				// We're going to parse tab-delimited records 
				// into two values, representing the professor's 
				// SSN and the section number that he/she is 
				// going to teach.

				StringTokenizer st = new StringTokenizer(
					line, "\t");

				// If there aren't two columns, signal an error.

				if (st.countTokens() != 2) {
					throw new SRSInitializationException(
						"File format error on record |" + 
						line + "| -- should have 2 tokens -- in file " + 
						assignmentsFileName);
				}
				else {
					String ssn = st.nextToken();

					// The full section number is a 
					// concatenation of the course no. 
					// and section no., separated 
					// by a hyphen; e.g., "ART101 - 1".

					String fullSectionNo = st.nextToken();

					// Look these two objects up in the 
					// appropriate collections.  Note that 
					// having made scheduleOfClasses a public 
					// static attribute of the SRS class 
					// makes this easy to do!

					Professor p = faculty.findProfessor(ssn); 
					Section s = SRS.scheduleOfClasses.
						findSection(fullSectionNo); 

					// As long as we've found both the Professor 
					// and Section objects in question, we're 
					// good to go.

					if (p != null && s != null) p.agreeToTeach(s);
				}

				line = bIn.readLine();
			}

			bIn.close();
		}
		catch (IOException i) { 
			throw new SRSInitializationException("Error accessing file " + 
				assignmentsFileName);
		}

		// If we didn't wind up creating any Faculty entries, we'll 
		// signal a problem in this regard.

		if (faculty.isEmpty()) {
			throw new SRSInitializationException("Error initializing faculty " + 
				"information");
		}

		// If we've made it to this point in the code without throwing any
		// exceptions, we've successfully crafted/populated the Faculty 
		// instance required to "drive" the SRS.

		return faculty;
	}

	// Initialize CourseCatalog.  Note that we're using a custom Exception type (as 
	// we did for Faculty) to signal various initialization errors. 

	public static CourseCatalog initializeCourseCatalog() 
	    throws SRSInitializationException {
		CourseCatalog catalog = new CourseCatalog();
		String line = null;
		BufferedReader bIn = null;

		try {
			// Open the file. 
			bIn = new BufferedReader(new FileReader(courseFileName));

		    	line = bIn.readLine();
		    	while (line != null) {
				// We're going to parse tab-delimited records into
				// three attributes -- courseNo, courseName, and credits --
				// and then call the Course constructor to fabricate a 
				// new course.

				StringTokenizer st = new StringTokenizer(line, "\t");

				// If there aren't three columns, signal an error.

				if (st.countTokens() != 3) {
					throw new SRSInitializationException(
						"File format error on record |" + 
						line + "| -- should have 3 tokens -- in file " + 
						courseFileName);
				}
				else {
					String courseNo = st.nextToken();
					String courseName = st.nextToken();
					String creditValue = st.nextToken();

					// We have to convert the last value into a 
					// number, using a static method on the 
					// Double class to do so.

					//? double credits = Double.parseDouble(creditValue);
					double credits = -1.0;
					try {
						credits = Double.parseDouble(creditValue);
					}
					catch (NumberFormatException nfe) {
					    throw new SRSInitializationException(
						"File format error on record |" + 
						line + "| -- invalid credit value -- " +
						"in file " + courseFileName);
					}

					// Finally, we call the Course constructor to create
					// an appropriate Course object, and store it in our
					// collection.

					Course c = new Course(courseNo, courseName, credits);
					catalog.addCourse(c);
				}
				
		    		line = bIn.readLine();
			}

			bIn.close();
		}
		catch (IOException i) { 
			throw new SRSInitializationException("Error accessing file " + 
				courseFileName);
		}

		// Process the second file, which defines prerequisite relationships
		// between courses.

		try {
			// Open the file. 
			bIn = new BufferedReader(
			    new FileReader(prereqFileName));

			line = bIn.readLine();
			while (line != null) {
				// We're going to parse tab-delimited records into
				// two values, representing the courseNo "A" of 
				// a course that serves as a prerequisite for 
				// courseNo "B".

				StringTokenizer st = new StringTokenizer(line, "\t");

				// If there aren't two columns, signal an error.

				if (st.countTokens() != 2) {
					throw new SRSInitializationException(
						"File format error on record |" + 
						line + "| -- should have 2 tokens -- in file " + 
						prereqFileName);
				}
				else {
					String courseNoA = st.nextToken();
					String courseNoB = st.nextToken();

					// Look these two courses up in the CourseCatalog.

					Course a = catalog.findCourse(courseNoA); 
					Course b = catalog.findCourse(courseNoB); 

					// If both exist, link a to b as a prerequisite.

					if (a != null && b != null) {
						b.addPrerequisite(a);
					}
				}

				line = bIn.readLine();
			}

			bIn.close();
		}
		catch (IOException i) { 
			throw new SRSInitializationException("Error accessing file " + 
				prereqFileName);
		}

		// If we didn't wind up creating any course catalog entries, we'll 
		// signal a problem in this regard.

		if (catalog.isEmpty()) {
			throw new SRSInitializationException("Error initializing course " + 
				"catalog information");
		}

		// If we've made it to this point in the code without throwing any
		// exceptions, we've successfully crafted/populated the CourseCatalog 
		// instance required to "drive" the SRS.

		return catalog;
	}

	// Initialize ScheduleOfClasses.  Note that we're using a custom Exception 
	// type (as we did for Faculty) to signal various initialization errors. 

	public static ScheduleOfClasses initializeScheduleOfClasses(String semester) 
	    throws SRSInitializationException {
		ScheduleOfClasses soc = new ScheduleOfClasses(semester);
		String line = null;
		BufferedReader bIn = null;

		try {
			// Open the file. 
			bIn = new BufferedReader(new FileReader(scheduleFileName));

		    	line = bIn.readLine();
		    	while (line != null) {
				// We're going to parse tab-delimited records into
				// six attributes -- courseNo, sectionNo, dayOfWeek, 
				// timeOfDay, room, and capacity.  We'll use courseNo to 
				// look up the appropriate Course object, and will then
				// call the scheduleSection() method to fabricate a
				// new Section object.

				StringTokenizer st = new StringTokenizer(line, "\t");

				// If there aren't six columns, signal an error.

				if (st.countTokens() != 6) {
					throw new SRSInitializationException(
						"File format error on record |" + 
						line + "| -- should have 6 tokens -- in file " + 
						scheduleFileName);
				}
				else {
					String courseNo = st.nextToken();

					// We have to convert the next value from
					// a String to an int.

					String sectionNumber = st.nextToken();
					//? int sectionNo = Integer.parseInt(sectionNumber);
					int sectionNo = -1;
					try {
						sectionNo = Integer.parseInt(sectionNumber);
					}
					catch (NumberFormatException nfe) {
					    throw new SRSInitializationException(
						"File format error on record |" + 
						line + "| -- invalid section no. -- " +
						"in file " + scheduleFileName);
					}

					String dayOfWeek = st.nextToken();
					String timeOfDay = st.nextToken();
					String room = st.nextToken();
					
					// We have to convert the next value from
					// a String to an int.

					String capacityValue = st.nextToken();
					//? int capacity = Integer.parseInt(capacityValue);
					int capacity = -1;
					try {
						capacity = Integer.parseInt(capacityValue);
					}
					catch (NumberFormatException nfe) {
					    throw new SRSInitializationException(
						"File format error on record |" + 
						line + "| -- invalid capacity value -- " +
						"in file " + scheduleFileName);
					}

					// Look up the Course object in the Course Catalog.
					// (Having made courseCatalog a public static 
					// attribute of the SRS class comes in handy!)

					Course c = SRS.courseCatalog.findCourse(courseNo);

					// Create a Section object ...

					Section s = new Section(
						sectionNo, dayOfWeek.charAt(0), 
						timeOfDay, c, room, capacity);

					// ... add it to the schedule of classes ...

					String key = courseNo + " - " + s.getSectionNo();
					soc.addSection(s);

					// ... and link it to the Course.
					c.addSection(s);
				}
				
		    		line = bIn.readLine();
			}

			bIn.close();
		}
		catch (IOException i) { 
			throw new SRSInitializationException("Error accessing file " + 
				scheduleFileName);
		}

		// If we didn't wind up creating any Section entries, we'll 
		// signal a problem in this regard.

		if (soc.isEmpty()) {
			throw new SRSInitializationException("Error initializing " + 
				"schedule of classes information");
		}

		// If we've made it to this point in the code without throwing any
		// exceptions, we've successfully crafted/populated the 
		// ScheduleOfClasses instance required to "drive" the SRS.

		return soc;
	}

	// Initialize a single Student.  Again, we are using a custom Exception --
	// in this case, InvalidStudentException, which is a subtype of 
	// SRSInitializationException -- to signal various issues with retrieving
	// the Student's state from persistent storage.

	public static Student initializeStudent(String sId) throws InvalidStudentException {
		// First, construct a "dummy" Student object.  Then, 
		// attempt to pull this Student's information from the 
		// appropriate file (e.g., 111-11-1111.dat).  

		Student s = new Student("?");

		String line = null;
		BufferedReader bIn = null;

		// Formulate the file name.

		String pathToFile = sId + ".dat";

		try {
			// Open the file. 

			bIn = new BufferedReader(new FileReader(pathToFile));

			// The file consists of a header record, containing 
			// the student's basic info. (ssn, name, etc.), and 
			// 0 or more subsequent records representing a list of 
			// the sections that he/she is currently registered for.

		    	line = bIn.readLine();
			if (line == null) {
				// Signal the problem via a custom Exception.

				throw new InvalidStudentException("Improperly formatted file:  " +
					pathToFile);
			}

			// We're going to parse the header record into
			// four attributes -- ssn, name, major, and degree. 

			StringTokenizer st = new StringTokenizer(line, "\t");

			// If record doesn't have four columns, report an error.

			if (st.countTokens() != 4) {
				// Signal the problem via a custom Exception.

				throw new InvalidStudentException("Improperly formatted " +
					"record |" + line + "| in file " + pathToFile);
			}

			// Populate the newly-crafted Student object with the information
			// read from the file.

			s.setSsn(st.nextToken());
			s.setName(st.nextToken());
			s.setMajor(st.nextToken());
			s.setDegree(st.nextToken());

			// Remaining lines in the file (if any) contain section 
			// references to sections that the student has previously
			// registered for.  

			// If there are no secondary records in the file,
			// the "while" loop won't execute at all.

		    	line = bIn.readLine();
		    	while (line != null) {
				// The full section number is a concatenation of the
				// course no. and section no., separated by a hyphen;
				// e.g., "ART101 - 1".

				// Strip off any leading/trailing white space, then use
				// the section number to retrieve the corresponding
				// Section object from the SRS schedule of classes,
				// which was declared as a public static attribute of
				// the SRS class.

				String fullSectionNo = line.trim();
				Section sec = SRS.scheduleOfClasses.findSection(
					fullSectionNo);

				// Note that we are using the Section class's enroll()
				// method to ensure that bidirectionality is established
				// between the Student and the Section.

				if (sec != null) sec.enroll(s);

		    		line = bIn.readLine();
			}

			bIn.close();
		}
		catch (IOException i) {
			// Use a custom Exception to signal the problem.

			throw new InvalidStudentException("Error accessing file " + 
				pathToFile);
		}

		// If we've made it to this point in the code without throwing any
		// exceptions, we've successfully reconsitituted a Student object
		// to represent the student user who has logged onto the SRS.

		return s;
	}

	// Persist the state of a Student.  This method writes out all of the 
	// student's information to his/her ssn.dat file when he/she logs off.
	// Once again, we use a custom Exception type -- StudentPersistenceException --
	// to signal problems.

	public static void persistStudent(Student s) throws StudentPersistenceException {
		FileOutputStream fos = null;
		PrintWriter pw = null;
		String pathToFile = s.getSsn() + ".dat";

		try {
			// Attempt to create the ssn.dat file.  Note that
			// it will overwrite one if it already exists, which
			// is what we want to have happen.

			fos = new FileOutputStream(pathToFile);
			pw = new PrintWriter(fos);

			// First, we output the header record as a tab-delimited
			// record.

			pw.println(s.getSsn() + "\t" + s.getName() + "\t" +
				   s.getMajor() + "\t" + s.getDegree());

			// Then, we output one record for every Section that
			// the Student is enrolled in.

			Collection<Section> sections = s.getEnrolledSections();
			for (Section sec : sections) {
				pw.println(sec.getFullSectionNo());
			}

			pw.close();
		}
		catch (IOException e) {
			// Signal that an error has occurred.
			
			throw new StudentPersistenceException("Error saving student " +
				"information to file " + pathToFile);
		}
	}
}

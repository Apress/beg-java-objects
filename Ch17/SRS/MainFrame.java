// MainFrame.java - Chapter 16, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// A GUI class.


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class MainFrame extends JFrame {
	// Define all of the components here as attributes of this class.
	private JPanel leftPanel;
	private JPanel topLeftPanel;
	private JPanel labelPanel;
	private JPanel fieldPanel;
	private JPanel bottomLeftPanel;
	private JPanel rightPanel;
	private JPanel buttonPanel;
	private JTextField ssnField;
	private JLabel nameLabel;
	private JLabel totalCoursesLabel;
	private JButton dropButton;
	private JButton addButton;
	private JButton logoffButton;
	private JButton saveScheduleButton; 
	private JLabel l1;
	private JLabel l2;
	private JList studentCourseList;
	private JList scheduleOfClassesList;

	// Maintain a handle on the Student who is logged in.
	// (Whenever this is set to null, nobody is officially logged on.)
	private Student currentUser;

	// Constructor.
	public MainFrame() {
		// Initialize attributes.
		currentUser = null;

		// Note that using "this." as a prefix is unnecessary -
		// any method calls that stand alone (without a dot notation
		// prefix) are UNDERSTOOD to be invoked on THIS object.
		this.setTitle("Student Registration System");
		this.setSize(500, 300);
		Container contentPane = this.getContentPane( );

		// Technique for centering a frame on the screen.
		Dimension frameSize = this.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - frameSize.width)/2, 
		                 (screenSize.height - frameSize.height)/2);

		// Create a few panels.

		leftPanel = new JPanel();
		leftPanel.setLayout(new GridLayout(2, 1));  

		topLeftPanel = new JPanel();
		topLeftPanel.setLayout(new GridLayout(1, 2));  

		labelPanel = new JPanel();
		labelPanel.setLayout(new GridLayout(4, 1));

		fieldPanel = new JPanel();
		fieldPanel.setLayout(new GridLayout(4, 1));

		bottomLeftPanel = new JPanel();
		bottomLeftPanel.setLayout(new BorderLayout());
		
		rightPanel = new JPanel();
		rightPanel.setLayout(new BorderLayout());

		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 4)); 

		// We'll allow the main frame's layout to remain the
		// default BorderLayout.

		// Note that we are adding labels without maintaining 
		// handles on them!  This is because we don't need to
		// manipulate them programmatically after the fact.
		// Thus, we use the same reference variable "l" repeatedly. 

		JLabel l = new JLabel("SSN:  ");
		l.setForeground(Color.black);
 		labelPanel.add(l);

		l = new JLabel("Name:  ");
		l.setForeground(Color.black);
 		labelPanel.add(l);

		l = new JLabel("Total Courses:  ");
		l.setForeground(Color.black);
		labelPanel.add(l);

		// Add an empty label for padding/white space.
		l = new JLabel("");
 		labelPanel.add(l);

		// We DO maintain handles on modifiable components, however, so
		// that we can later go back and read/write their contents
		// by name.  Note our choice of descriptive names for these.
 		ssnField = new JTextField(10);

 		nameLabel = new JLabel();
		nameLabel.setForeground(Color.black);

		totalCoursesLabel = new JLabel(); 
		totalCoursesLabel.setForeground(Color.black);

		fieldPanel.add(ssnField);
		fieldPanel.add(nameLabel);
		fieldPanel.add(totalCoursesLabel);
		
		// Add an empty label for padding/white space.
		l = new JLabel("");
 		fieldPanel.add(l);

		// Create the buttons and add them to their panel.  Again,
		// note use of descriptive names.
		dropButton = new JButton("Drop");
		addButton = new JButton("Add");
		logoffButton = new JButton("Log Off");

		// Technique for creating a multi-line button label.
		saveScheduleButton = new JButton();
		saveScheduleButton.setLayout(new GridLayout(2, 1));
		l1 = new JLabel("Save My", JLabel.CENTER);
		l1.setForeground(Color.black);
		l2 = new JLabel("Schedule", JLabel.CENTER);
		l2.setForeground(Color.black);
		saveScheduleButton.add(l1);
		saveScheduleButton.add(l2);

		buttonPanel.add(dropButton);
		buttonPanel.add(saveScheduleButton);
		buttonPanel.add(new JLabel("")); // white space padding
		buttonPanel.add(addButton);
		buttonPanel.add(logoffButton);

		studentCourseList = new JList();
		studentCourseList.setFixedCellWidth(200);
		bottomLeftPanel.add(studentCourseList, BorderLayout.CENTER);

		l = new JLabel("Registered For:");
		l.setForeground(Color.black);
		bottomLeftPanel.add(l, BorderLayout.NORTH);

		l = new JLabel("--- Schedule of Classes ---", JLabel.CENTER);
		l.setForeground(Color.black);
		rightPanel.add(l, BorderLayout.NORTH);

		// Retrieve a Collection of Sections from the main ScheduleOfClasses,
		// then sort it via a private "housekeeping" method, 
		// sortSections, before displaying it.
		scheduleOfClassesList = new JList(sortSections(SRS.scheduleOfClasses.
			getSectionsOffered()));

		scheduleOfClassesList.setFixedCellWidth(250);
		rightPanel.add(scheduleOfClassesList, BorderLayout.EAST);

		// Initialize the buttons to their proper enabled/disabled
		// state.
		resetButtons();

		// Finally, attach all of the panels to one another
		// and to the frame.
 		// Add in ascending row, then column, order.
		topLeftPanel.add(labelPanel);
		topLeftPanel.add(fieldPanel);
		leftPanel.add(topLeftPanel);
		leftPanel.add(bottomLeftPanel);
 		contentPane.add(leftPanel, BorderLayout.WEST);
 		contentPane.add(rightPanel, BorderLayout.CENTER);
 		contentPane.add(buttonPanel, BorderLayout.SOUTH);
 
		// ------------------
		// Add all behaviors.
		// ------------------

		// Different types of components require different types
		// of listeners:
		//
		// o	Text fields respond to an ActionListener
		//	whenever the Enter key is pressed.
		//
		// o	Buttons respond to an ActionListener
		// 	whenever the button is clicked.
		//
		// o	JLists respond to a ListSelectionListener
		//	whenever an item is selected.

		ActionListener aListener;
		ListSelectionListener lListener;
		WindowListener wListener;

		// ssnField

		aListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// First, clear the fields reflecting the
				// previous student's information.
				clearFields();
		
				// We'll try to construct a Student based on
				// the ssn we read from the GUI.
				String id = ssnField.getText();
				Student theStudent = null;

				try {
					theStudent = SRSDataAccess.initializeStudent(id);
				}
				catch (InvalidStudentException e2) {
				    // Drat!  The ID was invalid.
				    currentUser = null;

				    // Let the user know that login failed,
				    // UNLESS the ID typed was blank,
				    // signalling a successful log-off.
				    JOptionPane.showMessageDialog(null, 
					"Invalid student ID; please try again.",
					"Invalid Student ID",
					JOptionPane.WARNING_MESSAGE);

				    return;
				}

				// If we've made it to this point in our code,
				// we found a valid student.  We now need
				// to request and validate the password.
				// We'll use a utility method added to the
			  	// MainFrame class for the latter purpose.
				PasswordPopup pp = new PasswordPopup(
					MainFrame.this);
				String pw = pp.getPassword();
				pp.dispose();

				if (validatePassword(theStudent, pw)) {
					    currentUser = theStudent;
					    setFields(theStudent);

					    // Let the user know that the
					    // login succeeded.
					    JOptionPane.showMessageDialog(null, 
						"Log in succeeded for " + 
						theStudent.getName() + ".",
						"Log In Succeeded",
						JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					    // Password validation failed;
					    // notify the user of this.
					    JOptionPane.showMessageDialog(null, 
						"Invalid password; please " +
						"try again.",
						"Invalid Password",
						JOptionPane.WARNING_MESSAGE);
				}

				MainFrame.this.repaint();

				// Check/reset states of the various buttons.
				resetButtons();
			}
		};
		ssnField.addActionListener(aListener);

		// addButton

		aListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Determine which section is selected
				// (note that we must cast it, as it
				// is returned as an Object reference).
				Section selected = (Section)
					scheduleOfClassesList.getSelectedValue();

				// Check to see if this COURSE is already
				// one that the student registered for,
				// even if the SECTION is different.
				// If so, warn them of this.
				if (currentUser.isCurrentlyEnrolledInSimilar(
					selected)) {
				      // Create a String array of TWO lines
				      // of messsage text, so that the popup 
				      // window won't be too wide.
				      String[] message = 
					{ "You are already enrolled in " +
					      "(or have already ",
					  "successfully completed) a section " +
					      "of this course.",
					  " " };

				      // Then, we can just hand the String
				      // array in to the showMessageDialog()
				      // call.
				      JOptionPane.showMessageDialog(null, 
					  message,
					  "Request Denied",
					  JOptionPane.WARNING_MESSAGE);
				}
				else {
					// Attempt to enroll the student, noting
					// the status value that is returned.
					EnrollmentStatus outcome =
						selected.enroll(currentUser);

					// Report the status to the user.
					if (outcome != EnrollmentStatus.success) {
					    JOptionPane.showMessageDialog(
						null, 
						outcome.value(),
						"Request Denied",
						JOptionPane.WARNING_MESSAGE);
					}
					else { // success!
					    // Display a confirmation message.
					    JOptionPane.showMessageDialog(
						null, 
						"Seat confirmed in " + selected.
						        getRepresentedCourse().
						        getCourseNo() + ".",
						"Request Successful",
						JOptionPane.INFORMATION_MESSAGE);

					    // Update the list of sections 
					    // that this student is 
					    // registered for.  (Note that a JList
					    // likes to be "fed" an Array, so
					    // we call the toArray method on the
					    // collection returned by the 
					    // getEnrolledSections method.)
					    studentCourseList.setListData(
						currentUser.
					        getEnrolledSections().toArray(new Section[1]));

					    // Update the field representing
					    // student's course total.
					    int total = 
						currentUser.getEnrolledSections().size();
					    totalCoursesLabel.setText("" + total);

					    // Clear the selection in the
					    // schedule of classes list.
					    scheduleOfClassesList.clearSelection();
					}
				}

				// Check/reset the states of the various buttons.
				resetButtons();
			}
		};
		addButton.addActionListener(aListener);

		// dropButton

		aListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Determine which section is selected
				// (note that we must cast it, as it
				// is returned as an Object reference).
				Section selected = (Section)
					studentCourseList.getSelectedValue();

				// Drop the course.
				selected.drop(currentUser);

				// Display a confirmation message.
				JOptionPane.showMessageDialog(null, 
					"Course " + selected.
					    getRepresentedCourse().
					    getCourseNo() + " dropped.",
					"Request Successful",
					JOptionPane.INFORMATION_MESSAGE);

				// Update the list of sections that 
				// this student is registered for.
			        // (Note that a JList likes to be "fed" an Array, 
				// so we call the toArray method on the collection 
				// returned by the getEnrolledSections method.)
				studentCourseList.setListData(
					currentUser.
				        getEnrolledSections().toArray(new Section[1]));

				// Update the field representing
				// student's course total.
				int total = currentUser.getEnrolledSections().size();
				totalCoursesLabel.setText("" + total);

				// Check/reset the states of the various buttons.
				resetButtons();
			}
		};
		dropButton.addActionListener(aListener);

		// saveScheduleButton

		aListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SRSDataAccess.persistStudent(currentUser);

					// If no exceptions are thrown, 
				        // let the user know that his/her
					// schedule was successfully saved.
				        JOptionPane.showMessageDialog(null, 
						"Schedule saved.", 
						"Schedule Saved",
						JOptionPane.INFORMATION_MESSAGE);
				}
				catch (StudentPersistenceException e2) {
				        // Let the user know that there
					// was a problem.
				        JOptionPane.showMessageDialog(null, 
						"Problem saving your " +
						"schedule; please contact " +
						"the SRS Support Staff for " +
						"assistance.",
						"Problem Saving Schedule",
						JOptionPane.WARNING_MESSAGE);
				}
			}
		};
		saveScheduleButton.addActionListener(aListener);

		// logoffButton

		aListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearFields();
				ssnField.setText("");
				currentUser = null;

				// Clear the selection in the
				// schedule of classes list.
				scheduleOfClassesList.clearSelection();

				// Check/reset states of the various buttons.
				resetButtons();
			}
		};
		logoffButton.addActionListener(aListener);

		// studentCourseList

		lListener = new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				// When an item is selected in this list,
				// we clear the selection in the other list.
				if (!(studentCourseList.isSelectionEmpty())) 
					scheduleOfClassesList.clearSelection();

				// Check/reset states of the various buttons.
				resetButtons();
			}
		};
		studentCourseList.addListSelectionListener(lListener);

		// scheduleOfClassesList

		lListener = new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				// When an item is selected in this list,
				// we clear the selection in the other list.
				if (!(scheduleOfClassesList.isSelectionEmpty())) 
					studentCourseList.clearSelection();

				// Check states of the various buttons.
				resetButtons();
			}
		};
		scheduleOfClassesList.addListSelectionListener(lListener);

		wListener = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};
		this.addWindowListener(wListener);

              	this.setVisible(true);
         }

        //----------------------
        // Housekeeping methods.
        //----------------------

	private void resetButtons() {
		// There are four conditions which collectively govern the
		// state of each button:
		//	
		// o	Whether a user is logged on or not.

		boolean isLoggedOn;
		if (currentUser != null) isLoggedOn = true;
		else isLoggedOn = false;
		
		// o	Whether the user is registered for at least one course.

		boolean atLeastOne;
		if (currentUser != null && currentUser.getEnrolledSections().size() > 0)
			atLeastOne = true;
		else atLeastOne = false;

		// o	Whether a registered course has been selected.

		boolean courseSelected;
		if (studentCourseList.isSelectionEmpty()) 
			courseSelected = false;
		else courseSelected = true;
		
		// o    Whether an item is selected in the Schedule of Classes.

		boolean catalogSelected;
		if (scheduleOfClassesList.isSelectionEmpty()) 
			catalogSelected = false;
		else catalogSelected = true;

		// Now, verify the conditions on a button-by-button basis.

		// Drop button:

		if (isLoggedOn && atLeastOne && courseSelected)
			dropButton.setEnabled(true);
		else dropButton.setEnabled(false);

		// Add button:

		if (isLoggedOn && catalogSelected)
			addButton.setEnabled(true);
		else addButton.setEnabled(false);

		// Save My Schedule button:

		if (isLoggedOn) {
			saveScheduleButton.setEnabled(true);

			// Because of the way that we created the latter two 
			// buttons, we have do a bit of extra work to make them
			// APPEAR to be turned on or off.
			l1.setEnabled(true); 
			l2.setEnabled(true); 
		}
		else {
			saveScheduleButton.setEnabled(false);
			l1.setEnabled(false); 
			l2.setEnabled(false); 
		}

		// Log Off button:

		if (isLoggedOn) logoffButton.setEnabled(true);  
		else logoffButton.setEnabled(false);  
	}

	// Called whenever a user is logged off.

	private void clearFields() {
		nameLabel.setText("");
		totalCoursesLabel.setText("");

	        // Note that a JList likes to be "fed" an Array, 
		// so we fabricate a "dummy" Object array.
		studentCourseList.setListData(new Object[1]);
	}

	// Set the various fields, lists, etc. to reflect the information
	// associated with a particular student.  (Used when logging in.)

	private void setFields(Student theStudent) {
		nameLabel.setText(theStudent.getName());
		int total = theStudent.getEnrolledSections().size();
		totalCoursesLabel.setText("" + total);
	
		// If the student is registered for any courses, list these, too.
		if (total > 0) {
			// Because we already have a collection containing the
			// sections that the student is registered for, 
			// and because these objects have defined a toString()
			// method, we can merely hand the collection to the JList.
		        // (Note that a JList likes to be "fed" an Array, 
			// so we call the toArray method on the collection 
			// returned by the getEnrolledSections method.)
			studentCourseList.setListData(theStudent.
			        getEnrolledSections().toArray(new Section[1]));
		}
	}

	// A utility method used to convert the contents of the HashMap into a Section
	// array that is sorted in alphabetic section no. order.

	private Section[] sortSections(HashMap<String, Section> sections) {
		// We'll transfer the contents of the HashMap to a TreeMap, which
		// automatically orders entries in ascending key order.
		TreeMap<String, Section> sortedMap = 
			new TreeMap<String, Section>(sections);
		
		return sortedMap.values().toArray(new Section[1]);
	}

	// A utility method used to validate a Student's password by comparing it
	// to the first three digits of his/her student ID number.

	private boolean validatePassword(Student s, String pw) {
		if (pw == null) return false;
		else if (s.getSsn().startsWith(pw)) return true;
		else return false;
	}
 }

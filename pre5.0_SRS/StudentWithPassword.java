// StudentWithPassword.java - Chapter 16, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// A MODEL class.


public class StudentWithPassword extends Student {
	//------------
	// Attributes.
	//------------

	private String password;

	//----------------
	// Constructor(s).
	//----------------

	public StudentWithPassword(String name, String ssn, String major, 
		String degree, String password) {
		// Reuse the code of the superclass constructor ...
		super(name, ssn, major, degree);

		// ... and do something extra!
		this.setPassword(password);
	}
	
	// A second simpler form of constructor.

	public StudentWithPassword(String ssn) {
		// Reuse the code of the other constructor in this class.
		this("TBD", ssn, "TBD", "TBD", "TBD");
	}

	//------------------
	// Accessor methods.
	//------------------

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	//-----------------------------
	// Miscellaneous other methods.
	//-----------------------------

	public boolean validatePassword(String pw) {
		if (pw.equals(password)) return true;
		else return false;
	}
}

// InvalidStudentException.java - Chapter 15, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// An IMPLEMENTATION class.


// We throw this type of Exception to signal a problem with regard to 
// restoring a Student's state from persistent storage.

public class InvalidStudentException extends SRSInitializationException {
	public InvalidStudentException(String message) {
		super(message);
	}
}

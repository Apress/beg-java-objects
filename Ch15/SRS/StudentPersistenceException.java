// StudentPersistenceException.java - Chapter 15, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// An IMPLEMENTATION class.


// We throw this type of Exception to signal a problem with regard to 
// storing a Student's state to persistent storage.

public class StudentPersistenceException extends SRSInitializationException {
	public StudentPersistenceException(String message) {
		super(message);
	}
}

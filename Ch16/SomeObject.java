// Class #3:  SomeObject.java

// Copyright 2005 by Jacquie Barker - all rights reserved.

// This will be the object that is being "listened to"; it can be of
// ANY type!

// This is actually a Java Bean!  See comments below that explain WHY.

import java.beans.*;

//? public class SomeObject implements Customizer { // experimenting
public class SomeObject implements ListenedToObject {
	// The following attributes will be considered to be BOUND PROPERTIES.
	private String foobar;
	private String barfoo;

	// A BOUND PROPERTY in JavaBeans "lingo" is one that informs 
	// interested listeners when its value has changed.  To implement 
	// a BOUND property, there are two mechanisms that must be implemented 
	// by the bean (i.e., THIS CLASS):
	//
	//	1.	Whenever the value of the property changes anywhere
	//		in the code, a PropertyChange event must be fired off, 
	//		typically when the "set" method for that attribute
	//	        is invoked.  (See the "set" methods for the above 
	//		bound properties, below.)
	//
	//	2.	The bean must also provide a mechanism for enabling
	//		interested listeners to register themselves.  This
	//		can be handled by creating a PropertyChangeSupport
	//		object as an attribute of the bean class (below)
	//              and then providing a few methods as defined by
	//		the ListenedToObject interface. 
	//
	// Of course, the LISTENING class also has some work to do!  See
	// ListeningObject.java for details on the other half of the equation.

	// In order for objects of this class to communicate with other 
	// objects via PropertyChangeEvents, we must give THIS class
	// the ability to fire PropertyChange events and to register
	// listeners for these events -- namely, classes who, upon hearing 
	// such events, can react accordingly.  We create a 
	// PropertyChangeSupport ("P.C.S.") object for this purpose, as a
	// private attribute, and we'll then DELEGATE all of the work
	// to it!

	private PropertyChangeSupport pcs = 
				new PropertyChangeSupport(this);

	// Get/set methods.
	public void setFoobar(String newValue) {
		String oldValue = this.foobar;
		this.foobar = newValue;

		// See discussion of BOUND properties above.  Whenever
		// the value of a BOUND property changes, we fire an event 
		// that in turn gets delivered to all registered listeners.
		pcs.firePropertyChange("foobar", oldValue, newValue);
	}

	public void setBarfoo(String newValue) {
		String oldValue = this.barfoo;
		this.barfoo = newValue;

		// See discussion of BOUND properties above.  Whenever
		// the value of a BOUND property changes, we fire an event 
		// that in turn gets delivered to all registered listeners.
		pcs.firePropertyChange("barfoo", oldValue, newValue);
	}

	// The following methods enable PropertyChange support.

	public void addPropertyChangeListener(
					PropertyChangeListener l) {
		// We delegate the task of adding listeners to the P.C.S. 
		// object.

		// Just to be safe, let's remove it first, to make sure it
		// isn't already on the list.
		pcs.removePropertyChangeListener(l);

		pcs.addPropertyChangeListener(l);
	}

	public void removePropertyChangeListener(
					PropertyChangeListener l) {
		// We alse delegate the task of removing listeners to the P.C.S.
		// object.

		pcs.removePropertyChangeListener(l);
	}
}

// Item #2:  ListenedToObject.java

// Copyright 2005 by Jacquie Barker - all rights reserved.

// This is an interface that I invented (didn't really NEED it, though);
// it specifies the two method signatures that any "listened to" object
// needs to implement, so that ListeningObjects can register to listen
// to them for property change events.

import java.beans.*;

public interface ListenedToObject {
	// In order for objects of this type to communicate with other 
	// objects via PropertyChangeEvents, we must provide
	// the ability to fire PropertyChange events and to register
	// listeners for these events -- namely, OTHER objects who, upon 
	// hearing such events, can react accordingly.  (For example,
	// objects of type ListeningObject.)

	// Most of this functionality will be handled by declaring a
	// private attribute of type PropertyChangeSupport in the class 
	// IMPLEMENTING this interface.  This embedded PCS object will do 
	// most of the work for us.  Unfortunately, the only way to
	// force an object to implement an attribute of a given type
	// is to declare it in an (abstract) parent class, then have
	// OUR class EXTEND that class.  But, since Java doesn't support
	// multiple inheritance, having to extend some arbitrary parent
	// class just for the sake of inheriting a P.C.S. attribute
	// would prevent that class from, say, being a subclass of a
	// GUI component (e.g., MyFrame extends JFrame).  
	// We CAN, however, use an interface (namely, THIS interface) 
	// to force the implementor to create the following two methods:
	
	public void addPropertyChangeListener(PropertyChangeListener l);

	public void removePropertyChangeListener(PropertyChangeListener l);

	// Another alternative to having written this interface would have
	// been to try to use Java's built-in Customizer interface,
	// which calls for THREE methods -- the above two plus one more --
	// but since we have no need for the third method, that would
	// seem "wasteful".
}

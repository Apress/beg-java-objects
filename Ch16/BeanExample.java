// Class #4:  BeanExample.java

// Copyright 2005 by Jacquie Barker - all rights reserved.

// This is the driver program for an example of how objects can exchange
// events ... see also files ListeningObject.java, ListenedToObject.java,
// and SomeObject.java.

public class BeanExample {
	public static void main(String[] args) {
		SomeObject mouth = new SomeObject();
		ListeningObject ear = new ListeningObject();
		
		// Hand "ear" a reference to "mouth"!
		ear.handInListenedToObject(mouth);

		// Now, as we change the properties of "mouth",
		// "ear" should be notified!
		mouth.setFoobar("chocolate");
		mouth.setBarfoo("pizza");
	}
}

import javax.swing.*;
import java.awt.*;

public class JListDemoStudents {
	public static void main(String[] args) {
		JFrame theFrame = new JFrame("Students Enrolled in Math 101");
		Container contentPane = theFrame.getContentPane( );

		// Create a Collection of students.
		Student[] v = new Student[3];
		v[0] = new Student("123456789", "Steve Barker");
		v[1] = new Student("987654321", "Jacquie Barker");
		v[2] = new Student("000000000", "Baby Grode");

		// Create a list based on this Collection.  The reason that
		// we can do this is because the Student class defines
		// a toString() method, which causes each Student object to 
		// be rendered in terms of its name and SSN in the list.
		JList myList = new JList(v);
		contentPane.add(myList);

	       	theFrame.setSize(300, 100);  
	       	theFrame.setVisible(true);
	}
}

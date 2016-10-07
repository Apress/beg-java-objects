// SimpleGUIDemo.java - Exercise E with behavior

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// We're turning this JFrame into a variety of Listeners by implementing
// various Listener interfaces.
public class SimpleGUIDemo extends JFrame implements ActionListener, 
	FocusListener, KeyListener, MouseListener, MouseMotionListener {
	// Our components become attributes of the class.
	private JButton theButton;

	// Constructor.
	public SimpleGUIDemo() {
		// Create the button.
		theButton = new JButton("Push Me");

		// Set its colors.
		theButton.setBackground(Color.yellow);
		theButton.setForeground(Color.magenta);
		
		// Obtain a handle on the JFrame's content pane, and attach
		// the button.
		Container contentPane = this.getContentPane();
		contentPane.add(theButton);

		// Set the size.
		this.setSize(100, 100);

		// Center the JFrame on the screen.
		Dimension frameSize = this.getSize();
		Dimension screenSize = 
			Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - frameSize.width)/2,
				 (screenSize.height - frameSize.height)/2);

		// Make it visible.
		this.setVisible(true);

		// Add the Frame as a listener to the button.
		theButton.addActionListener(this);
		theButton.addKeyListener(this);
		theButton.addFocusListener(this);
		theButton.addMouseListener(this);
		theButton.addMouseMotionListener(this);
	}

	// Because we are implementing various Listener interfaces, we must
	// program the methods that these interfaces call for.

	// ActionListener - only one method required

	public void actionPerformed(ActionEvent e) {
		// Note that we can use the Event object to get info.
		// about the nature of the event.
		// When we are using a parent container as the listener,
		// it is important to sort out which of the possibly
		// many components on the container generated the event.
		if (e.getSource() == theButton) {
			System.out.println("ActionEvent (button clicked)");
		}
	}

	// FocusListener - two methods required

	public void focusGained(FocusEvent e) {
		if (e.getSource() == theButton) {
			System.out.println("FocusEvent (button is in focus)");
		}
	}

	public void focusLost(FocusEvent e) {
		if (e.getSource() == theButton) {
			System.out.println("FocusEvent (button has lost focus)");
		}
	}

	// MouseListener - five methods required

	public void mouseClicked (MouseEvent e) {
		if (e.getSource() == theButton) {
			System.out.println("MouseEvent (mouse clicked on button)");
		}
	}

	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == theButton) {
			System.out.println("MouseEvent (mouse entered button)");
		}
	}

	public void mouseExited(MouseEvent e) {
		if (e.getSource() == theButton) {
			System.out.println("MouseEvent (mouse exited button)");
		}
	}

	public void mousePressed(MouseEvent e) {
		if (e.getSource() == theButton) {
			System.out.println("MouseEvent (mouse pressed on button)");
		}
	}

	public void mouseReleased(MouseEvent e) {
		if (e.getSource() == theButton) {
			System.out.println("MouseEvent (mouse released on button)");
		}
	}

	// MouseMotionListener - two methods required

	public void mouseMoved(MouseEvent e) {
		if (e.getSource() == theButton) {
			System.out.println("MouseEvent (mouse moved on button)");
		}
	}

	public void mouseDragged(MouseEvent e) {
		if (e.getSource() == theButton) {
			System.out.println("MouseEvent (mouse dragged on button)");
		}
	}

	// KeyListener - three methods required

	public void keyTyped(KeyEvent e) {
		if (e.getSource() == theButton) {
			System.out.println("KeyEvent (key " + e.getKeyChar() + 
					   " typed on button)");
		}
	}

	public void keyPressed(KeyEvent e) {
		if (e.getSource() == theButton) {
			System.out.println("KeyEvent (key " + e.getKeyChar() + 
					   " pressed on button)");
		}
	}

	public void keyReleased(KeyEvent e) {
		if (e.getSource() == theButton) {
			System.out.println("KeyEvent (key " + e.getKeyChar() + 
					   " released on button)");
		}
	}

	public static void main(String[] args) {
		new SimpleGUIDemo();
	}
}	

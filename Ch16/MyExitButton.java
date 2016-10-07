import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyExitButton extends JButton {
    public MyExitButton() {
        super();

        this.setLayout(new GridLayout(2, 1));
        this.add(new JLabel("Press Here", JLabel.CENTER));
        this.add(new JLabel("To Exit", JLabel.CENTER));

        this.setBackground(Color.green);

        ActionListener l = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int optionChosen = JOptionPane.showConfirmDialog(
			null,
			"Are you sure you want to exit?", 
			"Exit?", 
			JOptionPane.YES_NO_OPTION,
			JOptionPane.QUESTION_MESSAGE);

		if (optionChosen == 0) { // Yes (first choice).
		    // Do whatever is required to gracefully
		    // shut down the application ... details omitted.

		    System.exit(0);
		}
		
            }
        };
        this.addActionListener(l);
    }

    // Test scaffold.
    public static void main(String[] args) {
        JFrame f = new JFrame("Using our custom exit button");
        f.getContentPane().add(new JLabel("APPLICATION SPECIFIC STUFF GOES HERE ...",
		JLabel.CENTER), BorderLayout.CENTER);
	JPanel p = new JPanel();
	p.setLayout(new GridLayout(1, 3));
	p.add(new JLabel(""));
        p.add(new MyExitButton());
	p.add(new JLabel(""));
        f.getContentPane().add(p, BorderLayout.SOUTH);
        f.setSize(400, 200);
        f.setVisible(true);
    }
}

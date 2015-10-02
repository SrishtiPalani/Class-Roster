import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * This class will create the GUI for the class roster
 * @author Srishti Palani
 */
public class RosterDisplay extends JPanel {
	/***************************** INSTANCE PROPERTIES ***********************/
	// text field for user input
	private JTextField userInputField;

	// sets the user input equal to a blank string
	String userInput = " ";

	// a displayPanel of type JPanel to hold the enrolled students and the
	// waitlisted
	JPanel displayPanel;

	// JTextArea for enrolled roster students
	JTextArea regField;

	// JTextArea for waitlisted students
	JTextArea waitField;

	// a new instance of the roster program
	RosterProgram roster = new RosterProgram();

	/***************************** INSTANCE METHODS **********************/
	/**
	 * Constructor
	 */

	public RosterDisplay() {
		// use Border Layout
		setLayout(new BorderLayout());
		// create and add panel for user input in the South
		add(createUserInputPanel(), BorderLayout.SOUTH);
		// create and add display panel in the center
		add(createDisplayPanel(), BorderLayout.CENTER);
	}

	/**
	 * Create a panel for user input with text field and button
	 */

	public JPanel createUserInputPanel() {
		// create panel (by default the panel has FlowLayout)
		JPanel userInputPanel = new JPanel();

		// set this panel background black
		userInputPanel.setBackground(Color.orange);

		// create a JTextField for the user to enter the news story
		// 30 is the number of columns
		userInputField = new JTextField(30);
		// add to user input panel
		userInputPanel.add(userInputField);
		// create a button
		// display text "ADD the class!"
		JButton addButton = new JButton("ADD NEW STUDENT");
		// add an action listener for button's action (click)
		addButton.addActionListener(new ActionListener() {

			/**
			 * invoked when associated action is performed
			 */
			public void actionPerformed(ActionEvent e) {
				// print out if the button was clicked
				System.out.println("ADD Button was clicked");

				// get the name of the person
				String input = userInputField.getText();

				// update the student list
				roster.updateStudent(input, "add");

				// refresh the GUI
				modifyDisplay();
			}
		});

		// create a button
		// display text "REMOVE the class!"

		JButton removeButton = new JButton("REMOVE STUDENT");

		// add an action listener for button's action (click)
		removeButton.addActionListener(
		new ActionListener()
		{
			/**
			 * invoked when associated action is performed
			 */

			public void actionPerformed(ActionEvent e) {
				// print out if the button was clicked
				System.out.println("REMOVE Button was clicked");
				// get the name of the person to be removed
				String input = userInputField.getText();
				// update the student list
				roster.updateStudent(input, "remove");
				// invoke modify display
				modifyDisplay();
			}
		});

		// add the enter button to the input panel
		userInputPanel.add(addButton);

		// add the enter button to the input panel
		userInputPanel.add(removeButton);

		// return the user input panel
		return userInputPanel;
}

	/**
	 * Create a panel that holds the Class Type & it's intro
	 * @return JPanel
	 **/

	public JPanel createDisplayPanel() {
		// create a new display panel
		displayPanel = new JPanel();
		// set the layout to a grid layout with 2 rows, 2 columns
		displayPanel.setLayout(new GridLayout(2, 2));
		// add the class type (regular or waitlisted)
		addClassType();
		// add the people in the list
		addClassStanding();
		// return the panel
		return displayPanel;
	}

	/**
	 * Adds the class options (enrolled vs. waitlisted) For colors, referenced:
	 * http://cloford.com/resources/colours/500col.htm
	 **/

	public void addClassType() {
		// initialize instance field of regular news label
		JLabel reg = new JLabel("ENROLLED STUDENTS:" + "\n" +"CLASS SIZE:5",
				JLabel.CENTER);
		// set the font to Monospaced, italic, size 16
		reg.setFont(new Font("Monospaced", Font.BOLD, 16));
		// create new color
		Color black = new Color(0,0,0);
		// set text equal to the color created
		reg.setForeground(black);
		// set opaque
		reg.setOpaque(true);
		// add the regular label to the display panel
		displayPanel.add(reg);
		// initialize instance field of waitlist news label
		JLabel wait = new JLabel("WAIT LIST: ", JLabel.CENTER);
		// set the font to Monospaced, italic, size 16
		wait.setFont(new Font("Monospaced", Font.BOLD, 16));
		// set text equal to the color created
		wait.setForeground(black);
		// set opaque
		wait.setOpaque(true);
		// add the cnn label to the display panel
		displayPanel.add(wait);
	}

	/**
	 * Adds the class rosters (enrolled & waitlisted)
	 * @return void
	 **/

	public void addClassStanding() {
		// create new JText area that holds the fox news intro and breaking news
		regField = new JTextArea(roster.getStudents());
		// set opaque
		regField.setOpaque(true);
		// don't allow editing
		regField.setEditable(false);
		// set line wrap
		regField.setLineWrap(true);
		// set word wrapping
		regField.setWrapStyleWord(true);
		// add to display panel
		displayPanel.add(regField);
		// create new JText area that holds the can news intro and breaking news
		waitField = new JTextArea(roster.getWaitlist());

		// set opaque
		waitField.setOpaque(true);

		// don't allow editing
		waitField.setEditable(false);

	// set line wrap
		waitField.setLineWrap(true);
	// set word wrapping
		waitField.setWrapStyleWord(true);
		// add to display panel
		displayPanel.add(waitField);

		// performs relayout
		// invalid content is asked for all the sizes and all the subcomponents
		// sizes are set to proper values by Layout Manager
		// Reference: Stack Overflow
		// (http://stackoverflow.com/questions/9510125/difference-between-validate-revalidate-and-invalidate-in-swing-gui)
			displayPanel.validate();

		// repaint
		// gets the component to repaint itself
		// Reference: Stack Overflow
		// (http://stackoverflow.com/questions/10768619/paint-and-repaint-in-java)
		displayPanel.repaint();

	}

	public void modifyDisplay() {
		// set the text to update
		regField.setText(roster.getStudents());
		// don't allow editing
		regField.setEditable(false);
		// set line wrap
		regField.setLineWrap(true);
		// set word wrapping
		regField.setWrapStyleWord(true);

		// set the text to update
		waitField.setText(roster.getWaitlist());
		// don't allow editing
		waitField.setEditable(false);
		// set line wrap
		waitField.setLineWrap(true);
		// set word wrapping
		waitField.setWrapStyleWord(true);
		// performs relayout
		displayPanel.validate();
		// repaints component
		displayPanel.repaint();
	}

}

/**
 * A Class for the Frame to hold the roster display
 * Size: 1000, 1010 pixels
 * @author: Srishti Palani
 */
import javax.swing.JFrame;

public class RosterApplication {

	/*
	 * JFrame that displays everything
	 */

	public static void main(String[] args) {
		// create a new JFrame to hold the guessing game
		JFrame classFrame = new JFrame("The Class Roster");

		// add roster panel to JFrame
		classFrame.add (new RosterDisplay());
		
		// set size
		classFrame.setSize(800,500);
		// exit normally on closing the window
		classFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// show frame
		classFrame.setVisible(true);

	}

}

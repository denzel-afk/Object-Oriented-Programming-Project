package boundary;

import control.CompanyController;

/**
 * Main class is used to initialise the CompanyController and display the main
 * page for the user to interact with the system.
 * 
 * @author Denzel Elden Wijaya
 * @author Federrico Hansen Budianto
 * @author Melisa Lee
 * @author Rivaldo Billy Sebastian
 * @version 1.0
 * @since 2024-04-26
 */
public class Main {

	/**
	 * The main method is used to initialise the CompanyController and display the
	 * main page for the user to interact with the system.
	 * 
	 * @param args The arguments passed to the main method.
	 */
	public static void main(String[] args) {

		CompanyController.initialise(); // Static
		MainUI.MainPageUI();
	}
}
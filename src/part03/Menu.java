package part03;

import java.awt.Font;

import console.Console;

public class Menu {
	private String items[];
	private String title;
	private static final Font f1 = new Font("Sans", Font.BOLD, 15);
	private static final Font f2 = new Font("Sans", Font.BOLD, 19);

	public Menu(String title, String data[]) {
		this.title = title;
		this.items = data;
	}

	/**
	 * Displays menu in the console. Title and possible choices
	 */
	private void display(Console con) {
		con.setFont(f2);
		con.println(title);
		con.setFont(f1);
		for (int count = 0; count < title.length(); count++) {
			con.print("=");
		}
		con.println();
		for (int option = 1; option <= items.length; option++) {
			con.println(option + ". " + items[option - 1]);
		}
		con.println();
	}

	/**
	 * Calls display method and asks user to make a selection. Repeats until a value within the options has been chosen
	 * @return integer value representing index of user's choice (indexed starting with 1)
	 */
	public int getUserChoice(Console con) {
		boolean ok = false;
		int value = 0;
		do {
			display(con);
			con.print("Enter Selection: ");
			try {
				String input = con.readLn();
				input = input.trim();
				value = Integer.valueOf(input);		// turns string input into an integer value
				if ( value>=1 && value<=items.length ) {
					ok = true;
				}
			} catch (Exception ex) {
				
			}
			con.clear();
		} while (!ok);
		return value;
	}
}

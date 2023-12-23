package part03;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;

import console.Console;

public class ConsoleDemo {

	private static final Font f1 = new Font("Courier", Font.BOLD, 30);
	private static final Font f2 = new Font("Courier", Font.ITALIC, 40);
	private static Font current = f1;

	public static void main(String[] args) {
		Console c1 = setup1(600, 600, 100, 100, true);
		Console c2 = setup1(600, 600, 800, 100, false);
		Color c;

		do {
			displayOptions(c1);
			String input = c1.readLn();
			input = input.trim();
			switch (input) {
			case "1":
				c = selectColour(c1);
				c2.setColour(c);
				c2.println("Colour has changed!");
				break;
			case "2":
				c = selectColour(c1);
				c2.setBgColour(c);
				break;
			case "3":
				if (current == f1) {
					c2.setFont(f2);
					current = f2;
				} else {
					c2.setFont(f1);
					current = f1;
				}
				c2.println("Font has changed!");
				break;
			case "4":
				String userdir = System.getProperty("user.dir");
				String path = userdir + "/Images/";
				String name = path + "Dog.png";
				c2.println("Dog");
				ImageIcon im = new ImageIcon(name);
				c2.println(im);
				break;
			case "5":
				c2.clear();
				break;
			case "6":
			default:
			}
		} while (true);
	}

	private static Color selectColour(Console con) {
		con.clear();
		con.print("Select Colour (1. for Red, 2. for Green, 3. for Blue: ");
		String col = con.readLn();
		col = col.trim();
		switch (col) {
		case "1":
			return Color.RED;
		case "2":
			return Color.GREEN;
		case "3":
			return Color.BLUE;
		default:
			return null;
		}
	}

	private static Console setup1(int width, int height, int xPos, int yPos, boolean isInput) {
		Console con = new Console(isInput); // true means user input is possible
		con.setSize(width, height); // set console size
		con.setVisible(true); // make console visible
		con.setLocation(xPos, yPos); // fix location of console window
		con.setFont(current); // set console font
		con.setColour(Color.WHITE); // set text colour
		con.setBgColour(Color.BLACK); // set background colour
		return con;
	}

	private static void displayOptions(Console con) {
		con.clear();
		con.println("1. Change text colour.");
		con.println("2. Change background colour.");
		con.println("3. Change font.");
		con.println("4. Display image.");
		con.println("5. Clear console.");
		con.println("6. Exit App.");
		con.print("\nEnter Selection:");
	}
}

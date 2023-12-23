package part03;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.Font;
import console.Console;
import javax.swing.ImageIcon;


public class QUBMediaKitchen {
	
	private static final Font f1 = new Font("Sans", Font.BOLD, 15);
	private static final Font f2 = new Font("Sans", Font.BOLD, 19);
	private static Console con = setup1(600, 600, 100, 100, true);
	private static ArrayList<IdedAndNamed> ingredientList = new ArrayList<IdedAndNamed>();
	private static ArrayList<IdedAndNamed> recipeList = new ArrayList<IdedAndNamed>();
	private static WeeklyMenu weeklyMenu = null;
	private static ArrayList<IdedAndNamed> defaultMenuRecipes = new ArrayList<IdedAndNamed>();
	
	public static void main(String[] args) {
		// Pre-generate default ingredients
		prefabValues();
		ingredientList = Helper.sortById(ingredientList);
		recipeList = Helper.sortById(recipeList);
		
		// Main program starts
		Menu mainMenu = new Menu("QUB Kitchen", Resources.mainOptions);
		int choice = 0;
		boolean quit = false;
		do {
			con.setColour(new Color(138, 116, 56)); // set text colour
			con.setBgColour(new Color(245, 231, 193)); // set background colour
			choice = mainMenu.getUserChoice(con);
			quit = processChoiceMain(choice);
		} while (!quit);
		con.clear();
		con.setColour(Color.WHITE); // set text colour
		con.setBgColour(Color.BLACK); // set background colour
		con.println("All done - Goodbye!");
	}
	
// Process choice methods - each menu has a method to process it's choices
	
	/**
	 * Executes method for selected choice, intended for use with mainMenu
	 * (1) go to ingredients manager
	 * (2) go to recipes manager
	 * (3) go to weekly menu manager
	 * (4) quit
	 * @param choice
	 * @return true if quit option is chosen, false for other options or if no option matches value
	 */
	private static boolean processChoiceMain(int choice) {
		boolean quit = false;
		switch (choice) {
		case 1:
			manageIngredients();
			break;
		case 2:
			manageRecipes();
			break;
		case 3:
			manageWeeklyMenu();
			break;
		case 4:
			quit = true;
		}
		return quit;
	}
	
	/**
	 * Executes method for selected choice, intended for use with ingrMenu
	 * (1) add ingredient
	 * (2) view ingredient list
	 * (3) view single ingredient
	 * (4) update ingredient
	 * (5) delete ingredient
	 * (6) quit
	 * @param choice
	 * @return true if quit option is chosen, false for other options or if no option matches value
	 */
	private static boolean processChoiceIngr(int choice) {
		boolean quit = false;
		switch (choice) {
		case 1:
			con.clear();
			con.setFont(f2);
			con.println("== Add Ingredient ==\n");
			con.setFont(f1);
			addIngredient();
			break;
		case 2:
			con.clear();
			con.setFont(f2);
			con.println("== View Ingredient List ==\n");
			con.setFont(f1);
			viewList(Helper.sortByName(ingredientList));
			break;
		case 3:	
			con.clear();
			con.setFont(f2);
			con.println("== View Single Ingredient ==\n");
			con.setFont(f1);
			viewSingleItem(ingredientList);
			break;
		case 4:
			con.clear();
			con.setFont(f2);
			con.println("== Update Ingredient ==\n");
			con.setFont(f1);
			updateIngredient();
			break;
		case 5:
			con.clear();
			con.setFont(f2);
			con.println("== Delete Ingredient ==\n");
			con.setFont(f1);
			deleteIngredient();
			break;
		case 6:
			quit = true;
		}
		return quit;
	}
	
	/**
	 * Executes method for selected choice, intended for use with recipeMenu
	 * (1) add recipe
	 * (2) view recipe list
	 * (3) view single recipe
	 * (4) update recipe
	 * (5) delete recipe
	 * (6) quit
	 * @param choice
	 * @return true if quit option is chosen, false for other options or if no option matches value
	 */
	private static boolean processChoiceRec(int choice) {
		boolean quit = false;
		switch (choice) {
		case 1:
			//add recipe
			con.clear();
			con.setFont(f2);
			con.println("== Add Recipe ==\n");
			con.setFont(f1);
			addRecipe();
			break;
		case 2:
			con.clear();
			con.setFont(f2);
			con.println("== View Recipe List ==\n");
			con.setFont(f1);
			viewList(Helper.sortByName(recipeList));
			break;
		case 3:
			con.clear();
			con.setFont(f2);
			con.println("== View Single Recipe ==\n");
			con.setFont(f1);
			viewSingleItem(recipeList);
			break;
		case 4:
			con.clear();
			con.setFont(f2);
			con.println("== Update Recipe ==\n");
			con.setFont(f1);
			updateRecipe();
			break;
		case 5:
			con.clear();
			con.setFont(f2);
			con.println("== Delete Recipe ==\n");
			con.setFont(f1);
			deleteRecipe();
			break;
		case 6:
			quit = true;
		}
		return quit;
	}
	
	/**
	 * Executes method for selected choice, intended for use with menuMenu
	 * (1) create new menu
	 * (2) view menu
	 * (3) modify menu
	 * (4) quit
	 * @param choice
	 * @return true if quit option is chosen, false for other options or if no option matches value
	 */
	private static boolean processChoiceMenu(int choice) {
		boolean quit = false;
		switch (choice) {
		case 1:
			con.clear();
			con.setFont(f2);
			con.println("== Create Weekly Menu ==\n");
			con.setFont(f1);
			createWeeklyMenu();
			break;
		case 2:
			con.clear();
			con.setFont(f2);
			con.println("== View Weekly Menu ==\n");
			con.setFont(f1);
			viewWeeklyMenu();
			break;
		case 3:
			con.clear();
			con.setFont(f2);
			con.println("== Modify Weekly Menu ==\n");
			con.setFont(f1);
			modifyWeeklyMenu();
			break;
		case 4:
			quit = true;
		}
		return quit;
	}
	
	/**
	 * Selects FoodGroup based on user input, to be used with foodGroupSelector()
	 * @param choice
	 * @return FoodGroup that matches user's chosen food group, or FoodGroup.OTHER if none match
	 */
	private static FoodGroup processFoodGroup(int choice) {
		FoodGroup result;
		switch (choice) {
		case 1:
			result = FoodGroup.DAIRY;
			break;
		case 2:
			result = FoodGroup.CEREAL;
			break;
		case 3:
			result = FoodGroup.FRUIT_AND_VEG;
			break;
		case 4:
			result = FoodGroup.PROTEIN;
			break;
		case 5:
			result = FoodGroup.SUGAR;
			break;
		case 6:
			result = FoodGroup.FAT;
			break;
		case 7:
			result = FoodGroup.SPICE_AND_HERB;
			break;
		case 8:
			result = FoodGroup.COMPOSITE_FOOD;
			break;
		case 9:
			result = FoodGroup.ESSENTIAL_NUTRIENT;
			break;
		default:
			result =  FoodGroup.OTHER;
			break;
		}
		return result;
	}
	
// Main menu methods - Creating sub-menus
	
	/**
	 * Creates menu that manages ingredients
	 */
	private static void manageIngredients() {
		Menu ingrMenu = new Menu("Ingredients Manager - QUB Kitchen", Resources.ingrOptions);
		int choice = 0;
		boolean quit = false;
		do {
			con.setColour(new Color(83, 128, 70)); // set text colour
			con.setBgColour(new Color(196, 217, 180)); // set background colour
			choice = ingrMenu.getUserChoice(con);
			quit = processChoiceIngr(choice);
		} while (!quit);
	}

	/**
	 * Creates menu that manages recipes
	 */
	private static void manageRecipes() {
		Menu recipeMenu = new Menu("Recipe Manager - QUB Kitchen", Resources.recOptions);
		int choice = 0;
		boolean quit = false;
		do {
			con.setColour(new Color(59, 113, 130)); // set text colour
			con.setBgColour(new Color(167, 199, 209)); // set background colour
			choice = recipeMenu.getUserChoice(con);
			quit = processChoiceRec(choice);
		} while (!quit);
	}

	/**
	 * Creates menu that manages the weekly menu
	 */
	private static void manageWeeklyMenu() {
		Menu menuMenu = new Menu("Weekly Menu Manager - QUB Kitchen", Resources.menuOptions);
		int choice = 0;
		boolean quit = false;
		do {
			con.setColour(new Color(98, 64, 128)); // set text colour
			con.setBgColour(new Color(188, 167, 207)); // set background colour
			choice = menuMenu.getUserChoice(con);
			quit = processChoiceMenu(choice);
		} while (!quit);
	}
	
// FoodGroup and Ingredient selector
	/**
	 * Creates menu to safely select a FoodGroup
	 */
	private static FoodGroup foodGroupSelector() {
		Menu foodGroupMenu = new Menu("Food group selection - QUB Kitchen", Resources.foodGroupOptions);
		int choice;
		choice = foodGroupMenu.getUserChoice(con);
		FoodGroup result = processFoodGroup(choice);
		return result;
	}
	/**
	 * Creates menu to safely select an Ingredient
	 */
	private static Ingredient ingredientSelector() {
		if(ingredientList.size() > 0) {
			// Create an array with names of current ingredientList for the choosing menu
			String ingrListOptions[] = new String[ingredientList.size()];
			for(int index = 0; index < ingredientList.size(); index++) {
				ingrListOptions[index]= Helper.sortByName(ingredientList).get(index).getName();
			}
			// Menu for choosing ingredient
			Menu ingrSelect = new Menu("Ingredient selection - QUB Kitchen", ingrListOptions);
			int choice;
			choice = ingrSelect.getUserChoice(con);
			Ingredient result = (Ingredient) Helper.sortByName(ingredientList).get(choice-1);
			return result;
		}
		return null;
	}
	
	
	
// Ingredient manager methods
	
	/**
	 * Asks user for name, calories (per 100g) and food group. Uses this data to create a new ingredient and add it to the ingredientList
	 */
	private static void addIngredient() {
		// Get user to input data
		con.print("Enter name: ");
		String name = inputString(con);
		con.print("\nEnter amount of calories (per 100g): ");
		double calories;
		try {
			calories = inputDouble(con);
		}catch(Exception e) {calories = -1;}
		FoodGroup foodGroup = foodGroupSelector();
		// Create ingredient
		Ingredient ingr = null;
		try {
			ingr = new Ingredient(name, foodGroup, calories);
			ingredientList.add(ingr);	//Add to list
			con.clear();
			con.println("Ingredient:\n"+ingr);
			con.println("Ingredient added successfully!\n");
			ingredientList = Helper.sortById(ingredientList);
		}catch(Exception e){
			con.clear();
			con.println("\nAn error ocurred when creating the ingredient. Please ensure all data provided is correct");
		}
		
	}
	
	/**
	 * Shows user the ingredient list and asks for id of ingredient that will be deleted. Then asks for confirmation for deletion.
	 * Finally, deletes the ingredient that matches id.
	 */
	private static void deleteIngredient() {
		if(ingredientList.size() > 0) {
			viewList(Helper.sortByName(ingredientList)); // print list for user to see
			int choice = -1; // default value
			// ask for ingredient id until a valid id is given
			do {
				con.print("Enter ID of the ingredient you wish to delete: ");
				try {
					choice = inputInt(con);
				}catch(Exception e) {
					con.println("Invalid id");
				}
			}while(Helper.searchById(ingredientList, choice)<0);
			// Delete confirmation
			con.print("Are you sure you want to delete this ingredient (id:"+choice+"): (yes or y to confirm) ");
			String ans = inputString(con);
			if(ans.trim().compareToIgnoreCase("yes") == 0 || ans.trim().compareToIgnoreCase("y") == 0) {
				int index = Helper.searchById(ingredientList, choice); // find index to delete
				ingredientList.remove(index); // delete ingredient
				con.clear();
				con.println("Ingredient was successfully deleted");
			} else {
				con.clear();
				con.println("Ingredient was not deleted");
			}
		} else {
			con.clear();
			con.println("There are no ingredients in the list.");
		}
	}
	
	/**
	 * Shows user the ingredient list and asks for id of ingredient that will be updated. 
	 * User must enter data to overwrite the ingredient. Then is asked for confirmation for update.
	 * Finally, updates the ingredient that matches id.
	 */
	private static void updateIngredient() {
		if(ingredientList.size() > 0) {
			viewList(Helper.sortByName(ingredientList)); // print list for user to see
			int choice = -1; //default value
			// ask for ingredient id until a valid id is given
			do {
				con.print("Enter ID of the ingredient you wish to update: ");
				try {
					choice = inputInt(con);
				}catch(Exception e) {
					con.println("Invalid id");
				}
			}while(Helper.searchById(ingredientList, choice)<0);
			con.clear();
			con.println("== Updating ingredient ==");
			// Get user input
			con.print("Enter name: ");
			String name = inputString(con);
			con.print("\nEnter amount of calories (per 100g): ");
			double calories;
			try {
				calories = inputDouble(con);
			}catch(Exception e) {calories = -1;}
			con.clear();
			FoodGroup foodGroup = foodGroupSelector();
			con.clear();
			// Update confirmation
			con.print("Are you sure you want to overwrite this ingredient (id:"+choice+"): (yes or y to confirm) ");
			String ans = inputString(con);
			if(ans.trim().compareToIgnoreCase("yes") == 0 || ans.trim().compareToIgnoreCase("y") == 0) {
				int index = Helper.searchById(ingredientList, choice); // find index to update
				// set new values to ingredient
				Ingredient ingr = (Ingredient) ingredientList.get(index);
				ingr.setName(name);
				ingr.setCalories(calories);
				ingr.setFoodGroup(foodGroup);
				con.clear();
				con.println("Ingredient was successfully updated");
			} else {
				con.clear();
				con.println("Ingredient was not updated");
			}
		} else {
			con.clear();
			con.println("There are no ingredients in the list.");
		}
	}
	
// Recipe manager methods
	/**
	 * Asks user for the necessary data to create a recipe and adds it to the RecipeList
	 * @return true if successful, false if the recipe creation failed
	 */
	private static boolean addRecipe(){
		// User input
		con.print("Enter name: ");
		String name = inputString(con);
		
		ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();		
		ArrayList<Double> ingrAmounts = new ArrayList<Double>();			
		ArrayList<String> ingrDetails = new ArrayList<String>();
		boolean quit = false;
		// Adding ingredients, amounts and details to their respective ArrayLists until the user decides to stop
		do {
			con.clear();
			try {
				// User input
				Ingredient ingr = ingredientSelector();
				if(ingr == null) {
					con.clear();
					con.println("Theere was an error while adding the recipe");
					return false;
				}
				con.print("Enter amount of this ingredient (in grams): ");
				double amount = inputDouble(con);
				if(amount <= 0) {
					con.clear();
					con.println("Theere was an error while adding the recipe");
					return false;
				}
				con.print("Enter any detail or specification about the ingredient: ");
				String detail = inputString(con);
				if(detail == null) {
					con.clear();
					con.println("There was an error while adding the recipe");
					return false;
				}
				
				// add values to temporary arraylist to be used in constructor
				ingredients.add(ingr);
				ingrAmounts.add(amount);
				ingrDetails.add(detail);
			}catch(Exception e) {
				con.clear();
				con.println("There was an error while adding this ingredient to the recipe.");
				return false;
			}
			// Ask user if they want to keep adding ingredients
			con.print("Do you want to stop adding ingredients to this recipe: (yes or y to confirm) ");
			String ans = inputString(con);				
			if(ans.trim().compareToIgnoreCase("yes") == 0 || ans.trim().compareToIgnoreCase("y") == 0) {
				quit = true;
			}
		}while(!quit);
		con.clear();
		try {
			// User chooses amount of steps 
			con.print("How many steps will be added to the cooking method: ");
			int count = inputInt(con);		// counts the times the following while loop repeats
			ArrayList<String> method = new ArrayList<String>();
			// Repeats for number of times chosen by user
			for(int index = 0; index < count; index++) {
				String step = null;
				con.print("Write the step "+(index+1)+" of the recipe: ");
				step = inputString(con);
				method.add(step);
			}
			con.clear();
			int serves;
			con.print("Enter amount of serves for this recipe: ");
			serves = inputInt(con);
			// Construct the recipe and add to recipe list, if all provided data has been valid
			Recipe recipe = new Recipe(name, ingredients, ingrAmounts, ingrDetails, method, serves);
			recipeList.add(recipe);
			con.clear();
			con.println("Recipe:\n"+recipe);
			con.println("Recipe added successfully!\n");
			recipeList = Helper.sortById(recipeList);
			return true;
		}catch(Exception e) {
			con.clear();
			con.println("An error ocurred adding the recipe. Make sure to fill all fields were filled with valid data");
			return false;
		}
	}
	
	/**
	 * Shows user the recipe list and asks for id of recipe that will be deleted. Then asks for confirmation for deletion.
	 * Finally, deletes the recipe that matches id.
	 */
	private static void deleteRecipe() {
		if(recipeList.size() > 0) {
			viewList(Helper.sortByName(recipeList)); // Shows list of recipes
			int choice = -1;
			// Ask for id of recipe until a valid id is given
			do {
				con.print("Enter ID of the recipe you wish to delete: ");
				try {
					choice = inputInt(con);
				}catch(Exception e) {
					con.clear();
					con.println("Invalid id. Try again");
				}
			}while(Helper.searchById(recipeList, choice)<0);
			con.clear();
			// Ask for deletion confirmation
			con.print("Are you sure you want to delete this recipe (id:"+choice+"): (yes or y to confirm) ");
			String ans = inputString(con);
			if(ans.trim().compareToIgnoreCase("yes") == 0 || ans.trim().compareToIgnoreCase("y") == 0) {
				int index = Helper.searchById(recipeList, choice); // find index to delete
				recipeList.remove(index); // delete recipe
				con.clear();
				con.println("Recipe was successfully deleted\n");
			} else {
				con.clear();
				con.println("Recipe was not deleted");
			}
		} else {
			con.clear();
			con.println("There are no recipes in the list.");
		}
	}
	
	/**
	 * Asks user for data to overwrite a recipe. Asks for id of recipe to be replaced,
	 * and confirmation to perform update.
	 * @return true if update successfully done, false otherwise
	 */
	private static boolean updateRecipe() {
		if(recipeList.size() > 0) {
			viewList(Helper.sortByName(recipeList)); // Show recipe list
			int choice = -1;
			// Ask for recipe id until a valid id is given
			do {
				con.print("Enter ID of the recipe you wish to update: ");
				try {
					choice = inputInt(con);
				}catch(Exception e) {
					con.clear();
					con.println("\n Invalid id. Try again");
					return false;
				}
			}while(Helper.searchById(recipeList, choice)<0);
			con.clear();
			// Ask for update confirmation
			con.print("Are you sure want to overwrite this recipe (id:"+choice+"): (yes or y to confirm) ");
			String ans = inputString(con);
			if(ans.trim().compareToIgnoreCase("yes") == 0 || ans.trim().compareToIgnoreCase("y") == 0) {
				int index = Helper.searchById(recipeList, choice); // find index to be updated
				// User input
				con.print("Enter name: ");
				String name = inputString(con);
				if(name == null || name.trim().length()<=0) {
					con.clear();
					con.println("There was an error while creating the recipe. Ensure name is appropiate");
					return false;
				}
				ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();		
				ArrayList<Double> ingrAmounts = new ArrayList<Double>();			
				ArrayList<String> ingrDetails = new ArrayList<String>();
				boolean quit = false;
				// Adding ingredients, amounts and details to their respective ArrayLists until the user decides to stop
				do {
					con.clear();
					try {
						Ingredient ingr = ingredientSelector();
						if(ingr == null) {
							con.clear();
							con.println("There was an error while updating the recipe");
							return false;
							}
						con.print("Enter amount of this ingredient (in grams): ");
						double amount = inputDouble(con);
						if(amount <= 0) {
							con.clear();
							con.println("There was an error while updating the recipe");
							return false;
						}
						con.print("Enter any detail or specification about the ingredient (or leave blank): ");
						String detail = inputString(con);
						if(detail == null) {
							con.clear();
							con.println("There was an error while updating the recipe");
							return false;
						}
						
						ingredients.add(ingr);
						ingrAmounts.add(amount);
						ingrDetails.add(detail);
					}catch(Exception e) {
						con.clear();
						con.println("There was an error while adding this ingredient to the recipe.");
						return false;
					}
					// Ask user if they want to keep adding ingredients
					con.print("Do you want to stop adding ingredients to this recipe: (yes or y to confirm) ");
					String answer = inputString(con);	
					if(answer.trim().compareToIgnoreCase("yes") == 0 || answer.trim().compareToIgnoreCase("y") == 0) {
						quit = true;
					}
				}while(!quit);
				con.clear();
				try {
					// Ask user for number of steps to be added
					con.print("How many steps will be added to the cooking method: ");
					int count = inputInt(con);		// counts the times the following while loop repeats
					ArrayList<String> method = new ArrayList<String>();
					// Will repeat for amount specified by user
					for(int i = 0; i < count; i++) {
						String step = null;
						con.print("Write the step "+(i+1)+" of the recipe: ");
						step = inputString(con);
						if(step == null || step.trim().length()<=0) {
							con.clear();
							con.println("Theere was an error while adding the recipe");
							return false;
							}
						method.add(step);
					}
					// User input
					con.clear();
					int serves;
					con.print("Enter amount of serves for this recipe: ");
					serves = inputInt(con);
					if(serves <= 0) {
						con.clear();
						con.println("Theere was an error while adding the recipe");
						return false;
					}
					// Update recipe
					Recipe recipe = (Recipe) recipeList.get(index);
					recipe.setName(name);
					recipe.setIngredients(ingredients, ingrAmounts, ingrDetails);
					recipe.setServes(serves);
					recipe.setMethod(method);
					
					con.clear();
					con.println("Recipe updated!");
					recipeList = Helper.sortById(recipeList);
					return true;
				}catch(Exception e) {
					con.clear();
					con.println("An error ocurred updating the recipe. Make sure to fill all fields were filled with valid data");
					return false;
				}
			} else {
				con.clear();
				con.println("Recipe was not updated");
				return false;
			}
		} else {
			con.clear();
			con.println("There are no recipes in the list.");
			return false;
		}
	}
	
	/**
	 * 	Prints out elements in an ArrayList of IdedAndNamed calling their toString() method in the order that the list is provided
	 * @param list
	 */
	private static void viewList(ArrayList<IdedAndNamed> list) {
		if(list != null && list.size()>0) {
			for(int index = 0; index < list.size(); index++) {
				// Numbers each printed element
				con.println((index+1)+". "+ list.get(index)+"\n");
				con.println(getImage(list.get(index)));
			}
		} else {
			con.println("The list is empty or does not exist");
		}
	}
	
	/**
	 * Receives the ingredientList or recipeList and lets the user search an element or elements by id, name, part-name and (ingredientList only) food group
	 * @param list
	 */
	private static void viewSingleItem(ArrayList<IdedAndNamed> list) {
		if(list != null && list.size()>0) {
			// Menu to choose searching method
			Menu searchMenu = new Menu("Searching menu", Resources.searchOptions);
			int choice;
			ArrayList<Integer> matches;
			choice = searchMenu.getUserChoice(con);
			switch(choice) {
				case 1:
					// Search by id
					con.clear();
					try {
						con.print("Enter ID for search: ");
						int selection = inputInt(con);
						con.clear();
						con.println(list.get(Helper.searchById(list, selection)).getDetails()+"\n");	// ingredientList and RecipeList are by default already sorted by id
						con.println(getImage(list.get(Helper.searchById(list, selection))));
					}catch(Exception e) {
						con.clear();
						con.println("An error ocurred when searching for this id\n");
					}
					break;
				case 2:
					// Search by name
					con.clear();
					con.print("Enter name for search: ");
					String name = inputString(con);	
					list = Helper.sortByName(list);	// sort by name before search
					matches = Helper.searchByName(list, name);
					if(matches.size() <= 0) {
						con.clear();
						con.println("No elements matched");
						break;
					}
					con.clear();
					con.println("Matches:");
					// Print each element that matches
					for(int i = 0; i < matches.size(); i++) {
						con.println(list.get(matches.get(i)).getDetails());
						con.println(getImage(list.get(matches.get(i))));
					}
					con.println();
					break;
				case 3:
					// Search by part-name
					con.clear();
					con.print("Enter name for search: ");
					String partName = inputString(con);	
					list = Helper.sortByName(list);	// sort by name before search
					matches = Helper.searchByPartName(list, partName);
					if(matches.size() <= 0) {
						con.clear();
						con.println("No elements matched");
						break;
					}
					con.clear();
					con.println("Matches:");
					// Print each element that matches
					for(int i = 0; i < matches.size(); i++) {
						con.println(list.get(matches.get(i)).getDetails());
						con.println(getImage(list.get(matches.get(i))));
					}
					con.println();
					break;
				case 4:
					// Search by food group
					con.clear();
					// create an arrayList of ingredients to add as argument for searchByFoodGroup()
					ArrayList<Ingredient> ingrList = new ArrayList<Ingredient>();	
					try {
						for(int i = 0; i < list.size(); i++) {
							ingrList.add((Ingredient) list.get(i));
						}
					}catch(Exception e) {
						con.clear();
						// If casting elements to ingredient fails, functionality only usable with ingredient lists
						con.println("Option only available for searching ingredients");
						break;
					}
					ingrList = Helper.sortByFoodGroup(ingrList);	// sort list
					FoodGroup foodGroup = foodGroupSelector();		// user input
					matches = Helper.searchByFoodGroup(ingrList, foodGroup); // obtains matching indexes
					if(matches.size() <= 0) {
						con.clear();
						con.println("No elements matched");
						break;
					}
					// create an arrayList of the resulting ingredients to be sorted by name for display
					ArrayList<Ingredient> result = new ArrayList<Ingredient>();
					for(int i = 0; i < matches.size(); i++) {
						result.add(ingrList.get(matches.get(i)));
					}
					result = Helper.sortByName((ArrayList)result); // sort by name. Arraylist will always contain ingredients
					con.clear();
					con.println("Matches:");
					// Print each element that matches
					for(int i = 0; i < result.size(); i++) {
						con.println(result.get(i).getDetails());
						con.println(getImage(list.get(matches.get(i))));
					}
					con.println();
					break;
				default:
					con.clear();
					con.println("Search cancelled\n");
					return;
			}
		} else {
			con.clear();
			con.println("The list is empty or does not exist");
		}
	}
	
	/**
	 * Creates weekly menu with recipes chosen by user, or using default values
	 * @return true if weekly menu is successfully created, otherwise false
	 */
	private static boolean createWeeklyMenu() {
		if(weeklyMenu != null) {
			con.print("A weekly menu already exists. Do you want to create a new one anyway? If creation is successful, this will overwrite existing menu: (yes or y to confirm) ");
			String answer = inputString(con);
			// Confirm overwriting weekly menu
			if(!(answer.trim().compareToIgnoreCase("yes") == 0 || answer.trim().compareToIgnoreCase("y") == 0)) {
				return false;
			}
		}
		con.clear();
		// Ask if user will input recipes or menu will create with default values
		con.print("Do you want to choose the recipes for the menu (otherwise, it will be filled with default data): (yes or y to confirm) ");
		String answer = inputString(con);
		if(answer.trim().compareToIgnoreCase("yes") == 0 || answer.trim().compareToIgnoreCase("y") == 0) {
			if(recipeList.size() > 0) {
				ArrayList<IdedAndNamed> menuRecipes = new ArrayList<IdedAndNamed>();
				con.clear();
				viewList(Helper.sortByName(recipeList));	// Show recipes to user
				for(int i = 0; i < WeeklyMenu.getRecipeNum(); i++) {
					int choice = 0;
					do {
						con.print("Enter ID of the recipe you wish to add for "+ Resources.mealTimes[i].toLowerCase() +": ");
						try {
							choice = inputInt(con);
						}catch(Exception e) {
							con.println("Invalid id. Try again");
						}
					}while(Helper.searchById(recipeList, choice)<0);
					int index = Helper.searchById(recipeList, choice);	// get index of recipe in recipeList
					menuRecipes.add(recipeList.get(index));				// add recipe to menu
				}
				try {
					// create new weekly menu with user input
					weeklyMenu = new WeeklyMenu(menuRecipes);
					con.clear();
					con.println("The weekly menu was successfully created\n"); 
				}catch(Exception e) {
					con.clear();
					con.println("There was an error creating the weekly menu\n"); 
					return false;
					}
			} else {
				con.clear();
				con.println("There are no recipes in the list. Creation of weekly menu cancelled.\n");
				return false;
			}
		} else {
			try {
				// create new weekly menu with default values
				weeklyMenu = new WeeklyMenu(defaultMenuRecipes);
				con.clear();
				con.println("Weekly menu was successfully created using default values!");
			}catch(Exception e) {
				con.clear();
				con.println("There was an error creating the weekly menu"); 
				return false;
				}
		}
		return true;
	}
	
	/**
	 * Prints out weekly menu for user to view
	 */
	private static void viewWeeklyMenu() {
		if(weeklyMenu != null) {
			for(int i = 0; i < weeklyMenu.getRecipes().size(); i++) {
				// Print recipe and allocated time of the week
				con.println(Resources.mealTimes[i]+": "+ weeklyMenu.getRecipes().get(i)+ "\n");
			}
		}else {
			con.println("No weekly meny has been created yet.\n");
		}
	}
	
	/**
	 * Asks user for an element they want to replace from the menu,
	 * and a recipe to replace it with.
	 * @return true if weekly menu is successfully modified
	 */
	private static boolean modifyWeeklyMenu() {
		// if weekly menu does not exist, exit
		if(weeklyMenu != null) {
			// Print weeklyMeny to the user in a numbered list
			for(int i = 0; i < weeklyMenu.getRecipes().size(); i++) {
				con.println((i+1)+". \t"+Resources.mealTimes[i]+": "+ weeklyMenu.getRecipes().get(i));
			}
			// Get user input
			try {
				con.println("Enter selection for the recipe you would like to modify (1-15): ");
				int selection = inputInt(con);
				// Make sure chosen position is valid
				if(selection > WeeklyMenu.getRecipeNum() || selection <= 0){
					con.clear();
					con.println("Invalid selection. No changes have been made.");
					return false;
				}
				viewList(Helper.sortByName(recipeList)); // Show recipes to user
				int choice = 0;
				// Ask for recipe until valid id is given
				do {
					con.print("Enter ID of the recipe you wish to replace this position with: ");
					try {
						choice = inputInt(con);
					}catch(Exception e) {
						con.println("Invalid id");
					}
				}while(Helper.searchById(recipeList, choice)<0);
				int index = Helper.searchById(recipeList, choice); // get index of recipe in recipeList
				// replace recipe at chosen position with chosen recipe
				weeklyMenu.replaceRecipe((Recipe)recipeList.get(index), (selection-1)); 
				con.clear();
				con.println("Weekly menu successfully modified!\n");
				return true;
			}catch(Exception e) {
				con.clear();
				con.println("An error ocurred while modifying the weekly menu. No changes have been made.");
				return false;
			}
		}else {
			con.clear();
			con.println("No weekly meny has been created yet.");
			return false;
		}
	}
	
	/**
	 * Safely create a console object for program input and output
	 * @param width
	 * @param height
	 * @param xPos
	 * @param yPos
	 * @param isInput
	 * @return
	 */
	private static Console setup1(int width, int height, int xPos, int yPos, boolean isInput) {
		Console con = new Console(isInput); // true means user input is possible
		con.setSize(width, height); // set console size
		con.setVisible(true); // make console visible
		con.setLocation(xPos, yPos); // fix location of console window
		con.setFont(f1); // set console font
		con.setColour(Color.BLACK); // set text colour
		con.setBgColour(Color.lightGray); // set background colour
		return con;
	}
	
	/**
	 * Uses console method readLn() to receive user input string
	 * @param con
	 * @return string provided by user
	 */
	private static String inputString(Console con) {
		String input = con.readLn();
		input = input.trim();
		return input;
	}
	
	/**
	 * Uses console method readLn() to receive user input string and convert it to int
	 * @param con
	 * @return int provided by user
	 * @exception
	 */
	private static int inputInt(Console con) throws Exception {
		int value;
		String input = con.readLn();
		input = input.trim();
		try {
			value = Integer.valueOf(input);	
		}catch(Exception e) {
			throw new Exception("Invalid data: String '"+input+"' cannot be converted to int");
		}
		return value;
	}
	
	/**
	 * Uses console method readLn() to receive user input string and convert it to int
	 * @param con
	 * @return int provided by user
	 * @exception
	 */
	private static double inputDouble(Console con) throws Exception {
		double value;
		String input = con.readLn();
		input = input.trim();
		try {
			value = Double.valueOf(input);	
		}catch(Exception e) {
			throw new Exception("Invalid data: String '"+input+"' cannot be converted to double");
		}
		return value;
	}
	
	/**
	 * Returns image associated with a prefab ingredient or recipe
	 * @param element
	 * @return ImageIcon for given premade IdedAndNamed
	 */
	private static ImageIcon getImage(IdedAndNamed element){
		// Check if element is an ingredient, otherwise element is a recipe
		boolean isIngr;
		int index;
		try {
			element = (Ingredient) element;
			isIngr = true;
		}catch(Exception e) {isIngr = false;}
		if(isIngr && element.getId() <= 25){
			index = element.getId();
		} else if(!isIngr && element.getId() <= 15) {
			index = element.getId() + 25;
		} else {
			index = 0;
		}
		// Prepare image path
		String userdir = System.getProperty("user.dir");
		String path = userdir + "/Images/";
		String name = path + index+".png";
		ImageIcon im = new ImageIcon(name);
		
		return im;
	}
	
	/**
	 * Creates 25 ingredients, 15 recipes and an ArrayList of recipes as defaultRecipes for weeklyMenu
	 */
	private static void prefabValues() {
		try {
			// Ingredients
			Ingredient ingr1 = new Ingredient("Bread", FoodGroup.CEREAL, 265);
			Ingredient ingr2 = new Ingredient("Cheese", FoodGroup.DAIRY, 402);
			Ingredient ingr3 = new Ingredient("Minced beef", FoodGroup.PROTEIN, 332);
			Ingredient ingr4 = new Ingredient("Mayonnaise", FoodGroup.OTHER, 200);
			Ingredient ingr5 = new Ingredient("Banana", FoodGroup.FRUIT_AND_VEG, 89);
			Ingredient ingr6 = new Ingredient("Strawberry", FoodGroup.FRUIT_AND_VEG, 33);
			Ingredient ingr7 = new Ingredient("Grapes", FoodGroup.FRUIT_AND_VEG, 67);
			Ingredient ingr8 = new Ingredient("Pineapple", FoodGroup.FRUIT_AND_VEG, 50);
			Ingredient ingr9 = new Ingredient("Egg", FoodGroup.PROTEIN, 155);
			Ingredient ingr10 = new Ingredient("Penne", FoodGroup.CEREAL, 131);
			Ingredient ingr11 = new Ingredient("Tuna", FoodGroup.PROTEIN, 132);
			Ingredient ingr12 = new Ingredient("Spaghetti", FoodGroup.CEREAL, 150);
			Ingredient ingr13 = new Ingredient("Chicken", FoodGroup.PROTEIN, 239);
			Ingredient ingr14 = new Ingredient("Carbonara sauce", FoodGroup.OTHER, 191);
			Ingredient ingr15 = new Ingredient("Bolognese sauce", FoodGroup.OTHER, 131);
			Ingredient ingr16 = new Ingredient("Ham", FoodGroup.COMPOSITE_FOOD, 140);
			Ingredient ingr17 = new Ingredient("Butter", FoodGroup.FAT, 700);
			Ingredient ingr18 = new Ingredient("Peanut butter", FoodGroup.SUGAR, 588);
			Ingredient ingr19 = new Ingredient("Strawberry jam", FoodGroup.SUGAR, 278);
			Ingredient ingr20 = new Ingredient("Orange", FoodGroup.FRUIT_AND_VEG, 47);
			Ingredient ingr21 = new Ingredient("Water", FoodGroup.ESSENTIAL_NUTRIENT, 0);
			Ingredient ingr22 = new Ingredient("Sugar", FoodGroup.SUGAR, 380);
			Ingredient ingr23 = new Ingredient("Pesto sauce", FoodGroup.OTHER, 370);
			Ingredient ingr24 = new Ingredient("Beans", FoodGroup.FRUIT_AND_VEG, 347);
			Ingredient ingr25 = new Ingredient("Avocado", FoodGroup.FRUIT_AND_VEG, 160);
			ingredientList.add(ingr1);		// Bread
			ingredientList.add(ingr2);		// Cheese
			ingredientList.add(ingr3);		// Minced beef
			ingredientList.add(ingr4);		// Mayonnaise
			ingredientList.add(ingr5);		// Banana
			ingredientList.add(ingr6);		// Strawberry
			ingredientList.add(ingr7);		// Grapes
			ingredientList.add(ingr8);		// Pineapple
			ingredientList.add(ingr9);		// Egg
			ingredientList.add(ingr10);		// Penne
			ingredientList.add(ingr11);		// Tuna
			ingredientList.add(ingr12);		// Spaghetti
			ingredientList.add(ingr13);		// Chicken
			ingredientList.add(ingr14);		// Carbonara sauce
			ingredientList.add(ingr15);		// Bolognese sauce
			ingredientList.add(ingr16);		// Ham
			ingredientList.add(ingr17);		// Butter
			ingredientList.add(ingr18);		// Peanut butter
			ingredientList.add(ingr19);		// Strawberry jam
			ingredientList.add(ingr20);		// Orange
			ingredientList.add(ingr21);		// Water
			ingredientList.add(ingr22);		// Sugar
			ingredientList.add(ingr23);		// Pesto sauce
			ingredientList.add(ingr24);		// Beans
			ingredientList.add(ingr25);		// Avocado
			
			// Recipes
			
			// 1. Cheese burger (Recipe)
			ArrayList<Ingredient> ingrListTemp = new ArrayList<Ingredient>();
			ArrayList<Double> ingrAmountTemp = new ArrayList<Double>();
			ArrayList<String> ingrDetailTemp = new ArrayList<String>();
			ArrayList<String> methodTemp = new ArrayList<String>();
			ingrListTemp.add(ingr1);
			ingrAmountTemp.add(200.0);
			ingrDetailTemp.add("2 burger buns");
			ingrListTemp.add(ingr2);
			ingrAmountTemp.add(40.0);
			ingrDetailTemp.add("2 slices");
			ingrListTemp.add(ingr3);
			ingrAmountTemp.add(300.0);
			ingrDetailTemp.add("");
			ingrListTemp.add(ingr4);
			ingrAmountTemp.add(100.0);
			ingrDetailTemp.add("");			
			methodTemp.add("Shape the minced beef into two beef patties");
			methodTemp.add("Cook the beef patties in a pan at high heat until brown");
			methodTemp.add("Place the patties on the bottom buns, and add a cheese slice on top of each one.");
			methodTemp.add("Add mayo, close the burger and enjoy!");
			Recipe rec1 = new Recipe("Cheese burger", ingrListTemp, ingrAmountTemp, ingrDetailTemp, methodTemp, 2);
			
			// 2. Fruit Salad (Recipe)
			ingrListTemp = new ArrayList<Ingredient>();
			ingrAmountTemp = new ArrayList<Double>();
			ingrDetailTemp = new ArrayList<String>();
			methodTemp = new ArrayList<String>();
			ingrListTemp.add(ingr5);
			ingrAmountTemp.add(100.0);
			ingrDetailTemp.add("sliced");
			ingrListTemp.add(ingr6);
			ingrAmountTemp.add(100.0);
			ingrDetailTemp.add("");
			ingrListTemp.add(ingr7);
			ingrAmountTemp.add(50.0);
			ingrDetailTemp.add("");
			ingrListTemp.add(ingr8);
			ingrAmountTemp.add(100.0);
			ingrDetailTemp.add("sliced");			
			methodTemp.add("Place all ingredients in a bowl");
			methodTemp.add("Mix thoroughly, add any toppings of your liking, and enjoy!");
			Recipe rec2 = new Recipe("Fruit salad", ingrListTemp, ingrAmountTemp, ingrDetailTemp, methodTemp, 1);
			
			// 3. Scrambled eggs and toast
			ingrListTemp = new ArrayList<Ingredient>();
			ingrAmountTemp = new ArrayList<Double>();
			ingrDetailTemp = new ArrayList<String>();
			methodTemp = new ArrayList<String>();
			ingrListTemp.add(ingr1);
			ingrAmountTemp.add(200.0);
			ingrDetailTemp.add("2 slices");
			ingrListTemp.add(ingr9);
			ingrAmountTemp.add(200.0);
			ingrDetailTemp.add("2 large eggs");			
			methodTemp.add("Break the eggs into a bowl, season and mix until no clear parts can be seen.");
			methodTemp.add("Cook the eggs in a pan at high heat and stirring constantly.");
			methodTemp.add("Toast bread on the toaster for desired amount");
			methodTemp.add("Serve together and enjoy!");
			Recipe rec3 = new Recipe("Scrambled eggs and toast", ingrListTemp, ingrAmountTemp, ingrDetailTemp, methodTemp, 1);
			
			// 4. Fried eggs and toast
			ingrListTemp = new ArrayList<Ingredient>();
			ingrAmountTemp = new ArrayList<Double>();
			ingrDetailTemp = new ArrayList<String>();
			methodTemp = new ArrayList<String>();
			ingrListTemp.add(ingr1);
			ingrAmountTemp.add(200.0);
			ingrDetailTemp.add("2 slices");
			ingrListTemp.add(ingr9);
			ingrAmountTemp.add(200.0);
			ingrDetailTemp.add("2 large eggs");			
			methodTemp.add("Break the eggs directly into the a pan and cook at high heat.");
			methodTemp.add("Toast bread on the toaster for desired amount");
			methodTemp.add("Serve together and enjoy!");
			Recipe rec4 = new Recipe("Fried eggs and toast", ingrListTemp, ingrAmountTemp, ingrDetailTemp, methodTemp, 1);
			
			// 5. Tuna and mayonnaise pasta
			ingrListTemp = new ArrayList<Ingredient>();
			ingrAmountTemp = new ArrayList<Double>();
			ingrDetailTemp = new ArrayList<String>();
			methodTemp = new ArrayList<String>();
			ingrListTemp.add(ingr10);
			ingrAmountTemp.add(200.0);
			ingrDetailTemp.add("");
			ingrListTemp.add(ingr11);
			ingrAmountTemp.add(150.0);
			ingrDetailTemp.add("canned");		
			ingrListTemp.add(ingr4);
			ingrAmountTemp.add(50.0);
			ingrDetailTemp.add("");
			methodTemp.add("Bring water to a boil on a saucepan");
			methodTemp.add("Add pasta to the boiling water and cook at medium heat.");
			methodTemp.add("Strain the pasta, and put back into saucepan");
			methodTemp.add("Add tuna and mayo to the pasta and mix together.");
			methodTemp.add("Serve and enjoy!");
			Recipe rec5 = new Recipe("Tuna and mayonnaise pasta", ingrListTemp, ingrAmountTemp, ingrDetailTemp, methodTemp, 1);
			
			// 6. Chicken carbonara
			ingrListTemp = new ArrayList<Ingredient>();
			ingrAmountTemp = new ArrayList<Double>();
			ingrDetailTemp = new ArrayList<String>();
			methodTemp = new ArrayList<String>();
			ingrListTemp.add(ingr12);
			ingrAmountTemp.add(300.0);
			ingrDetailTemp.add("");
			ingrListTemp.add(ingr13);
			ingrAmountTemp.add(200.0);
			ingrDetailTemp.add("");		
			ingrListTemp.add(ingr14);
			ingrAmountTemp.add(50.0);
			ingrDetailTemp.add("");
			methodTemp.add("Bring water to a boil on a saucepan");
			methodTemp.add("Add pasta to the boiling water and cook at medium heat.");
			methodTemp.add("Strain the pasta, and put back into saucepan");
			methodTemp.add("Chop chicken into cubes.");
			methodTemp.add("Cook chicken in a pan until golden brown.");
			methodTemp.add("Add chicken and sauce to pasta and mix together.");
			methodTemp.add("Serve and enjoy!");
			Recipe rec6 = new Recipe("Chicken carbonara", ingrListTemp, ingrAmountTemp, ingrDetailTemp, methodTemp, 2);

			// 7. Spaghetti bolognese
			ingrListTemp = new ArrayList<Ingredient>();
			ingrAmountTemp = new ArrayList<Double>();
			ingrDetailTemp = new ArrayList<String>();
			methodTemp = new ArrayList<String>();
			ingrListTemp.add(ingr12);
			ingrAmountTemp.add(300.0);
			ingrDetailTemp.add("");
			ingrListTemp.add(ingr3);
			ingrAmountTemp.add(200.0);
			ingrDetailTemp.add("");		
			ingrListTemp.add(ingr15);
			ingrAmountTemp.add(50.0);
			ingrDetailTemp.add("");
			methodTemp.add("Bring water to a boil on a saucepan");
			methodTemp.add("Add pasta to the boiling water and cook at medium heat.");
			methodTemp.add("Strain the pasta, and put back into saucepan");
			methodTemp.add("Cook beef in a pan until golden brown, stirring constantly.");
			methodTemp.add("Add beef and sauce to pasta and mix together.");
			methodTemp.add("Serve and enjoy!");
			Recipe rec7 = new Recipe("Spaghetti bolognese", ingrListTemp, ingrAmountTemp, ingrDetailTemp, methodTemp, 2);
			
			// 8. Grilled cheese sandwich
			ingrListTemp = new ArrayList<Ingredient>();
			ingrAmountTemp = new ArrayList<Double>();
			ingrDetailTemp = new ArrayList<String>();
			methodTemp = new ArrayList<String>();
			ingrListTemp.add(ingr1);
			ingrAmountTemp.add(200.0);
			ingrDetailTemp.add("2 slices");
			ingrListTemp.add(ingr2);
			ingrAmountTemp.add(40.0);
			ingrDetailTemp.add("1 slice");		
			ingrListTemp.add(ingr17);
			ingrAmountTemp.add(20.0);
			ingrDetailTemp.add("");
			methodTemp.add("Spread butter on two bread slices");
			methodTemp.add("Place cheese on one of the slices, on the side without the butter.");
			methodTemp.add("Close the sandwich with both buttered sides facing outwards");
			methodTemp.add("Place in a pan at medium heat, until bread is golden and toasted.");
			methodTemp.add("Serve and enjoy!");
			Recipe rec8 = new Recipe("Grilled cheese sandwich", ingrListTemp, ingrAmountTemp, ingrDetailTemp, methodTemp, 1);
			
			// 9. Ham and cheese sandwich
			ingrListTemp = new ArrayList<Ingredient>();
			ingrAmountTemp = new ArrayList<Double>();
			ingrDetailTemp = new ArrayList<String>();
			methodTemp = new ArrayList<String>();
			ingrListTemp.add(ingr1);
			ingrAmountTemp.add(200.0);
			ingrDetailTemp.add("2 slices");
			ingrListTemp.add(ingr2);
			ingrAmountTemp.add(40.0);
			ingrDetailTemp.add("1 slice");		
			ingrListTemp.add(ingr17);
			ingrAmountTemp.add(20.0);
			ingrDetailTemp.add("");
			ingrListTemp.add(ingr16);
			ingrAmountTemp.add(60.0);
			ingrDetailTemp.add("2 slices");
			methodTemp.add("Spread butter on two bread slices");
			methodTemp.add("Place cheese and ham on one of the slices, on the side without the butter.");
			methodTemp.add("Close the sandwich with both buttered sides facing outwards");
			methodTemp.add("Place in a pan at medium heat, until bread is golden and toasted.");
			methodTemp.add("Serve and enjoy!");
			Recipe rec9 = new Recipe("Ham and cheese sandwich", ingrListTemp, ingrAmountTemp, ingrDetailTemp, methodTemp, 1);
			
			// 10. Peanut butter and jam sandwich
			ingrListTemp = new ArrayList<Ingredient>();
			ingrAmountTemp = new ArrayList<Double>();
			ingrDetailTemp = new ArrayList<String>();
			methodTemp = new ArrayList<String>();
			ingrListTemp.add(ingr1);
			ingrAmountTemp.add(200.0);
			ingrDetailTemp.add("2 slices");
			ingrListTemp.add(ingr18);
			ingrAmountTemp.add(100.0);
			ingrDetailTemp.add("");		
			ingrListTemp.add(ingr19);
			ingrAmountTemp.add(100.0);
			ingrDetailTemp.add("");
			methodTemp.add("Spread peanut butter on one of the bread slices");
			methodTemp.add("Spread jam on the other bread slice");
			methodTemp.add("Close the sandwich, with the peanut butter and jam on the inside.");
			methodTemp.add("Serve and enjoy!");
			Recipe rec10 = new Recipe("Peanut butter and jam sandwich", ingrListTemp, ingrAmountTemp, ingrDetailTemp, methodTemp, 1);
			
			// 11. Orange juice
			ingrListTemp = new ArrayList<Ingredient>();
			ingrAmountTemp = new ArrayList<Double>();
			ingrDetailTemp = new ArrayList<String>();
			methodTemp = new ArrayList<String>();
			ingrListTemp.add(ingr20);
			ingrAmountTemp.add(1000.0);
			ingrDetailTemp.add("whole oranges");
			ingrListTemp.add(ingr21);
			ingrAmountTemp.add(750.0);
			ingrDetailTemp.add("");		
			ingrListTemp.add(ingr22);
			ingrAmountTemp.add(50.0);
			ingrDetailTemp.add("");
			methodTemp.add("Squeeze oranges, letting the juice into a jar.");
			methodTemp.add("Add water and sugar to the freshly squeezed juice");
			methodTemp.add("Mix thoroughly, and add any extra sugar as needed.");
			methodTemp.add("Serve and enjoy!");
			Recipe rec11 = new Recipe("Orange juice", ingrListTemp, ingrAmountTemp, ingrDetailTemp, methodTemp, 4);
			
			// 12. Hard boiled eggs and toast
			ingrListTemp = new ArrayList<Ingredient>();
			ingrAmountTemp = new ArrayList<Double>();
			ingrDetailTemp = new ArrayList<String>();
			methodTemp = new ArrayList<String>();
			ingrListTemp.add(ingr1);
			ingrAmountTemp.add(200.0);
			ingrDetailTemp.add("2 slices");
			ingrListTemp.add(ingr9);
			ingrAmountTemp.add(200.0);
			ingrDetailTemp.add("2 large eggs");			
			methodTemp.add("Bring water to a boil on a saucepan");
			methodTemp.add("Cook eggs in boiling water.");
			methodTemp.add("Toast bread on the toaster for desired amount");
			methodTemp.add("Serve together and enjoy!");
			Recipe rec12 = new Recipe("Hard-boiled eggs and toast", ingrListTemp, ingrAmountTemp, ingrDetailTemp, methodTemp, 1);
			
			// 13. Pesto pasta
			ingrListTemp = new ArrayList<Ingredient>();
			ingrAmountTemp = new ArrayList<Double>();
			ingrDetailTemp = new ArrayList<String>();
			methodTemp = new ArrayList<String>();
			ingrListTemp.add(ingr10);
			ingrAmountTemp.add(300.0);
			ingrDetailTemp.add("");
			ingrListTemp.add(ingr13);
			ingrAmountTemp.add(200.0);
			ingrDetailTemp.add("");		
			ingrListTemp.add(ingr23);
			ingrAmountTemp.add(50.0);
			ingrDetailTemp.add("");
			methodTemp.add("Bring water to a boil on a saucepan");
			methodTemp.add("Add pasta to the boiling water and cook at medium heat.");
			methodTemp.add("Strain the pasta, and put back into saucepan");
			methodTemp.add("Chop chicken into cubes.");
			methodTemp.add("Cook chicken in a pan until golden brown.");
			methodTemp.add("Add chicken and sauce to pasta and mix together.");
			methodTemp.add("Serve and enjoy!");
			Recipe rec13 = new Recipe("Pesto pasta", ingrListTemp, ingrAmountTemp, ingrDetailTemp, methodTemp, 2);
			
			// 14. Beans on toast
			ingrListTemp = new ArrayList<Ingredient>();
			ingrAmountTemp = new ArrayList<Double>();
			ingrDetailTemp = new ArrayList<String>();
			methodTemp = new ArrayList<String>();
			ingrListTemp.add(ingr1);
			ingrAmountTemp.add(150.0);
			ingrDetailTemp.add("2 slices");
			ingrListTemp.add(ingr24);
			ingrAmountTemp.add(280.0);
			ingrDetailTemp.add("canned");		
			methodTemp.add("Pour beans into a saucepan.");
			methodTemp.add("Leave them at medium heat for 3 roughly minutes");
			methodTemp.add("Toast bread on the toaster for desired amount");
			methodTemp.add("Serve toasts and spread beans over them.");
			methodTemp.add("Enjoy!");
			Recipe rec14 = new Recipe("Beans on toast", ingrListTemp, ingrAmountTemp, ingrDetailTemp, methodTemp, 1);
			
			// 15. Avocado toast
			ingrListTemp = new ArrayList<Ingredient>();
			ingrAmountTemp = new ArrayList<Double>();
			ingrDetailTemp = new ArrayList<String>();
			methodTemp = new ArrayList<String>();
			ingrListTemp.add(ingr1);
			ingrAmountTemp.add(150.0);
			ingrDetailTemp.add("2 slices");
			ingrListTemp.add(ingr25);
			ingrAmountTemp.add(220.0);
			ingrDetailTemp.add("");		
			methodTemp.add("Mash avocados on a bowl.");
			methodTemp.add("Toast bread on the toaster for desired amount");
			methodTemp.add("Serve toasts and spread the avocado mix over them.");
			methodTemp.add("Enjoy!");
			Recipe rec15 = new Recipe("Avocado toast", ingrListTemp, ingrAmountTemp, ingrDetailTemp, methodTemp, 1);
			
			// Add recipes to recipeList
			recipeList.add(rec1);	// Cheese burger
			recipeList.add(rec2);	// Fruit salad
			recipeList.add(rec3);	// Scrambled eggs and toast
			recipeList.add(rec4);	// Fried eggs and toast
			recipeList.add(rec5);	// Tuna and mayonnaise pasta
			recipeList.add(rec6);	// Chicken carbonara
			recipeList.add(rec7);	// Spaghetti bolognese
			recipeList.add(rec8);	// Grilled cheese sandwich
			recipeList.add(rec9);	// Ham and cheese sandwich
			recipeList.add(rec10);	// Peanut butter and jam sandwich
			recipeList.add(rec11);	// Orange juice
			recipeList.add(rec12);	// Hard-boiled eggs and toast
			recipeList.add(rec13);	// Pesto pasta
			recipeList.add(rec14);	// Beans on toast
			recipeList.add(rec15);	// Avocado toast
			
			// Default menu recipes
			defaultMenuRecipes.add(rec2);	// Monday morning
			defaultMenuRecipes.add(rec1);	// Monday afternoon
			defaultMenuRecipes.add(rec6);	// Monday evening
			
			defaultMenuRecipes.add(rec3);	// Tuesday morning
			defaultMenuRecipes.add(rec5);	// Tuesday afternoon
			defaultMenuRecipes.add(rec15);	// Tuesday evening
			
			defaultMenuRecipes.add(rec4);	// Wednesday morning
			defaultMenuRecipes.add(rec8);	// Wednesday afternoon
			defaultMenuRecipes.add(rec7);	// Wednesday evening
			
			defaultMenuRecipes.add(rec9);	// Thursday morning
			defaultMenuRecipes.add(rec12);	// Thursday afternoon
			defaultMenuRecipes.add(rec10);	// Thursday evening
			
			defaultMenuRecipes.add(rec11);	// Friday morning
			defaultMenuRecipes.add(rec13);	// Friday afternoon
			defaultMenuRecipes.add(rec14);	// Friday evening
			
		}catch(Exception e){
			con.println("There was an error while creating the prefab ingredients and recipes");
		}
	}
}
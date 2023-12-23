package part03;

import java.util.ArrayList;

public class WeeklyMenu {
	private ArrayList<IdedAndNamed> recipes;
	private static final int RECIPE_NUM = 15;
	
	/**
	 * WeeklyMenu constructor
	 * @param recipes
	 * @throws Exception
	 */
	public WeeklyMenu(ArrayList<IdedAndNamed> recipes) throws Exception{
		if(!setRecipes(recipes)){
			throw new Exception("Bad data: "+ recipes);
		}
	}
	
	// Accesor method
	
	/**
	 * Recipes accessor
	 * @return recipes arraylist of weeklyMenu instance
	 */
	public ArrayList<IdedAndNamed> getRecipes(){
		return this.recipes;
	}
	/**
	 * Recipe_num accessor
	 * @return constant number of recipes in every weeklyMenu
	 */
	public static int getRecipeNum() {
		return RECIPE_NUM;
	}
	
	// Mutator method
	
	/**
	 * Recipes mutator
	 * @param recipes
	 * @return true if recipes successfully set, otherwise false
	 */
	public boolean setRecipes(ArrayList<IdedAndNamed> recipes) {
		// ensure recipe list contains right amount of elements
		if(recipes.size() != RECIPE_NUM) {
			return false;
		}
		// for each recipe, check reference is not null
		for(int index = 0; index < recipes.size(); index++) {
			if(recipes.get(index) == null) {
				return false;
			}
		}
		this.recipes = recipes;
		return true;
	}
	
	/** Replaces the recipe at index position with the new recipe given
	 * 
	 * Indexed 0 to RECIPE_NUM-1
	 * 
	 * @param recipe
	 * @param index
	 * @return true if the recipe was successfully replaced, otherwise false
	 */
	public boolean replaceRecipe(Recipe recipe, int index) {
		// check recipe reference not null and index is within range 0-14 (inclusive)
		if(recipe != null && index < RECIPE_NUM && index >= 0) {
			this.recipes.remove(index);
			this.recipes.add(index, recipe);
			return true;
		}
		return false;
	}
}

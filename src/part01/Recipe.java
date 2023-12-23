package part01;

import java.util.ArrayList;

public class Recipe implements IdedAndNamed {
	private int id;									// unique identifier
	private String name;
	private ArrayList<Ingredient> ingredients;		// each ingredient will share index with respective amount and detail in ingrAmounts and ingrDetails
	private ArrayList<Double> ingrAmounts;			// amount of each ingredient in grams
	private ArrayList<String> ingrDetails;			// description of each ingredient for the recipe's ingredient list
	private ArrayList<String> method;				// each element is a step in the method of preparation of the recipe
	private int serves;
	private static int nextId = 1;
	
	/**
	 * Recipe constructor
	 * @param name
	 * @param ingredients
	 * @param ingrAmounts
	 * @param ingrDetails
	 * @param method
	 * @param serves
	 * @throws Exception
	 */
	public Recipe(String name, ArrayList<Ingredient> ingredients, ArrayList<Double> ingrAmounts, ArrayList<String> ingrDetails,
			ArrayList<String> method, int serves) throws Exception {
		if(!setName(name) || !setIngredients(ingredients, ingrAmounts, ingrDetails) || !setMethod(method) || !setServes(serves)) {
			throw new Exception("Bad data:\nName: "+ name + "\nIngredients: " + ingredients + "\n" + ingrAmounts + "\n" + ingrDetails +
					"\nMethod: " + method + "\nServes: " + serves);
		}
		this.id = nextId;
		nextId++;
	}
	
	// Accessor methods
	
	/**
	 * Id accessor
	 * @return id of recipe instance
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * Name accessor
	 * @return name of recipe instance
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * Ingredients accessor
	 * @return ingredients arraylist of recipe instance
	 */
	public ArrayList<Ingredient> getIngredients(){
		return this.ingredients;
	}
	/**
	 * IngrAmounts accessor
	 * @return ingrAmounts arraylist of recipe instance (amounts of each ingredient in ingredients)
	 */
	public ArrayList<Double> getIngrAmounts(){
		return this.ingrAmounts;
	}
	
	/**
	 * IngrDetails accessor
	 * @return ingrDetails arraylist of recipe instance (detail of each ingredient in ingredients)
	 */
	public ArrayList<String> getIngrDetails(){
		return this.ingrDetails;
	}
	
	/**
	 * Method accessor
	 * @return method arraylist of recipe instance (list of steps for preparing recipe)
	 */
	public ArrayList<String> getMethod(){
		return this.method;
	}
	
	/**
	 * Serves accessor
	 * @return serves of recipe instance
	 */
	public int getServes() {
		return this.serves;
	}
	
	// Mutator methods
	
	/**
	 * Mutator for ingredients, ingrAmounts, and ingrDetails. For each ingredient in ingredients there must be an amount in ingrAmounts 
	 * and a detail in ingrDetails with matching index
	 * @param ingredients
	 * @param ingrAmounts
	 * @param ingrDetails
	 * @return true if the three lists are successfully set, otherwise false
	 */
	public boolean setIngredients(ArrayList<Ingredient> ingredients, ArrayList<Double> ingrAmounts, ArrayList<String> ingrDetails) {
		
		// ensure no ArrayList reference is null and all ArrayLists are the same size
		if(ingredients == null || ingrAmounts == null || ingrDetails == null || ingrAmounts.size() != ingredients.size() || ingrDetails.size() != ingredients.size()) {
			return false;
		}
		
		
		ArrayList<Ingredient> newIngrs = new ArrayList<Ingredient>();
		ArrayList<Double> newAmounts = new ArrayList<Double>();
		ArrayList<String> newDetails = new ArrayList<String>();
		
		// ensure every ingredient, amount and detail is acceptable
		for(int index = 0; index < ingredients.size(); index++) {
			if(ingredients.get(index) == null || ingrAmounts.get(index) <= 0 || ingrDetails.get(index) == null) {
				return false;
			}
			// checks that ingredient isn't being added twice
			for(int j = 0; j < newIngrs.size(); j++) {
				if(newIngrs.get(j).getId() == ingredients.get(index).getId()) {
					return false;
				}
			}
			newIngrs.add(ingredients.get(index));
			newAmounts.add(ingrAmounts.get(index));
			newDetails.add(ingrDetails.get(index));
		}
		
		this.ingredients = newIngrs;
		this.ingrAmounts = newAmounts;
		this.ingrDetails = newDetails;
		return true;
	}
	
	/**
	 * Method mutator method. Each element is a step in the recipe's method of preparation
	 * @param method
	 * @return true if method is successfully set, otherwise false
	 */
	public boolean setMethod(ArrayList<String> method) {
		if(method != null) {
			for(int index = 0; index < method.size(); index++) {
				if(method.get(index) == null || method.get(index).trim().length() == 0) {
					return false;
				}
			}
			this.method = method;
			return true;
		}
		return false;
	}
	
	/**
	 * Name mutator method.
	 * @param name
	 * @return true if method is successfully set, otherwise false
	 */
	public boolean setName(String name) {
		if(name != null && name.trim().length() > 0){
			this.name = name;
			return true;
		}
		return false;
	}
	
	/**
	 * Serves mutator method.
	 * @param serves
	 * @return true if method is successfully set, otherwise false
	 */
	public boolean setServes(int serves) {
		if(serves > 0) {
			this.serves = serves;
			return true;
		}
		return false;
	}
	
	// Other methods
	
	/**
	 * Calculates the total calories of the recipe
	 * @return double value representing the total calories of the recipe
	 */
	public double getTotalCalories() {
		double totalCalories = 0.0;
		for(int index = 0; index < this.getIngredients().size(); index++) {
			// add the each ingredient's calories based on calories per 100 grams and amount of grams in recipe
			totalCalories += (this.getIngredients().get(index).getCalories()) / 100.0 * this.getIngrAmounts().get(index);
		}
		return totalCalories;
	}
		
	
	public String toString() {
		String result = this.getName() + " \n\t| ID: " + this.getId() + " \n\t| Total calories: " + this.getTotalCalories() + " \n\t| Serves: " + this.getServes();
		return result;
	}
	
	/**
	 * Get recipe's description in string format. Useful for printing in console
	 * @return string fully describing the recipe
	 */
	public String getDetails() {
		String result = this.toString();
		result += "\n\nIngredients:";
		for(int index = 0; index < this.getIngredients().size(); index++) {
			result += "\n"+this.getIngredients().get(index).getName()+" \n\t| "+this.getIngrAmounts().get(index)+" grams \n\t| "+ this.getIngrDetails().get(index);
		}
		result += "\n\nPreparation method:";
		for(int index = 0; index < this.getMethod().size(); index++) {
			result += "\n"+(index+1)+". "+this.getMethod().get(index);
		}
		return result;
	}
}

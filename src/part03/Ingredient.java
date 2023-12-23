package part03;

public class Ingredient implements IdedAndNamed{
	private int id;				// unique identifier
	private String name;			
	private FoodGroup foodGroup;	
	private double calories;		// calories per 100 grams
	private static int nextId = 1;
	
	/**
	 * Ingredient constructor
	 * @param name
	 * @param foodGroup
	 * @param calories
	 * @throws Exception
	 */
	public Ingredient(String name, FoodGroup foodGroup, double calories) throws Exception{
		if(!setName(name) || !setCalories(calories) || !setFoodGroup(foodGroup)) {
			throw new Exception("Bad data:\nName: " + name +"\nCalories: "+ calories + "\nFood group: "+ foodGroup);
		}
		this.id = nextId;
		nextId++;
	}
	
	// Accessor methods
	
	/**
	 * Id accessor
	 * @return id of ingredient instance
	 */
	public int getId() {
		return this.id;
	}
	/**
	 * Name accessor
	 * @return name of ingredient instance
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * FoodGroup accessor
	 * @return foodGroup of ingredient instance
	 */
	public FoodGroup getFoodGroup() {
		return this.foodGroup;
	}
	/**
	 * Calories accessor
	 * @return calories of ingredient instance
	 */
	public double getCalories() {
		return this.calories;
	}
	
	// Mutator methods
	
	/**
	 * Name mutator
	 * @param name
	 * @return true is successfully set, otherwise false 
	 */
	public boolean setName(String name) {
		if(name != null) {
			name.trim();
			if(name.length() > 0) {
				this.name = name;
				return true;
			}
		}
		return false;
	}
	/**
	 * Calories mutator
	 * @param calories
	 * @return true is successfully set, otherwise false 
	 */
	public boolean setCalories(double calories) {
		if(calories >= 0) {
			this.calories = calories;
			return true;
		}
		return false;
	}
	/**
	 * FoodGroup mutator
	 * @param foodGroup
	 * @return true is successfully set 
	 */
	public boolean setFoodGroup(FoodGroup foodGroup) {
		this.foodGroup = foodGroup;
		return true;
	}
	
	// Other methods
	public String toString(){
		String result = this.getName() + " \n\t| ID: " + this.getId() +" \n\t| Calories per 100g: " + this.getCalories() + " \n\t| Food group: " + this.getFoodGroup()+"\n";
		return result;
	}
	
	// Included as Ingredient implements IdedAndNamed. Same as toString()
	/**
	 * Get ingredient's description in string format. Useful for printing in console
	 * @return string of describing the ingredient
	 */
	public String getDetails() {
		return this.toString();
	}
}

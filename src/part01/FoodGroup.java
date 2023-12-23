package part01;

/**
 *  Defines the food group an ingredient is part of.
 */
public enum FoodGroup {
	DAIRY("Dairy"),
	CEREAL("Cereal"),
	FRUIT_AND_VEG("Fruit & Veg"),
	PROTEIN("Protein"),
	SUGAR("Sugar"),
	FAT("Fat"), 
	SPICE_AND_HERB("Spice & Herb"),
	COMPOSITE_FOOD("Composite Food"),
	ESSENTIAL_NUTRIENT("Essential Nutrient"),
	OTHER("Other");
	
	private String str;
	
	private FoodGroup(String str) {
		this.str = str;
	}
	
	public String toString() {
		return this.str;
	}
}

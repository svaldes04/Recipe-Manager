package part02;

import part01.FoodGroup;
import part01.Ingredient;
import part01.Recipe;
import java.util.ArrayList;

public class TestRecipe {
	private static Ingredient ingr1 , ingr2, ingr3, ingr4;
	private static ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
	private static ArrayList<Double> ingrAmounts =  new ArrayList<Double>();
	private static ArrayList<String> ingrDetails =  new ArrayList<String>();
	private static ArrayList<String> method =  new ArrayList<String>();
	
	public static void main(String[] args) {
		// Creating precondition ingredients
		try {
			ingr1 = new Ingredient("Chicken", FoodGroup.PROTEIN, 270);
			ingr2 = new Ingredient("Cheese", FoodGroup.DAIRY, 300);
			ingr3 = new Ingredient("Bread", FoodGroup.CEREAL, 100);
			ingr4 = new Ingredient("Water", FoodGroup.ESSENTIAL_NUTRIENT, 0);
		}catch(Exception e) {
			ingr1 = null;
			ingr2 = null;
			ingr3 = null;
			ingr4 = null;
			System.out.println("Ran into an error creating precondition ingredients");
		}
		
		// Tests
		ingredients.add(ingr1);
		ingredients.add(ingr2);
		ingrAmounts.add(100.0);
		ingrAmounts.add(200.0);
		ingrDetails.add("");
		ingrDetails.add("shredded");
		method.add("Cook together");
		method.add("Serve!");
		test19();
		test20();
		test21();
		test22();
		test23();
		test24();
		test25();
		test26();
		test27();
		test28();
		test29();
		test30();
		test31();
		test32();
		test33();
		test34();
		test35();
		test36();
		test37();
		test38();
		test39();
		test40();

		
	}
	
	private static void test19() {
		Recipe rec1 = null;
		System.out.println("=========== TEST 19 ============");
		System.out.println("Testing recipe constructor with valid arguments");
		System.out.println("Before: "+rec1);
		try {
			rec1 = new Recipe("Test recipe", ingredients, ingrAmounts, ingrDetails, method, 2);
		}catch(Exception e) {
			
		}
		System.out.println("After: "+rec1);
		if(rec1 != null) {
			System.out.println("Test passed");
		} else {
			System.out.println("Test failed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
		
	}
	
	private static void test20() {
		Recipe rec1 = null;
		System.out.println("=========== TEST 20 ============");
		System.out.println("Testing recipe constructor with invalid arguments");
		System.out.println("Before: "+rec1);
		try {
			rec1 = new Recipe( null, ingredients, ingrAmounts, ingrDetails, method, 2);
		}catch(Exception e) {
			
		}
		System.out.println("After: "+rec1);
		if(rec1 != null) {
			System.out.println("Test failed");
		} else {
			System.out.println("Test passed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
		
	}
	
	private static void test21() {
		Recipe rec1 = null;
		System.out.println("=========== TEST 21 ============");
		System.out.println("Testing name mutator method with valid arguments");
		try {
			rec1 = new Recipe("Test recipe", ingredients, ingrAmounts, ingrDetails, method, 2);
		}catch(Exception e) {
			
		}
		System.out.println("Before: "+rec1.getName());
		boolean status = rec1.setName("New name");
		System.out.println("After: "+rec1.getName());
		if(status) {
			System.out.println("Test passed");
		} else {
			System.out.println("Test failed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
		
	}
	
	private static void test22() {
		Recipe rec1 = null;
		System.out.println("=========== TEST 22 ============");
		System.out.println("Testing name mutator method with empty string");
		try {
			rec1 = new Recipe("Test recipe", ingredients, ingrAmounts, ingrDetails, method, 2);
		}catch(Exception e) {
			
		}
		System.out.println("Before: "+rec1.getName());
		boolean status = rec1.setName("");
		System.out.println("After: "+rec1.getName());
		if(status) {
			System.out.println("Test failed");
		} else {
			System.out.println("Test passed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
		
	}
	
	private static void test23() {
		Recipe rec1 = null;
		System.out.println("=========== TEST 23 ============");
		System.out.println("Testing name mutator method with blank spaces as string");
		try {
			rec1 = new Recipe("Test recipe", ingredients, ingrAmounts, ingrDetails, method, 2);
		}catch(Exception e) {
			
		}
		System.out.println("Before: "+rec1.getName());
		boolean status = rec1.setName("     ");
		System.out.println("After: "+rec1.getName());
		if(status) {
			System.out.println("Test failed");
		} else {
			System.out.println("Test passed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
		
	}
	
	private static void test24() {
		Recipe rec1 = null;
		System.out.println("=========== TEST 24 ============");
		System.out.println("Testing name mutator method with null string");
		try {
			rec1 = new Recipe("Test recipe", ingredients, ingrAmounts, ingrDetails, method, 2);
		}catch(Exception e) {
			
		}
		System.out.println("Before: "+rec1.getName());
		boolean status = rec1.setName(null);
		System.out.println("After: "+rec1.getName());
		if(status) {
			System.out.println("Test failed");
		} else {
			System.out.println("Test passed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
		
	}
	
	private static void test25() {
		Recipe rec1 = null;
		System.out.println("=========== TEST 25 ============");
		System.out.println("Testing serves mutator method with positive value");
		try {
			rec1 = new Recipe("Test recipe", ingredients, ingrAmounts, ingrDetails, method, 2);
		}catch(Exception e) {
			
		}
		System.out.println("Before: "+rec1.getServes());
		boolean status = rec1.setServes(5);
		System.out.println("After: "+rec1.getServes());
		if(status) {
			System.out.println("Test passed");
		} else {
			System.out.println("Test failed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
		
	}
	
	private static void test26() {
		Recipe rec1 = null;
		System.out.println("=========== TEST 26 ============");
		System.out.println("Testing serves mutator method with 0 as value");
		try {
			rec1 = new Recipe("Test recipe", ingredients, ingrAmounts, ingrDetails, method, 2);
		}catch(Exception e) {
			
		}
		System.out.println("Before: "+rec1.getServes());
		boolean status = rec1.setServes(0);
		System.out.println("After: "+rec1.getServes());
		if(status) {
			System.out.println("Test failed");
		} else {
			System.out.println("Test passed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
		
	}
	
	private static void test27() {
		Recipe rec1 = null;
		System.out.println("=========== TEST 27 ============");
		System.out.println("Testing serves mutator method with negative value");
		try {
			rec1 = new Recipe("Test recipe", ingredients, ingrAmounts, ingrDetails, method, 2);
		}catch(Exception e) {
			
		}
		System.out.println("Before: "+rec1.getServes());
		boolean status = rec1.setServes(-1);
		System.out.println("After: "+rec1.getServes());
		if(status) {
			System.out.println("Test failed");
		} else {
			System.out.println("Test passed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
		
	}
	
	private static void test28() {
		Recipe rec1 = null;
		System.out.println("=========== TEST 28 ============");
		System.out.println("Testing setMethod with valid data");
		ArrayList<String> testMethod = new ArrayList<String>();
		testMethod.add("Text 1");
		testMethod.add("Text 2");
		try {
			rec1 = new Recipe("Test recipe", ingredients, ingrAmounts, ingrDetails, method, 2);
		}catch(Exception e) {
			
		}
		System.out.println("Before: "+rec1.getMethod());
		boolean status = rec1.setMethod(testMethod);
		System.out.println("After: "+rec1.getMethod());
		if(status) {
			System.out.println("Test passed");
		} else {
			System.out.println("Test failed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
		
	}
	
	private static void test29() {
		Recipe rec1 = null;
		System.out.println("=========== TEST 29 ============");
		System.out.println("Testing setMethod with null arraylist");
		ArrayList<String> testMethod = null;
		try {
			rec1 = new Recipe("Test recipe", ingredients, ingrAmounts, ingrDetails, method, 2);
		}catch(Exception e) {
			
		}
		System.out.println("Before: "+rec1.getMethod());
		boolean status = rec1.setMethod(testMethod);
		System.out.println("After: "+rec1.getMethod());
		if(status) {
			System.out.println("Test failed");
		} else {
			System.out.println("Test passed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
	}
	
	private static void test30() {
		Recipe rec1 = null;
		System.out.println("=========== TEST 30 ============");
		System.out.println("Testing setMethod with empty arraylist");
		ArrayList<String> testMethod = new ArrayList<String>();
		try {
			rec1 = new Recipe("Test recipe", ingredients, ingrAmounts, ingrDetails, method, 2);
		}catch(Exception e) {
			
		}
		System.out.println("Before: "+rec1.getMethod());
		boolean status = rec1.setMethod(testMethod);
		System.out.println("After: "+rec1.getMethod());
		if(status) {
			System.out.println("Test failed");
		} else {
			System.out.println("Test passed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
	}
	
	private static void test31() {
		Recipe rec1 = null;
		System.out.println("=========== TEST 31 ============");
		System.out.println("Testing setMethod with arraylist containing empty strings");
		ArrayList<String> testMethod = new ArrayList<String>();
		testMethod.add("");
		testMethod.add("");
		try {
			rec1 = new Recipe("Test recipe", ingredients, ingrAmounts, ingrDetails, method, 2);
		}catch(Exception e) {
			
		}
		System.out.println("Before: "+rec1.getMethod());
		boolean status = rec1.setMethod(testMethod);
		System.out.println("After: "+rec1.getMethod());
		if(status) {
			System.out.println("Test failed");
		} else {
			System.out.println("Test passed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
	}
	
	private static void test32() {
		Recipe rec1 = null;
		System.out.println("=========== TEST 32 ============");
		System.out.println("Testing setMethod with arraylist containing null strings");
		ArrayList<String> testMethod = new ArrayList<String>();
		testMethod.add(null);
		testMethod.add(null);
		try {
			rec1 = new Recipe("Test recipe", ingredients, ingrAmounts, ingrDetails, method, 2);
		}catch(Exception e) {
			
		}
		System.out.println("Before: "+rec1.getMethod());
		boolean status = rec1.setMethod(testMethod);
		System.out.println("After: "+rec1.getMethod());
		if(status) {
			System.out.println("Test failed");
		} else {
			System.out.println("Test passed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
	}
	
	private static void test33() {
		Recipe rec1 = null;
		System.out.println("=========== TEST 33 ============");
		System.out.println("Testing setIngredients with valid arguments");
		ArrayList<Ingredient> testIngrs = new ArrayList<Ingredient>();
		ArrayList<Double> testAmounts = new ArrayList<Double>();
		ArrayList<String> testDetails = new ArrayList<String>();
		testIngrs.add(ingr3);
		testIngrs.add(ingr4);
		testAmounts.add(400.0);
		testAmounts.add(200.0);
		testDetails.add("1 loaf");
		testDetails.add("");
		
		try {
			rec1 = new Recipe("Test recipe", ingredients, ingrAmounts, ingrDetails, method, 2);
		}catch(Exception e) {
			
		}
		System.out.println("Before: "+rec1.getIngredients()+ "\n"+rec1.getIngrAmounts()+"\n"+rec1.getIngrDetails());
		boolean status = rec1.setIngredients(testIngrs, testAmounts, testDetails);
		System.out.println("After: "+rec1.getIngredients()+ "\n"+rec1.getIngrAmounts()+"\n"+rec1.getIngrDetails());
		if(status) {
			System.out.println("Test passed");
		} else {
			System.out.println("Test failed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
	}
	
	private static void test34() {
		Recipe rec1 = null;
		System.out.println("=========== TEST 34 ============");
		System.out.println("Testing setIngredients with null arraylists");
		ArrayList<Ingredient> testIngrs = null;
		ArrayList<Double> testAmounts = null;
		ArrayList<String> testDetails = null;
		
		try {
			rec1 = new Recipe("Test recipe", ingredients, ingrAmounts, ingrDetails, method, 2);
		}catch(Exception e) {
			
		}
		System.out.println("Before: "+rec1.getIngredients()+ "\n"+rec1.getIngrAmounts()+"\n"+rec1.getIngrDetails());
		boolean status = rec1.setIngredients(testIngrs, testAmounts, testDetails);
		System.out.println("After: "+rec1.getIngredients()+ "\n"+rec1.getIngrAmounts()+"\n"+rec1.getIngrDetails());
		if(status) {
			System.out.println("Test failed");
		} else {
			System.out.println("Test passed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
	}
	
	private static void test35() {
		Recipe rec1 = null;
		System.out.println("=========== TEST 35 ============");
		System.out.println("Testing setIngredients with different length arraylists");
		ArrayList<Ingredient> testIngrs = new ArrayList<Ingredient>();
		ArrayList<Double> testAmounts = new ArrayList<Double>();
		ArrayList<String> testDetails = new ArrayList<String>();
		testIngrs.add(ingr3);
		testIngrs.add(ingr4);
		testAmounts.add(400.0);
		testAmounts.add(200.0);
		testDetails.add("1 loaf");
		
		try {
			rec1 = new Recipe("Test recipe", ingredients, ingrAmounts, ingrDetails, method, 2);
		}catch(Exception e) {
			
		}
		System.out.println("Before: "+rec1.getIngredients()+ "\n"+rec1.getIngrAmounts()+"\n"+rec1.getIngrDetails());
		boolean status = rec1.setIngredients(testIngrs, testAmounts, testDetails);
		System.out.println("After: "+rec1.getIngredients()+ "\n"+rec1.getIngrAmounts()+"\n"+rec1.getIngrDetails());
		if(status) {
			System.out.println("Test failed");
		} else {
			System.out.println("Test passed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
	}
	
	private static void test36() {
		Recipe rec1 = null;
		System.out.println("=========== TEST 36 ============");
		System.out.println("Testing setIngredients with a null reference in ingredient arraylist");
		ArrayList<Ingredient> testIngrs = new ArrayList<Ingredient>();
		ArrayList<Double> testAmounts = new ArrayList<Double>();
		ArrayList<String> testDetails = new ArrayList<String>();
		testIngrs.add(ingr3);
		testIngrs.add(null);
		testAmounts.add(400.0);
		testAmounts.add(200.0);
		testDetails.add("1 loaf");
		testDetails.add("");
		
		try {
			rec1 = new Recipe("Test recipe", ingredients, ingrAmounts, ingrDetails, method, 2);
		}catch(Exception e) {
			
		}
		System.out.println("Before: "+rec1.getIngredients()+ "\n"+rec1.getIngrAmounts()+"\n"+rec1.getIngrDetails());
		boolean status = rec1.setIngredients(testIngrs, testAmounts, testDetails);
		System.out.println("After: "+rec1.getIngredients()+ "\n"+rec1.getIngrAmounts()+"\n"+rec1.getIngrDetails());
		if(status) {
			System.out.println("Test failed");
		} else {
			System.out.println("Test passed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
	}
	
	private static void test37() {
		Recipe rec1 = null;
		System.out.println("=========== TEST 37 ============");
		System.out.println("Testing setIngredients with a 0 in amounts arraylist");
		ArrayList<Ingredient> testIngrs = new ArrayList<Ingredient>();
		ArrayList<Double> testAmounts = new ArrayList<Double>();
		ArrayList<String> testDetails = new ArrayList<String>();
		testIngrs.add(ingr3);
		testIngrs.add(ingr4);
		testAmounts.add(0.0);
		testAmounts.add(200.0);
		testDetails.add("1 loaf");
		testDetails.add("");
		
		try {
			rec1 = new Recipe("Test recipe", ingredients, ingrAmounts, ingrDetails, method, 2);
		}catch(Exception e) {
			
		}
		System.out.println("Before: "+rec1.getIngredients()+ "\n"+rec1.getIngrAmounts()+"\n"+rec1.getIngrDetails());
		boolean status = rec1.setIngredients(testIngrs, testAmounts, testDetails);
		System.out.println("After: "+rec1.getIngredients()+ "\n"+rec1.getIngrAmounts()+"\n"+rec1.getIngrDetails());
		if(status) {
			System.out.println("Test failed");
		} else {
			System.out.println("Test passed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
	}
	
	private static void test38() {
		Recipe rec1 = null;
		System.out.println("=========== TEST 38 ============");
		System.out.println("Testing setIngredients with a null string in details arraylist");
		ArrayList<Ingredient> testIngrs = new ArrayList<Ingredient>();
		ArrayList<Double> testAmounts = new ArrayList<Double>();
		ArrayList<String> testDetails = new ArrayList<String>();
		testIngrs.add(ingr3);
		testIngrs.add(ingr4);
		testAmounts.add(400.0);
		testAmounts.add(200.0);
		testDetails.add("1 loaf");
		testDetails.add(null);
		
		try {
			rec1 = new Recipe("Test recipe", ingredients, ingrAmounts, ingrDetails, method, 2);
		}catch(Exception e) {
			
		}
		System.out.println("Before: "+rec1.getIngredients()+ "\n"+rec1.getIngrAmounts()+"\n"+rec1.getIngrDetails());
		boolean status = rec1.setIngredients(testIngrs, testAmounts, testDetails);
		System.out.println("After: "+rec1.getIngredients()+ "\n"+rec1.getIngrAmounts()+"\n"+rec1.getIngrDetails());
		if(status) {
			System.out.println("Test failed");
		} else {
			System.out.println("Test passed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
	}
	
	private static void test39() {
		Recipe rec1 = null;
		System.out.println("=========== TEST 39 ============");
		System.out.println("Testing setIngredients with empty arraylists");
		ArrayList<Ingredient> testIngrs = new ArrayList<Ingredient>();
		ArrayList<Double> testAmounts = new ArrayList<Double>();
		ArrayList<String> testDetails = new ArrayList<String>();
		
		try {
			rec1 = new Recipe("Test recipe", ingredients, ingrAmounts, ingrDetails, method, 2);
		}catch(Exception e) {
			
		}
		System.out.println("Before: "+rec1.getIngredients()+ "\n"+rec1.getIngrAmounts()+"\n"+rec1.getIngrDetails());
		boolean status = rec1.setIngredients(testIngrs, testAmounts, testDetails);
		System.out.println("After: "+rec1.getIngredients()+ "\n"+rec1.getIngrAmounts()+"\n"+rec1.getIngrDetails());
		if(status) {
			System.out.println("Test failed");
		} else {
			System.out.println("Test passed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
	}
	
	private static void test40() {
		Recipe rec1 = null;
		System.out.println("=========== TEST 40 ============");
		System.out.println("Testing setIngredients with a repeated ingredient in ingredient arraylist");
		ArrayList<Ingredient> testIngrs = new ArrayList<Ingredient>();
		ArrayList<Double> testAmounts = new ArrayList<Double>();
		ArrayList<String> testDetails = new ArrayList<String>();
		testIngrs.add(ingr3);
		testIngrs.add(ingr3);
		testAmounts.add(400.0);
		testAmounts.add(200.0);
		testDetails.add("1 loaf");
		testDetails.add("");
		
		try {
			rec1 = new Recipe("Test recipe", ingredients, ingrAmounts, ingrDetails, method, 2);
		}catch(Exception e) {
			
		}
		System.out.println("Before: "+rec1.getIngredients()+ "\n"+rec1.getIngrAmounts()+"\n"+rec1.getIngrDetails());
		boolean status = rec1.setIngredients(testIngrs, testAmounts, testDetails);
		System.out.println("After: "+rec1.getIngredients()+ "\n"+rec1.getIngrAmounts()+"\n"+rec1.getIngrDetails());
		if(status) {
			System.out.println("Test failed");
		} else {
			System.out.println("Test passed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
	}
}

package part02;

import part01.WeeklyMenu;

import java.util.ArrayList;

import part01.FoodGroup;
import part01.IdedAndNamed;
import part01.Ingredient;
import part01.Recipe;

public class TestWeeklyMenu {

	private static WeeklyMenu menu;
	private static Recipe rec1;
	private static Recipe rec2;
	private static Ingredient ingr;
	private static ArrayList<IdedAndNamed> recList;
	
	public static void main(String[] args) {
		try {
			ingr = new Ingredient("Name", FoodGroup.OTHER, 0);
			ArrayList<Ingredient> ingrList = new ArrayList<Ingredient>();
			ArrayList<Double> ingrAmounts = new ArrayList<Double>();
			ArrayList<String> ingrDetails = new ArrayList<String>();
			ArrayList<String> method = new ArrayList<String>();
			ingrList.add(ingr);
			ingrAmounts.add(1.0);
			ingrDetails.add("");
			method.add("Text");
			rec1 = new Recipe("Recipe 1",ingrList,ingrAmounts,ingrDetails,method,1);
			rec2 = new Recipe("Recipe 2",ingrList,ingrAmounts,ingrDetails,method,1);
			recList = new ArrayList<IdedAndNamed>();
			for(int i=0;i<15;i++) {
				recList.add(rec1);
			}
		}catch(Exception e) {
			System.out.println("There was an error generating the pre-existing test data");
		}
		
		// Tests
		test41();
		test42();
		test43();
		test44();
		test45();
		test46();
		test47();
		test48();
		test49();
		test50();
		test51();
		test52();
		test53();
		test54();
	}
	
	/**
	 * Aids in printing elements of an ArrayList of IdedAndNamed
	 * @param list
	 */
	private static void printElems(ArrayList<IdedAndNamed> list) {
		for(int i=0; i<list.size();i++) { 
			if(i == list.size()-1) {
				System.out.print(list.get(i).getName()+"\n");
				break;
			}
			System.out.print(list.get(i).getName()+ ", ");
			}
	}
	
	private static void test41() {
		menu = null;
		System.out.println("=========== TEST 41 ============");
		System.out.println("Testing weekly menu constructor with valid arguments");
		System.out.println("Before: "+menu);
		try {
			menu = new WeeklyMenu(recList);
		}catch(Exception e) {
			
		}
		System.out.println("After: "+menu);
		if(menu != null) {
			System.out.println("Test passed");
		} else {
			System.out.println("Test failed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
		
	}
	
	private static void test42() {
		menu = null;
		ArrayList<IdedAndNamed> temp = new ArrayList<IdedAndNamed>();
		System.out.println("=========== TEST 42 ============");
		System.out.println("Testing weekly menu constructor with invalid arguments");
		System.out.println("Before: "+menu);
		try {
			menu = new WeeklyMenu(temp);
		}catch(Exception e) {
			
		}
		System.out.println("After: "+menu);
		if(menu != null) {
			System.out.println("Test failed");
		} else {
			System.out.println("Test passed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
		
	}
	
	private static void test43() {
		menu = null;
		System.out.println("=========== TEST 43 ============");
		System.out.println("Testing setRecipes with valid arguments");
		try {
			menu = new WeeklyMenu(recList);
		}catch(Exception e) {
			
		}
		ArrayList<IdedAndNamed> temp = new ArrayList<IdedAndNamed>();
		for(int i=0; i<15;i++) {
			temp.add(rec2);
		}
		System.out.println("Before: ");
		printElems(menu.getRecipes());
		boolean status = menu.setRecipes(temp);
		System.out.println("After: ");
		printElems(menu.getRecipes());
		
		if(status) {
			System.out.println("Test passed");
		} else {
			System.out.println("Test failed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
		
	}
	
	private static void test44() {
		menu = null;
		System.out.println("=========== TEST 44 ============");
		System.out.println("Testing setRecipes with null arraylist");
		try {
			menu = new WeeklyMenu(recList);
		}catch(Exception e) {
			
		}
		ArrayList<IdedAndNamed> temp = null;
		System.out.println("Before: ");
		printElems(menu.getRecipes());
		boolean status;
		try {
			status = menu.setRecipes(temp);
		}catch(Exception e) {
			System.out.println("An unexpected exception was thrown when attempting to use setRecipe");
			System.out.println("Test failed");
			System.out.println("=========== END OF TEST ============\n\n");
			return;
		}
		menu.setRecipes(temp);
		System.out.println("After: ");
		printElems(menu.getRecipes());
		if(status) {
			System.out.println("Test failed");
		} else {
			System.out.println("Test passed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
		
	}
	
	private static void test45() {
		menu = null;
		System.out.println("=========== TEST 45 ============");
		System.out.println("Testing setRecipes with arraylist containing null references");
		try {
			menu = new WeeklyMenu(recList);
		}catch(Exception e) {
			
		}
		ArrayList<IdedAndNamed> temp = new ArrayList<IdedAndNamed>();
		for(int i=0; i<15;i++) {
			temp.add(null);
		}
		System.out.println("Before: ");
		printElems(menu.getRecipes());
		boolean status = menu.setRecipes(temp);
		System.out.println("After: ");
		printElems(menu.getRecipes());
		if(status) {
			System.out.println("Test failed");
		} else {
			System.out.println("Test passed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
		
	}
	
	private static void test46() {
		menu = null;
		System.out.println("=========== TEST 46 ============");
		System.out.println("Testing setRecipes with arraylist containing ingredient references");
		try {
			menu = new WeeklyMenu(recList);
		}catch(Exception e) {
			
		}
		ArrayList<IdedAndNamed> temp = new ArrayList<IdedAndNamed>();
		for(int i=0; i<15;i++) {
			temp.add(ingr);
		}
		System.out.println("Before: ");
		printElems(menu.getRecipes());
		boolean status = menu.setRecipes(temp);
		System.out.println("After: ");
		printElems(menu.getRecipes());
		if(status) {
			System.out.println("Test failed");
		} else {
			System.out.println("Test passed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
		
	}
	
	private static void test47() {
		menu = null;
		System.out.println("=========== TEST 47 ============");
		System.out.println("Testing setRecipes with arraylist containing 14 recipe references");
		try {
			menu = new WeeklyMenu(recList);
		}catch(Exception e) {
			
		}
		ArrayList<IdedAndNamed> temp = new ArrayList<IdedAndNamed>();
		for(int i=0; i<14;i++) {
			temp.add(ingr);
		}
		System.out.println("Before: ");
		printElems(menu.getRecipes());
		boolean status = menu.setRecipes(temp);
		System.out.println("After: ");
		printElems(menu.getRecipes());
		if(status) {
			System.out.println("Test failed");
		} else {
			System.out.println("Test passed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
		
	}
	
	private static void test48() {
		menu = null;
		System.out.println("=========== TEST 48 ============");
		System.out.println("Testing setRecipes with arraylist containing 16 recipe references");
		try {
			menu = new WeeklyMenu(recList);
		}catch(Exception e) {
			
		}
		ArrayList<IdedAndNamed> temp = new ArrayList<IdedAndNamed>();
		for(int i=0; i<16;i++) {
			temp.add(ingr);
		}
		System.out.println("Before: ");
		printElems(menu.getRecipes());
		boolean status = menu.setRecipes(temp);
		System.out.println("After: ");
		printElems(menu.getRecipes());
		if(status) {
			System.out.println("Test failed");
		} else {
			System.out.println("Test passed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
		
	}
	
	private static void test49() {
		menu = null;
		System.out.println("=========== TEST 49 ============");
		System.out.println("Testing replaceRecipe method with valid arguments");
		try {
			menu = new WeeklyMenu(recList);
		}catch(Exception e) {
			
		}
		System.out.println("Before: ");
		printElems(menu.getRecipes());
		boolean status = menu.replaceRecipe(rec2, 5);
		System.out.println("After: ");
		printElems(menu.getRecipes());
		if(status) {
			System.out.println("Test passed");
			menu.replaceRecipe(rec1, 5);
		} else {
			System.out.println("Test failed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
		
	}
	
	private static void test50() {
		menu = null;
		System.out.println("=========== TEST 50 ============");
		System.out.println("Testing replaceRecipe method with null recipe");
		try {
			menu = new WeeklyMenu(recList);
		}catch(Exception e) {
			
		}
		System.out.println("Before: ");
		printElems(menu.getRecipes());
		boolean status = menu.replaceRecipe(null, 5);
		System.out.println("After: ");
		printElems(menu.getRecipes());
		if(status) {
			System.out.println("Test failed");
			menu.replaceRecipe(rec1, 5);
		} else {
			System.out.println("Test passed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
		
	}
	
	private static void test51() {
		menu = null;
		System.out.println("=========== TEST 51 ============");
		System.out.println("Testing replaceRecipe method with index -1");
		try {
			menu = new WeeklyMenu(recList);
		}catch(Exception e) {
			
		}
		System.out.println("Before: ");
		printElems(menu.getRecipes());
		boolean status = menu.replaceRecipe(rec2, -1);
		System.out.println("After: ");
		printElems(menu.getRecipes());
		if(status) {
			System.out.println("Test failed");
			menu.replaceRecipe(rec1, -1);
		} else {
			System.out.println("Test passed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
		
	}
	
	private static void test52() {
		menu = null;
		System.out.println("=========== TEST 52 ============");
		System.out.println("Testing replaceRecipe method with index 0");
		try {
			menu = new WeeklyMenu(recList);
		}catch(Exception e) {
			
		}
		System.out.println("Before: ");
		printElems(menu.getRecipes());
		boolean status = menu.replaceRecipe(rec2, 0);
		System.out.println("After: ");
		printElems(menu.getRecipes());
		if(status) {
			System.out.println("Test passed");
			menu.replaceRecipe(rec1, 0);
		} else {
			System.out.println("Test failed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
		
	}
	
	private static void test53() {
		menu = null;
		System.out.println("=========== TEST 53 ============");
		System.out.println("Testing replaceRecipe method with index 14");
		try {
			menu = new WeeklyMenu(recList);
		}catch(Exception e) {
			
		}
		System.out.println("Before: ");
		printElems(menu.getRecipes());
		boolean status = menu.replaceRecipe(rec2, 14);
		System.out.println("After: ");
		printElems(menu.getRecipes());
		if(status) {
			System.out.println("Test passed");
			menu.replaceRecipe(rec1, 14);
		} else {
			System.out.println("Test failed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
		
	}
	
	private static void test54() {
		menu = null;
		System.out.println("=========== TEST 54 ============");
		System.out.println("Testing replaceRecipe method with index 15");
		try {
			menu = new WeeklyMenu(recList);
		}catch(Exception e) {
			
		}
		System.out.println("Before: ");
		printElems(menu.getRecipes());
		boolean status = menu.replaceRecipe(rec2, 15);
		System.out.println("After: ");
		printElems(menu.getRecipes());
		if(status) {
			System.out.println("Test failed");
			menu.replaceRecipe(rec1, 15);
		} else {
			System.out.println("Test passed");
		}
		System.out.println("=========== END OF TEST ============\n\n");
		
	}
}
